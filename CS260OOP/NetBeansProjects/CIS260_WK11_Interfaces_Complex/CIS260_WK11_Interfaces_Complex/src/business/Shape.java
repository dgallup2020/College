package business;

import helpers.InputHelpers;
import helpers.OutputHelpers;

//Note:  Shape is a class that implements a Interface
//however, since Shape is an Abstract class, it is not
//required to implement the Interface methods, but any concrete subclass
//of Shape will be required to implment the Interface methods
public abstract class Shape implements IShape
{
    public static final int MIN_COORDINATE = 0;
    public static final int MAX_COORDINATE = 1024;
    public static final int MIN_SIDES = 0;
    public static final int MAX_SIDES = 20;
    public static final String DEFAULT_TYPE = "Point";
    
    protected int x;
    protected int y;
    protected String type;
    protected int numberSides;

    public Shape() {
        setX(MIN_COORDINATE);
        setY(MIN_COORDINATE);
        setType(DEFAULT_TYPE);
        setNumberSides(MIN_SIDES);
    }
    protected Shape(String type, int numberSides) {
        this();
        setType(type);
        setNumberSides(numberSides);
    }
    public Shape(String type, int numberSides, int x, int y) {
        setX(x);
        setY(y);
        setType(type);
        setNumberSides(numberSides);
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = InputHelpers.setField(x, MIN_COORDINATE, MAX_COORDINATE);
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = InputHelpers.setField(y, MIN_COORDINATE, MAX_COORDINATE);
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = InputHelpers.setField(type, DEFAULT_TYPE);
    }
    public int getNumberSides() {
        return numberSides;
    }
    public void setNumberSides(int numberSides) {
        this.numberSides = InputHelpers.setField(numberSides, MIN_SIDES, MAX_SIDES);
    }
    
    //methods abstract given to the abstracted members. 
    public abstract double area();
    public abstract double perimeter();

    
    
    //method given through the interface. 
    public String getStartPoint() {
            StringBuilder str = new StringBuilder();
            str.append("starts at point (" + x + ", " + y + ")");
            return str.toString();
    }
    public String toString()
    {
            StringBuilder str = new StringBuilder();
            str.append(type );
            str.append(" ");
            str.append(getStartPoint());

            str.append("\narea: " + OutputHelpers.formattedDouble(area(), 2));
            str.append("\nPerimeter: " + OutputHelpers.formattedDouble(perimeter(), 2));

            return str.toString();
    }
}
