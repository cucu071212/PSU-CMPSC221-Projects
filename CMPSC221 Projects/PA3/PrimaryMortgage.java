/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package customer.loan.accounts;

/**
 *
 * @author Jonghun Won
 */
public class PrimaryMortgage extends LoanAccount{
    private double PMIMonthlyAmount;
    private Address Address;
    
    public PrimaryMortgage(double principal, double annualInterestRate, 
        double months, double PMIMonthlyAmount, Address Address){
        super(principal, annualInterestRate, months);
        this.PMIMonthlyAmount = PMIMonthlyAmount;
        this.Address = Address;}
        
    @Override
    public String toString(){
        return String.format ("Primary Mortgage Loan with:%n%s%n" + "PMI Monthly Amount: $%.2f%n" + "Property Address: %n%s",
                super.toString(), PMIMonthlyAmount, Address);
    }
    }
