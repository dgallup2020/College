/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;
//pay rate, hours, and calculate pay

import helpers.*;

/**
 *
 * @author dgallup14
 */
public class Pay {
    public static final double MIN_HOURS = 0;
    public static final double MAX_HOURS = 75;
    public static final double MIN_RATE = 8.50;
    public static final double MAX_RATE = 65;
    
    
    
    
    private double payRate;
    private double hoursWorked;
    private double grossPay;
    private double taxRate;
 
    public Pay(){
        payRate = MIN_RATE;
        hoursWorked = MIN_HOURS;
    }
    
    public Pay(double hoursWorked, double payRate){
        setHoursWorked(hoursWorked);
        setPayRate(payRate);
    }
    
    public double getPayRate() {
        return payRate;
    }
    public final void setPayRate(double payRate) {
        if (payRate >= MIN_RATE && payRate <= MAX_RATE) {
            this.payRate = payRate;
        }
        else if (payRate < MIN_RATE) {
            this.payRate = MIN_RATE;
        }
        else {
             this.payRate = MAX_RATE;
        }
    }
    public double getGrossPay() {
        calculateGrossPay();
        return grossPay;
    }
    
    public double getNetPay() {
        calculateGrossPay();
        return grossPay * (1-calculateTaxRate(grossPay));
        
    }
    public double getHoursWorked() {
        return hoursWorked;
    }
    public final void setHoursWorked(double hoursWorked) {
        if (hoursWorked >= MIN_HOURS && hoursWorked <= MAX_HOURS) {
            this.hoursWorked = hoursWorked;
        }
        else if (hoursWorked < MIN_HOURS) {
            this.hoursWorked = MIN_HOURS;
        }
        else {
            this.hoursWorked = MAX_HOURS;
        }
    }
    private void calculateGrossPay() {
        grossPay = hoursWorked * payRate;
    }   
    
    private double calculateTaxRate(double grossPay){
        
        if(grossPay<1500)
            taxRate = .15;
        if(grossPay >= 1500 && grossPay < 3000)
            taxRate = .19;
        if(grossPay >= 3000 && grossPay < 5000)
            taxRate = .21;
        if(grossPay >= 5000 && grossPay < 7000)
            taxRate = .23;
        if(grossPay >= 7000)
            taxRate = .27;
         
        return taxRate;
    }
    
    
    
    
            
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Hours worked: ");
        str.append(OutputHelpers.formattedDouble(getHoursWorked(), 2));
        str.append("\n");
        str.append("Pay rate: ");
        str.append(OutputHelpers.formattedCurrency(getPayRate()));
        str.append("\n");
        str.append("Gross pay: ");
        str.append(OutputHelpers.formattedCurrency(getGrossPay()));
        str.append("\n");
        str.append("Net pay: ");
        str.append(OutputHelpers.formattedCurrency(getNetPay()));
        
        return str.toString();
    }         
            
}
