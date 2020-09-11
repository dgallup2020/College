package business;

import helpers.InputHelpers;
import helpers.OutputHelpers;
import helpers.*;

public class Circle extends Shape
{
    public static final double MIN_RADIUS = 0;
    public static final double MAX_RADIUS = 1000;
    
    private static final int SIDES = 1;
    private static final String SHAPE_NAME = "Circle";
    protected double radius = 0;

    public Circle() {
        super(SHAPE_NAME, SIDES);
    }
    public Circle(double radius, int x, int y) {
        super(SHAPE_NAME, SIDES, x, y);
        this.radius = radius;
    }
    public void setRadius(double radius) {
        this.radius = InputHelpers.setField(radius, MIN_RADIUS, MAX_RADIUS);
    }
    @Override
    public void draw() {
        StringBuilder str = new StringBuilder();

        str.append("\n------- Drawing Circle -----------\n");
        str.append(toString());
        str.append("\n------- End Drawing Circle  -----------\n");
        OutputHelpers.showStandardDialog(str.toString(), "Drawing: " + type);
    }
    
    @Override
    public void translate() {
        x = x + 200;
        y = y + 200;
    }
    
    //instance method specific to circle
    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
    
    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }
    
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append(super.toString());
        str.append("\nradius: " + OutputHelpers.formattedDouble(radius, 2));
 
        return str.toString();
    }
}
