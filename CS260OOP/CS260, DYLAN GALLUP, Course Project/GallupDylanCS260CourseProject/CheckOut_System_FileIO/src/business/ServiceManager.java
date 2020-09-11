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
public class ServiceManager extends Person{
    
    public ServiceManager(){
        this.aCost = new PersonnelCost(); 
    }
    
    private String type;
    public PersonnelCost aCost;// = new PersonnelCost();

    public String getType() {
        return this.type;
    }

    //set the type of worker, and the maxhours depending on the worker
    public void setType(String type) {
        this.type = type;
        if("IT Student Worker".equals(type))
            aCost.MAXHOURS = 20;
        if("IT Full Time Staff".equals(type))
            aCost.MAXHOURS = 30;
    }
    
    
    
    public void setRate(double rate){
        aCost.setRate(rate);
    }
    //setter using the string type
    public void setRate(String type){
        if("IT Student Worker".equals(type))
            aCost.setRate(30);
        if("IT Full Time Staff".equals(type))
            aCost.setRate(65);
        if("IT Supervisor/Manager".equals(type))
            aCost.setRate(85);
         if("IT Director/Program Manager".equals(type))
            aCost.setRate(110);
        else
            aCost.setRate(1);
    }
    
    
    
    
}
