public class Influencer {
	private String name;
	private String platform;
	private int followers;
	
	public Influencer(String name, String platform, int followers) {
		this.name = name;
		this.platform = platform;
		this.followers = followers;
	}
	
	/*
	 * Purpose: get the name of this influencer
	 * Parameters: none
	 * Returns: String - the name of this influencer
	 */	
	public String getName() {
		return name;
	}
	
	/*
	 * Purpose: get the platform this influencer uses
	 * Parameters: none
	 * Returns: String - this influencer's platform
	 */	
	public String getPlatform() {
		return platform;
	}
	
	/*
	 * Purpose: get the number of followers this influencer has
	 * Parameters: none
	 * Returns: int - this influencer's number of followers
	 */	
	public int getFollowers() {
		return followers;
	}
	
	/*
	 * Purpose: determines if this influencer has the given name
	 * Parameters: String name - the name to compare to
	 * Returns: boolean - true if this influencer's name is equal to the given name
	 */
	public boolean isNamed(String name) {
		return this.name.equals(name);
	}
	
	/*
	 * Purpose: get the String representation of this object
	 * Parameters: none
	 * Returns: String - this object's String representation
	 */
	public String toString() {
		return name + "(" + platform + ")";
	}
		
	/*
	 * Purpose: determine if this influencer equals the given other influencer
	 * Parameters: Influencer other - the influencer to compare with this one
	 * Returns: boolean - true if the influencers are considered equivalent
	 *          (influencers are considered equivalent if they have the
	 *           the same name and platform)
	 */
	public boolean equals(Influencer other) {
		return this.name.equals(other.name)
			&& this.platform.equals(other.platform);
	}
	
}