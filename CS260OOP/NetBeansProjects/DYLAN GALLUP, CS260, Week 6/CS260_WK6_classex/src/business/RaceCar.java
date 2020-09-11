/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;
import Helpers.*;
import helpers.NumberHelpers;

/**
 *
 * @author dgallup14
 */
public class RaceCar extends Car{
    
    //protected Hot_Rod aHotRod;
    //protected Street_Tuned aStreetTuned;
    
    public RaceCar(){
       // super(CarTypes.Cars.RACE_CAR);
    }
    
    public String getHealth(int speed, int horsepower){
        int rand = (int)(NumberHelpers.getRandomNumber(10));
        if(speed > 80 && rand > 9){
            if(horsepower < 350)
                return "Running";
            else
                return "Is Dead";
        }
        else if(speed > 125 && rand > 7){
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
        str.append(speed);
        str.append(super.toString());
        return str.toString();
    }
}
