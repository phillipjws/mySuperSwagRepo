/*
 * A3Tester
 *
 * A class to test the methods required for Assignment 3
 *
 */
public class A3Tester {
    
	private static int testPassCount = 0;
	private static int testCount = 0;

    public static void main(String[] args) {
		
		/*
		Uncomment each method one at a time, 
		and implement the method in A3LinkedList.java 
		until all tests pass. It is strongly
		recommended that you add additional tests 
		to ensure the correctness of your implementation.
		*/
		
		/* Part 1: */
		testAddFront();
		testAddBack();
		testSizeAndIsEmpty();
		testRemoveFront();
		testRemoveBack();
		
		/* Part 2 */
		testRemoveAt();
		testMergeSorted();
		
		System.out.println("Passed " + testPassCount + " / " + testCount + " tests");
    }
	
		
	public static void testAddFront() {
		String result = "";
		A3LinkedList list1 = new A3LinkedList();
		
		result = list1.frontToBack();
		displayResults(result.equals("{}"), "testAddFront");
		
		list1.addFront("A");
		result = list1.frontToBack();
		displayResults(result.equals("{A}"), "testAddFront");
		
		list1.addFront("V");
		list1.addFront("A");
		list1.addFront("J");
		result = list1.frontToBack();
		System.out.println(result);
		displayResults(result.equals("{JAVA}"), "testAddFront");
		System.out.println(result);
		result = list1.backToFront();
		System.out.println(result);
		displayResults(result.equals("{AVAJ}"), "testAddFront");
	}
	
	public static void testAddBack() {
		String result = "";
		A3LinkedList list1 = new A3LinkedList();
		
		result = list1.frontToBack();
		displayResults(result.equals("{}"), "testAddBack");
		
		list1.addBack("F");
		result = list1.frontToBack();
		displayResults(result.equals("{F}"), "testAddBack");
		
		list1.addBack("U");
		list1.addBack("N");
		result = list1.frontToBack();
		displayResults(result.equals("{FUN}"), "testAddBack");
		result = list1.backToFront();
		displayResults(result.equals("{NUF}"), "testAddBack");
	}
	
	public static void testSizeAndIsEmpty() {
		int result = 0;
		A3LinkedList list1 = new A3LinkedList();

		result = list1.size();
		displayResults(result==0, "testSizeAndIsEmpty");
		displayResults(list1.isEmpty()==true, "testSizeAndIsEmpty");
		
		list1.addFront("C");
		list1.addFront("S");
		list1.addFront("C");
		result = list1.size();
		displayResults(result==3, "testSizeAndIsEmpty");
		displayResults(list1.isEmpty()==false, "testSizeAndIsEmpty");
		
		list1.addBack("115");
		result = list1.size();
		displayResults(result==4, "testSizeAndIsEmpty");
		
	}
	
	public static void testRemoveFront() {
		String result = "";
		A3LinkedList list1 = new A3LinkedList();
		
		list1.addBack("P");
		list1.addBack("I");
		list1.addBack("N");
		list1.addBack("K");
		result = list1.frontToBack();
		displayResults(result.equals("{PINK}"), "testRemoveFront");
		
		list1.removeFront();
		result = list1.frontToBack();
		displayResults(result.equals("{INK}"), "testRemoveFront");
		
		/* Write additional tests here to ensure all of your pointers
		   have been updated correctly.
		
		   You should also ensure that your size and isEmpty 
		   methods work with removal as well as addition */
				
	}
	
	public static void testRemoveBack() {
		// Write all of your own tests here 
	}
	
	public static void testRemoveAt() {
		System.out.println("\nTesting removeAt...");
		A3LinkedList list1 = new A3LinkedList();
		String result1;
		String result2;		
		
		list1.addBack("i");
		list1.addBack("f");
		list1.addBack("o");
		list1.addBack("u");
		list1.addBack("n");
		list1.addBack("d");
		
		list1.removeAt(2);
		result1 = list1.frontToBack();
		result2 = list1.backToFront();
		displayResults(result1.equals("{ifund}"), "removeAt test1");
		displayResults(result2.equals("{dnufi}"), "removeAt test2");
		
		list1.removeAt(4);
		result1 = list1.frontToBack();
		result2 = list1.backToFront();
		System.out.println(result1);
		System.out.println(result2);
		displayResults(result1.equals("{ifun}"), "removeAt test3");
		displayResults(result2.equals("{nufi}"), "removeAt test4");
		
		list1.removeAt(0);
		result1 = list1.frontToBack();
		result2 = list1.backToFront();
		displayResults(result1.equals("{fun}"), "removeAt test5");
		displayResults(result2.equals("{nuf}"), "removeAt test6");
		
		// Write more tests here		
	}
	
	
	public static void testMergeSorted() {
		System.out.println("\nTesting mergeSorted...");
		A3LinkedList list0 = new A3LinkedList();
		A3LinkedList list1 = new A3LinkedList();
		A3LinkedList list2 = new A3LinkedList();
		
		A3LinkedList resultList;
		
		String result1f;
		String result1b;
		String result2f;
		String result2b;
		String result3f;
		String result3b;
		
		list1.addBack("e");
		list1.addBack("m");
		list1.addBack("x");
		list1.addBack("z");
		
		list2.addBack("a");
		list2.addBack("b");
		list2.addBack("h");
		list2.addBack("p");
		list2.addBack("t");
		
		resultList = list1.mergeSorted(list2);	
		result1f = list1.frontToBack();
		result1b = list1.backToFront();
		result2f = list2.frontToBack();
		result2b = list2.backToFront();
		result3f = resultList.frontToBack();
		result3b = resultList.backToFront();
		displayResults(result1f.equals("{emxz}"), "original list unchanged - mergeSorted test1");
		displayResults(result1b.equals("{zxme}"), "original list unchanged - mergeSorted test2");
		displayResults(result2f.equals("{abhpt}"), "original list unchanged - mergeSorted test3");
		displayResults(result2b.equals("{tphba}"), "original list unchanged - mergeSorted test4");
		displayResults(result3f.equals("{abehmptxz}"), "merged lists correctly  - mergeSorted test5");
		displayResults(result3b.equals("{zxtpmheba}"), "merged lists correctly  - mergeSorted test6");
		
		resultList = list0.mergeSorted(list1);	
		result1f = list0.frontToBack();
		result1b = list0.backToFront();
		result2f = list1.frontToBack();
		result2b = list1.backToFront();
		result3f = resultList.frontToBack();
		result3b = resultList.backToFront();
		displayResults(result1f.equals("{}"), "original list unchanged - mergeSorted test5");
		displayResults(result1b.equals("{}"), "original list unchanged - mergeSorted test6");		
		displayResults(result2f.equals("{emxz}"), "original list unchanged - mergeSorted test7");
		displayResults(result2b.equals("{zxme}"), "original list unchanged - mergeSorted test8");
		displayResults(result3f.equals("{emxz}"), "merged lists correctly  - mergeSorted test9");
		displayResults(result3b.equals("{zxme}"), "merged lists correctly  - mergeSorted test10");
		
		resultList = list2.mergeSorted(list0);	
		result1f = list2.frontToBack();
		result1b = list2.backToFront();
		result2f = list0.frontToBack();
		result2b = list0.backToFront();
		result3f = resultList.frontToBack();
		result3b = resultList.backToFront();
		displayResults(result1f.equals("{abhpt}"), "original list unchanged - mergeSorted test11");
		displayResults(result1b.equals("{tphba}"), "original list unchanged - mergeSorted test12");		
		displayResults(result2f.equals("{}"), "original list unchanged - mergeSorted test13");
		displayResults(result2b.equals("{}"), "original list unchanged - mergeSorted test14");
		displayResults(result3f.equals("{abhpt}"), "merged lists correctly  - mergeSorted test15");
		displayResults(result3b.equals("{tphba}"), "merged lists correctly  - mergeSorted test16");
		
		// Write more tests here
		
	}

	public static void displayResults (boolean passed, String testName) {
       /* There is some magic going on here getting the line number
        * Borrowed from:
        * http://blog.taragana.com/index.php/archive/core-java-how-to-get-java-source-code-line-number-file-name-in-code/
        */
        
        testCount++;
        if (passed)
        {
            System.out.println ("Passed test: " + testName);
            testPassCount++;
        }
        else
        {
            System.out.println ("Failed test: " + testName + " at line "
                                + Thread.currentThread().getStackTrace()[2].getLineNumber());
        }
    }
	
}
