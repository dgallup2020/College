package business;
import helpers.NumberHelpers;
public class HotRod extends RaceCar
{
    public HotRod() {
        super(CarTypes.Cars.HOT_ROD);
    }
    public HotRod(String name, int cylinders, int power) {
        super(CarTypes.Cars.HOT_ROD, name, cylinders, power);
    }
    protected String getHealth() {
        String str;
        if (speed > 80 && (NumberHelpers.getRandomNumber(1) > .9)) {
            if (aEngine.getHorsePower() < 350)
                str = "Hot Rod is Running";
            else
                str = "Hot Rod is Dead";
        }
        else if (speed > 125 && (NumberHelpers.getRandomNumber(1) > .7))
            if (aEngine.getHorsePower() >= 400)
                str = "Hot Rod is Dead";
            else
                str = "Hot Rod is Running";
        else 
            str = "Hot Rod is Running";
        
        return str;
    }
    
    @Override
    public String toString()
    {
            StringBuilder str = new StringBuilder();
            str.append(super.toString());
            str.append("\nHot rod has a blower");
            return str.toString();
    }
    
    @Override
    public void accelerate() {
        setSpeed(getSpeed() + 10);
    }

    @Override
    public void brake() {
        setSpeed(getSpeed() - 20);
    }
    
    
    @Override
    public void changeTires() {
         this.Carinterfacestatus = "I am changing the tires on my " +"HOT ROD";
    }

    
    @Override
    public void fillUpGas() {
        this.Carinterfacestatus = "I am filling up gas on my " + "HOT ROD";
    }
    
}
