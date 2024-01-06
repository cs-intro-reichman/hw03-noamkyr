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
        // Gets the loan data
        double loan = Double.parseDouble(args[0]);
        double rate = Double.parseDouble(args[1]);
        int n = Integer.parseInt(args[2]);
        System.out.println("Loan sum = " + loan + ", interest rate = " + rate + "%, periods = " + n);


        // Computes the periodical payment using brute force search
        System.out.print("Periodical payment, using brute force: ");
        System.out.printf("%.2f", bruteForceSolver(loan, rate, n, epsilon));
        System.out.println();
        System.out.println("number of iterations: " + iterationCounter);
        iterationCounter = 0;
        // Computes the periodical payment using bisection search
        System.out.print("Periodical payment, using bi-section search: ");
        System.out.printf("%.2f", bisectionSolver(loan, rate, n, epsilon));
        System.out.println();
        System.out.println("number of iterations: " + iterationCounter);




        /*
        loan = 100000;
        rate = 5;
        n = 10;
        //double guess_payment = bruteForceSolver(loan, rate , n, epsilon);
        //System.out.println(guess_payment);
        //System.out.println(endBalance(loan, rate, n, guess_payment));
        System.out.println(bisectionSolver(loan, rate, n, epsilon));
        */
    }

    /**
     * Uses a sequential search method  ("brute force") to compute an approximation
     * of the periodical payment that will bring the ending balance of a loan close to 0.
     * Given: the sum of the loan, the periodical interest rate (as a percentage),
     * the number of periods (n), and epsilon, a tolerance level.
     */
    // Side effect: modifies the class variable iterationCounter.
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
        // Replace the following statement with your code
        double payment  = loan / (double)n;
        double end_balance  = endBalance(loan, rate , n , payment);
        while (end_balance > 0) {
            payment =   payment + epsilon;
            end_balance = endBalance(loan, rate , n , payment);
            iterationCounter ++;
        }
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
        // Replace the following statement with your code

        double low  = loan / (double)n;
        double high = loan;
        double g = (low + high) / 2;
        double current_end_balance  = endBalance(loan, rate , n , g);
        while (high - low >= epsilon) {

            g = (high + low) / 2;
            current_end_balance = endBalance(loan, rate , n , g);


            if (current_end_balance >= epsilon){
                low = g;
            } else {
                high = g;
            }

            iterationCounter ++;


        }

        return g;
    }

    /**
     * Computes the ending balance of a loan, given the sum of the loan, the periodical
     * interest rate (as a percentage), the number of periods (n), and the periodical payment.
     */
    private static double endBalance(double loan, double rate, int n, double payment) {
        // Replace the following statement with your code
        rate = (rate + 100) / 100.0;
        double balance = loan;
        //System.out.println(balance);
        for (int i = 0; i < n; i++) {

            balance = ( balance - payment ) * rate;
            // System.out.println(balance);
        }

        return balance;
    }
}