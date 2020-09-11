/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import presentation.Main_Class;

/**
 *
 * @author dgallup14
 */
public class Square extends Main_Class implements iShape{

    
    
    public int getSideLength() {
        return sideLength;
    }

    public void setSideLength(int sideLength) {
        this.sideLength = sideLength;
    }
 
    
    
    
    private int sideLength = 4;

    @Override
    public double area() {
        return sideLength*sideLength;
    }

    @Override
    public double circumference() {
       return 4*sideLength;
    }

    @Override
    public double sides() {
        return 4;
    }
    
}
