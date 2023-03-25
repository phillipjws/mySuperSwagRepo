public interface A3List {

	/* 
	 * Purpose: add s to the front of the list
	 * Parameters: String s - the string to add
	 * Returns: nothing
	 * Precondition: s is not null
	 */
	public void addFront(String s);

	/* 
	 * Purpose: add s to the back of the list
	 * Parameters: String s - the string to add
	 * Returns: nothing
	 * Precondition: s is not null
	 */
	public void addBack(String s);
	
	/* 
	 * Purpose: get the current size of the list
	 * Parameters: none
	 * Returns: int - number of elements in list
	 */
	public int size(); 
	
	/* 
	 * Purpose: determines if the list is empty
	 * Parameters: none
	 * Returns: boolean - true if empty, false otherwise
	 */
	public boolean isEmpty();
	
	/* 
	 * Purpose: removes the element from the front of the list
	 * Parameters: none
	 * Returns: nothing
	 */
	public void removeFront();
	
	/* 
	 * Purpose: removes the element from the back of the list
	 * Parameters: none
	 * Returns: nothing
	 */
	public void removeBack();
	
	/* 
	 * Purpose: remove the node at the given position from this list
	 * Parameters: int pos - the position of the node to remove
	                         (assuming 0-based positioning)
	 * Returns: void - nothing
	 *
	 * Note: If an invalid positions is given, no node is removed
	 *
	 * Note: there are no pre-conditions about the size of the list
	 *       or the value of the pos parameter
	 */
	public void removeAt(int pos);
	
	/* 
	 * Purpose: create and return a new A3LinkedList containing all the 
	 *          values from this list and other list, sorted alphabetically
	 * Parameters: A3LinkedList other - the other linked list
	 * Returns: A3LinkedList - a new linked list containing all of the values
	 *                         merged from this list and other list
	 *
	 * Pre-condition: the elements in both this list and other list are 
	 *                sorted alphabetically
	 * Post-condition: none of the elements in this list or other list
	 *                 have been modified or removed
	 *
	 * HINT: Look through the Node class for helpful methods
	 * Note: there are no pre-conditions about the size of either list
	 */
	public A3LinkedList mergeSorted(A3LinkedList other);
}