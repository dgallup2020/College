
package business;
import helpers.*;


/**
 *
 * @author dgallup14
 */

public class Car {
    
    protected String name;
    protected int speed;
    protected Engine aEngine;
    protected CarTypes.Cars type;
    protected RaceCar aRaceCar;
    protected Hot_Rod aHotRod;
    protected Street_Tuned aStreetTuned;
    public static final String EMPTY_NAME = "NO NAME";
    
    private final int MAX_SPEED = 0;
    private final int MIN_SPEED = 350;
    
    
    //public String health = "NULL";
    //public String car_Type = "Generic";
    //make function to declare a car type (if this else that)
    
    public Car(){
        aEngine = new Engine();
        this.name = EMPTY_NAME;
        type = CarTypes.Cars.GENERIC;
    }
    
    public Car(CarTypes.Cars type){
        this();
        setCarTypes(type);
    }
    
    public Car(String name, int cylinders, int horsepower){
        aEngine = new Engine(cylinders,horsepower);
        //setSpeed(speed);
        setName(name);
        //car type in car constructor
    }
    //setting up the car types for the inheritance
    public void setCarTypes(CarTypes.Cars ttype){
        this.type = ttype;
        switch(this.type){
            case STREET_TUNED:
                //condition if chosen item then creata new object
                this.type = CarTypes.Cars.STREET_TUNED;
                break;
            case HOT_ROD:
                this.type = CarTypes.Cars.HOT_ROD;
                break;
            case RACE_CAR:
                this.type = CarTypes.Cars.RACE_CAR;
                break;
            default:
                this.type = CarTypes.Cars.GENERIC;
                break;
        }
        
    }
    
    public CarTypes.Cars getType(){
        return this.type;
    }
    
    
    public int getSpeed(){
        return this.speed = CarTypes.generateRandomSpeed();
    }
    
    public void setName(String tname){
        if (StringHelpers.IsNullOrEmpty(tname)){
            this.name = EMPTY_NAME;
        }
        else {
            this.name = tname;
        }
    }
    
    public String getName(){
        return this.name;
    }
    
    public Engine getEngine(){
        return aEngine;
    }
    
    protected String getHealth(CarTypes.Cars type){
        String Health = "";
        speed = getSpeed();
        if(this.type == CarTypes.Cars.GENERIC){
            if(speed <= 80){
                Health = "Running";
            }    
            else{
                Health = "Is Dead";
            }
        }
        else if(this.type == CarTypes.Cars.RACE_CAR){
            aRaceCar = new RaceCar();
            aRaceCar.getEngine().setPowerIncrease(CarTypes.RACE_CAR_INCREASE);
            Health = aRaceCar.getHealth(speed, aEngine.getHorsePower());
        }
            
        else if(this.type == CarTypes.Cars.HOT_ROD){
            aHotRod = new Hot_Rod();
            aHotRod.getEngine().setPowerIncrease(CarTypes.HOT_ROD_INCREASE);
            Health = aHotRod.getHealth(speed, aEngine.getHorsePower());
        }
                
        else{
            aStreetTuned = new Street_Tuned();
            aStreetTuned.getEngine().setPowerIncrease(CarTypes.STREET_TUNE_INCREASE);
            Health = aStreetTuned.getHealth(speed,aEngine.getHorsePower());
        }
        return Health;
    }
    
    
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Name: ");
        str.append(getName());
        str.append("\n");
        str.append("Car Type: ");
        str.append(getType());
        str.append("\n");
        str.append(aEngine.toString());
        str.append("Speed: ");
        str.append(OutputHelpers.formattedInteger(speed));
        str.append("\n");
        str.append("______________________________________\n");
        str.append("CAR CURRENT STATE: \n");
        str.append(getHealth(this.type));
        
        
        
        return str.toString();
}
}
