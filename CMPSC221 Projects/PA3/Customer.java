/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package customer.loan.accounts;

import java.util.ArrayList;

/**
 *
 * @author wonjonghun
 */
public class Customer {
    
    private String firstName;
    private String lastName;
    private String SSN;
    private ArrayList<LoanAccount> loanAccounts;

    /**
     * 
     */
    public Customer(String firstName, String lastName, String SSN){
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = SSN;
        this.loanAccounts = new ArrayList<>();
    }
    
    public String getfirstName(){
        return firstName;
        
    }
    public String getlastName(){
        return lastName;
        
    }
    public String getSSN(){
        return SSN;
        
    }
    
    public void addLoanAccount(LoanAccount account){
        loanAccounts.add(account);
    
    }
    
    public void printMonthlyReport(){
        System.out.printf("Account Report for Customer: %s %s with SSN %s%n%n", this.firstName, this.lastName, this.SSN);
        for (LoanAccount account : loanAccounts) {
            System.out.println(account.toString());
            System.out.println();
            System.out.println();}
    }
}
    
    
    

