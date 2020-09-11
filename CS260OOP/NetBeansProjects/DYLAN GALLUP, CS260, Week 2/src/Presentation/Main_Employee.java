/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;
import Business.*;
import helpers.*;
import static helpers.ApplicationHelpers.terminateApplication;
import java.util.Scanner;




     

/**
 *
 * @author dylan gallup
 */
public class Main_Employee {

    /**
     * @param args the command line arguments
     */
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
   
         
        Employee BobbySmith = new Employee();//("SMITH",9.00,60);
      
        getEmployeeInformation(BobbySmith);
        displayEmployeeInformation(BobbySmith);
         //System.out.println(BobbySmith.toString());        
        terminateApplication("Pay Calculator");
        System.exit(0);
         // TODO code application logic here
         
        }
        private static void getEmployeeInformation(Employee n1) {
        if (n1 == null) 
            n1 = new Employee();
        n1.setName(InputHelpers.getScannerInput("Employee name"));
        n1.setPayrate(InputHelpers.getScannerInput("Payrate", Employee.MIN_PAYRATE, Employee.MAX_PAYRATE));
        n1.setHoursworked(InputHelpers.getScannerInput("Hours Worked", Employee.MIN_HOURSWORKED, Employee.MAX_HOURSWORKED));
        }   
        
        private static void displayEmployeeInformation(Employee n1) {
        OutputHelpers.showConsole(n1.toString());
        }
        
    
    
        
        // TODO:  retrieve the radius and set the value in theCircle object++
        
        
    
}
