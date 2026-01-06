/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package customer.loan.accounts;

/**
 *
 * @author Jonghun Won
 */
public class CarLoan extends LoanAccount {
    private String vehicleVIN;
        
    public CarLoan(double principal, double annualInterestRate, 
        double months, String vehicleVIN){
        super(principal, annualInterestRate, months);
        this.vehicleVIN = vehicleVIN;}
    
    @Override
    public String toString(){
        return String.format ("Car Loan with:%n%s%n" + "Vehicle VIN: %s%n%n",
                super.toString(),vehicleVIN);
        }
        
    }
        
    