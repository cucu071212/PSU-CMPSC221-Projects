/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package customer.loan.accounts;

/**
 *
 * @author Jonghun Won
 */
public class Address{
    private String street;
    private String city;
    private String state;
    private String zipcode;
    
    public Address(String street, String city, String state, String zipcode){
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }
    
    public String getstreet(){
        return street;
    }
    
    public String getcity(){
        return city;
    }
    
    public String getstate(){
        return state;
    }
    
    public String getzipcode(){
        return zipcode;
    }
    
    @Override
    public String toString(){
        return String.format("    %s%n"+"    %s, %s %s%n%n",
                street, city, state, zipcode);
    }
}
    