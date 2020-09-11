package presentation;


import Business.Circle;
import helpers.*;
import business.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dylan Gallup
 */
public class CS260_W2EX {

        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       ApplicationHelpers.displayApplicationInformation("Circle","2","Basic Circle");
       
       Circle theCircle = new Circle(1000);
       //this is what say to create an object
       
       do{
           displayCircleInformation(theCircle);
           
       } while(ApplicationHelpers.continueProcessing("Circles"));
       ApplicationHelpers.terminateApplication("Basic Circle");
          
    }
    
    private static void displayCircleInformation(Circle aCircle) {
        OutputHelpers.showConsole(aCircle.toString());
    }
    
    
       
}

