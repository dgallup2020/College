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
public class Circle extends Main_Class implements iShape{
    
    
    private double radius = 8.00;
    

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI*(radius*radius);
    }

    @Override
    public double circumference() {
       return 2*Math.PI*radius;
    }

    @Override
    public double sides() {
       return 1;
    }
    
    
}

