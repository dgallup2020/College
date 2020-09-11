/**
 * Simple Class and its members.
 */
package business;
import helpers.*;

import java.text.NumberFormat;
public class Circle
{
    private static final double DEFAULT_RADIUS = 2.0;
    private static final String DEFAULT_NAME = "Circle";
    public static final double PI = 3.14;

    public static final int MIN_RADIUS = 1;
    public static final int MAX_RADIUS = 1000;
    public static final int MIN_COORDINATE = 0;
    public static final int MAX_COORDINATE = 1024;
    
    private static int numberOfCircles = 0;

    private double radius;
    private String name;
    private int x;
    private int y;

    public Circle() {
        setName(DEFAULT_NAME);
        setRadius(DEFAULT_RADIUS);
        setX(MIN_COORDINATE);
        setY(MIN_COORDINATE);
        numberOfCircles++;
    }
    public Circle(String name, double r, int x, int y) {
        setRadius(r);
        setName(name);
        setX(x);
        setY(y);
        numberOfCircles++;
    }
    public static int getNumberOfCircles() {
        return numberOfCircles;
    }
    public static double radiansToDegrees(double rads)
    {
	return rads * 180/Circle.PI;
    }
    public final void setName(String name) {

        if(name != null && !name.trim().isEmpty()) {
                this.name = name;
        }
        else {
                this.name = DEFAULT_NAME;
        }
    }
    public String getName() {
            return name;
    }
    public final void setRadius(double radius)
    {
        if (radius >= Circle.MIN_RADIUS && radius <= Circle.MAX_RADIUS)
                this.radius = radius;
        else
                this.radius = DEFAULT_RADIUS;
    }
    public void setRadius(String radius) {
        try {
            this.setRadius(Double.parseDouble(radius));
        }
        catch (NumberFormatException ex) {
            setRadius(DEFAULT_RADIUS);
        }
    }
    public double getRadius() {
        return radius;
    }
    public int getX() {
        return x;
    }
    public final void setX(int x) {
        if (x >= MIN_COORDINATE && x <= MAX_COORDINATE) {
            this.x = x;
        }
        else if(x < MIN_COORDINATE) {
          x = MIN_COORDINATE;
        }
        else {
           x = MAX_COORDINATE;
        }
    }
    public int getY() {
        return y;
    }
    public final void setY(int y) {
        if (y >= MIN_COORDINATE && y <= MAX_COORDINATE) {
            this.y = y;
        }
        else if(y < MIN_COORDINATE) {
          y = MIN_COORDINATE;
        }
        else {
           y = MAX_COORDINATE;
        }
    }
    private double area()	
    {
        //use the Math class, static constant PI
        return Math.PI * radius * radius;
    }
    private double circumference() {
        return 2 * Math.PI * radius;
    }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(getName());
        str.append(" Circle Data");
        str.append("\n");
        str.append("Radius: ");
        str.append(OutputHelpers.formattedDouble(getRadius(), 2));
        str.append("\n");
        str.append("Circumference: ");
        str.append(OutputHelpers.formattedDouble(getRadius(), 2));
        str.append("\n");
        str.append("Area: ");
        str.append(OutputHelpers.formattedDouble(area(), 2));
        str.append("\n");
        str.append("Point (x, y) = (");
        str.append(x);
        str.append(",");
        str.append(y);
        str.append(")");
       
        return str.toString();
    }
}
