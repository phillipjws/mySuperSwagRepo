public class A5Exercises{

	/*
	 * Purpose: get the number of occurrences of toFind in theList
	 * Parameters: A5List<T> theList - the list to search through
	 *             T toFind - the target search value
	 * Returns: int - the number of occurrences of toFind found
	 */
	public static<T> int countMatches(A5List<T> theList, T toFind) {
		// TODO: Call a recursive helper method
		return countMatchesRec(toFind, theList, 0); // so it compiles
	}
	
	private static<T> int countMatchesRec(T toFind, A5List<T> theList, int index){
		if(index >= theList.size()){
			return 0;
		}
		if(theList.get(index).equals(toFind)){
			return 1 + countMatchesRec(toFind, theList, index+1);
		}
		return countMatchesRec(toFind, theList, index+1);
	}
	/*
	 * Purpose: change all occurrences of x to y in the given list
	 * Parameters: A5List<T> theList - the list to search through
	 *			   T x - the value to change
	 *			   T y = the value to change all x's to
	 * Returns: void - nothing
	 */
	public static<T> void changeXToY(A5List<T> theList, T x, T y) {
		// TODO: Call a recursive helper method
		changeXToYRec(theList, x, y, 0);
	}

	private static<T> void changeXToYRec(A5List<T> theList, T x, T y, int index){
		if(index >= theList.size()){
			return;
		}
		if(theList.get(index).equals(x)){
			theList.change(index, y);
		}
		changeXToYRec(theList, x, y, index+1);
	}
		
	/* 
	 * Purpose: determines if all values in the list are equivalent
	 * Parameters: A5List<T> theList - the list
	 * Returns: boolean - true unless any values in the list are 
	 *                    different from one another
	 */
	public static<T> boolean allEqual(A5List<T> theList) {
		if (theList.isEmpty()) {
			return true;
		} else {
			// TODO: Call a recursive helper method
			return allEqualRec(theList, 1, theList.get(0)); // so it compiles
		}
	}

	private static<T> boolean allEqualRec(A5List<T> theList, int index, T firstVal){
		if(index >= theList.size()){
			return true;
		}
		if(theList.get(index).equals(firstVal)){
			return allEqualRec(theList, index+1, firstVal);
		}
		return false;
	}
	
	
	/*
	 * Purpose: get the range of values in the given list
	 * Parameters: List<Integer> theList - the list of Integers
	 * Returns: int - the range of values
	 */
	public static int rangeOfValues(A5List<Integer> theList) {
		if (theList.size() == 0) {
			return 0;
		} else {
			return rangeOfValuesRec(theList, 1, theList.get(0), theList.get(0));
		}
	}
	
	/*
	 * Complete the design of the recursive helper below
	 */
	
	/*
	 * Purpose: get the range of values in the given list from index i onward
	 * Parameters: List<Integer> theList - the list of Integers
	 *             int i - the current index
	 *             Integer min - the smallest value found so far
	 *             Integer max - the largest value found so far
	 * Returns: int - the range of values
	 */
	public static int rangeOfValuesRec(A5List<Integer> theList, int i, Integer min, Integer max) {
		if(i >= theList.size()){
			return max - min + 1;
		}
		int currentValue = theList.get(i);
		if (currentValue < min) {
			min = currentValue;
		} else if (currentValue > max) {
			max = currentValue;
		}
		return rangeOfValuesRec(theList, i+1, min, max);
	}
}