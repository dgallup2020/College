/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

public class PayTypes {
    
    public static final double MIN_HOURS = 0;
    public static final double MAX_HOURS = 75;
    public static final double MIN_RATE = 8.50;
    public static final double MAX_RATE = 65;
    public static final String EMPTY_NAME = "Person";
    
    public static final int MAX_PERSONS = 3;
    public static final int MIN_PERSONS = 0;
    
    private static final double TAX_RANGE1 = 1500;
    private static final double TAX_RANGE2 = 300;
    private static final double TAX_RANGE3 = 5000;
    private static final double TAX_RANGE4 = 7000;
   
    private static final double TAX_RATE1= .15;
    private static final double TAX_RATE2= .19;
    private static final double TAX_RATE3= .21;
    private static final double TAX_RATE4= .23;
    private static final double TAX_RATE5= .27;
    
    private static final double LEVEL1_SALARY = 1000;
    private static final double LEVEL2_SALARY = 1500;
    private static final double LEVEL3_SALARY = 2000;
    private static final double LEVEL4_SALARY = 3000;
    private static final double LEVEL5_SALARY = 5000;
    
    
    
    public enum PayType {
        HOURLY,
        SALARIED
    }
    public static String getPayType(PayType type) {
        String str;
        switch (type) {
            case HOURLY:
                str = "Hourly";
                break;
            case SALARIED:
                str = "Salaried";
                break;
            default:
                str = "Hourly";
                break;
        }
        return str;
    }
    public enum SalaryLevel {
        LEVEL1,
        LEVEL2,
        LEVEL3,
        LEVEL4,
        LEVEL5
    }
    public static double getSalary(SalaryLevel level) {
        double salary;
        switch (level) {
            case LEVEL1:
                salary = LEVEL1_SALARY;
                break;
            case LEVEL2:
                salary = LEVEL2_SALARY;
                break;
            case LEVEL3:
                salary = LEVEL3_SALARY;
                break;
            case LEVEL4:
                salary = LEVEL4_SALARY;
                break;
            case LEVEL5:
                salary = LEVEL5_SALARY;
                break;
            default:
                salary = LEVEL1_SALARY;
                break;
        }
        return salary;
    }
    public static String getSalaryLevel(SalaryLevel level) {
        String str;
        switch (level) {
            case LEVEL1:
                str = "Level 1";
                break;
            case LEVEL2:
                str = "Level 2";
                break;
            case LEVEL3:
                str = "Level 3";
                break;
            case LEVEL4:
                str = "Level 4";
                break;
            case LEVEL5:
                str = "Level 5";
                break;
            default:
                str = "Level 1";
                break;
        }
        return str;
    }
    public static SalaryLevel getLevel(int level) {
        SalaryLevel tmpLevel;
        switch (level) {
            case 1: 
                tmpLevel = SalaryLevel.LEVEL1;
                break;
            case 2:
                tmpLevel = SalaryLevel.LEVEL2;
                break;
            case 3:
                tmpLevel = SalaryLevel.LEVEL3;
                break;
            case 4:
                tmpLevel = SalaryLevel.LEVEL4;
                break;
            case 5:
                tmpLevel = SalaryLevel.LEVEL5;
                break;
            default:
                tmpLevel = SalaryLevel.LEVEL1;
                break;
        }
        return tmpLevel;
    }
    
    public static double calculateNetPay(double grossPay) {
        double taxRate;
        if (grossPay < TAX_RANGE1) {
            taxRate = TAX_RATE1;
        }
        else if (grossPay < TAX_RANGE2) {
            taxRate = TAX_RATE2;
        }
        else if (grossPay < TAX_RANGE3) {
            taxRate = TAX_RATE3;
        }
        else if (grossPay < TAX_RANGE4) {
            taxRate = TAX_RATE4;
        }
        else {
            taxRate = TAX_RATE5;
        }
        return (1 - taxRate) * grossPay;
    }
    
}