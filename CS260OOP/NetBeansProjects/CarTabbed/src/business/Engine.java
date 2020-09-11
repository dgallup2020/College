package business;

import helpers.*;

public class Engine 
{
    public static final int MIN_CYLINDERS = 4;
    public static final int MAX_CYLINDERS = 12;
    private static final int DEFAULT_CYLINDERS = 8;
    public static final int MIN_HORSE_POWER = 150;
    public static final int MAX_HORSE_POWER = 750;
    
    private int cylinders;
    private int horsePower;
    private double powerIncrease = 0;

    public Engine()
    {
        cylinders = DEFAULT_CYLINDERS;
        horsePower = MIN_HORSE_POWER;
    }
    public Engine(int numCylinders, int horsepower) {
        setCylinders(numCylinders);
        setHorsePower(horsepower);
    }
    public int getCylinders()
    {
            return cylinders;
    }
    public final void setCylinders(int cylinders)
    {
        if (cylinders >= MIN_CYLINDERS && cylinders <= MAX_HORSE_POWER)
            this.cylinders = cylinders;
        else if (cylinders < MIN_CYLINDERS)
            this.cylinders = MIN_CYLINDERS;
        else
            this.cylinders = MAX_CYLINDERS;
    }
    public int getHorsePower()
    {
        return horsePower;
    }
    public final void setHorsePower(int power)
    {
        if (power >= MIN_HORSE_POWER && power <= MAX_HORSE_POWER) 
            this.horsePower = power;
        else if (power < MIN_HORSE_POWER)
            this.horsePower=MIN_HORSE_POWER;
        else
            this.horsePower = MAX_HORSE_POWER;
    }
    public final void setPowerIncrease(double increase) {
        horsePower = (int)((1 + increase) * (double) horsePower);
    }
    public String toString()
    {
            StringBuilder str = new StringBuilder();
            str.append("Engine Data");
            str.append("\n");
            str.append("Cylinders:  ");
            str.append(OutputHelpers.formattedInteger(cylinders));
            str.append("\n");
            str.append("Horsepower: ");
            str.append(OutputHelpers.formattedInteger(horsePower));

            return str.toString();
    }
}
