public class Date implements Comparable<Date> {
	private int year;
	private int month; // month number, from 1 to 12
	private int day; // day in month, from 1 to 31
	
	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public int compareTo(Date other) {
		if (this.year == other.year) {
			if (this.month == other.month) {
				return this.day - other.day;
			} else {
				return this.month - other.month;
			}
		} else {
			return this.year - other.year;
		}
	}
	
	public String toString() {
		return year + "/" + month + "/" + day;
	}
}