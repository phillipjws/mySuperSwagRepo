public class A2Tester {
	private static int testPassCount = 0;
	private static int testCount = 0;
	private static double THRESHOLD = 0.1;
	
	public static void main(String[] args) {
		
		// Part 1
		testIsNamed();
		// testIsShorterThan();
		// testAverageFollowers();
		// testHasHost();
	
		// Part 2
		// testHighestFollowers();
		// testMostFollowers();
		// testNumberShorterThan();
		// testNumberWithInfluencer();
		// testHighestAverageFollowers();
		
		System.out.println("PASSED " + testPassCount + " / " + testCount + " tests");
	}
	
	
	public static void testIsNamed() {
		System.out.println("\nTesting isNamed");
		Influencer in1 = new Influencer("Ninja", "Twitch", 17000000);
		Influencer in2 = new Influencer("Pokimane", "Twitch", 9000000);
		Influencer in3 = new Influencer("CharliDamelio", "TikTok", 136000000);
		Influencer in4a = new Influencer("Liza Koshy", "Vine", 7000000);
		Influencer in4b = new Influencer("Liza Koshy", "Youtube", 17500000);
		Influencer in5 = new Influencer("MrBeast", "Youtube", 94000000);
		Influencer in6 = new Influencer("khaby.lame", "TikTok", 137000000);
		Influencer in7 = new Influencer("Nastya", "Youtube", 76500000);
		
		String toFind = new String("Pokimane");
		boolean result;
		boolean expected;
		
		result = in1.isNamed(toFind);
		expected = false;
		//System.out.println("\nExpected: "+expected+". Result returned: "+result);
		displayResults(result==expected, "in1 is named " + toFind);
		
		result = in2.isNamed(toFind);
		expected = true;
		//System.out.println("\nExpected: "+expected+". Result returned: "+result);
		displayResults(result==expected, "in2 is named " + toFind);
		
		result = in3.isNamed(toFind);
		expected = false;
		//System.out.println("\nExpected: "+expected+". Result returned: "+result);
		displayResults(result==expected, "in3 is named " + toFind);
		
		toFind = new String("Liza Koshy");
		
		result = in1.isNamed(toFind);
		expected = false;
		//System.out.println("\nExpected: "+expected+". Result returned: "+result);
		displayResults(result==expected, "in1 is named " + toFind);
		
		result = in2.isNamed(toFind);
		expected = false;
		//System.out.println("\nExpected: "+expected+". Result returned: "+result);
		displayResults(result==expected, "in2 is named " + toFind);
		
		result = in4a.isNamed(toFind);
		expected = true;
		//System.out.println("\nExpected: "+expected+". Result returned: "+result);
		displayResults(result==expected, "a4a is named " + toFind);

		result = in4b.isNamed(toFind);
		expected = true;
		//System.out.println("\nExpected: "+expected+". Result returned: "+result);
		displayResults(result==expected, "a4a is named " + toFind);
	}
	
	
	public static void testIsShorterThan() {
		System.out.println("\nTesting isShorterThan");
		Influencer in1 = new Influencer("Ninja", "Twitch", 17000000);
		Influencer in2 = new Influencer("Pokimane", "Twitch", 9000000);
		Influencer in3 = new Influencer("CharliDamelio", "TikTok", 136000000);
		Influencer in4a = new Influencer("Liza Koshy", "Vine", 7000000);
		Influencer in4b = new Influencer("Liza Koshy", "Youtube", 17500000);
		Influencer in5 = new Influencer("MrBeast", "Youtube", 94000000);
		Influencer in6 = new Influencer("khaby.lame", "TikTok", 137000000);
		Influencer in7 = new Influencer("Nastya", "Youtube", 76500000);
		
		Influencer[] hosts1 = {in1, in2};
		Influencer[] hosts2 = {in4a, in5, in6};
		Influencer[] hosts3 = {in2, in3};
		Influencer[] hosts4 = {in1, in5, in7};
		
		Podcast p1 = new Podcast("Upcoming Games", hosts1, 30);
		Podcast p2 = new Podcast("The Next Big Thing", hosts2, 60);
		Podcast p3 = new Podcast("Social Media 101", hosts3, 45);
		Podcast p4 = new Podcast("Interacting with Fans: AMA", hosts4, 120);
		
		int timeLimit = 50;
		
		boolean result;
		boolean expected;
		
		result = p1.isShorterThan(timeLimit);
		expected = true;
		//System.out.println("\nExpected: "+expected+". Result returned: "+result);
		displayResults(result==expected, "p1 is shorter than " + timeLimit + " minutes");
		
		result = p2.isShorterThan(timeLimit);
		expected = false;
		//System.out.println("\nExpected: "+expected+". Result returned: "+result);
		displayResults(result==expected, "p2 is shorter than " + timeLimit + " minutes");

		result = p3.isShorterThan(timeLimit);
		expected = true;
		//System.out.println("\nExpected: "+expected+". Result returned: "+result);
		displayResults(result==expected, "p3 is shorter than " + timeLimit + " minutes");
		
		result = p4.isShorterThan(timeLimit);
		expected = false;
		//System.out.println("\nExpected: "+expected+". Result returned: "+result);
		displayResults(result==expected, "p4 is shorter than " + timeLimit + " minutes");
		
		// add tests until you are sure your implementation works correctly
				
	}
		
		
	public static void testAverageFollowers() {
		System.out.println("\nTesting averageFollowers");
		Influencer in1 = new Influencer("Ninja", "Twitch", 17000000);
		Influencer in2 = new Influencer("Pokimane", "Twitch", 9000000);
		Influencer in3 = new Influencer("CharliDamelio", "TikTok", 136000000);
		Influencer in4a = new Influencer("Liza Koshy", "Vine", 7000000);
		Influencer in4b = new Influencer("Liza Koshy", "Youtube", 17500000);
		Influencer in5 = new Influencer("MrBeast", "Youtube", 94000000);
		Influencer in6 = new Influencer("khaby.lame", "TikTok", 137000000);
		Influencer in7 = new Influencer("Nastya", "Youtube", 76500000);
		
		Influencer[] hosts1 = {in1, in2};
		Influencer[] hosts2 = {in4a, in5, in6};
		Influencer[] hosts3 = {in2, in3};
		Influencer[] hosts4 = {in1, in5, in7};
		
		Podcast p1 = new Podcast("Upcoming Games", hosts1, 30);
		Podcast p2 = new Podcast("The Next Big Thing", hosts2, 60);
		Podcast p3 = new Podcast("Social Media 101", hosts3, 45);
		Podcast p4 = new Podcast("Interacting with Fans: AMA", hosts4, 120);
		
		double result;
		double expected;
		
		result = p1.averageFollowers();
		expected = (17000000+9000000)/2.0;
		//System.out.println("\nExpected: "+expected+". Result returned: "+result);
		displayResults(Math.abs(result-expected)<THRESHOLD, "average age of cast in p1");
	
		result = p2.averageFollowers();
		expected = (7000000+94000000+137000000)/3.0;
		//System.out.println("\nExpected: "+expected+". Result returned: "+result);
		displayResults(Math.abs(result-expected)<THRESHOLD, "average age of cast in p2");
	
		// add tests until you are sure your implementation works correctly
	}
	
	
	public static void testHasHost() {
		System.out.println("\nTesting hasHost");
		Influencer in1 = new Influencer("Ninja", "Twitch", 17000000);
		Influencer in2 = new Influencer("Pokimane", "Twitch", 9000000);
		Influencer in3 = new Influencer("CharliDamelio", "TikTok", 136000000);
		Influencer in4a = new Influencer("Liza Koshy", "Vine", 7000000);
		Influencer in4b = new Influencer("Liza Koshy", "Youtube", 17500000);
		Influencer in5 = new Influencer("MrBeast", "Youtube", 94000000);
		Influencer in6 = new Influencer("khaby.lame", "TikTok", 137000000);
		Influencer in7 = new Influencer("Nastya", "Youtube", 76500000);
		
		Influencer[] hosts1 = {in1, in2};
		Influencer[] hosts2 = {in4a, in5, in6};
		Influencer[] hosts3 = {in2, in3};
		Influencer[] hosts4 = {in1, in5, in7};
		
		Podcast p1 = new Podcast("Upcoming Games", hosts1, 30);
		Podcast p2 = new Podcast("The Next Big Thing", hosts2, 60);
		Podcast p3 = new Podcast("Social Media 101", hosts3, 45);
		Podcast p4 = new Podcast("Interacting with Fans: AMA", hosts4, 120);

		boolean result;
		boolean expected;
		
		result = p1.hasHost(in1);
		expected = true;
		//System.out.println("\nExpected: "+expected+". Result returned: "+result);
		displayResults(result==expected, "m1 has "+in1+" as a host");

		result = p1.hasHost(in2);
		expected = true;
		//System.out.println("\nExpected: "+expected+". Result returned: "+result);
		displayResults(result==expected, "m1 has "+in2+" as a host");		
		
		result = p1.hasHost(in3);
		expected = false;
		//System.out.println("\nExpected: "+expected+". Result returned: "+result);
		displayResults(result==expected, "m1 has "+in3+" as a host");	
		
		// add tests until you are sure your implementation works correctly
	}


	public static void testHighestFollowers() {
		System.out.println("\nTesting highestFollowers");
		Influencer in1 = new Influencer("Ninja", "Twitch", 17000000);
		Influencer in2 = new Influencer("Pokimane", "Twitch", 9000000);
		Influencer in3 = new Influencer("CharliDamelio", "TikTok", 136000000);
		Influencer in4a = new Influencer("Liza Koshy", "Vine", 7000000);
		Influencer in4b = new Influencer("Liza Koshy", "Youtube", 17500000);
		Influencer in5 = new Influencer("MrBeast", "Youtube", 94000000);
		Influencer in6 = new Influencer("khaby.lame", "TikTok", 137000000);
		Influencer in7 = new Influencer("Nastya", "Youtube", 76500000);
		
		int result;
		int expected;
		
		result = A2Exercises.highestFollowers(in1, in2);
		expected = 17000000;
		//System.out.println("\nExpected: "+expected+". Result returned: "+result);
		displayResults(result==expected, "highest followers between "+in1+" and "+in2);
		
		// add tests until you are sure your implementation works correctly		
	}
	
	
	public static void testMostFollowers() {
		System.out.println("\nTesting mostFollowers");
		Influencer in1 = new Influencer("Ninja", "Twitch", 17000000);
		Influencer in2 = new Influencer("Pokimane", "Twitch", 9000000);
		Influencer in3 = new Influencer("CharliDamelio", "TikTok", 136000000);
		Influencer in4a = new Influencer("Liza Koshy", "Vine", 7000000);
		Influencer in4b = new Influencer("Liza Koshy", "Youtube", 17500000);
		Influencer in5 = new Influencer("MrBeast", "Youtube", 94000000);
		Influencer in6 = new Influencer("khaby.lame", "TikTok", 137000000);
		Influencer in7 = new Influencer("Nastya", "Youtube", 76500000);
		
		Influencer[] array1 = {in1};
		Influencer[] array2 = {in2, in1};
		Influencer[] array3 = {in4a, in3, in1, in5};
		Influencer[] array4 = {in6, in4a, in3, in1};
		Influencer[] array5 = {in1, in3, in7, in4b, in5, in6, in4a, in3};
		
		Influencer result;
		Influencer expected;
		
		result = A2Exercises.mostFollowers(array1);
		expected = in1;
		//System.out.println("\nExpected: "+expected+". Result returned: "+result);
		displayResults(result.equals(expected), "most followers in array1");

		result = A2Exercises.mostFollowers(array2);
		expected = in1;
		//System.out.println("\nExpected: "+expected+". Result returned: "+result);
		displayResults(result.equals(expected), "most followers in array2");

		// add tests until you are sure your implementation works correctly
	}
	
	
	public static void testNumberShorterThan() {
		System.out.println("\nTesting numberShorterThan");
		Influencer in1 = new Influencer("Ninja", "Twitch", 17000000);
		Influencer in2 = new Influencer("Pokimane", "Twitch", 9000000);
		Influencer in3 = new Influencer("CharliDamelio", "TikTok", 136000000);
		Influencer in4a = new Influencer("Liza Koshy", "Vine", 7000000);
		Influencer in4b = new Influencer("Liza Koshy", "Youtube", 17500000);
		Influencer in5 = new Influencer("MrBeast", "Youtube", 94000000);
		Influencer in6 = new Influencer("khaby.lame", "TikTok", 137000000);
		Influencer in7 = new Influencer("Nastya", "Youtube", 76500000);
		
		Influencer[] hosts1 = {in1, in2};
		Influencer[] hosts2 = {in4a, in5, in6};
		Influencer[] hosts3 = {in2, in3};
		Influencer[] hosts4 = {in1, in5, in7};
		
		Podcast p1 = new Podcast("Upcoming Games", hosts1, 30);
		Podcast p2 = new Podcast("The Next Big Thing", hosts2, 60);
		Podcast p3 = new Podcast("Social Media 101", hosts3, 45);
		Podcast p4 = new Podcast("Interacting with Fans: AMA", hosts4, 120);

		Podcast[] array0 = new Podcast[0]; // empty array
		Podcast[] array1 = {p1};
		Podcast[] array2 = {p1, p2, p3, p4};
		
		int result;
		int expected;
		int timeLimit = 80;
		
		result = A2Exercises.numberShorterThan(array0, timeLimit);
		expected = 0;
		//System.out.println("\nExpected: "+expected+". Result returned: "+result);
		displayResults(result == expected, "array0 podcasts shorter than "+timeLimit+" minutes");

		result = A2Exercises.numberShorterThan(array1, timeLimit);
		expected = 1;
		//System.out.println("\nExpected: "+expected+". Result returned: "+result);
		displayResults(result == expected, "array1 podcasts shorter than "+timeLimit+" minutes");

		result = A2Exercises.numberShorterThan(array2, timeLimit);
		expected = 3;
		//System.out.println("\nExpected: "+expected+". Result returned: "+result);
		displayResults(result == expected, "array2 podcasts shorter than "+timeLimit+" minutes");
		
		// add tests until you are sure your implementation works correctly		
	}
	
	
	public static void testNumberWithInfluencer() {
		System.out.println("\nTesting numberWithInfluencer");
		Influencer in1 = new Influencer("Ninja", "Twitch", 17000000);
		Influencer in2 = new Influencer("Pokimane", "Twitch", 9000000);
		Influencer in3 = new Influencer("CharliDamelio", "TikTok", 136000000);
		Influencer in4a = new Influencer("Liza Koshy", "Vine", 7000000);
		Influencer in4b = new Influencer("Liza Koshy", "Youtube", 17500000);
		Influencer in5 = new Influencer("MrBeast", "Youtube", 94000000);
		Influencer in6 = new Influencer("khaby.lame", "TikTok", 137000000);
		Influencer in7 = new Influencer("Nastya", "Youtube", 76500000);
		
		Influencer[] hosts1 = {in1, in2};
		Influencer[] hosts2 = {in4a, in5, in6};
		Influencer[] hosts3 = {in2, in3};
		Influencer[] hosts4 = {in1, in5, in7};
		
		Podcast p1 = new Podcast("Upcoming Games", hosts1, 30);
		Podcast p2 = new Podcast("The Next Big Thing", hosts2, 60);
		Podcast p3 = new Podcast("Social Media 101", hosts3, 45);
		Podcast p4 = new Podcast("Interacting with Fans: AMA", hosts4, 120);

		Podcast[] array0 = new Podcast[0]; // empty array
		Podcast[] array1 = {p1};
		Podcast[] array2 = {p1, p2, p3, p4};
		
		int result;
		int expected;
		Influencer toFind = in1;
		
		result = A2Exercises.numberWithInfluencer(array0, toFind);
		expected = 0;
		//System.out.println("\nExpected: "+expected+". Result returned: "+result);
		displayResults(result == expected, "array0 podcasts with "+toFind+" as a host");

		result = A2Exercises.numberWithInfluencer(array1, toFind);
		expected = 1;
		//System.out.println("\nExpected: "+expected+". Result returned: "+result);
		displayResults(result == expected, "array1 podcasts with "+toFind+" as a host");

		result = A2Exercises.numberWithInfluencer(array2, toFind);
		expected = 2;
		//System.out.println("\nExpected: "+expected+". Result returned: "+result);
		displayResults(result == expected, "array2 podcasts with "+toFind+" as a host");
		
		// add tests until you are sure your implementation works correctly
	}
	
	
	public static void testHighestAverageFollowers() {
		System.out.println("\nTesting highestAverageFollowers");
		Influencer in1 = new Influencer("Ninja", "Twitch", 17000000);
		Influencer in2 = new Influencer("Pokimane", "Twitch", 9000000);
		Influencer in3 = new Influencer("CharliDamelio", "TikTok", 136000000);
		Influencer in4a = new Influencer("Liza Koshy", "Vine", 7000000);
		Influencer in4b = new Influencer("Liza Koshy", "Youtube", 17500000);
		Influencer in5 = new Influencer("MrBeast", "Youtube", 94000000);
		Influencer in6 = new Influencer("khaby.lame", "TikTok", 137000000);
		Influencer in7 = new Influencer("Nastya", "Youtube", 76500000);
		
		Influencer[] hosts1 = {in1, in2};
		Influencer[] hosts2 = {in4a, in5, in6};
		Influencer[] hosts3 = {in2, in3};
		Influencer[] hosts4 = {in1, in5, in7};
		
		Podcast p1 = new Podcast("Upcoming Games", hosts1, 30);
		Podcast p2 = new Podcast("The Next Big Thing", hosts2, 60);
		Podcast p3 = new Podcast("Social Media 101", hosts3, 45);
		Podcast p4 = new Podcast("Interacting with Fans: AMA", hosts4, 120);

		Podcast[] array1 = {p1};
		Podcast[] array2 = {p1, p2};
		Podcast[] array3 = {p1, p2, p3, p4};

		Podcast result;
		Podcast expected;
		
		result = A2Exercises.highestAverageFollowers(array1);
		expected = p1;
		//System.out.println("\nExpected: "+expected+". Result returned: "+result);
		displayResults(result.equals(expected), "highest average followers of podcast hosts in array1");

		result = A2Exercises.highestAverageFollowers(array2);
		expected = p2;
		//System.out.println("\nExpected: "+expected+". Result returned: "+result);
		displayResults(result.equals(expected), "highest average followers of podcast hosts in array2");
	
		result = A2Exercises.highestAverageFollowers(array3);
		expected = p2;
		//System.out.println("\nExpected: "+expected+". Result returned: "+result);
		displayResults(result.equals(expected), "highest average followers of podcast hosts in array3");
		
		// add tests until you are sure your implementation works correctly
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
	