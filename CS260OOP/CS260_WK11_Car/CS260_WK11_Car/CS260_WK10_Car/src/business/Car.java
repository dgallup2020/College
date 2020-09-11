package business;
import helpers.*;
public abstract class Car implements iDrive, iPit, iBump, iCruze
{
    private static int carCount;
    protected String name;
    protected int speed;
    protected Engine aEngine;
    protected CarTypes.Cars type = CarTypes.Cars.GENERIC;
    protected String Carinterfacestatus;

    public Car()
    {
        name = CarTypes.CarType(CarTypes.Cars.GENERIC);
        type = CarTypes.Cars.GENERIC;
        aEngine = new Engine();
        setSpeed(CarTypes.generateRandomSpeed());
    }
    public Car (CarTypes.Cars type) {
        this();
        this.type = type;
         setSpeed(CarTypes.generateRandomSpeed());
    }
    public Car(CarTypes.Cars type, String name, int cylinders, int power) {
        this.type = type;
        aEngine = new Engine(cylinders, power);
        adjustHorsePower();
         setSpeed(CarTypes.generateRandomSpeed());
    }
    public static int getCarCount() {
        return carCount;
    }
    
    public abstract void accelerate();
    public abstract void brake();
    
    public static void incrementCarCount() {
        carCount++;
    }
    public static void decrementCarCount() {
        carCount--;
    }
    public void adjustHorsePower() {
        double increase;
        if (aEngine == null) {
            aEngine = new Engine();
        }
        switch (type) {
            case RACE_CAR:
                increase = CarTypes.RACE_CAR_INCREASE;
                break;
            case STREET_TUNED:
                increase = CarTypes.STREET_TUNE_INCREASE;
                break;
            case HOT_ROD:
                increase = CarTypes.HOT_ROD_INCREASE;
                break;
            default:
                increase = CarTypes.GENERIC_INCREASE;
                break;
        }
        aEngine.setPowerIncrease(increase);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (StringHelpers.IsNullOrEmpty(name)) 
            this.name = CarTypes.CarType(CarTypes.Cars.GENERIC);
        else 
            this.name = name;
    }
    public int getSpeed() {
        return speed;
    }
    public final void setSpeed(int speed) {
        if (speed >= CarTypes.MIN_SPEED && speed <= CarTypes.MAX_SPEED) {
            this.speed  = speed;
        }
        else if (speed < CarTypes.MIN_SPEED) {
                this.speed = CarTypes.MIN_SPEED;
        }
        else {
                this.speed = CarTypes.MAX_SPEED;
        }
    }
    public Engine getEngine() {
        return aEngine;
    }
    protected String getHealth() {
        String str = "Car Running";
        if (speed > 80) {
            str = "Car Is Dead";
        }
        return str;
    }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Car Data");
        str.append("\n_________________________________________\n");
        str.append("Name:  ");
        str.append(name);
        str.append("\nCurrent speed:  ");
        str.append(OutputHelpers.formattedInteger(speed));
        str.append("\n_________________________________________\n");
        str.append(aEngine.toString());
        str.append("\n_________________________________________\n");
        str.append("Car Health:  ");
        str.append(getHealth());
        str.append("\n_________________________________________\n");
        return str.toString();
    }

    @Override//create a string that will print. then when the button is clicked
    //create a temporary variable to hold the status values
    public void turnRight() {
        this.Carinterfacestatus = "I just turned RIGHT in my " + type + " car";
    }

    @Override
    public void turnLeft() {
        this.Carinterfacestatus = "I just turned LEFT in my " + type + " car";
    }

    @Override
    public void stop() {
       this.Carinterfacestatus = "I just STOPPED my " + type + " car";
    }
    
    public String getCarinterfaceStatus(){
        return this.Carinterfacestatus;
    }

    @Override
    public void changeTires() {    
    }

    @Override
    public void fillUpGas() {    
    }
    
    @Override
    public void bump(){   
    }

    @Override
    public void justCruising() {    
    }
	
}
