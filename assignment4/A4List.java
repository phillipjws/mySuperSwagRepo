public interface A4List {

	/* 
	 * Purpose: add b to the back of the A4List
	 * Parameters: Building b - the building to add
	 * Returns: nothing
	 * Precondition: b is not null
	 */
	public void add(Building b);
		
	/* 
	 * Purpose: get the current size of the A4List
	 * Parameters: none
	 * Returns: int - number of elements in A4List
	 */
	public int size(); 
			
	/* 
	 * Purpose: gets the building at the given index in the A4List
	 * Parameters: int index - the index of the building to access
	 * Returns: Building - the building at the given index
	 * Precondition: 0 <= index < size()
	 */
	public Building get(int index);
	
	/*
	 * Purpose: get the index of b in this A4List
	 * Parameters: Building b - the building to find
	 * Returns: int - index of b, or -1 if b is not in this A4List
	 */
	public int find(Building b);
	
}