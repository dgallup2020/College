/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import helpers.OutputHelpers;

/**
 *
 * @author dgallup14
 */
public class Employee extends Person{
    public Pay aPay;
    public Benefits aBenefits;
    public BenefitsTypes.BenefitPackages aBtype;
    public PayTypes.PayType aPtype;
    public PayTypes.SalaryLevel slevel;
   
    
    //find some way to use the string????
    
    //default constructor maybe not needed
    /*public Employee(){
        super();
        aBenefits = new Benefits();
        aPay = new Pay();
    }
    */
    //second constructor to set up the benefits and pay
    public Employee(){
        
    }
    
    
    public Employee(BenefitsTypes.BenefitPackages aBtype, PayTypes.PayType aPtype){
        super();
        this.aBenefits = new Benefits(aBtype);
        this.aPay = new Pay(aPtype);
    }
    
    
    //setters for the benefits and pay
    
    //set the hoursworked
    
    public void setHoursWorked (double hours){
        if (aPay instanceof Hourly_Pay)
            aPay.setHours(hours);
    }
    
    public void setPayRate (double payrate){
        if(aPay instanceof Hourly_Pay)
            aPay.setPayRate(payrate);
    }
    
    public void setSalaryLevel (PayTypes.SalaryLevel slevel){
        if(aPay instanceof Salaried_Pay)
            aPay.setSalaryLevel(slevel);
    }
    
    public String getPayType(){
        if(PayTypes.PayType.HOURLY == aPtype)
            return "Hourly";
        else
            return "Salaried";
    }
    
    public double CalculateFinalPay(){
        double netPay;
        double benefitcost = aBenefits.getCost();
        if(aPay instanceof Hourly_Pay)
            netPay = aPay.calcGrossPay(aPay.getHours(),aPay.getPayRate());
        //if(aPay instanceof Salaried_Pay)
            else
            netPay = aPay.calcGrossPay(slevel);
        return netPay - benefitcost;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("First Name: ");
        str.append(getFirstName());
        str.append("\n");
        str.append("Last Name: ");
        str.append(getLastName());
        str.append("\n");
        str.append("Email: ");
        str.append(getEmail());
        str.append("\n");
        str.append("Phone Number: ");
        str.append(getPhoneNumber());
        str.append("\n");
        OutputHelpers.showOutputSeparator();
        str.append("Pay Type: \n");
        str.append(getPayType());
        str.append(aPay.toString());
        str.append("Benefits Package: \n");
        str.append(aBenefits.toString());
        OutputHelpers.showOutputSeparator();
        str.append("Final Cost: $");
        str.append(CalculateFinalPay());
        
        return str.toString();
}

    
}
