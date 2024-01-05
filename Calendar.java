public class Calendar {
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
        int debugDaysCounter = 0;
        //// Write the necessary initialization code, and replace the condition
        //// of the while loop with the necessary condition
        int count_first_sunday = 0;

        int requested_year = Integer.parseInt(args[0]);

        while (true) {

            if (year == requested_year){
                String msg = String.valueOf(dayOfMonth)+'/'+String.valueOf(month)+'/'+String.valueOf(year);
                if (dayOfWeek == 1){
                    msg += " Sunday";
                }

                System.out.println(msg);
            }


            if (dayOfMonth == 1 && dayOfWeek == 1){
                count_first_sunday ++;
            }
            nDaysInMonth = nDaysInMonth(month, year);
            advance();
            debugDaysCounter++;


            //// If you want to stop the loop after n days, replace the condition of the
            //// if statement with the condition (debugDaysCounter == n)
            if ((year > requested_year && month == 12 && dayOfMonth == 31) || debugDaysCounter == end_stop) {
                break;
            }
        }
    }

    // Advances the date (day, month, year) and the day-of-the-week.
    // If the month changes, sets the number of days in this month.
    // Side effects: changes the static variables dayOfMonth, month, year, dayOfWeek, nDaysInMonth.
    private static void advance() {
        // Replace this comment with your code
        if (dayOfMonth < nDaysInMonth){
            dayOfMonth ++;
        } else {
            if (month == 12){
                month = 1;
                year ++;
            } else {
                month ++;
            }
            dayOfMonth = 1;
        }

        if (dayOfWeek == 7){
            dayOfWeek = 1;
        } else {
            dayOfWeek ++;
        }

    }

    // Returns true if the given year is a leap year, false otherwise.
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
        // Replace the following statement with your code
        if (month == 4 || month == 6 || month == 9 || month == 11){
            return 30;
        }
        if (month == 2){
            if (isLeapYear(year)){
                return 29;
            } else {
                return 28;
            }
        }

        return 31;

    }
}
