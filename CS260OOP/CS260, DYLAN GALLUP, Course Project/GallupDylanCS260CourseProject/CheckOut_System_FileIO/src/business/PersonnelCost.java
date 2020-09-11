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
public class PersonnelCost {
    
    public PersonnelCost(){    
    }
    
    public PersonnelCost(double hours, double rate){
        setHours(hours);
        setRate(rate);
    }
    
    public double hours;
    public double rate;
    public double charge = 0;
    public double MAXHOURS = 60;
    public double MINHOURS = 0;

    
    public double getHours() {
        return hours;
    }
    //do the verifcation through GUI
    //do basic verificaition here. 
    public void setHours(double hours) {
        if(this.MAXHOURS!=0)
            if(hours<=this.MAXHOURS)
                this.hours = hours;
            else
                this.hours = 0;
        this.hours = hours;
    }

    public double getRate() {
        return this.rate;
    }

    public void setMaxhours(int maxhours){
        this.MAXHOURS = maxhours;
    }
    
    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getCharge() {
        return this.charge;
    }
    
    public void setCharge() {
        this.charge = this.rate*this.hours;
    }
    
    
    
}
