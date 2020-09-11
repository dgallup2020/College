/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import business.Circle;
import business.Square;
import business.iShape;
import helpers.OutputHelpers;

/**
 *
 * @author dgallup14
 */
public class Main_Class {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Circle aCircle =  new Circle();
        Square aSquare = new Square();
        
        
        
        displayShapeInfo(aSquare);
        displayShapeInfo(aCircle);
        
        
        
    }
    
    
    public static void displayShapeInfo(iShape myShape){
            StringBuilder shapeInfo = new StringBuilder();
            String str;
            
            shapeInfo.append("Shape type: " + myShape.getClass() + "\n\n");
            
            
            str = String.format("Area: %4.2f\n", myShape.area());
            shapeInfo.append(str);
            
            str = String.format("Circumference: %4.2f\n", myShape.circumference());
            shapeInfo.append(str);
            
            str = String.format("Sides: %f\n", myShape.sides());
            shapeInfo.append(str);
            
            OutputHelpers.showStandardDialog(shapeInfo.toString(), "Shape: " + myShape.getClass());
    }
    
}
