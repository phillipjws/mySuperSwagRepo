public class A5Exercises {

	/*
	 * Purpose: get the number of occurrences of toFind in theList
	 * Parameters: List<T> theList - the list to search through
	 *             T toFind - the target search value
	 * Returns: int - the number of occurrences of toFind found
	 */
	public static<T> int countMatches(List<T> theList, T toFind) {
		// TODO: Call a recursive helper method
		return countMatchesRec(toFind, theList.head); // so it compiles
	}
	
	private static<T> int countMatchesRec(T toFind, Node cur){
		if( cur == null){
			return 0;
		}
		if(cur.getData().equals(toFind)){
			return 1 + countMatchesRec(toFind, cur.next);
		}
		return countMatchesRec(toFind, cur.next);
	}
	/*
	 * Purpose: change all occurrences of x to y in the given list
	 * Parameters: List<T> theList - the list to search through
	 *			   T x - the value to change
	 *			   T y = the value to change all x's to
	 * Returns: void - nothing
	 */
	public static<T> void changeXToY(List<T> theList, T x, T y) {
		// TODO: Call a recursive helper method
	}
		
	/* 
	 * Purpose: determines if all values in the list are equivalent
	 * Parameters: List<T> theList - the list
	 * Returns: boolean - true unless any values in the list are 
	 *                    different from one another
	 */
	public static<T> boolean allEqual(List<T> theList) {
		if (theList.isEmpty()) {
			return true;
		} else {
			// TODO: Call a recursive helper method
			return false; // so it compiles
		}
	}
	
	
	/*
	 * Purpose: get the range of values in the given list
	 * Parameters: List<Integer> theList - the list of Integers
	 * Returns: int - the range of values
	 */
	public static int rangeOfValues(List<Integer> theList) {
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
	public static int rangeOfValuesRec(List<Integer> theList, int i, Integer min, Integer max) {
		return -1; // so it compiles
	}
}