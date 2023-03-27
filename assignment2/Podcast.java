public class Podcast {
	private String title;
	private Influencer[] hosts;
	private int duration; // in minutes
	
	public Podcast(String title, Influencer[] hosts, int duration) {
		this.title = title;
	    this.hosts = hosts;
        this.duration = duration;
	}

	/*
	 * Purpose: get the title of this podcast
	 * Parameters: none
	 * Returns: String - this podcast's title
	 */
	public String getTitle() {
		return title;
	}
	
	/*
	 * Purpose: get the hosts of this podcast
	 * Parameters: none
	 * Returns: String - this podcast's hosts
	 */
	public Influencer[] getHosts() {
		return hosts;
	}
	
	/*
	 * Purpose: get the duration of this podcast in minutes
	 * Parameters: none
	 * Returns: String - this podcast's duration (in minutes)
	 */
	public int getDuration() {
		return duration;
	}

	/*
	 * Purpose: get the String representation of this object
	 * Parameters: none
	 * Returns: String - this object's String representation
	 */
	public String toString() {
		return this.title + "(" + duration + ")";
	}

	/*
	 * Purpose: determine if this podcast equals the given other podcast
	 * Parameters: Podcast other - the podcast to compare with this one
	 * Returns: boolean - true if the podcasts are considered equivalent
	 *          (podcasts are considered equivalent if they have the
	 *           the same title and duration)
	 */
	public boolean equals(Podcast other) {
		return this.title.equals(other.title)
			&& this.duration == other.duration;
	}
	
	/*
	 * Purpose: determine if this podcast is shorter than the given duration
	 * Parameters: int duration - a duration in minutes to compare to
	 * Returns: boolean - true if this podcast has has a duration less than the given duration
	 */
	public boolean isShorterThan(int duration) {
		if (getDuration() > duration){
			return false;
		}
		return true; // so it compiles
	}

	/*
	 * Purpose: get the average number of followers of this podcast's hosts
	 * Parameters: none
	 * Returns: double - the average number of followers of all the hosts
	 *                   of this podcast
	 */
	public double averageFollowers() {
		double sum = 0.0;
		for(int i = 0; i < hosts.length; i++){
			sum += hosts[i].getFollowers();
		}
		
		return sum / hosts.length; // so it compiles
	}

	/*
	 * Purpose: determine whether the give influencer is one of the hosts of this podcast
	 * Parameters: Influencer alias - the influencer in question
	 * Returns: boolean - true if this given influencer is one of this podcast's hosts
	 */
	public boolean hasHost(Influencer alias) {
		hosts = getHosts();
		for(int i = 0; i < hosts.length; i++){
			if(hosts[i] == alias){
				return true;
			}
		}
		
		return false; // so it compiles
	}
}