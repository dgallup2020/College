package business;
import helpers.NumberHelpers;
public class StreetTuned extends RaceCar implements iBump,iCruze
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
    public String toString()
    {
            StringBuilder str = new StringBuilder();
            str.append(super.toString());
            str.append("\nStreet Tuned has a nitrous system");
            return str.toString();
    }

    @Override
    public void bump() {
        this.Carinterfacestatus = "I am BUMPING in my " + type + " car";
    }

    @Override
    public void justCruising() {
        this.Carinterfacestatus = "I am CRUISING DOWN the streets in my " + type + " car";
    }
}
