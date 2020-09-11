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

public class Hot_Rod extends RaceCar{
    public Hot_Rod(){
    }
    
    @Override
    public String getHealth(int speed, int horsepower){
        int rand = (int)(NumberHelpers.getRandomNumber(10));
        if(speed > 75 && rand > 7){
            if(horsepower < 400)
                return "Running";
            else
                return "Is Dead";
        }
        else if(speed > 125 && rand > 5){
            if(horsepower >= 400)
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
