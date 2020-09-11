
package business;

import helpers.*;
public class Person {
    
    private String firstName;
    private String lastName;
    
    public static final String EMPTY_NAME = "Not Given";
    
     public Person(){
        firstName = EMPTY_NAME;
        lastName = EMPTY_NAME;
    }
    
    public Person(String firstName, String lastName){
        setFirstName(firstName);
        setLastName(lastName);
    }
    
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String name) {
        if (StringHelpers.IsNullOrEmpty(name)) {
            firstName = EMPTY_NAME;
        }
        else {
            firstName = name;
        }
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String name) {
        if (StringHelpers.IsNullOrEmpty(name)) {
            lastName = EMPTY_NAME;
        }
        else {
            lastName = name;
        }
    }

    
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Employee Name: ");
        str.append(getFirstName());
        str.append(" ");
        str.append(getLastName());
        str.append("\n");
        
        return str.toString();
    }
}
