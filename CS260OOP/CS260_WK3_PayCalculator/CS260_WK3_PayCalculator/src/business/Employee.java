package business;
import helpers.*;

public class Employee {
    
    
    
    private Pay aPay;
    private Person aPerson;
    
    public Employee() {
        aPay = new Pay();
        aPerson = new Person();
    }
    
    public Employee(double hoursWorked, double payRate) {
        aPay = new Pay(hoursWorked,payRate);
    }
    
    public Pay getPay(){
        return aPay;
    }
    
 
    
    
    
    
    
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(aPerson.toString());
        str.append(aPay.toString());
        
        return str.toString();
    } 
}
