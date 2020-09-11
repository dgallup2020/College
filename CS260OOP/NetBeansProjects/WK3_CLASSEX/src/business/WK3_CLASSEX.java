/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author dgallup14
 */
public class WK3_CLASSEX {

    public static final double MIN_HOURS = 0;
    public static final double MAX_HOURS = 75;
    public static final double MIN_RATE = 8.50;
    public static final double MAX_RATE = 65;
    public static final String EMPTY_NAME = "Not Given";
    
    private double payRate;
    private double hoursWorked;
    private double grossPay;
    private String firstname;
    private String lastname;
    
    public Employee(){
        setHoursWorked(MIN_HOURS;
        setPayrate(MIN_RATE);
    }
    
    public Employee(double hoursWorked, double payRate){
        setHoursWorked(hoursWorked);
        setPayRate(payRate);
    }
    public String getFirstName(){
        return firstname;
    }
    
    public void setFirstName(String name){
        if (StringHelpers.IsNullOrEmpty(name)){
            firstname = EMPTY_NAME;
        }
        else{
            firstname = name;
        }
    }
    
    public String getLastName(){
        return lastname;
    }
    
    public void setLastName(String name){
        if (StringHelpers.IsNullOrEmpty(name)){
            lastname = EMPTY_NAME;
        }
        else{
            lastname = name;
        }
    }
    
    public double getPayRate(){
        return payrate;
    }
    
    public void setPayRate(double payRate){
        if(payRate >= MIN_RATE && payRate <= MAX_RATE){
            this.payRate = payRate;
        }
        else if (payRate < MIN_RATE){
            this.payRate = MIN_RATE;
        }
        else {
                this.payRate = MAX_RATE;
        }
    }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Employee Name: ");
        str.append(getFirstName() + " " + getLastName());
        str.append(str)
    }
}
