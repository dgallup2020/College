/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author dgallup14
 */
public class Employee {
    
   
    
    public static final String DEFAULT_NAME = "";
    public static final double DEFAULT_PAYRATE = 0;
    public static final int DEFAULT_HOURSWORKED = 0;
    public static final double DEFAULT_GROSSPAY = 0;
    
    public static final double MIN_PAYRATE = 8.50; 
    public static final double MAX_PAYRATE = 65.00;
    public static final int MIN_HOURSWORKED = 0;
    public static final int MAX_HOURSWORKED = 75;
    
    
    private String name;
    private double payrate;
    private int hoursworked;
    
    private double grosspay;
    
    
    
    
    
    public Employee() {
        //this.name = DEFAULT_NAME;
        //this.payrate = DEFAULT_PAYRATE;
        //this.hoursworked = DEFAULT_HOURSWORKED;
        //this.grosspay = DEFAULT_GROSSPAY;
    }
    
    public Employee(String nm, double pr, int hw){
        setName(nm);
        setPayrate(pr);
        setHoursworked(hw);
    }
    
    
    
    
    public void setName(String name){
       this.name = name;
    }
    
    public void setPayrate(double payrate){
        if (payrate >= Employee.MIN_PAYRATE && payrate <= Employee.MAX_PAYRATE)
            this.payrate = payrate;
        else
            this.payrate = DEFAULT_PAYRATE;
    }
    
    
    public void setHoursworked(int hw){
        if (hw >= Employee.MIN_HOURSWORKED && hw <= Employee.MAX_HOURSWORKED)
            this.hoursworked = hw;
        else
            this.hoursworked = DEFAULT_HOURSWORKED;
    }

    
    
    
    
    public String getName(){
        return name;
    
    }
    
    public double getPayrate(){
        return payrate;
    }
    
    public int getHoursworked(){
        return hoursworked;
    }
    
    
    private double calcgrosspay(){
        return grosspay = hoursworked*payrate;
    }
    
    public double getGrosspay(){
        return calcgrosspay();
    }
    
    
    @Override
    public String toString() {
        return "Employee{" + "name=" + getName() + ", payrate=" + getPayrate() + ", hoursworked=" + getHoursworked() + ", grosspay=" + calcgrosspay() + '}';
    }    
}