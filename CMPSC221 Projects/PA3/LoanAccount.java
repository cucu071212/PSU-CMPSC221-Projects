/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package customer.loan.accounts;

/**
 *
 * @author Jonghun Won
 */

public class LoanAccount{
    
    /** A private variable to store the principal amount of a specific
     *loan objects.
     */
    private double principal;
    
    /** A private variable to hold the annual interest rate shared by all
     *loan objects.
     */
    private double annualInterestRate;
    
    /** A private variable to store the number of months in term of a specific
     *loan objects.
     */
    private double months;
    
    /** This is the constructor for the LoanAccount class.

     */
    public LoanAccount(double principal, double annualInterestRate, 
            double months)
    {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.months = months;
    }

    /** This method calculates the monthly payment for the loan.
     * @return The calculated monthly payment amount.
     */
    public double calculateMonthlyPayment()
    {
        //It calculates the monthly interest rate from annualInterestRate.
        double monthlyInterest = (this.annualInterestRate / 100) / 12;
        
        //It calculates the monthly payment by using the formula.
        double monthlyPayment = this.principal * (monthlyInterest / (1 - Math.pow
        (1 + monthlyInterest, -this.months)));
        
        return monthlyPayment;
    }
    
    
    public double getprincipal(){
        return principal;
    }
    
    public double getannualInterestRate(){
        return annualInterestRate;
    }
    
    public double getmonths(){
        return months;
    }

    public String toString(){
        return String.format ("Principal: $%.2f%n" + "Annual Interest Rate: %.2f%%%n"+ 
                "Term of Loan in Months: %.0f%n" + "Monthly Payment: $%.2f",
                principal, annualInterestRate, months, calculateMonthlyPayment());
        }
    
    
    
    
    
        
        
    
}