public class A6Tester {	
	private static int testPassCount = 0;
	private static int testCount = 0;	
	
	public static void main(String[] args) {
		A6ListTests();
		cinemaTests();
		
		System.out.println("Passed " + testPassCount + " / " + testCount + " tests");
	}
	
	public static void A6ListTests() {
		System.out.println("\nTesting linked A6List implementation");
		
		LinkedList<Integer> A6List1 = new LinkedList<Integer>();
		LinkedList<Integer> A6List2 = new LinkedList<Integer>();
		LinkedList<Integer> A6List3 = new LinkedList<Integer>();
		LinkedList<Integer> A6List4 = new LinkedList<Integer>();
		
		String expected = "";
		String result = "";
		
		displayResults(A6List1.size()==0, "size of empty A6List");
		
		A6List1.addFront(2);
		A6List2.addFront(2);
		displayResults(A6List1.size()==1, "size after inserting to front");
		
		A6List3.addBack(3);
		A6List4.addBack(3);
		displayResults(A6List3.size()==1, "size after inserting to back");
		
		A6List1.addFront(1);
		result = A6List1.toString();
		expected = "{1 2}";
		displayResults(result.equals(expected), "elements in A6List correct");
		
		A6List2.addBack(3);
		result = A6List2.toString();
		expected = "{2 3}";
		displayResults(result.equals(expected), "elements in A6List correct");
	
		A6List3.addFront(2);
		result = A6List3.toString();
		expected = "{2 3}";
		displayResults(result.equals(expected), "elements in A6List correct");
		
		A6List4.addBack(4);
		result = A6List4.toString();
		expected = "{3 4}";
		displayResults(result.equals(expected), "elements in A6List correct");
		
		try {
			A6List1.insertAt(0, 8);
			displayResults(A6List1.size()==3, "size after third insert");
			result = A6List1.toString();
			expected = "{8 1 2}";
			displayResults(result.equals(expected), "contents after third insert");
		} catch (InvalidPositionException e) {
			System.out.println("exception thrown");
			displayResults(false, "size after third insert");
			displayResults(false, "contents after third insert");
		}
		
		try {
			A6List2.insertAt(1, 8);
			displayResults(A6List2.size()==3, "size after third insert");
			result = A6List2.toString();
			expected = "{2 8 3}";
			displayResults(result.equals(expected), "contents after third insert");
		} catch (InvalidPositionException e) {
			System.out.println("exception thrown");
			displayResults(false, "size after third insert");
			displayResults(false, "contents after third insert");
		}
		
		try {
			A6List3.insertAt(2, 8);
			displayResults(A6List3.size()==3, "size after third insert");
			result = A6List3.toString();
			expected = "{2 3 8}";
			displayResults(result.equals(expected), "contents after third insert");
		} catch (InvalidPositionException e) {
			System.out.println("exception thrown");
			displayResults(false, "size after third insert");
			displayResults(false, "contents after third insert");
		}
		
		try {
			A6List4.insertAt(3, 8);
			displayResults(false, "size after third insert");
			displayResults(false, "contents after third insert");
		} catch (InvalidPositionException e) {
			System.out.println("exception thrown");
			displayResults(A6List4.size()==2, "size after third insert");
			result = A6List4.toString();
			expected = "{3 4}";
			displayResults(result.equals(expected), "contents after third insert");
		}
		
		
		Integer removed = null;
		
		try {
			removed = A6List1.removeFront();
			removed = A6List1.removeFront();
			removed = A6List1.removeFront();
			displayResults(A6List1.size()==0, "size after removeFronts");
			displayResults(removed.equals(2), "element returned after removeFronts");
		} catch (A6ListEmptyException e) {
			System.out.println("exception thrown");
			displayResults(false, "size after removeFronts");
			displayResults(false, "element returned after removeFronts");
		}

		try {
			removed = A6List2.removeBack();
			removed = A6List2.removeBack();
			removed = A6List2.removeBack();
			displayResults(A6List2.size()==0, "size after removeBacks");
			displayResults(removed.equals(2), "element returned after removeBacks");
		} catch (A6ListEmptyException e) {
			System.out.println("exception thrown");
			displayResults(false, "size after removeBacks");
			displayResults(false, "element returned after removeBacks");
		}

		try {
			removed = A6List3.removeBack();
			removed = A6List3.removeFront();
			removed = A6List3.removeBack();
			displayResults(A6List3.size()==0, "size after removals");
			displayResults(removed.equals(3), "element returned after removals");
		} catch (A6ListEmptyException e) {
			System.out.println("exception thrown");
			displayResults(false, "size after removals");
			displayResults(false, "element returned after removals");
		}
		
		try {
			removed = A6List4.removeFront();
			removed = A6List4.removeBack();
			removed = A6List4.removeFront();
			displayResults(false, "size after removals");
			displayResults(false, "element returned after removals");
		} catch (A6ListEmptyException e) {
			System.out.println("exception thrown");
			displayResults(A6List4.size()==0, "size after removals");
			displayResults(removed.equals(4), "element returned after removals");
		}
		
		try {
			A6List1.addBack(9);
			displayResults(A6List1.size()==1, "size after insert at removeAll");
			result = A6List1.toString();
			expected = "{9}";
			displayResults(expected.equals(result), "contents after insert at removeAll");
		} catch (Exception e) {
			System.out.println("exception thrown");
			displayResults(false, "size after insert at removeAll");
			displayResults(false, "contents after insert at removeAll");
		}
		
		try {
			A6List2.addBack(9);
			displayResults(A6List2.size()==1, "size after insert at removeAll");
			result = A6List2.toString();
			expected = "{9}";
			displayResults(expected.equals(result), "contents after insert at removeAll");
		} catch (Exception e) {
			System.out.println("exception thrown");
			displayResults(false, "size after insert at removeAll");
			displayResults(false, "contents after insert at removeAll");
		}
		
		try {
			A6List3.addFront(9);
			displayResults(A6List3.size()==1, "size after insert at removeAll");
			result = A6List3.toString();
			expected = "{9}";
			displayResults(expected.equals(result), "contents after insert at removeAll");
		} catch (Exception e) {
			System.out.println("exception thrown");
			displayResults(false, "size after insert at removeAll");
			displayResults(false, "contents after insert at removeAll");
		}

		try {
			A6List4.addFront(9);
			displayResults(A6List4.size()==1, "size after insert at removeAll");
			result = A6List4.toString();
			expected = "{9}";
			displayResults(expected.equals(result), "contents after insert at removeAll");
		} catch (Exception e) {
			System.out.println("exception thrown");
			displayResults(false, "size after insert at removeAll");
			displayResults(false, "contents after insert at removeAll");
		}	
		
		try {
			A6List1.removeFront();
			A6List1.removeFront();
			displayResults(false, "correct exception thrown when removing from empty A6List");
		} catch (A6ListEmptyException e) {
			System.out.println("exception thrown");
			displayResults(true, "correct exception thrown when removing from empty A6List");
		} catch (Exception e) {
			System.out.println("exception thrown");
			displayResults(false, "correct exception thrown when removing from empty A6List");
		}
		
		try {
			A6List2.removeBack();
			A6List2.removeBack();
			displayResults(false, "correct exception thrown when removing from empty A6List");
		} catch (A6ListEmptyException e) {
			System.out.println("exception thrown");
			displayResults(true, "correct exception thrown when removing from empty A6List");
		} catch (Exception e) {
			System.out.println("exception thrown");
			displayResults(false, "correct exception thrown when removing from empty A6List");
		}
		
		try {
			A6List3.removeBack();
			A6List3.removeFront();
			displayResults(false, "correct exception thrown when removing from empty A6List");
		} catch (A6ListEmptyException e) {
			System.out.println("exception thrown");
			displayResults(true, "correct exception thrown when removing from empty A6List");
		} catch (Exception e) {
			System.out.println("exception thrown");
			displayResults(false, "correct exception thrown when removing from empty A6List");
		}
		
		try {
			A6List4.removeFront();
			A6List4.removeBack();
			displayResults(false, "correct exception thrown when removing from empty A6List");
		} catch (A6ListEmptyException e) {
			System.out.println("exception thrown");
			displayResults(true, "correct exception thrown when removing from empty A6List");
		} catch (Exception e) {
			System.out.println("exception thrown");
			displayResults(false, "correct exception thrown when removing from empty A6List");
		}
	
	}
	
	public static void cinemaTests() {
		System.out.println("\nTesting Cinema Lineup implementation");
		
		Person p1 = new Person("Ali", 23);
		Person p2 = new Person("Juan", 23);
		Person p3 = new Person("Sam", 23);
		Person p4 = new Person("Yiyi", 23);
		Person p5 = new Person("Lee", 23);
		Person p6 = new Person("Mika", 23);
		Person p7 = new Person("Ola", 23);
		
		CinemaLine cl = new CinemaLine();
		Person result = null;
		Person expected = null;
		boolean inserted = false;
		int numRemoved = 0;
		
		displayResults(cl.peopleInLine()==0, "people in empty line");
		
		try {
			result = cl.handleOne();
			displayResults(result == null, "handled person in empty line");
		} catch (Exception e) {
			System.out.println("exception thrown");
			displayResults(false, "handled person in empty line");
		}
		
		cl.enterLine(p1);
		displayResults(cl.peopleInLine()==1, "people in line 1");
		cl.enterLine(p2);
		cl.enterLine(p3);
		cl.enterLine(p4);
		displayResults(cl.peopleInLine()==4, "people in line 2");
		
		
		try {
			result = cl.handleOne();
			expected = p1;
			if (result == null) {
				displayResults(false, "handled first person in line 1");
			} else {
				displayResults(result.equals(expected), "handled first person in line 1");
			}
		} catch (Exception e) {
			System.out.println("exception thrown");
			displayResults(false, "handled first person in line 1");
		}
		
		displayResults(cl.peopleInLine()==3, "people in line 3");
		cl.enterLine(p5);
		cl.enterLine(p6);
		displayResults(cl.peopleInLine()==5, "people in line 4");
		
		try {
			inserted = cl.premiumEntry(p7, 2);
			displayResults(inserted==true, "inserted into specific pos");
		} catch (Exception e) {
			displayResults(false, "inserted into specific pos");
		}
		
		try {
			result = cl.handleOne();
			expected = p2;
			if (result == null) {
				displayResults(false, "handled first person in line 2");
			} else {
				displayResults(result.equals(expected), "handled first person in line 2");
			}
		} catch (Exception e) {
			System.out.println("exception thrown");
			displayResults(false, "handled first person in line 2");
		}

		try {
			result = cl.handleOne();
			expected = p3;
			if (result == null) {
				displayResults(false, "handled first person in line 3");
			} else {
				displayResults(result.equals(expected), "handled first person in line 3");
			}
		} catch (Exception e) {
			System.out.println("exception thrown");
			displayResults(false, "handled first person in line 3");
		}

		try {
			result = cl.handleOne();
			expected = p7;
			if (result == null) {
				displayResults(false, "handled first person in line 4");
			} else {
				displayResults(result.equals(expected), "handled first person in line 4");
			}
		} catch (Exception e) {
			System.out.println("exception thrown");
			displayResults(false, "handled first person in line 4");
		}
		
		displayResults(cl.peopleInLine()==3, "people in line 4");		
		cl.enterLine(p7);
		cl.enterLine(p1);
		cl.enterLine(p2);
		cl.enterLine(p3);		
		displayResults(cl.peopleInLine()==7, "people in line 5");
		
		try {
			numRemoved = cl.handleMultiple(5);
			displayResults(numRemoved==5, "group of 5 enter the cinema");
		} catch (Exception e) {
			displayResults(false, "group of 5 enter the cinema");
		}
		displayResults(cl.peopleInLine()==2, "people in line 6");
		
		try {
			numRemoved = cl.handleMultiple(5); // buy 5 tickets, but only 2 in line
			displayResults(numRemoved==2, "group of 2 enter the cinema");
		} catch (Exception e) {
			displayResults(false, "group of 2 enter the cinema");
		}
		displayResults(cl.peopleInLine()==0, "people in line 7");
		
		try {
			numRemoved = cl.handleMultiple(5); // buy 5 tickets, but no one in line
			displayResults(numRemoved==0, "group of 0 enter the cinema");
		} catch (Exception e) {
			displayResults(false, "group of 0 enter the cinema");
		}
		displayResults(cl.peopleInLine()==0, "people in line 8");		
		
		cl.enterLine(p1);
		displayResults(cl.peopleInLine()==1, "people in line 9");		

		try {
			inserted = cl.premiumEntry(p2, 0); 
			displayResults(inserted==true, "inserted into specific pos");
		} catch (Exception e) {
			displayResults(false, "inserted into specific pos");
		}
		displayResults(cl.peopleInLine()==2, "people in line 10");	

		try {
			inserted = cl.premiumEntry(p3, 2); 
			displayResults(inserted==true, "inserted into specific pos");
		} catch (Exception e) {
			displayResults(false, "inserted into specific pos");
		}
		displayResults(cl.peopleInLine()==3, "people in line 11");	

		try {
			inserted = cl.premiumEntry(p4, -2); 
			displayResults(inserted==false, "inserted into specific pos");
		} catch (Exception e) {
			displayResults(false, "inserted into specific pos");
		}
		displayResults(cl.peopleInLine()==3, "people in line 12");	

		try {
			inserted = cl.premiumEntry(p5, 4); 
			displayResults(inserted==false, "inserted into specific pos");
		} catch (Exception e) {
			displayResults(false, "inserted into specific pos");
		}
		displayResults(cl.peopleInLine()==3, "people in line 13");		

		try {
			result = cl.handleOne();
			expected = p2;
			if (result == null) {
				displayResults(false, "handled first person in line 5");
			} else {
				displayResults(result.equals(expected), "handled first person in line 5");
			}
		} catch (Exception e) {
			System.out.println("exception thrown");
			displayResults(false, "handled first person in line 5");
		}

		try {
			result = cl.handleOne();
			expected = p1;
			if (result == null) {
				displayResults(false, "handled first person in line 6");
			} else {
				displayResults(result.equals(expected), "handled first person in line 6");
			}
		} catch (Exception e) {
			System.out.println("exception thrown");
			displayResults(false, "handled first person in line 6");
		}

		try {
			result = cl.handleOne();
			expected = p3;
			if (result == null) {
				displayResults(false, "handled first person in line 7");
			} else {
				displayResults(result.equals(expected), "handled first person in line 7");
			}
		} catch (Exception e) {
			System.out.println("exception thrown");
			displayResults(false, "handled first person in line 7");
		}
		
		try {
			result = cl.handleOne();
			displayResults(result == null, "handled first person in line 8");
		} catch (Exception e) {
			System.out.println("exception thrown");
			displayResults(false, "handled first person in line 8");
		}

	}
		

	public static void displayResults (boolean passed, String testName) {
		testCount++;
		if (passed) {
			System.out.println ("Passed test: " + testCount);
			testPassCount++;
		} else {
			System.out.println ("Failed test: " + testName + " at line "
								+ Thread.currentThread().getStackTrace()[2].getLineNumber());
		}
	}
}