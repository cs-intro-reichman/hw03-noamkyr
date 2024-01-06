/**
 * Computes the periodical payment necessary to re-pay a given loan.
 */
public class LoanCalc {

    static double epsilon = 0.001;  // The computation tolerance (estimation error)
    static int iterationCounter = 0;    // Monitors the efficiency of the calculation

    /**
     * Gets the loan data and computes the periodical payment.
     * Expects to get three command-line arguments: sum of the loan (double),
     * interest rate (double, as a percentage), and number of payments (int).  
     */
    public static void main(String[] args) {
        // Gets the loan data from the user
        double loan = Double.parseDouble(args[0]);

        // get the rate data from the user
        double rate = Double.parseDouble(args[1]);

        // get the data of how many payments from the user
        int n = Integer.parseInt(args[2]);

        // print the given data
        System.out.println("Loan sum = " + loan + ", interest rate = " + rate + "%, periods = " + n);

        // Computes the periodical payment using brute force search
        System.out.print("Periodical payment, using brute force: ");
        System.out.printf("%.2f", bruteForceSolver(loan, rate, n, epsilon));
        System.out.println();

        // print the number of iteration
        System.out.println("number of iterations: " + iterationCounter);

        // set new couting
        iterationCounter = 0;

        // Computes the periodical payment using bisection search
        System.out.print("Periodical payment, using bi-section search: ");
        System.out.printf("%.2f", bisectionSolver(loan, rate, n, epsilon));
        System.out.println();

        // print number of iteration in the bisection algorithm
        System.out.println("number of iterations: " + iterationCounter);


    }

    /**
     * Uses a sequential search method  ("brute force") to compute an approximation
     * of the periodical payment that will bring the ending balance of a loan close to 0.
     * Given: the sum of the loan, the periodical interest rate (as a percentage),
     * the number of periods (n), and epsilon, a tolerance level.
     */
    // Side effect: modifies the class variable iterationCounter.
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {

        // init the first guess of payment
        double payment  = loan / (double)n;

        // calculate the balance at the end of the loan
        double end_balance  = endBalance(loan, rate , n , payment);

        // iterate the while if the balance greater than 0
        while (end_balance > 0) {

            // increase the guess
            payment =   payment + epsilon;

            // calclate the new balance
            end_balance = endBalance(loan, rate , n , payment);

            // increase number of iterations
            iterationCounter ++;
        }

        // return the final answer
        return payment;
    }

    /**
     * Uses bisection search to compute an approximation of the periodical payment
     * that will bring the ending balance of a loan close to 0.
     * Given: the sum of theloan, the periodical interest rate (as a percentage),
     * the number of periods (n), and epsilon, a tolerance level.
     */
    // Side effect: modifies the class variable iterationCounter.
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {



        // init the lowest possible guess
        double low  = loan / (double)n;

        // init the highest possible guess
        double high = loan;

        // init the mid guess according to the boundaries
        double g = (low + high) / 2;

        // calculate the balance of the avrage option
        double current_end_balance  = endBalance(loan, rate , n , g);

        // go to the while of the search has't ended yet
        while ( (high - low) >= epsilon ) {


            // calculate the new middle
            g = (high + low) / 2;

            // calculate the balance according to the new g
            current_end_balance = endBalance(loan, rate , n , g);


            // check if the you still have to give money at the end of month
            if (current_end_balance >= epsilon){

                // get new low bound
                low = g;
            } else {

                // set new high bound
                high = g;
            }

            // increase number of guess
            iterationCounter ++;

        }

        // return the final answer
        return g;
    }

    /**
     * Computes the ending balance of a loan, given the sum of the loan, the periodical
     * interest rate (as a percentage), the number of periods (n), and the periodical payment.
     */
    private static double endBalance(double loan, double rate, int n, double payment) {

        // convert the percents to rational number
        rate = (rate + 100) / 100.0;

        // init the remaining balance
        double balance = loan;

        // calculate the balance at each payment (n times)
        for (int i = 0; i < n; i++) {
            balance = ( balance - payment ) * rate;
        }

        // return the final balance
        return balance;
    }
}