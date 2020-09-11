package business;
import helpers.NumberHelpers;
public class StreetTuned extends RaceCar
{
    public StreetTuned() {
        super(CarTypes.Cars.STREET_TUNED);
    }
    public StreetTuned(String name, int cylinders, int power) {
        super(CarTypes.Cars.STREET_TUNED, name, cylinders, power);
    }
    @Override
    protected String getHealth() {
        String str;
        if (speed > 50 && (NumberHelpers.getRandomNumber(1) > .6)) {
            if (aEngine.getHorsePower() < 425)
                str = "Street Tuned is Running";
            else
                str = "Street Tuned is Dead";
        }
        else if (speed > 100 && (NumberHelpers.getRandomNumber(1) > .4))
            if (aEngine.getHorsePower() >= 400)
                str = "Street Tuned is Dead";
            else
                str = "Street Tuned is Running";
        else 
            str = "Street Tuned is Running";
        
        return str;
    }
    @Override
    public String carDetails()
    {
            StringBuilder str = new StringBuilder();
            str.append(super.toString());
            str.append("\nStreet Tuned has a nitrous system");
            return str.toString();
    }
}
