package helpers;
import java.text.NumberFormat;

public class NumberHelpers 
{
    public static int getRandomNumber(int seed)
    {
            return (int) (Math.random() * seed + 1);
    }

    private static NumberFormat decimalFormatter = NumberFormat.getNumberInstance();
    public static NumberFormat getDecimalFormatter(int precision)
    {
            decimalFormatter.setMaximumFractionDigits(precision);
            return decimalFormatter;
    }

    private static NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
    public static NumberFormat getCurrencyFormatter()
    {
            return currencyFormatter;
    }
    private static NumberFormat percentFormatter = NumberFormat.getPercentInstance();
    public static NumberFormat getPercentFormatter(int precision) {
        percentFormatter.setMaximumFractionDigits(precision);
        return percentFormatter;
    }
    public static int findRangeValue(int value, int min, int max) {
        int theValue;
        if (value >= min && value <= max) {
            theValue = value;
        }
        else if (value < min) {
            theValue = min;
        }
        else {
            theValue = max;
        }
        return theValue;
    }
     public static double findRangeValue(double value, double min, double max) {
        double theValue;
        if (value >= min && value <= max) {
            theValue = value;
        }
        else if (value < min) {
            theValue = min;
        }
        else {
            theValue = max;
        }
        return theValue;
    }
}
