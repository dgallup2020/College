package helpers;
//Java extension packages
import java.text.*;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class InputHelpers 
{
    public static final int CANCEL_FLAG = -99;
    private static final NumberFormat decimalFormatter = NumberFormat.getNumberInstance();
    private static Scanner input = new Scanner(System.in);

    /******************  Scanner methods ***************************/
    public static int getScannerInput(String dataInput, int minValue,int maxValue) {
        int num = 0;
        boolean valid;
        String prompt;

        prompt = "Enter a " + dataInput + " between " + minValue + " and "
                        + maxValue + ": ";
        do {
            try {
                System.out.print(prompt);
                while (!input.hasNextInt()) {
                    input.next();
                    System.out.print("Invalid number " + prompt);
                }
                num = input.nextInt();
                if (num >= minValue && num <= maxValue) {
                    valid = true;
                } 
                else {
                    valid = false;
                }
            }
            catch (Exception ex) {
                OutputHelpers.showExceptionDialog("Illegal input " + prompt, "Illegal " + dataInput);
                valid = false;
            }

        } while (!valid);
        return num;
    }
    public static double getScannerInput(String dataInput, double minValue, double maxValue)
    {
        double num = 0;
        boolean valid;
        String prompt = "Enter a " + dataInput + " between "
                        + decimalFormatter.format(minValue) + " and "
                        + decimalFormatter.format(maxValue) + ": ";

        do {
            try {
                System.out.print(prompt);
                while (!input.hasNextDouble()) {
                    input.nextLine();
                    System.out.print(prompt);
                }
                num = input.nextDouble();
                if (num >= minValue && num <= maxValue) {
                    valid = true;
                } 
                else {
                    valid = false;
                }
            }
            catch (Exception ex) {
                OutputHelpers.showExceptionDialog("Illegal input " + prompt, "Illegal " + dataInput);
                valid = false;
            }

        } while (!valid);
        return num;
    }
    public static String getScannerInput(String dataInput)
    {
            String strInput;
            boolean valid;
            String prompt = "\nEnter a " + dataInput + ": ";
            do {
                System.out.print(prompt);
                strInput = input.nextLine();
                if (strInput == null || strInput.trim().length() == 0) {
                    valid = false;
                }
                else {
                    valid = true;
                }
            } while (!valid);
            return strInput;
    }
    public static void closeScanner() {
        if (input != null) {
            input.close();
        }
    }
    /******************  Integer Methods ***************************/
    public static int getIntegerInput(String dataInput)
    {
        int num = 0;
        String numStr = "";
        boolean valid = false;
        String prompt = "";

        while (!valid) {
            try {
                prompt = "Enter a whole number " + dataInput; 
                numStr = JOptionPane.showInputDialog(prompt);
                num = Integer.parseInt(numStr);
                valid = true;
            } 
            catch (NumberFormatException e) {
                    OutputHelpers.showExceptionDialog("Illegal input " + prompt, "Illegal " + dataInput);
            }
        }
        return num;
    }
    public static int getIntegerInput(String dataInput, int minValue, int maxValue) {
        int num = 0;
        String numStr = "";
        boolean valid = false;
        String prompt = "";

        while (!valid) {
            try {
                prompt = "Enter a " + dataInput + " between " + decimalFormatter.format(minValue)+ " and " + decimalFormatter.format(maxValue); 
                numStr = JOptionPane.showInputDialog(prompt);
                if (numStr != null) {
                    num = Integer.parseInt(numStr);
                    if (num >= minValue && num <= maxValue)
                        valid = true;
                    else
                        valid = false;
                } 
                else {
                    valid = true; 
                    num = CANCEL_FLAG;
                }
                if (!valid)
                    OutputHelpers.showExceptionDialog("Illegal input " + prompt, "Invalid " + dataInput);
                } 
            catch (NumberFormatException e) 
            {
                    OutputHelpers.showExceptionDialog("Illegal input " + prompt, "Illegal " + dataInput);
            }
        }
        return num;
    }
   

    /****************** Double  Methods ***************************/

  
    public static double getDoubleInput(String dataInput) {
        double num = 0;
        String numStr = "";
        boolean valid = false;
        String prompt = "";
        decimalFormatter.setMaximumFractionDigits(2);

        while (!valid) {
            try {
                prompt = "Enter a " + dataInput ; 
                numStr = JOptionPane.showInputDialog(prompt);
                num = Double.parseDouble(numStr);
                valid = true;
            } 
            catch (NumberFormatException e) {
                valid = false;
                OutputHelpers.showExceptionDialog("Illegal input " + prompt, "Illegal " + dataInput);
                num = (double) CANCEL_FLAG;
            }
        }
        return num;
    }

    public static double getDoubleInput(String dataInput, double minValue, double maxValue) {
        double num = 0;
        String numStr = "";
        boolean valid = false;
        String prompt = "";
        decimalFormatter.setMaximumFractionDigits(2);

        while (!valid) {
            try {
                prompt = "Enter a " + dataInput + " between " + decimalFormatter.format(minValue)+ " and " + decimalFormatter.format(maxValue); 
                numStr = JOptionPane.showInputDialog(prompt);
                if (numStr != null) {
                    num = Double.parseDouble(numStr);
                    if (num >= minValue && num <= maxValue)
                        valid = true;
                    else
                        valid = false;
                } 
                else {
                        //user selected cancel
                    valid = true; 
                    num = (double) CANCEL_FLAG;
                }
                if (!valid)
                    OutputHelpers.showExceptionDialog("Invalid input " + prompt, "Illegal " + dataInput);
            } 
            catch (NumberFormatException e) {
                    OutputHelpers.showExceptionDialog("Illegal input " + prompt, "Illegal " + dataInput);
            }
        }
        return num;
    }
    /****************** String Methods ***************************/

    public static String getString(String dataInput)
    {
        String input;
        input = JOptionPane.showInputDialog("Enter " + dataInput);
        return input;
    }

    /************ GUI Helpers **************************************/

    public static boolean fieldNotEmpty(JTextField theField, String info) {
        boolean notEmpty = true;

        if (theField.getText() == null || theField.getText().trim().length() == 0) {
            notEmpty = false;
        }
        return notEmpty;
    }
    public static double parseDoubleField(JTextField theField, String info) {
        double value;
        try {
            if (fieldNotEmpty(theField, info)) {
                value = Double.parseDouble(theField.getText());
            }
            else {
                String message = info + " value is invalid, enter any value between ";
                OutputHelpers.showExceptionDialog(message, "Invalid " + info);
                value = (double) CANCEL_FLAG;
            }
        }
        catch (NumberFormatException ex) {
            String message = info + " value is illegal, enter any value between ";
            OutputHelpers.showExceptionDialog(message, "Illegal " + info);
            value = (double) CANCEL_FLAG;
        }
        return value;
    }
    public static double parseDoubleField(JTextField theField, String info, double minValue, double maxValue) {
        double value;
        try {
            if (fieldNotEmpty(theField, info)) {
                value = Double.parseDouble(theField.getText());
                if (value < minValue || value > maxValue) {
                    OutputHelpers.showExceptionDialog(info + " needs to be an integer between " + minValue + " and " + maxValue, info + " input");
                    value = (double) CANCEL_FLAG;
                    theField.setText("");
                    theField.requestFocus();
                }
            }
            else {
                String message = info + " value is invalid, enter any value between " + minValue + " and " + maxValue;
                OutputHelpers.showExceptionDialog(message, "Invalid " + info);
                value = (double) CANCEL_FLAG;
            }
        }
        catch (NumberFormatException ex) {
            String message = info + " value is illegal, enter any value between " + minValue + " and " + maxValue;
            OutputHelpers.showExceptionDialog(message, "Illegal " + info);
            value = CANCEL_FLAG;
        }
        return value;
    }
    public static int parseIntegerField(JTextField theField, String info) {
        int value;
        try {
            if (fieldNotEmpty(theField, info)) {
                value = Integer.parseInt(theField.getText());
            }
            else {
                String message = info + " value is invalid, enter any value between ";
                OutputHelpers.showExceptionDialog(message, "Invalid " + info);
                value = CANCEL_FLAG;
            }
        }
        catch (NumberFormatException ex) {
            String message = info + " value is illegal, enter any value between ";
            OutputHelpers.showExceptionDialog(message, "Illegal " + info);
            value = CANCEL_FLAG;
        }
        return value;
    }
    public static int parseIntegerField(JTextField theField, String info, int minValue, int maxValue) {
        int value;
        try {
            if (fieldNotEmpty(theField, info)) {
                value = Integer.parseInt(theField.getText());
                if (value < minValue || value > maxValue) {
                    OutputHelpers.showExceptionDialog(info + " needs to be an integer between " + minValue + " and " + maxValue, info + " input");
                    value = CANCEL_FLAG;
                    theField.setText("");
                    theField.requestFocus();
                }
            }
            else {
                String message = info + " value is invalid, enter any value between " + minValue + " and " + maxValue;
                OutputHelpers.showExceptionDialog(message, "Invalid " + info);
                value = CANCEL_FLAG;
            }
        }
        catch (NumberFormatException ex) {
            String message = info + " value is illegal, enter any value between " + minValue + " and " + maxValue;
            OutputHelpers.showExceptionDialog(message, "Illegal " + info);
            value = CANCEL_FLAG;
        }
        return value;
    }
    public static String getStringField(JTextField theField, String info) {
        String value = "";

        if (fieldNotEmpty(theField, info)) {
            value = theField.getText();
        }
        else {
            OutputHelpers.showExceptionDialog(info + " cannot be empty", info + " input");
        }
        return value;
    }
    //setter utilities
    public static String setField(String value, String valueDefault) {
        String str;
        if (!StringHelpers.IsNullOrEmpty(value)) {
            str = value;
        }
        else {
            str = valueDefault;
        }
        return str;
    }
    public static double setField(double value, double minValue, double maxValue) {
        double tmpValue;
        if (value >= minValue && value <= maxValue) {
            tmpValue = value;
        }
        else if (value < minValue) {
            tmpValue = minValue;
        }
        else {
             tmpValue = maxValue;
        }
        return tmpValue;
    }
     public static int setField(int value, int minValue, int maxValue) {
        int tmpValue;
        if (value >= minValue && value <= maxValue) {
            tmpValue = value;
        }
        else if (value < minValue) {
            tmpValue = minValue;
        }
        else {
             tmpValue = maxValue;
        }
        return tmpValue;
    }
}