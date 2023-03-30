public class A5Tester {
	private static int testPassCount = 0;
	private static int testCount = 0;
	private static double THRESHOLD = 0.1; // allowable margin of error for floating point results
	
    public static void main(String[] args) {
		
		/* Linked List Recursion Exercises: */
		testTotalBooks();
		testTotalPages();
		testCountLongerThan();
		testPagesBeforeBookByAuthor();
		testLongestBook();
		testDistanceBetweenBooksByAuthor();

		/* Recursion Exercises using the List ADT */
		testCountMatches();
		// testChangeXToY();
		// testAllEqual();
		// testRangeOfValues();
		
		System.out.println("Passed " + testPassCount + " / " + testCount + " tests");
	}
	
	public static void testTotalBooks() {
		System.out.println("\nTesting totalBooks");
		LinkedBookList list1 = new LinkedBookList();
		LinkedBookList list2 = new LinkedBookList();
		LinkedBookList list3 = new LinkedBookList();
		
		Book b1 = new Book("Gone Girl", "Gillian Flynn", 432);
		Book b2 = new Book("Divergent", "Veronica Roth", 487);
		Book b3 = new Book("Hunger Games", "Suzanne Collins", 374);
		Book b4 = new Book("Mockingjay", "Suzanne Collins", 390);
		Book b5 = new Book("Jade City", "Fonda Lee", 560);
		Book b6 = new Book("Insurgent", "Veronica Roth", 525);
		Book b7 = new Book("Allegiant", "Veronica Roth", 526);
		Book[] books1 = {b1};
		Book[] books2 = {b1, b2, b3};
		Book[] books3 = {b1, b2, b3, b4, b5};
		list1.buildFromArray(books1);
		list2.buildFromArray(books2);
		list3.buildFromArray(books3);
		
		int result = 0;
		int expected = 0;
		
		result = list1.totalBooks();
		expected = 1;
		displayResults(result==expected, "totalBooks in list1");
		
		result = list2.totalBooks();
		expected = 3;
		displayResults(result==expected, "totalBooks in list2");
		
		result = list3.totalBooks();
		expected = 5;
		displayResults(result==expected, "totalBooks in list3");
		
		// Write more tests here
		
		LinkedBookList list4 = new LinkedBookList();
		LinkedBookList list5 = new LinkedBookList();
		Book[] books4 = {b1, b2, b3, b4, b5, b6, b7};
		list4.buildFromArray(books4);
		
		result = list4.totalBooks();
		expected = 7;
		displayResults(result==expected, "totalBooks in list4");	

		result = list5.totalBooks();
		expected = 0;
		displayResults(result==expected, "totalBooks in list5");			
		
		System.out.println();		
	}
	
	public static void testTotalPages() {
		System.out.println("\nTesting totalPages");
		LinkedBookList list1 = new LinkedBookList();
		LinkedBookList list2 = new LinkedBookList();
		LinkedBookList list3 = new LinkedBookList();
		
		Book b1 = new Book("Gone Girl", "Gillian Flynn", 432);
		Book b2 = new Book("Divergent", "Veronica Roth", 487);
		Book b3 = new Book("Hunger Games", "Suzanne Collins", 374);
		Book b4 = new Book("Mockingjay", "Suzanne Collins", 390);
		Book b5 = new Book("Jade City", "Fonda Lee", 560);
		Book b6 = new Book("Insurgent", "Veronica Roth", 525);
		Book b7 = new Book("Allegiant", "Veronica Roth", 526);
		Book[] books1 = {b1};
		Book[] books2 = {b1, b2, b3};
		Book[] books3 = {b1, b2, b3, b4, b5};
		list1.buildFromArray(books1);
		list2.buildFromArray(books2);
		list3.buildFromArray(books3);
		
		int result = 0;
		int expected = 0;
		
		result = list1.totalPages();
		expected = 432;
		displayResults(result==expected, "totalPages in list1");
		
		result = list2.totalPages();
		expected = 432+487+374;
		displayResults(result==expected, "totalPages in list2");
		
		result = list3.totalPages();
		expected = 432+487+374+390+560;
		displayResults(result==expected, "totalPages in list3");
		
		// Write more tests here
		
		LinkedBookList list4 = new LinkedBookList();
		LinkedBookList list5 = new LinkedBookList();
		Book[] books4 = {b1, b2, b3, b4, b5, b6, b7};
		list4.buildFromArray(books4);
		
		result = list4.totalPages();
		expected = 432+487+374+390+560+525+526;
		displayResults(result==expected, "totalPages in list4");	

		result = list5.totalPages();
		expected = 0;
		displayResults(result==expected, "totalPages in list5");			
		
		System.out.println();
	}
	
	public static void testCountLongerThan() {
		System.out.println("\nTesting countLongerThan");
		LinkedBookList list1 = new LinkedBookList();
		LinkedBookList list2 = new LinkedBookList();
		LinkedBookList list3 = new LinkedBookList();
		
		Book b1 = new Book("Gone Girl", "Gillian Flynn", 432);
		Book b2 = new Book("Divergent", "Veronica Roth", 487);
		Book b3 = new Book("Hunger Games", "Suzanne Collins", 374);
		Book b4 = new Book("Mockingjay", "Suzanne Collins", 390);
		Book b5 = new Book("Jade City", "Fonda Lee", 560);
		Book b6 = new Book("Insurgent", "Veronica Roth", 525);
		Book b7 = new Book("Allegiant", "Veronica Roth", 526);
		Book[] books1 = {b1};
		Book[] books2 = {b1, b2, b3};
		list1.buildFromArray(books1);
		list2.buildFromArray(books2);
		
		int result = 0;
		int expected = 0;
		
		result = list1.countLongerThan(b2);
		expected = 0;
		displayResults(result==expected, "count books longer than b2 in list1");
		
		result = list1.countLongerThan(b3);
		expected = 1;
		displayResults(result==expected, "count books longer than b3 in list1");
		
		result = list2.countLongerThan(b4);
		expected = 2;
		displayResults(result==expected, "count books longer than b4 in list2");

		result = list2.countLongerThan(b5);
		expected = 0;
		displayResults(result==expected, "count books longer than b5 in list2");
		
		// Write more tests here
		
		Book[] books3 = {b1, b2, b4, b6};
		list3.buildFromArray(books3);

		result = list3.countLongerThan(b1);
		expected = 2;
		displayResults(result==expected, "count books longer than b1 in list3");
		
		result = list3.countLongerThan(b3);
		expected = 4;
		displayResults(result==expected, "count books longer than b3 in list3");
		
		result = list3.countLongerThan(b5);
		expected = 0;
		displayResults(result==expected, "count books longer than b5 in list3");

		System.out.println();
	}
	
	public static void testPagesBeforeBookByAuthor() {
		System.out.println("Testing pagesBeforeBookByAuthor");
		LinkedBookList list1 = new LinkedBookList();
		LinkedBookList list2 = new LinkedBookList();
		LinkedBookList list3 = new LinkedBookList();
		
		Book b1 = new Book("Gone Girl", "Gillian Flynn", 432);
		Book b2 = new Book("Divergent", "Veronica Roth", 487);
		Book b3 = new Book("Hunger Games", "Suzanne Collins", 374);
		Book b4 = new Book("Mockingjay", "Suzanne Collins", 390);
		Book b5 = new Book("Jade City", "Fonda Lee", 560);
		Book b6 = new Book("Insurgent", "Veronica Roth", 525);
		Book b7 = new Book("Allegiant", "Veronica Roth", 526);
		Book[] books1 = {b1};
		Book[] books2 = {b1, b2, b3};
		Book[] books3 = {b1, b2, b3, b4, b5, b6, b7};
		list1.buildFromArray(books1);
		list2.buildFromArray(books2);
		list3.buildFromArray(books3);
		
		int result = 0;
		int expected = 0;
		
		result = list1.pagesBeforeBookByAuthor("Gillian Flynn");
		expected = 0;
		displayResults(result==expected, "pagesBeforeBookByAuthor Gillian Flynn in list1");
		
		result = list2.pagesBeforeBookByAuthor("Suzanne Collins");
		expected = 432+487;
		displayResults(result==expected, "pagesBeforeBookByAuthor Suzanne Collins in list2");
		
		result = list3.pagesBeforeBookByAuthor("Fonda Lee");
		expected = 432+487+374+390;
		displayResults(result==expected, "pagesBeforeBookByAuthor Fonda Lee in list3");
		
		// TODO: add more tests here
		
		result = list3.pagesBeforeBookByAuthor("Veronica Roth");
		expected = 432;
		displayResults(result==expected, "pagesBeforeBookByAuthor Fonda Lee in list3");
		
		System.out.println();
	}

	public static void testLongestBook() {
		System.out.println("\nTesting longestBook");
		LinkedBookList list1 = new LinkedBookList();
		LinkedBookList list2 = new LinkedBookList();
		LinkedBookList list3 = new LinkedBookList();
		
		Book b1 = new Book("Gone Girl", "Gillian Flynn", 432);
		Book b2 = new Book("Divergent", "Veronica Roth", 487);
		Book b3 = new Book("Hunger Games", "Suzanne Collins", 374);
		Book b4 = new Book("Mockingjay", "Suzanne Collins", 390);
		Book b5 = new Book("Jade City", "Fonda Lee", 560);
		Book[] books1 = {b1};
		Book[] books2 = {b1, b2};
		Book[] books3 = {b1, b2, b3, b4, b5};
		list1.buildFromArray(books1);
		list2.buildFromArray(books2);
		list3.buildFromArray(books3);
		
		Book result = null;
		Book expected = null;
		
		result = list1.longestBook();
		expected = b1;
		displayResults(result.equals(expected), "longest book in list1");
		
		result = list2.longestBook();
		expected = b2;
		displayResults(result.equals(expected), "longest book in list2");
		
		result = list3.longestBook();
		expected = b5;
		displayResults(result.equals(expected), "longest book in list3");
		
		// TODO: add more tests here
		
		LinkedBookList list4 = new LinkedBookList();
		LinkedBookList list5 = new LinkedBookList();
		LinkedBookList list6 = new LinkedBookList();
		LinkedBookList list7 = new LinkedBookList();
		
		Book b6 = new Book("Insurgent", "Veronica Roth", 525);
		Book b7 = new Book("Allegiant", "Veronica Roth", 526);
		Book[] books4 = {b1, b2, b3, b4, b5, b6, b7};
		Book[] books5 = {b5, b2, b3, b4, b1, b6, b7};
		Book[] books6 = {b4, b3, b2, b1, b5, b6, b7};
		Book b7Copy = new Book("Allegiant copy", "Veronica Roth", 526);
		Book[] books7 = {b1, b7, b7Copy, b2};
		
		list4.buildFromArray(books4);
		list5.buildFromArray(books5);
		list6.buildFromArray(books6);
		list7.buildFromArray(books7);
		
		result = list4.longestBook();
		expected = b5;
		displayResults(result.equals(expected), "longest book in list4");
		
		result = list5.longestBook();
		expected = b5;
		displayResults(result.equals(expected), "longest book in list5");
		
		result = list6.longestBook();
		expected = b5;
		displayResults(result.equals(expected), "longest book in list6");
		
		result = list7.longestBook();
		expected = b7;
		displayResults(result.equals(expected), "longest book in list7");
		
		System.out.println();
	}

	public static void testDistanceBetweenBooksByAuthor() {
		System.out.println("\nTesting distanceBetweenBooksByAuthor");
		LinkedBookList list1 = new LinkedBookList();
		LinkedBookList list2 = new LinkedBookList();
		LinkedBookList list3 = new LinkedBookList();
		
		Book b1 = new Book("Gone Girl", "Gillian Flynn", 432);
		Book b2 = new Book("Divergent", "Veronica Roth", 487);
		Book b3 = new Book("Hunger Games", "Suzanne Collins", 374);
		Book b4 = new Book("Mockingjay", "Suzanne Collins", 390);
		Book b5 = new Book("Jade City", "Fonda Lee", 560);
		Book b6 = new Book("Insurgent", "Veronica Roth", 525);
		Book b7 = new Book("Allegiant", "Veronica Roth", 526);
		Book[] books1 = {b1, b1};
		Book[] books2 = {b1, b2, b1};
		Book[] books3 = {b1, b2, b3, b4, b5, b6, b1};
		list1.buildFromArray(books1);
		list2.buildFromArray(books2);
		list3.buildFromArray(books3);

		int result = 0;
		int expected = 0;
		
		result = list1.distanceBetweenBooksByAuthor("Gillian Flynn");
		expected = 0;
		displayResults(result==expected, "distance between books by Gillian Flynn in list1");
		
		result = list2.distanceBetweenBooksByAuthor("Gillian Flynn");
		expected = 1;
		displayResults(result==expected, "distance between books by Gillian Flynn in list2");
		
		result = list3.distanceBetweenBooksByAuthor("Gillian Flynn");
		expected = 5;
		displayResults(result==expected, "distance between books by Gillian Flynn in list3");

		// Write more tests here
		
		result = list3.distanceBetweenBooksByAuthor("Veronica Roth");
		expected = 3;
		displayResults(result==expected, "distance between books by Veronica Roth in list3");
		
		result = list3.distanceBetweenBooksByAuthor("Suzanne Collins");
		expected = 0;
		displayResults(result==expected, "distance between books by Veronica Roth in list3");
	
		System.out.println();	
	
	}

	public static void testCountMatches() {
		System.out.println("\nTesting countMatches");
		SinglyLinkedList<Book> list0 = new SinglyLinkedList<Book>();
		SinglyLinkedList<Integer> list1 = new SinglyLinkedList<Integer>();
		SinglyLinkedList<String> list2 = new SinglyLinkedList<String>();
		SinglyLinkedList<Book> list3 = new SinglyLinkedList<Book>();
		Integer[] arr1 = {9, 3, 1, 2, 3, 3, 4, 2, 1, 2, 1, 1};
		String[]  arr2 = {"test", "the", "test", "to", "test", "the", "test"};
		
		Book b1 = new Book("Gone Girl", "Gillian Flynn", 432);
		Book b2 = new Book("Divergent", "Veronica Roth", 487);
		Book b3 = new Book("Hunger Games", "Suzanne Collins", 374);
		Book b4 = new Book("Mockingjay", "Suzanne Collins", 390);
		Book[] arr3 = {b1, b2, b2, b1, b3, b4, b1};
		
		list1.buildFromArray(arr1); // list1: {9, 3, 1, 2, 3, 3, 4, 2, 1, 2, 1, 1}
		list2.buildFromArray(arr2); // list2: {"test", "the", "test", "to", "test", "the", "test"};
		list3.buildFromArray(arr3);
		
		int result = 0;
		int expected = 0;
		
		result = A5Exercises.countMatches(list0, b1);
		expected = 0;
		displayResults(result==expected, "count b1s in empty list");
		
		result = A5Exercises.countMatches(list1, 9);
		expected = 1;
		displayResults(result==expected, "count 9s in list1");
		
		result = A5Exercises.countMatches(list2, new String("the"));
		expected = 2;
		displayResults(result==expected, "count 'the' in list2");
		
		// TODO: write more tests here
	
		result = A5Exercises.countMatches(list1, 5);
		expected = 0;
		displayResults(result==expected, "countMatches, no matches found");
		
		result = A5Exercises.countMatches(list1, 4);
		expected = 1;
		displayResults(result==expected, "countMatches, one found");
		
		result = A5Exercises.countMatches(list1, 2);
		expected = 3;
		displayResults(result==expected, "countMatches, found in middle");
		
		result = A5Exercises.countMatches(list1, 2);
		expected = 3;
		displayResults(result==expected, "countMatches, found in a row");
		
		result = A5Exercises.countMatches(list1, 9);
		expected = 1;
		displayResults(result==expected, "countMatches, found at beginning");
		
		result = A5Exercises.countMatches(list1, 1);
		expected = 4;
		displayResults(result==expected, "countMatches, found at end");

		result = A5Exercises.countMatches(list2, new String("computer"));
		expected = 0;
		displayResults(result==expected, "countMatches, found in middle");

		result = A5Exercises.countMatches(list2, new String("test"));
		expected = 4;
		displayResults(result==expected, "countMatches, found at both ends");
		
		result = A5Exercises.countMatches(list3, b2);
		expected = 2;
		displayResults(result==expected, "countMatches, with book objects");

		result = A5Exercises.countMatches(list3, b1);
		expected = 3;
		displayResults(result==expected, "countMatches, books found at both ends");

		System.out.println();	
	}
	
	public static void testChangeXToY() {
		System.out.println("\nTesting changeXToY");
		SinglyLinkedList<Book> list0 = new SinglyLinkedList<Book>();
		SinglyLinkedList<Integer> list1 = new SinglyLinkedList<Integer>();
		SinglyLinkedList<String> list2 = new SinglyLinkedList<String>();
		SinglyLinkedList<Book> list3 = new SinglyLinkedList<Book>();
		Integer[] arr1 = {9, 3, 1, 2, 3, 3, 4, 2, 1, 2, 1, 1};
		String[]  arr2 = {"test", "the", "test", "to", "test", "the", "test"};
		
		Book b1 = new Book("Gone Girl", "Gillian Flynn", 432);
		Book b2 = new Book("Divergent", "Veronica Roth", 487);
		Book b3 = new Book("Hunger Games", "Suzanne Collins", 374);
		Book b4 = new Book("Mockingjay", "Suzanne Collins", 390);
		Book[] arr3 = {b1, b2, b2, b1, b3, b4, b1};
		
		list1.buildFromArray(arr1); // list1: {9, 3, 1, 2, 3, 3, 4, 2, 1, 2, 1, 1}
		list2.buildFromArray(arr2); // list2: {"test", "the", "test", "to", "test", "the", "test"};
		list3.buildFromArray(arr3);
		
		String result = "";
		String expected = "";		
		
		A5Exercises.changeXToY(list0, b1, b2);
		result = list0.toString();
		expected = "{}";
		displayResults(result.equals(expected), "change all in empty list");
		
		list0.add(b1);
		list0.add(b3);
		A5Exercises.changeXToY(list0, b1, b3);
		result = list0.toString();
		expected = "{Hunger Games - Suzanne Collins, Hunger Games - Suzanne Collins}";
		// System.out.println(result);
		displayResults(result.equals(expected), "change all "+b1+" to "+b3);
		
		A5Exercises.changeXToY(list1, 2, 4);
		result = list1.toString();
		expected = "{9, 3, 1, 4, 3, 3, 4, 4, 1, 4, 1, 1}";
		displayResults(result.equals(expected), "change all 2s to 4s");
				
		A5Exercises.changeXToY(list1, 1, 3);
		result = list1.toString();
		expected = "{9, 3, 3, 4, 3, 3, 4, 4, 3, 4, 3, 3}";
		displayResults(result.equals(expected), "change all 1s to 3s");
		
		// Write more tests here
		
		A5Exercises.changeXToY(list1, 9, 3);
		result = list1.toString();
		expected = "{3, 3, 3, 4, 3, 3, 4, 4, 3, 4, 3, 3}";
		displayResults(result.equals(expected), "change all 9s to 3s");
		
		A5Exercises.changeXToY(list1, 3, 4);
		result = list1.toString();
		expected = "{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}";
		displayResults(result.equals(expected), "change all 3s to 4s");
		
		String toChange = new String("test");
		A5Exercises.changeXToY(list2, toChange, "to");
		result = list2.toString();
		expected = "{to, the, to, to, to, the, to}";
		displayResults(result.equals(expected), "change all 'test' to 'to'");
		
		toChange = new String("to");
		A5Exercises.changeXToY(list2, toChange, "the");
		result = list2.toString();
		expected = "{the, the, the, the, the, the, the}";
		displayResults(result.equals(expected), "change all 'to' to 'the'");
		
		System.out.println();
	}
	
	public static void testAllEqual() {
		System.out.println("\nTesting allEqual");
		SinglyLinkedList<Book> list0 = new SinglyLinkedList<Book>();
		SinglyLinkedList<Integer> list1 = new SinglyLinkedList<Integer>();
		SinglyLinkedList<String> list2 = new SinglyLinkedList<String>();
		
		Integer[] arr1 = {3, 3, 3, 3, 3};
		String[]  arr2 = {"buffalo", "buffalo", "buffalo", "buffalo", "buffalo"};
		
		list1.buildFromArray(arr1); // list1: {3, 3, 3, 3, 3};
		list2.buildFromArray(arr2); // list2: {"buffalo", "buffalo", "buffalo", "buffalo", "buffalo"};
		
		boolean result = false;
		boolean expected = false;
				
		result = A5Exercises.allEqual(list0);
		expected = true;
		displayResults(result==expected, "allEqual in empty list");
		
		result = A5Exercises.allEqual(list1);
		expected = true;
		displayResults(result==expected, "allEqual with Integers");
		
		result = A5Exercises.allEqual(list2);
		expected = true;
		displayResults(result==expected, "allEqual with Strings");
		
		// write more test here
		
		SinglyLinkedList<Integer> list3 = new SinglyLinkedList<Integer>();
		SinglyLinkedList<Integer> list4 = new SinglyLinkedList<Integer>();
		Integer[] arr3 = {3, 3, 3, 3, 3, 4};
		Integer[] arr4 = {4, 3, 3, 3};
		list3.buildFromArray(arr3); // list1: {3, 3, 3, 3, 3, 4}
		list4.buildFromArray(arr4); // list2: {4, 3, 3, 3}
		
		
		result = A5Exercises.allEqual(list3);
		expected = false;
		displayResults(result==expected, "allEqual except last element");
		
		result = A5Exercises.allEqual(list4);
		expected = false;
		displayResults(result==expected, "allEqual except first element");
		
		System.out.println();
	}
	
	public static void testRangeOfValues() {
		System.out.println("\nTesting rangeOfValues");
		SinglyLinkedList<Integer> list0 = new SinglyLinkedList<Integer>();
		SinglyLinkedList<Integer> list1 = new SinglyLinkedList<Integer>();
		SinglyLinkedList<Integer> list2 = new SinglyLinkedList<Integer>();
		Integer[] arr1 = {3}; // range of values is 1 (just 3)
		Integer[] arr2 = {3, 1, 7, 5, 0, 4}; // range of values between 0 and 7
											 // is 8: 0, 1, 2, 3, 4, 5, 6, and 7
		list1.buildFromArray(arr1);
		list2.buildFromArray(arr2);
				
		int result = 0;
		int expected = 0;
		
		result = A5Exercises.rangeOfValues(list0);
		expected = 0;
		displayResults(result==expected, "rangeOfValues in empty list");
		
		result = A5Exercises.rangeOfValues(list1);
		expected = 1;
		displayResults(result==expected, "rangeOfValues in list with 1 element");
		
		result = A5Exercises.rangeOfValues(list2);
		expected = 8;
		displayResults(result==expected, "rangeOfValues in {7,1,3,5,0,4}");
		
		// Write more tests here
		SinglyLinkedList<Integer> list3 = new SinglyLinkedList<Integer>();
		SinglyLinkedList<Integer> list4 = new SinglyLinkedList<Integer>();
		SinglyLinkedList<Integer> list5 = new SinglyLinkedList<Integer>();
		SinglyLinkedList<Integer> list6 = new SinglyLinkedList<Integer>();
		Integer[] arr3 = {9, 7}; // range of values between 7 and 9 is 3: 7, 8, 9
		Integer[] arr4 = {9, 1, 2, 3}; // range of values between 1 and 9 is 9
		Integer[] arr5 = {3, 2, 1, 9}; // range of values between 1 and 9 is 9
		Integer[] arr6 = {8, 5, 4, 7, 2}; // range of values between 2 and 8 is 7
		
		list3.buildFromArray(arr3);
		list4.buildFromArray(arr4);
		list5.buildFromArray(arr5);
		list6.buildFromArray(arr6);
		
		result = A5Exercises.rangeOfValues(list3);
		expected = 3;
		displayResults(result==expected, "rangeOfValues in {9,7}");
		
		result = A5Exercises.rangeOfValues(list4);
		expected = 9;
		displayResults(result==expected, "rangeOfValues in {9,1,2,3}");
		
		result = A5Exercises.rangeOfValues(list5);
		expected = 9;
		displayResults(result==expected, "rangeOfValues in {3,2,1,9}");
		
		result = A5Exercises.rangeOfValues(list6);
		expected = 7;
		displayResults(result==expected, "rangeOfValues in {8,5,4,7,2}");
		
		System.out.println();
	}
	
	public static void displayResults (boolean passed, String testName) {
		testCount++;
		if (passed) {
			System.out.println ("Passed test: " + testName);
			testPassCount++;
		} else {
			System.out.println ("Failed test: " + testName + " at line "
				+ Thread.currentThread().getStackTrace()[2].getLineNumber());
		}
    }
}