public class A4Tester {
	private static int testPassCount = 0;
	private static int testCount = 0;
	
	public static void main (String[] args)	{
		testCount = 0;
		testPassCount = 0;
		
		/* Part 1: Using the A4List ADT */		
		testBuildingsCount();
		testInhabitantsCount();
		testDistanceAway();
		testDistanceToTallest();
		testNumberVisible();
		
		/* Part 2: Implementing the Generic Stack ADT */
		testStackOperations();
		testStackIsGeneric();
		
		System.out.println("Passed " + testPassCount + " / " + testCount + " tests");
	}
	

	public static void testBuildingsCount() {
		System.out.println("\nTesting buildingsCount...");
		
		Building b1 = new Building("Corner Grocery", 2, 10);
		Building b2 = new Building("Luxury Suites", 3, 48);
		Building b3 = new Building("Bank and ATM", 1, 20);
		Building b4 = new Building("Tech Tower", 5, 120);
		Building b5 = new Building("Central Hotel", 3, 60);
		Building b6 = new Building("Business Empire", 7, 250);
		Building b7 = new Building("Uptown Apartments", 4, 72);
		Building b8 = new Building("ECS", 6, 80);
		Building[] arr1 = {b1};
		Building[] arr2 = {b1, b4, b3, b2};
		Building[] arr3 = {b1, b2, b3, b4, b5, b6, b7, b8};
		
		A4List A4List1 = new ArrayList(arr1);
		A4List A4List2 = new ArrayList(arr2);
		A4List A4List3 = new ArrayList(arr3);
		
		int result = 0;
		int expected = 0;
		
		result = A4Exercises.buildingsCount(A4List1);
		expected = 1;
		displayResults(result == expected, "buildingsCount(A4List1)");
		
		result = A4Exercises.buildingsCount(A4List2);
		expected = 4;
		displayResults(result == expected, "buildingsCount(A4List2)");
		
		result = A4Exercises.buildingsCount(A4List3);
		expected = 8;
		displayResults(result == expected, "buildingsCount(A4List3)");
		
		// Add tests until you are sure your implementation 
		// produces the correct result for all inputs

	}
	
	
	public static void testInhabitantsCount() {
		System.out.println("\nTesting inhabitantsCount...");
		
		Building b1 = new Building("Corner Grocery", 2, 10);
		Building b2 = new Building("Luxury Suites", 3, 48);
		Building b3 = new Building("Bank and ATM", 1, 20);
		Building b4 = new Building("Tech Tower", 5, 120);
		Building b5 = new Building("Central Hotel", 3, 60);
		Building b6 = new Building("Business Empire", 7, 250);
		Building b7 = new Building("Uptown Apartments", 4, 72);
		Building b8 = new Building("ECS", 6, 80);
		Building[] arr1 = {b1};
		Building[] arr2 = {b1, b4, b3, b2};
		Building[] arr3 = {b1, b2, b3, b4, b5, b6, b7, b8};
		
		A4List A4List1 = new ArrayList(arr1);
		A4List A4List2 = new ArrayList(arr2);
		A4List A4List3 = new ArrayList(arr3);
		
		int result = 0;
		int expected = 0;
		
		result = A4Exercises.inhabitantsCount(A4List1);
		expected = 10;
		displayResults(result == expected, "inhabitantsCount(A4List1)");
		
		result = A4Exercises.inhabitantsCount(A4List2);
		expected = 10+48+20+120;
		displayResults(result == expected, "inhabitantsCount(A4List2)");
		
		result = A4Exercises.inhabitantsCount(A4List3);
		expected = 10+48+20+120+60+250+72+80;
		displayResults(result == expected, "inhabitantsCount(A4List3)");
		
		// Add tests until you are sure your implementation 
		// produces the correct result for all inputs

	}


	public static void testDistanceAway() {
		System.out.println("\nTesting distanceAway...");
		
		Building b1 = new Building("Corner Grocery", 2, 10);
		Building b2 = new Building("Luxury Suites", 3, 48);
		Building b3 = new Building("Bank and ATM", 1, 20);
		Building b4 = new Building("Tech Tower", 5, 120);
		Building b5 = new Building("Central Hotel", 3, 60);
		Building b6 = new Building("Business Empire", 7, 250);
		Building b7 = new Building("Uptown Apartments", 4, 72);
		Building b8 = new Building("ECS", 6, 80);
		Building[] arr1 = {b1};
		Building[] arr2 = {b1, b4, b3, b2};
		Building[] arr3 = {b1, b2, b3, b4, b5, b6, b7, b8};
		
		A4List A4List1 = new ArrayList(arr1);
		A4List A4List2 = new ArrayList(arr2);
		A4List A4List3 = new ArrayList(arr3);
		
		int result = 0;
		int expected = 0;
		
		result = A4Exercises.distanceAway(A4List1, b1);
		expected = 0;
		displayResults(result==expected, "distanceAway(A4List1, b1)");
		
		result = A4Exercises.distanceAway(A4List2, b2);
		expected = 3;
		displayResults(result==expected, "distanceAway(A4List2, b2)");
		
		result = A4Exercises.distanceAway(A4List3, b3);
		expected = 2;
		displayResults(result==expected, "distanceAway(A4List3, b3)");

		// Add tests until you are sure your implementation 
		// produces the correct result for all inputs		
		
	}
	

	public static void testDistanceToTallest() {
		System.out.println("\nTesting distanceToTallest...");
		
		Building b1 = new Building("Corner Grocery", 2, 10);
		Building b2 = new Building("Luxury Suites", 3, 48);
		Building b3 = new Building("Bank and ATM", 1, 20);
		Building b4 = new Building("Tech Tower", 5, 120);
		Building b5 = new Building("Central Hotel", 3, 60);
		Building b6 = new Building("Business Empire", 7, 250);
		Building b7 = new Building("Uptown Apartments", 4, 72);
		Building b8 = new Building("ECS", 6, 80);
		Building[] arr1 = {b1};
		Building[] arr2 = {b1, b4, b3, b2};
		Building[] arr3 = {b4, b2, b2, b4};
		Building[] arr4 = {b1, b2, b3, b4, b5, b6, b7, b8};
		
		A4List A4List1 = new ArrayList(arr1);
		A4List A4List2 = new ArrayList(arr2);
		A4List A4List3 = new ArrayList(arr3);
		A4List A4List4 = new ArrayList(arr4);
		
		int result = 0;
		int expected = 0;		
		
		result = A4Exercises.distanceToTallest(A4List1);
		expected = 0;
		displayResults(result==expected, "distanceToTallest(A4List1)");
		
		result = A4Exercises.distanceToTallest(A4List2);
		expected = 1;
		displayResults(result==expected, "distanceToTallest(A4List2)");

		result = A4Exercises.distanceToTallest(A4List3);
		expected = 0;
		displayResults(result==expected, "distanceToTallest(A4List3)");
		
		result = A4Exercises.distanceToTallest(A4List4);
		expected = 5;
		displayResults(result==expected, "distanceToTallest(A4List4)");
		
		// Write more of your own tests here
		
	}
	
	
	public static void testNumberVisible() {
		System.out.println("\nTesting numberVisible...");
		
		Building b1 = new Building("Corner Grocery", 2, 10);
		Building b2 = new Building("Luxury Suites", 3, 48);
		Building b3 = new Building("Bank and ATM", 1, 20);
		Building b4 = new Building("Tech Tower", 5, 120);
		Building b5 = new Building("Central Hotel", 3, 60);
		Building b6 = new Building("Business Empire", 7, 250);
		Building b7 = new Building("Uptown Apartments", 4, 72);
		Building b8 = new Building("ECS", 6, 80);
		Building[] arr1 = {b1};
		Building[] arr2 = {b1, b4, b3, b2};
		Building[] arr3 = {b4, b2, b2, b4};
		Building[] arr4 = {b1, b2, b3, b4, b5, b6, b7, b8};
		
		A4List A4List1 = new ArrayList(arr1);
		A4List A4List2 = new ArrayList(arr2);
		A4List A4List3 = new ArrayList(arr3);
		A4List A4List4 = new ArrayList(arr4);
		
		int result = 0;
		int expected = 0;		
		
		result = A4Exercises.numberVisible(A4List1);
		expected = 1;
		displayResults(result==expected, "numberVisible(A4List1)");
		
		result = A4Exercises.numberVisible(A4List2);
		expected = 2;
		displayResults(result==expected, "numberVisible(A4List2)");

		result = A4Exercises.numberVisible(A4List3);
		expected = 1;
		displayResults(result==expected, "numberVisible(A4List3)");
		
		result = A4Exercises.numberVisible(A4List4);
		expected = 4;
		displayResults(result==expected, "numberVisible(A4List4)");
		
		// Write more of your own tests here
		
	}


	public static void testStackOperations() {
		System.out.println("\nTesting stack operations...");
		A4Stack<Integer> testStack = new A4Stack<Integer>();
		Integer result = 0;
		
		displayResults(testStack.isEmpty(), "stack initially empty");
				
		testStack.push(3);
		testStack.push(2);
		result = testStack.peek();
		displayResults(!testStack.isEmpty(), "stack no longer empty");
		displayResults(result.equals(2), "peek works after initial push");
		result = testStack.pop();
		displayResults(result.equals(2), "pop works after initial push");
		result = testStack.peek();
		displayResults(result.equals(3), "peek works after pop");
		// Write more of your own tests here

	}
	
	public static void testStackIsGeneric() {
		System.out.println("\nTesting generics...");
		A4Stack<Integer> s1 = new A4Stack<Integer>();
		A4Stack<String> s2 = new A4Stack<String>();
		A4Stack<Double> s3 = new A4Stack<Double>();
		
		Integer result1;
		String result2;
		Double result3;
		
		s1.push(3);
		s1.push(8);
		s2.push("CSC");
		s2.push("ENGR");
		s3.push(5.5);
		s3.push(9.1);
		
		result1 = s1.pop();
		result2 = s2.pop();
		result3 = s3.pop();
		
		displayResults(result1.equals(8), "Integer Stack");
		displayResults(result2.equals("ENGR"), "String Stack");
		displayResults(result3.equals(9.1), "Double Stack");		
		
		result1 = s1.peek();
		result2 = s2.peek();
		result3 = s3.peek();
		
		displayResults(result1.equals(3), "Integer Stack");
		displayResults(result2.equals("CSC"), "String Stack");
		displayResults(result3.equals(5.5), "Double Stack");
		
		// Write more of your own tests here
	}
	
	public static void displayResults (boolean passed, String testName) {
		testCount++;
		if (passed)	{
			System.out.println ("Passed test: " + testCount);
			testPassCount++;
		} else {
			System.out.println ("Failed test: " + testName + " at line "
								+ Thread.currentThread().getStackTrace()[2].getLineNumber());
		}
	}
}