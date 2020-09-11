package business;
import helpers.*;
public class RaceCar extends Car implements iPit {
    
    public RaceCar() {
        super(CarTypes.Cars.RACE_CAR);
    }
    public RaceCar(CarTypes.Cars type, String name, int cylinders, int power){
        super(type, name, cylinders, power);
    }
    public RaceCar(CarTypes.Cars type) {
        super(type);
    }
    @Override
    protected String getHealth() {
        String str;
       
        if (speed > 80 && (NumberHelpers.getRandomNumber(1) > .9)) {
            if (aEngine.getHorsePower() < 350)
                str = "Race car Running";
            else
                str = "Race car is Dead";
        }
        else if (speed > 125 && (NumberHelpers.getRandomNumber(1) > .7))
            if (aEngine.getHorsePower() >= 400)
                str = "Race car is Dead";
            else
                str = "Race car is Running";
        else 
            str = "Race car is Running";
        
        return str;
    }
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(super.toString());
        str.append("\nBasic race car modifications have been done!");
        
        return str.toString();
        
    }

    @Override
    public void accelerate() {
        setSpeed(getSpeed() + 20);
    }

    @Override
    public void brake() {
        setSpeed(getSpeed() - 30);
    }

    /**
     *
     */
    @Override
    public void changeTires() {
         this.Carinterfacestatus = "I am changing the tires on my " + type + " car";
    }

    /**
     *
     */
    @Override
    public void fillUpGas() {
        this.Carinterfacestatus = "I am filling up gas on my " + type + " car";
    }
}
