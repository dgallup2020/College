/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;
import Business.*;
//import Helpers.*;

     

/**
 *
 * @author dgallup14
 */
public class Main_Employee1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         Employee Bobbyjones1 = new Employee();
         
         Employee BobbySmith = new Employee("smith",9.00,20);
         
         System.out.println(BobbySmith.getName());
        // TODO code application logic here
    }
    
}
