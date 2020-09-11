/**
 * Simple Class and its members.
 */
package circle;

import java.text.NumberFormat;
public class Circle
{
    //demonstrates how to declare constants
    private static final double DEFAULT_RADIUS = 2.0;
    private static final String DEFAULT_NAME = "Circle";

    //a class field can be be private or public 
    public static final int MIN_RADIUS = 1;
    public static final int MAX_RADIUS = 1000;
    public static final int MIN_COORDINATE = 0;
    public static final int MAX_COORDINATE = 1024;

    //each object will have it's own copy of all instance variables
    //e.g. if there are 100 objects created there will be 100 radius
    //variables created in memory
    private double radius;
    private String name;
    private int x;
    private int y;
    //default constructor, no parameters, use to initialize key state variables to a known value
    public Circle()
    {
        this.name = DEFAULT_NAME;
        this.radius = DEFAULT_RADIUS;
        this.x = MIN_COORDINATE;
        this.y = MIN_COORDINATE;
    }
    //parameterized constructor
    public Circle(String name, double r, int x, int y)
    {
        //good idea to use setters created to validate attributes 
        setRadius(r);
        setName(name);
        setX(x);
        setY(y);
    }

    public void setName(String name) {

        if(name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
        else {
            this.name = DEFAULT_NAME;
        }
    }
    // TODO: create getter to return the name of the circle++
    public String getName() {
        return name;
    }
   
    public void setRadius(double radius)
    {
        // TODO: create logic to ensure radius is between MIN_RADIUS and MAX_RADIUS++
        if(radius>=MIN_RADIUS && radius<=MAX_RADIUS)
            this.radius = radius;
        else{
            this.radius = DEFAULT_RADIUS;
        }
  
    }
    // TODO:  create getter to return the radius++
    public double getRadius() {
        return radius;
    }
    
    public int getX() {
        return x;
    }
    public void setX(int x) {
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

    public void setY(int y) {
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
    private double circumference() //computer the circumference of the circle
    {
        return 2 * Math.PI * radius;
    }
    //override toString method to collect and format class attribute
    //information, then let the presentation layer determine
    //how to display the information--not a good practice to put display processing inside
    //a business object class
    public String toString()
    {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        String str;
        str = name + " Data"
              + "\n\tRadius: " + nf.format(radius)
              + "\n\tCircumference: " + nf.format(circumference()) 
              + "\n\tArea: " + nf.format(area());

        return str;
    }
}
