/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import helpers.InputHelpers;
import helpers.StringHelpers;

public class Person implements java.io.Serializable {
    
    private static final String DEFAULT_NAME = "Not Given";
    
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String phone;
    
    

  
    public Person ()
    {
        this.firstName = DEFAULT_NAME;
        this.lastName = DEFAULT_NAME;
    }
    public Person(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }
     public String getFirstName() {
        return firstName;
    }

    public final void setFirstName(String name) {
        this.firstName = InputHelpers.setField(name, DEFAULT_NAME);
    }
    public String getLastName() {
        return lastName;
    }
    public final void setLastName(String name) {
        this.lastName = InputHelpers.setField(name, DEFAULT_NAME);
    }
    public String getFullName() {
        return firstName + " " + lastName;
    }
     public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = InputHelpers.setField(email, DEFAULT_NAME);
    }
     public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = InputHelpers.setField(phone, DEFAULT_NAME);
    }
    
    
   
    public String getPersonInfo() {
        StringBuilder str = new StringBuilder();
        str.append(getFullName());
        str.append("\nEmail: ");
        str.append(email);
        str.append("\nPhone: ");
        str.append(StringHelpers.formattedPhone(phone));
        
        return str.toString();
    }
    @Override
    public String toString() {
        return getFullName();
    }
    
}
