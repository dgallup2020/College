/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import helpers.NumberHelpers;

/**
 *
 * @author dgallup14
 */
public class Hourly_Pay extends Pay{
    
    public Hourly_Pay(){
        super(PayTypes.PayType.HOURLY);
    } 
    
    
   //private double grosspay;
   // protected double hours;
    //protected double payrate;
    
   /* 
    public void setPayRate(double payrate){
        this.payrate =  NumberHelpers.findRangeValue(payrate, MAX_PAYRATE, MIN_PAYRATE);
    }
    
    public double getPayRate(){
        return this.payrate;
    }
    
    public void setHours(double hours){
        this.hours = NumberHelpers.findRangeValue(hours, MIN_HOURS, MAX_HOURS);
    }
    
    public double getHours(){
        return this.hours;
    }
    
    public double getGrossPay(){
        return this.grosspay;
    }
    
    public double calcGrossPay(double hours, double payrate){
        
        this.payrate =  NumberHelpers.findRangeValue(payrate, MAX_PAYRATE, MIN_PAYRATE);
        this.hours = NumberHelpers.findRangeValue(hours, MIN_HOURS, MAX_HOURS);
        
        
        return this.grosspay = this.hours * this.payrate;
    }
*/
}
    