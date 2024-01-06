/*
 * Checks if a given year is a leap year or a common year,
 * and computes the number of days in a given month and a given year. 
 */
public class Calendar0 {	
	
	// Gets a year (command-line argument), and tests the functions isLeapYear and nDaysInMonth.
	public static void main(String args[]) {

		// init the year given from user
		int year = Integer.parseInt(args[0]);

		// call the function, given the year
		isLeapYearTest(year);

		// call the function given the year
		nDaysInMonthTest(year);
	}
		 
	// prints if leap year according to the function
	private static void isLeapYearTest(int year) {
		String commonOrLeap = "common";
		if (isLeapYear(year)) {
			commonOrLeap = "leap";
		}
		System.out.println(year + " is a " + commonOrLeap + " year");  
	}

	// prints how many days in each month
	private static void nDaysInMonthTest(int year) {
		// Replace this comment with your code
		for (int i = 1; i <= 12; i++) {
			int days = nDaysInMonth(i, year);
			System.out.println("Month " + i + " has " +days +" days");
		}
	}

	// Returns true if the given year is a leap year, false otherwise.
	public static boolean isLeapYear(int year) {

		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
			return true;
		}
		return false;
	}
	 
	// Returns the number of days in the given month and year.
	// April, June, September, and November have 30 days each.
	// February has 28 days in a common year, and 29 days in a leap year.
	// All the other months have 31 days.
	public static int nDaysInMonth(int month, int year) {

		// check if month with 30 days
		if (month == 4 || month == 6 || month == 9 || month == 11){
			return 30;
		}

		// check if Febuary
		if (month == 2){

			// check if leap year
			if (isLeapYear(year)){
				return 29;
			} else {
				return 28;
			}
		}

		// month with 31 days
		return 31;
	}
}

