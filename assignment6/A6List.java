public interface A6List<T> {
    
	/*
	 * Purpose:  add val to the front of the A6List
	 * Parameters: T val - the value to insert
	 * Returns: void - nothing
	 */
	void addFront (T val);

	/*
	 * Purpose:  add val to the back of the A6List
	 * Parameters: T val - the value to insert
	 * Returns: void - nothing
	 */
	void addBack (T val);
	
	/*
	 * Purpose: remove and return the front element from the A6List
	 * Parameters: none
	 * Returns: T - the value of the element removed
	 * Throws: A6ListEmptyException - if there is nothing to remove
	 */
	T removeFront() throws A6ListEmptyException;
	
	/*
	 * Purpose: remove and return the back element from the A6List
	 * Parameters: none
	 * Returns: T - the value of the element removed
	 * Throws: A6ListEmptyException - if there is nothing to remove
	 */
	T removeBack() throws A6ListEmptyException;
	
	/*
	 * Purpose: get the number of elements in the A6List
	 * Parameters: none
	 * Returns: int - number of elements in A6List
	 */
	int size ();
	
	/* Purpose: insert val into the specified position while
	 *          maintaining the order of all other elements
	 * Parameters: int position - the 0-based position to insert
	 *             T val - the value to insert
	 * Returns: void - nothing
	 * Throws: InvalidPositionException - if the given position
	 *         is less than 0 or greater than the number of elements
	 */
	void insertAt (int position, T val) throws InvalidPositionException;
    
}

