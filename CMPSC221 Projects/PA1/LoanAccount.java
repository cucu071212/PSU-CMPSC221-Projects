/**
 * This program calcuates and displays the monthly payments for two different 
 * loan accounts with different interest rates and loan terms.
 * Author: Jonghun Won
 */
package loan.account.pkgclass;

public class LoanAccount{
    
    /** A private static variable to hold the annual interest rate shared by all
     *loan objects.
     */
    private static double annualInterestRate;
    
    /** A private static variable to store the principal amount of a specific
     *loan objects.
     */
    private double principal;
    
    /** This is the constructor for the LoanAccount class.
     * It initializes the principal amount for a new loan object.
     * @param initialPrincipal It is the initial principal amount fot the loan.
     */
    public LoanAccount(double initialPrincipal)
    {
        this.principal = initialPrincipal;
    }

    /** This method calculates the monthly payment for the loan.
     * @param numberOfPayments It is the total number of monthly payments.
     * @return The calculated monthly payment amount.
     */
    public double calculateMonthlyPayment(int numberOfPayments)
    {
        //It calculates the monthly interest rate from annualInterestRate.
        double monthlyInterest = (annualInterestRate / 12);
        
        //It calculates the monthly payment by using the formula.
        double monthlyPayment = this.principal * (monthlyInterest / (1 - Math.pow
        (1 + monthlyInterest, -numberOfPayments)));
        
        return monthlyPayment;
    }

    /** This static method sets the annual interest rate.
     * @param newRate It is the new annual interest rate and converted to a percentage.
     */
    public static void setAnnualInterestRate(double newRate)
    {
        
        annualInterestRate = newRate/100;
    }

    /** This is the main method for the LoanAccount class.
     * This initialzes loan objects and sets interest rates and displays output.
     */
    public static void main(String[] args)
    {
        // It makes two LoanAccount objects with their initial principal amount.
        LoanAccount loan1 = new LoanAccount(5000.00);
        LoanAccount loan2 = new LoanAccount(31000.00);
        
        // The results for a 1% interest rate are printed in a formatted form.
        setAnnualInterestRate(1.0);
        System.out.println("Monthly payments for loan1 of $5000.00 and loan2 of "
                + "$31000.00 for 3, 5, and 6 year loans at 1% interest.");
        System.out.println("Loan    3 years 5 years 6 years");
        System.out.printf("Loan1   %.2f  %.2f   %.2f", loan1.calculateMonthlyPayment(36),
                loan1.calculateMonthlyPayment(60), loan1.calculateMonthlyPayment(72));
        System.out.println();
        System.out.printf("Loan2   %.2f  %.2f  %.2f", loan2.calculateMonthlyPayment(36),
                loan2.calculateMonthlyPayment(60), loan2.calculateMonthlyPayment(72));
        
        System.out.println();
        System.out.println();
        
        // The results for a 5% interest rate are printed in a formatted form.
        setAnnualInterestRate(5.0);
        System.out.println("Monthly payments for loan1 of $5000.00 and loan2 of "
                + "$31000.00 for 3, 5, and 6 year loans at 5% interest.");
        System.out.println("Loan    3 years 5 years 6 years");
        System.out.printf("Loan1   %.2f  %.2f   %.2f", loan1.calculateMonthlyPayment(36),
                loan1.calculateMonthlyPayment(60), loan1.calculateMonthlyPayment(72));
        System.out.println();
        System.out.printf("Loan2   %.2f  %.2f  %.2f", loan2.calculateMonthlyPayment(36),
                loan2.calculateMonthlyPayment(60), loan2.calculateMonthlyPayment(72));
    }
}