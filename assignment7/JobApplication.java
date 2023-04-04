public class JobApplication implements Comparable<JobApplication> {
	private String name;
	private int priority;
	private Date availableStartDate;

	public JobApplication(String name, Date availableStartDate, String analysis) {
		this.name = name;
		this.availableStartDate = availableStartDate;
		setPriority(analysis);
	}
	
	public void setPriority(String analysis) {
		if (analysis.equals("Interview waived. Hire at all costs.")) {
			this.priority = 1;
		} else if (analysis.equals("Schedule interview. Strong credentials")) {
			this.priority = 2;
		} else if (analysis.equals("Consider interviewing")) {
			this.priority = 3;
		} else if (analysis.equals("Requires further analysis")) {
			this.priority = 4;
		} else {
			this.priority = 5;
		}
	}
	
	public String getName() {
		return this.name;
	}

	public int getPriority() {
		return this.priority;
	}
	
	public Date getAvailableStartDate() {
		return this.availableStartDate;
	}
	
	public String toString() {
		return "Applicant name: "+name;
	}

	/* 
	 * Purpose: returns the result of comparing this job application with other
	 * Parameters: JobApplication other - the job application to compare with
	 * Returns: a value < 0 if this job application is ordered before other
	 *          a value == 0 if this job application is ordered equally with other
	 *          a value > 0 if this job application is ordered after other
	 * Precondition: other is not null
	 *
	 * Notes on how to compare job applications:
	 * Job applications are ordered by their priority (1 comes first, 5 last).
	 * If priority values are equal, their available start date is used as a
	 * tie-breaker. Job applicatios who can start sooner are ordered first.
	 *
	 * HINT: Date is a Comparable object too!
	 */
	public int compareTo(JobApplication other) {
		// TODO: implement this
		if(getPriority() == other.getPriority()){
			return getAvailableStartDate().compareTo(other.getAvailableStartDate());
		}
		return getPriority() - other.getPriority(); // so it compiles
	}

	/* 
	 * Purpose: determines whether this job application is considered
	 *          equivalent to the other job application
	 * Parameters: Patient other - the job application to compare with
	 * Returns: true if this Patient is the same as other, false otherwise
	 * Precondition: other is not null
	 * 
	 * Notes: Two job applications are considered equal if they share 
	 *        the same applicant name and priority value.
	 *        (Available start date is not considered)
	 */
	public boolean equals(JobApplication other) {
		//TODO: implement this
		if(getPriority() == other.getPriority() && getName() == other.getName()){
			return true;
		}
		return false; // so it compiles
	}
}
