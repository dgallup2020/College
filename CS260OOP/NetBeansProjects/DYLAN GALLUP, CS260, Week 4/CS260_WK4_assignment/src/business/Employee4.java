package business;
import helpers.*;
//given employee class from boulware
public class Employee4 {
    
    
    private final Person person1;
    private Pay aPay;
    
    public Employee4() {
        //setHoursWorked(hoursWorked);
        //setPayRate(payRate);
        person1 = new Person();
        aPay = new Pay();
        
    }
    
    
    public Employee4(double hoursWorked, double payRate) {
        aPay = new Pay(hoursWorked,payRate);
        person1 = new Person();  
    }
    
    public Person getPerson(){
        return person1; 
    }
    
    public Pay getPay(){
        return aPay;
    }
    
    
    
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(person1.toString());
        str.append(aPay.toString());
        
        return str.toString();
    } 
}
