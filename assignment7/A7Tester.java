/*
* A7Tester.java
* A test program for Assignment 7.
*/

import java.util.Random;

public class A7Tester {
	private static int testPassCount = 0;
	private static int testCount = 0;
	public static boolean testHeapSolution = true;

	public static void main (String[] args) {
		
		if (args.length != 0 && args[0].equals("linked")) {
			testHeapSolution=false;
		}

		System.out.println("Testing " + (testHeapSolution ? "Heap" : "Linked" ) + " implementation.");
		
		testSize();
		testInsertionAndRemoval();
		testExceptions();
		testGeneric();
		testDuplicates();
		testMixed();
		stressTest();

		System.out.println("Testing Application using Priority Queue.");
		testAttendee();
		testApplicationManager();
		

		System.out.println("PASSED " + testPassCount + "/" + testCount + " tests");
	}

	public static<T extends Comparable<T>> PriorityQueue<T> createNewPriorityQueue(Class<T> type)  {
		if (testHeapSolution) {
			return new HeapPriorityQueue<T>(type);
		} else {
			return new LinkedPriorityQueue<T>();
		}
	}

	public static<T extends Comparable<T>> PriorityQueue<T> createNewPriorityQueue(Class<T> type, int size)  {
		if (testHeapSolution) {
			return new HeapPriorityQueue<T>(type, size);
		}
		else {
			return new LinkedPriorityQueue<T>();
		}
	}


	public static void testSize() {
		System.out.println("\nBasic testing of size, isEmpty");
		PriorityQueue<Integer> pq = createNewPriorityQueue(Integer.class);
		
		displayResults (pq.size() == 0, "size on empty PQ");
		displayResults (pq.isEmpty(), "isEmpty on empty PQ");

		pq.insert(10);
		displayResults (pq.size() == 1, "size on 1 element PQ");
		displayResults (!pq.isEmpty(), "isEmpty on 1 element PQ");

		pq.insert(9);
		displayResults (pq.size() == 2, "size on 2 element PQ");

		pq.insert(7);
		displayResults (pq.size() == 3, "size on 3 element PQ");
	}

	public static void testInsertionAndRemoval() {
		System.out.println("\nBasic testing of removeMin");
		PriorityQueue<Integer> pq = createNewPriorityQueue(Integer.class);
		
		pq.insert(8);
		pq.insert(9);
		pq.insert(10);

		Integer result;
		result = pq.removeMin();
		// System.out.println("res: " + result + ":" + pq);
		displayResults(result.equals(8), "remove on multiple element PQ");
		displayResults(pq.size() == 2, "remove + size on multiple element PQ");

		result = pq.removeMin();
		// System.out.println("res: " + result + ":" + pq);
		displayResults(result.equals(9), "remove on multiple element PQ");
		displayResults(pq.size() == 1, "remove + size on multiple element PQ");

		result = pq.removeMin();
		displayResults(result.equals(10), "remove + size on 1 element PQ");
		displayResults(pq.isEmpty(), "remove + isEmpty on 1 element PQ");

		pq = createNewPriorityQueue(Integer.class);
		pq.insert(3);
		pq.insert(2);
		pq.insert(1);

		result = pq.removeMin();
		displayResults(result.equals(1), "insert + remove on multiple element PQ");
		displayResults(pq.size() == 2, "insert + remove + size on multiple element PQ");

		result = pq.removeMin();
		displayResults(result.equals(2), "insert + remove on multiple element PQ");
		displayResults(pq.size() == 1, "insert + remove + size on multiple element PQ");

		result = pq.removeMin();
		displayResults(result.equals(3), "insert + remove on 1 element PQ");
		displayResults(pq.isEmpty(), "insert + remove + size on 1 element PQ");
	}

	public static void testExceptions() {
		System.out.println("\nTesting of exceptions");
		PriorityQueue<Integer> pq = createNewPriorityQueue(Integer.class, 2);

		try {
			pq.removeMin();
			displayResults(false, "exception should have been thrown");
		} catch (HeapFullException e) {
			displayResults(false, "different exception should have been thrown");
		} catch (HeapEmptyException e) {
			displayResults(true, "HeapEmptyException should be thrown");
		}
		
		pq.insert(10);
		pq.insert(9);
		try {
			pq.insert(8);
			if(testHeapSolution) {
				displayResults(false, "exception should have been thrown in heap solution");
			} else {
				displayResults(true, "exception should not have been thrown in linked version");
			} 
		} catch (HeapEmptyException e) {
			displayResults(false, "different exception should have been thrown");
		} catch (HeapFullException e) {
			displayResults(true, "HeapFullException should be thrown");
		}
	}

	public static void testGeneric() {
		System.out.println("\nTesting of removeMin with Strings");
		PriorityQueue<String> pq = createNewPriorityQueue(String.class);
		String result;

		pq.insert("abc");
		pq.insert("def");
		pq.insert("ghi");

		result = pq.removeMin();
		displayResults(result.equals("abc"), "insert/remove Strings");
		displayResults(pq.size() == 2, "insert/remove Strings");

		result = pq.removeMin();
		displayResults(result.equals("def"), "insert/remove Strings");
		displayResults(pq.size() == 1, "insert/remove Strings");

		result = pq.removeMin();
		displayResults(result.equals("ghi"), "insert/remove Strings");
		displayResults(pq.isEmpty(), "insert/remove Strings");

		pq = createNewPriorityQueue(String.class);
		pq.insert("ghi");
		pq.insert("def");
		pq.insert("abc");

		result = pq.removeMin();
		displayResults(result.equals("abc"), "insert/remove Strings");
		displayResults(pq.size() == 2, "insert/remove + size Strings");

		result = pq.removeMin();
		displayResults(result.equals("def"), "insert/remove Strings");
		displayResults(pq.size() == 1, "insert/remove + size Strings");

		result = pq.removeMin();
		displayResults(result.equals("ghi"), "insert/remove Strings");
		displayResults(pq.isEmpty(), "insert/remove + isEmpty Strings");
	}

	public static void testDuplicates() {
		System.out.println("\nTesting duplicates.");
		PriorityQueue<Integer> pq = createNewPriorityQueue(Integer.class);
		Integer result;

		pq.insert(4);
		pq.insert(1);
		pq.insert(1);
		pq.insert(5);
		pq.insert(0);
		// System.out.println("q after insert 4 1 1 5 0:" + q);
		result = pq.removeMin();
		displayResults(result == 0, "add duplicates + remove single");

		pq.insert(4);
		pq.insert(1);
		pq.insert(4);
		pq.insert(4);

		pq.insert(0);
		pq.insert(5);
		pq.insert(0);
		pq.insert(5);

		result = pq.removeMin();
		displayResults(result.equals(0), "add duplicates + remove duplicates");
		result = pq.removeMin();
		displayResults(result.equals(0), "add duplicates + remove duplicates");

		result = pq.removeMin();
		displayResults(result.equals(1), "add duplicates + remove duplicates");
		result = pq.removeMin();
		displayResults(result.equals(1), "add duplicates + remove duplicates");
		result = pq.removeMin();
		displayResults(result.equals(1), "add duplicates + remove duplicates");
		
		result = pq.removeMin();
		displayResults(result.equals(4), "add duplicates + remove duplicates");
		result = pq.removeMin();
		displayResults(result.equals(4), "add duplicates + remove duplicates");
		result = pq.removeMin();
		displayResults(result.equals(4), "add duplicates + remove duplicates");
		result = pq.removeMin();
		displayResults(result.equals(4), "add duplicates + remove duplicates");
		
		result = pq.removeMin();
		displayResults(result.equals(5), "add duplicates + remove duplicates");
		result = pq.removeMin();
		displayResults(result.equals(5), "add duplicates + remove duplicates");
		result = pq.removeMin();
		displayResults(result.equals(5), "add duplicates + remove duplicates");
		
		displayResults(pq.isEmpty(), "insert/remove + isEmpty");

	}

	public static void testMixed() {
		System.out.println("\nTesting insert mixed with removeMin.");
		PriorityQueue<Integer> pq = createNewPriorityQueue(Integer.class);
		Integer result;
		
		pq.insert(2);
		pq.insert(0);
		pq.insert(5);
		pq.insert(7);

		result = pq.removeMin();
		displayResults(result.equals(0), "inserts + remove");

		pq.insert(4);
		result = pq.removeMin();
		displayResults(result.equals(2), "inserts + remove");

		pq.insert(11);
		pq.insert(2);
		pq.insert(3);
		pq.insert(1);
		result = pq.removeMin();
		displayResults(result.equals(1), "inserts + remove");
		result = pq.removeMin();
		displayResults(result.equals(2), "inserts + remove");
		result = pq.removeMin();
		displayResults(result.equals(3), "inserts + remove");
		result = pq.removeMin();
		displayResults(result.equals(4), "inserts + remove");

		pq.insert(1);
		result = pq.removeMin();
		displayResults(result.equals(1), "inserts + remove");
		displayResults(pq.size() == 3, "inserts + remove + size");
	}

	public static boolean testRandomArray (int count)
	{
		/* These tests are effectively sorting the random values
			- for the heap, this is O (n log n)
			- for the linked list, this is O (n^2)
		*/
		PriorityQueue<Integer> q = createNewPriorityQueue(Integer.class, count);
		System.out.println("Testing size: " + count);
		Random r = new Random();
		for ( int i = 0; i < count; i++ ) {
			int val = r.nextInt(1000000);
			q.insert (val);
		}

		int oldVal = 0; //smallest possible value val could be
		int i = 0;
		while (!q.isEmpty()) {
			int val = q.removeMin().intValue(); // or a bug
			if ( val < oldVal ) {
				return false;
			}
			oldVal = val;
			i++;
		}
		return true;

	}

	public static void stressTest() {		
		System.out.println("\nStress Tests.");
		displayResults(testRandomArray(100), "inserts + removes");
		displayResults(testRandomArray(10000), "inserts + removes");
		displayResults(testRandomArray(100000), "inserts + removes");

		//This takes too long using the linked list.
		if (testHeapSolution) {
			displayResults(testRandomArray(1000000), "inserts + removes");
		}
		
	}

	public static void testAttendee() {
		System.out.println("\nTesting Attendee creation, compareTo and equals.");
		Date d1 = new Date(2023, 04, 21);
		Date d2 = new Date(2023, 05, 31);
		Date d3 = new Date(2023, 10, 15);
		Date d4 = new Date(2023, 12, 25);
		Date d5 = new Date(2024, 01, 01);
		
		JobApplication a1 = new JobApplication("Ali", d2, "Interview waived. Hire at all costs.");
		JobApplication a2 = new JobApplication("Sam", d3, "Schedule interview. Strong credentials");
		JobApplication a3 = new JobApplication("Lee", d1, "Schedule interview. Strong credentials");
		JobApplication a4 = new JobApplication("Ola", d5, "Consider interviewing");
		JobApplication a5 = new JobApplication("Mia", d2, "Interview waived. Hire at all costs.");
		JobApplication a6 = new JobApplication("Qui", d1, "Requires further analysis");
						
		displayResults(a1.compareTo(a2) < 0, "testing application compareTo (priority)");
		displayResults(a2.compareTo(a1) > 0, "testing application compareTo (priority)");
		displayResults(a1.compareTo(a3) < 0, "testing application compareTo (priority)");
		displayResults(a2.compareTo(a3) > 0, "testing application compareTo (priority and startDate tiebreaker)");
		displayResults(a3.compareTo(a2) < 0, "testing application compareTo (priority and startDate tiebreaker)");
		displayResults(a4.compareTo(a3) > 0, "testing application compareTo (priority)");
		displayResults(a1.compareTo(a5) == 0, "testing application compareTo (priority and startDate tiebreaker)");
		displayResults(a5.compareTo(a1) == 0, "testing application compareTo (priority and startDate tiebreaker)");
		
		JobApplication a1Copy = new JobApplication("Ali", d2, "Interview waived. Hire at all costs.");
		displayResults(a1.equals(a1Copy) == true, "testing equals on applications with same details");
		displayResults(a1.equals(a2) == false, "testing equals on applications with different names and dates");
		displayResults(a2.equals(a5) == false, "testing equals on applications with different priorities");
		
		// Write more tests here if you think certain cases are not covered
		
		JobApplication a1Later = new JobApplication("Ali", d3, "Interview waived. Hire at all costs.");
		displayResults(a1.equals(a1Later) == true, "testing equals on same appliation with same name and priority");
		displayResults(a1.equals(a5) == false, "testing equals on same appliation with priority but not name");
		displayResults(a1.compareTo(a1Later) < 0, "testing application compareTo (priority)");
		
	}

	public static void testApplicationManager() {
		System.out.println("\nTesting adding/removing applications from the Application Manager.");

		Date d1 = new Date(2023, 04, 21);
		Date d2 = new Date(2023, 05, 31);
		Date d3 = new Date(2023, 10, 15);
		Date d4 = new Date(2023, 12, 25);
		Date d5 = new Date(2024, 01, 01);
		
		JobApplication a1 = new JobApplication("Ali", d2, "Interview waived. Hire at all costs.");
		JobApplication a2 = new JobApplication("Sam", d3, "Schedule interview. Strong credentials");
		JobApplication a3 = new JobApplication("Lee", d1, "Schedule interview. Strong credentials");
		JobApplication a4 = new JobApplication("Ola", d5, "Consider interviewing");
		JobApplication a5 = new JobApplication("Mia", d1, "Interview waived. Hire at all costs.");
		JobApplication a6 = new JobApplication("Qui", d1, "Requires further analysis");
		JobApplication a7 = new JobApplication("Max", d2, "Consider interviewing");
		JobApplication a8 = new JobApplication("Jay", d1, "Schedule interview. Strong credentials");
		
		JobApplication nextA = null;

		ApplicationManager am1 = new ApplicationManager();
		displayResults(am1.numApplicantsWaiting() == 0, "testing ApplicationManager constructor + numApplicantsWaiting");

		am1.addApplication(a2);
		am1.addApplication(a3);
		am1.addApplication(a7);

		displayResults(am1.numApplicantsWaiting() == 3, "testing ApplicationManager addApplication + numApplicantsWaiting");
		nextA = am1.nextApplication();
		// System.out.println(nextA);
		displayResults(a3.equals(nextA), "testing ApplicationManager nextApplication");
		displayResults(am1.numApplicantsWaiting() == 2, "testing ApplicationManager nextApplication + numApplicantsWaiting");

		am1.addApplication(a1);
		am1.addApplication(a4);
		am1.addApplication(a5);
		am1.addApplication(a6);
		am1.addApplication(a8);
		displayResults(am1.numApplicantsWaiting() == 7, "testing ApplicationManager addApplication + numApplicantsWaiting");

		nextA = am1.nextApplication();
		// System.out.println(nextA);
		displayResults(a5.equals(nextA), "testing ApplicationManager nextApplication");
		nextA = am1.nextApplication();
		// System.out.println(nextA);
		displayResults(a1.equals(nextA), "testing ApplicationManager nextApplication");
		displayResults(am1.numApplicantsWaiting() == 5, "testing ApplicationManager nextApplication + numApplicantsWaiting");

		nextA = am1.nextApplication();
		// System.out.println(nextA);
		displayResults(a8.equals(nextA), "testing ApplicationManager nextApplication");
		nextA = am1.nextApplication();
		// System.out.println(nextA);
		displayResults(a2.equals(nextA), "testing ApplicationManager nextApplication");
		displayResults(am1.numApplicantsWaiting() == 3, "testing ApplicationManager nextApplication + numApplicantsWaiting");

		nextA = am1.nextApplication();
		// System.out.println(nextA);
		displayResults(a7.equals(nextA), "testing ApplicationManager nextApplication");
		nextA = am1.nextApplication();
		// System.out.println(nextA);
		displayResults(a4.equals(nextA), "testing ApplicationManager nextApplication");
		nextA = am1.nextApplication();
		// System.out.println(nextA);
		displayResults(a6.equals(nextA), "testing ApplicationManager nextApplication");
		displayResults(am1.numApplicantsWaiting() == 0, "testing ApplicationManager nextApplication + numApplicantsWaiting");

		nextA = am1.nextApplication();
		displayResults(nextA == null, "testing ApplicationManager nextApplication - no more in line");

		ApplicationManager smallVenue = new ApplicationManager(2);
		smallVenue.addApplication(a1);
		smallVenue.addApplication(a2);

		try {
			smallVenue.addApplication(a3);
			displayResults(true, "testing ApplicationManager addApplication when full - should get here without exception");
		} catch (HeapFullException e) {
			displayResults(false, "testing ApplicationManager addApplication when full - should not get here");
		}
		
		displayResults(smallVenue.numApplicantsWaiting() == 2, "testing numApplicantsWaiting when adding after full");
	}

	public static void displayResults (boolean passed, String testName) {
		testCount++;
		if (passed) {
			System.out.println ("Passed test " +testCount+": " + testName);
			testPassCount++;
		} else {
			System.out.println ("Failed test: " + testName + " at line "
								+ Thread.currentThread().getStackTrace()[2].getLineNumber());
		}
	}
}
