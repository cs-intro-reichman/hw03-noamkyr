/** 
 * Prints the calendars of all the years in the 20th century.
 */
public class Calendar1 {	
    // Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January

	static int end_stop = -1;
	
	/** 
	 * Prints the calendars of all the years in the 20th century. Also prints the  
	 * number of Sundays that occured on the first day of the month during this period.
	 */
	public static void main(String args[]) {
		// Advances the date and the day-of-the-week from 1/1/1900 till 31/12/1999, inclusive.
	    // Prints each date dd/mm/yyyy in a separate line. If the day is a Sunday, prints "Sunday".
	    // The following variable, used for debugging purposes, counts how many days were advanced so far.

		// init the variable that counts how many days
		int debugDaysCounter = 0;

		// init the variable that counts how many sundays of the first day of month
		int count_first_sunday = 0;

		while (true) {

			// init the message that prints the current date
			String msg = String.valueOf(dayOfMonth)+'/'+String.valueOf(month)+'/'+String.valueOf(year);

			// add sunday to the message if the current day is sunday
			if (dayOfWeek == 1){
				msg += " Sunday";
			}

			// print the message
			System.out.println(msg);

			// increase the variable if the first day of month is sunday
			if (dayOfMonth == 1 && dayOfWeek == 1){
				count_first_sunday ++;
			}

			// get the number of the days in the current month
			nDaysInMonth = nDaysInMonth(month, year);

			// advance to the next day according to the rules
			advance();

			// count one more day
			debugDaysCounter++;


			//// If you want to stop the loop after n days, replace the condition of the
	 		//// if statement with the condition (debugDaysCounter == n)
	 		if ((year == 1999 && month == 12 && dayOfMonth == 31) || debugDaysCounter == end_stop) {
	 			break;
	 		}
        }
	 	//// Write the necessary ending code here

		System.out.println("During the 20th century, "+count_first_sunday+" Sundays fell on the first day of the month");

	 }
	
	 // Advances the date (day, month, year) and the day-of-the-week.
	 // If the month changes, sets the number of days in this month.
	 // Side effects: changes the static variables dayOfMonth, month, year, dayOfWeek, nDaysInMonth.
	 private static void advance() {

		// check if it is not the last day of month
		 if (dayOfMonth < nDaysInMonth){
			 dayOfMonth ++;
		 } else {

			 // set new year values if end of year
			 if (month == 12){
				 month = 1;
				 year ++;
			 } else {

				 // if end of month
				 month ++;
			 }

			 // start of new month
			 dayOfMonth = 1;
		 }


		 // set sunday if a week has ended
		 if (dayOfWeek == 7){
			 dayOfWeek = 1;
		 } else {
			 dayOfWeek ++;
		 }

	 } 
		 
    // Returns true if the given year is a leap year, false otherwise, according to the rules
	private static boolean isLeapYear(int year) {

		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
			return true;
		}
		return false;
	}
	 
	// Returns the number of days in the given month and year.
	// April, June, September, and November have 30 days each.
	// February has 28 days in a common year, and 29 days in a leap year.
	// All the other months have 31 days.
	private static int nDaysInMonth(int month, int year) {

		// check if day with 30 days
		if (month == 4 || month == 6 || month == 9 || month == 11){
			return 30;
		}

		// check if Febuary
		if (month == 2){

			// check if Febuary with 29 days
			if (isLeapYear(year)){
				return 29;
			} else {
				return 28;
			}
		}

		// a month with 31 days
		return 31;

	}
}
