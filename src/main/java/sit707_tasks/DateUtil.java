package sit707_tasks;

/**
 * @author Ahsan Habib
 */
public class DateUtil {

	// Months in order 0-11 maps to January-December.
	private static String[] MONTHS = new String[] {
			"January", "February", "March", "April", "May", "June", 
			"July", "August", "September", "October", "November", "December"
	};
	
	private int day, month, year;
	
	/*
	 * Constructs object from given day, month and year.
	 */
	public DateUtil(int day, int month, int year) {
	    // Check for valid day, month, and year based on equivalence classes
	    if (!isValidDay(day, month, year))
	        throw new RuntimeException("Invalid day: " + day + ", for month: " + month + ", year: " + year);
	    if (!isValidMonth(month))
	        throw new RuntimeException("Invalid month: " + month);
	    if (!isValidYear(year))
	        throw new RuntimeException("Invalid year: " + year);

	    this.day = day;
	    this.month = month;
	    this.year = year;
	}

	private boolean isValidDay(int day, int month, int year) {
	    // Validate day based on equivalence classes
	    switch (month) {
	        case 2: // February
	            if (isLeapYear(year)) // Leap year
	                return day >= 1 && day <= 29; // D1-D2
	            else
	                return day >= 1 && day <= 28; // D1
	        case 4: case 6: case 9: case 11: // April, June, September, November
	            return day >= 1 && day <= 30; // D1-D3
	        default: // January, March, May, July, August, October, December
	            return day >= 1 && day <= 31; // D1-D4
	    }
	}

	private boolean isValidMonth(int month) {
	    return month >= 1 && month <= 12;
	}

	private boolean isValidYear(int year) {
	    return year >= 1700 && year <= 2024;
	}

	private boolean isLeapYear(int year) {
	    // Check if the year is a leap year
	    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}
	
	/**
	 * Increment one day.
	 */
	public void increment() {
		if (day < monthDuration(month, year)) {
			// At least 1 day remaining in current month of year.
			day++;
		} else if (month < 12) {
			// Last day of a month AND month is less than December, so +1d is first day of next month.
			day = 1;
			month++;
		} else {
			// Month is December, so +1d is 1st January next year.
			day = 1;
			month = 1;
			year++;
		}
	}
	
	/**
	 * Decrement one day from current date.
	 */
	public void decrement() {
		if (day > 1) {
			day--;
		} else if (month > 1) {
			month--;
			day = monthDuration(month, year);
		} else {
			month = 12;
			year--;
			day = monthDuration(month, year);
		}
	}
	
	/**
	 * Calculate duration of current month of year.
	 * @param month
	 * @param year
	 * @return
	 */
	public static int monthDuration(int month, int year) {		
		if (month == 2 && year % 4 == 0) {
			// February leap year?
			return 29;			
		} else if (month == 2) {  
			// normal 28 days February
			return 28;
			
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			// 30 days' months
			return 30;			
		}
		return 31;  // rest are 31 days' months.
	}
	
	/**
	 * User friendly output.
	 */
	public String toString() {
		return day + " " + MONTHS[month - 1] + " " + year;
	}
	
}
