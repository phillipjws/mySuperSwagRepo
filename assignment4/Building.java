public class Building {
	private String name;
	private int stories;
	private int inhabitants;
	
	public Building(String name, int stories, int inhabitants) {
		this.name = name;
		this.stories = stories;
		this.inhabitants = inhabitants;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getNumberOfStories() {
		return this.stories;
	}
	
	public int getNumberOfInhabitants() {
		return this.inhabitants;
	}
	
	public boolean equals(Building other) {
		return this.name.equals(other.name);
	}
	
	public String toString() {
		return this.name + " (stories: "+stories+", inhabitants: "+inhabitants+")";
	}
}