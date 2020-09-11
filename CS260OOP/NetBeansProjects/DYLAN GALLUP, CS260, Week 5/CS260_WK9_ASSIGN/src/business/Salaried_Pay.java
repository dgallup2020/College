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
public class Salaried_Pay extends Pay{
    
    public Salaried_Pay(){
        super(PayTypes.PayType.SALARIED);
    }
    
    /*
     public void setSalaryLevel(PayTypes.SalaryLevel lvl){
        this.salarylv = lvl;
    }
    
    public String getSalaryLevel(){
        return PayTypes.getSalaryLevel(salarylv);
    }
    
    public double calcGrossPay(PayTypes.SalaryLevel salarylv){
        return PayTypes.getSalary(salarylv);
    }
    */
    
    
}
