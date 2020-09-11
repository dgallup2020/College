
package business;
import helpers.*;
/**
 *
 * @author dgallup14
 */
public class Engine {
   
    public static final int MIN_CYLINDERS = 4;
    public static final int MAX_CYLINDERS = 12;
    public static final int MIN_HORSEPOWER = 150;
    public static final int MAX_HORSEPOWER = 750;
            
    private int numberCylinders;
    private int horsePower;
    
    
    public Engine(){
        numberCylinders = MIN_CYLINDERS;
        horsePower = MIN_HORSEPOWER;
    }
    
    public Engine(int numberCylinders, int horsePower){
        setNumberCylinders(numberCylinders);
        setHorsePower(horsePower);
    }
    
    public void setNumberCylinders(int cylinders){
        if(cylinders >= MIN_CYLINDERS && cylinders <= MAX_CYLINDERS)
            this.numberCylinders = cylinders;
        else if(cylinders < MIN_CYLINDERS)
            numberCylinders= MIN_CYLINDERS;
        else
            numberCylinders= MAX_CYLINDERS;
    }
    
    public void setHorsePower(int horsepower){
        if(horsepower >= MIN_HORSEPOWER && horsepower <= MAX_HORSEPOWER)
            this.horsePower = horsepower;
        else if(horsepower < MIN_HORSEPOWER)
            horsePower = MIN_HORSEPOWER;
        else 
            horsePower = MAX_HORSEPOWER;
    }
    
    public int getCylinders(){
        return numberCylinders;
    }
    
    public int getHorsePower(){
        return this.horsePower;
    }
    
    public final void setPowerIncrease(double increase){
        this.horsePower = (int)(increase * ((double)horsePower));
    }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Number of Cylinders: ");
        str.append(getCylinders());
        str.append("\n");
        str.append("Horse Power: ");
        str.append(getHorsePower());
        str.append("\n");
        
        return str.toString();
    }         
}
