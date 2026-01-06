/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loan.account.hierarchy;

/**
 *
 * @author Jonghun Won
 */
public class UnsecuredLoan extends LoanAccount {
    
    public UnsecuredLoan(double principal, double annualInterestRate, 
        double months){
        super(principal, annualInterestRate, months);
    }
    @Override
    public String toString(){
        return String.format ("Unsecured Loan with:%n%s",
                super.toString());
        }
        
    
    
    
}
