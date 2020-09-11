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
public class Pay {
    protected double grossPay;
    protected double NetPay;
    protected double hours;
    protected double payrate;
    protected double BenefitCost;
    protected PayTypes.PayType payType;
    
    protected PayTypes.SalaryLevel salarylv;
    protected Salaried_Pay aSalariedPay;
    protected Hourly_Pay aHourlyPay;
    
    public static final double MIN_HOURS = 0;
    public static final double MAX_HOURS = 75;
    public static final double MIN_RATE = 8.50;
    public static final double MAX_RATE = 65;

    
    protected Pay(PayTypes.PayType paytype){
        if(paytype == PayTypes.PayType.HOURLY)
            aHourlyPay = new Hourly_Pay();
        else{
            aSalariedPay = new Salaried_Pay();
        }
    }
    
    
    
    //redundant??
    
    public void setPayType(PayTypes.PayType paytype){
        this.payType = paytype;
    }
    
    
    
//for this you need the hours and payrate for the hourly;
    // for the salaried you need to find a way to know the level
    //paytypes calculatenetpay you get tax reductions as well.
            
    
    protected void setNetPay(PayTypes.PayType payType) {
        if(payType == PayTypes.PayType.SALARIED){
            this.NetPay = PayTypes.calculateNetPay(calcGrossPay(salarylv));
        }
        if(payType == PayTypes.PayType.HOURLY){
            this.NetPay = PayTypes.calculateNetPay(calcGrossPay(hours, payrate));
        }
    }
    
    protected double getNetPay(){
        return NetPay;
    }

    //This is for the Hourly Pay Inheritance since you can not access methods from a child class
    
    public void setPayRate(double payrate){
        this.payrate =  NumberHelpers.findRangeValue(payrate, MAX_RATE, MIN_RATE);
    }
    
    protected double getPayRate(){
        return this.payrate;
    }
    
    public void setHours(double hours){
        this.hours = NumberHelpers.findRangeValue(hours, MIN_HOURS, MAX_HOURS);
    }
    
    protected double getHours(){
        return this.hours;
    }
    
    protected double getGrossPay(){
        return this.grossPay;
    }
    
    protected double calcGrossPay(double hours, double payrate){
        
        this.payrate =  NumberHelpers.findRangeValue(payrate, MAX_RATE, MIN_RATE);
        this.hours = NumberHelpers.findRangeValue(hours, MIN_HOURS, MAX_HOURS);
        
        
        return this.grossPay = this.hours * this.payrate;
        
    }
    //this is fo rhte Salary Pay Inheritance since you can not access methods from child
    
    protected void setSalaryLevel(PayTypes.SalaryLevel level){
        this.salarylv = level;
    }
    
    protected String getSalaryLevel(){
        return PayTypes.getSalaryLevel(salarylv);
    }
    
    protected double calcGrossPay(PayTypes.SalaryLevel salarylv){
        return PayTypes.getSalary(salarylv);
    }
    
    
    
    
    
    
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Pay Information\n");
        
        if(aSalariedPay instanceof Pay){
            str.append("Salary Level: ");
            str.append(getSalaryLevel());
            str.append("\n");
            str.append("Gross Pay: $");
            str.append(calcGrossPay(salarylv));
            str.append("\n");
            str.append("Net Pay: $");
            str.append(NetPay);
            str.append("\n");
        }
        else{
            str.append("Hours: ");
            str.append(getHours());
            str.append("\n");
            str.append("Pay Rate: ");
            str.append(getPayRate());
            str.append("\n");
            str.append("Gross Pay: $");
            str.append(calcGrossPay(hours, payrate));
            str.append("\n");
            str.append("Net Pay: $");
            str.append(NetPay);
            str.append("\n"); 
        }
            
        
        return str.toString();
    }
   
}
