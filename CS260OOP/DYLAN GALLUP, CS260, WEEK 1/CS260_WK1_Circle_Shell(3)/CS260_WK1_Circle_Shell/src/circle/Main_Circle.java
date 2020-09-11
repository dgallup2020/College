package circle;

import java.util.Scanner;
import javax.swing.JOptionPane;
public class Main_Circle
{
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args)
    {
        Circle aCircle; 
        // TODO:  call the display application information method++
        displayApplicationInformation();
        do {
            aCircle = getCircleInformation();
            displayCircleInformation(aCircle);
        } while(continueProcessing());
        
        terminateApplication();
    }
    private static Circle getCircleInformation() {
        Circle theCircle = new Circle(); //new object using hte class

        System.out.print("Enter the name of the Circle: ");
        theCircle.setName(input.nextLine());

        String prompt = "Enter circle radius between " + Circle.MIN_RADIUS + " and less than " + Circle.MAX_RADIUS + ": ";
        System.out.print(prompt);
        
        // TODO:  retrieve the radius and set the value in theCircle object++
        
        theCircle.setRadius(Double.parseDouble(input.nextLine()));
        
        return theCircle;
    }
    private static void displayCircleInformation(Circle theCircle) {
        StringBuilder message = new StringBuilder();
        message.append("\n---------------------- Circle Data -----------------------\n");
        // TODO:  add the Circle object data to the message
        message.append(theCircle.toString());
        message.append("\n----------------------  End Data -------------------------\n");

        System.out.print(message.toString());
    }
    private static void displayApplicationInformation()
    {
        StringBuilder message = new StringBuilder();
        message.append("Working with Objects--The Circle Program");
        message.append("\n--------------------------------------------------------------\n");
        message.append("When prompted provide the radius of a circle greater than ");
        message.append(Circle.MIN_RADIUS + " and less than " + Circle.MAX_RADIUS);
        message.append("\n------------------------------------------------------------ \n");

        System.out.print(message.toString());

    }
    private static void terminateApplication()
    {
        StringBuilder message = new StringBuilder();

        message.append("\n*************************************************************");
        message.append("\nTerminating Circle Program");
        message.append("\n*************************************************************\n\n");

        System.out.print(message.toString());

        input.close();
        System.exit(0);
    }
    public static Boolean continueProcessing()
    {
        Boolean keepGoing = false;
        Boolean valid = false;
        String response = "";
        StringBuilder prompt = new StringBuilder();
        prompt.append("Process another Health profile?\n");
        prompt.append("Enter Y to continue, N to stop processing: ");
        
        System.out.print(prompt.toString());
	do {
            response = input.nextLine();
            if (response == null || response.trim().length() == 0) {
                valid = false;
            }
            else {
                valid = true;
            }
        } while (!valid);
        
        keepGoing = !response.toLowerCase().equals("n");
        
        return keepGoing;
    }
}

