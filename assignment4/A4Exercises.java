import java.util.List;

public class A4Exercises {

	/*
	 * Purpose: gets the number of buildings in the given A4List
	 * Parameters: A4List bA4List - the A4List of buildings
	 * Returns: int - the number of buildings in the given A4List
	 */
	public static int buildingsCount(A4List bA4List) {
		// TODO: implement this
		return bA4List.size(); // so it compiles
	}
	
	/*
	 * Purpose: gets the total number of inhabitants living 
	 *          in all the buildings in the given A4List
	 * Parameters: A4List bA4List - the A4List of buildings
	 * Returns: int - the number of inhabitants across all buildings
	 */
	public static int inhabitantsCount(A4List bA4List) {
		// TODO: implement this
		int total = 0;
		for(int i = 0; i < bA4List.size(); i++){
			total += bA4List.get(i).getNumberOfInhabitants();
		}
		return total; // so it compiles
	}
	
	/*
	 * Purpose: get the number of buildings into the A4List b is
	 * Parameters: A4List bA4List - the A4List of buildings
	 *             Building b - the building to find
	 * Returns: int - the distance the first occurrence of 
	 *                b is from the start of the A4List, or 
	 *                -1 if b is not found in bA4List
	 */
	public static int distanceAway(A4List bA4List, Building b) {
		// TODO: implement this
		for( int i = 0; i < bA4List.size(); i++){
			if(bA4List.get(i) == b){
				return i;
			}
		}
		return -1; // so it compiles
	}
	
	/*
	 * Purpose: get the distance the tallest building is 
	 *          from the start of the A4List
	 * Parameters: A4List bA4List - the A4List of buildings
	 * Returns: int - the distance the tallest building
	 *                is from the start of the A4List
	 */
	public static int distanceToTallest(A4List bA4List) {
		// TODO: implement this
		Building tallest = new Building(null, 0, 0);
		for(int i = 0; i < bA4List.size(); i++){
			if(bA4List.get(i).getNumberOfStories() > tallest.getNumberOfStories()){
				tallest = bA4List.get(i);
			}
		}
		return distanceAway(bA4List, tallest); // so it compiles
	}

	/*
	 * Purpose: get the number of buildings visible 
	 *          from the beginning of the A4List 
	 * Parameters: A4List bA4List - the A4List of buildings
	 * Returns: int - the number of buildings visible
	 * 
	 * Note: Read through the assignment PDF for more information
	 */
	public static int numberVisible(A4List bA4List) {
		// TODO: implement this
		int visible = 0;
		Building tallest = new Building(null, 0, 0);
		for(int i = 0; i < bA4List.size(); i++){
			if(bA4List.get(i).getNumberOfStories() > tallest.getNumberOfStories()){
				tallest = bA4List.get(i);
				visible++;
			}
		}
		return visible; // so it compiles
	}
		


}