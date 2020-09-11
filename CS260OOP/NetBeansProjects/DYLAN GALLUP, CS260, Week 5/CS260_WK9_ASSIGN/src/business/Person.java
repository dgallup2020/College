/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;
import helpers.*;

/**
 *
 * @author dgallup14
 */
public class Person {
    protected String firstName;
    protected String lastName;
    protected String phoneNumber;
    protected String email;
    protected double netPay;
   
    public void setFirstName(String fn){
        this.firstName = fn;
    }
    
    public void setLastName(String ln){
        this.firstName = ln;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public void setEmail(String em){
            this.email = em;
    }
    
    public void setPhoneNumber(String pn){
            this.phoneNumber = pn;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getPhoneNumber(){
        return phoneNumber;
    }
}
