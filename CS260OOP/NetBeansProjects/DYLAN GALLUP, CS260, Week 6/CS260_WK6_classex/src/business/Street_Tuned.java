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
public class Street_Tuned extends RaceCar{
    public Street_Tuned(){    
    }
    
    @Override
    public String getHealth(int speed, int horsepower){
        int rand = (int)(NumberHelpers.getRandomNumber(10));
        if(speed > 80 && rand > 9){
            if(horsepower < 425)
                return "Running";
            else
                return "Is Dead";
        }
        else if(speed > 100 && rand > 5){
            if(horsepower > 300)
                return "Is Dead";
            else
                return "Running";
        }
        else
            return "Running";    
    }
    
    
    
    
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append(super.toString());
        return str.toString();
    }
}
