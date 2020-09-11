/**
 * Simple Class and its members.
 */
package business;

import helpers.OutputHelpers;
public class Circle
{
    private static final String DEFAULT_NAME = "Circle";
    private String name;
    private Point point;
    private ShapeSize size;

    public Circle()
    {
        this.name = DEFAULT_NAME;
        size = new ShapeSize();
        point = new Point();
    }
    public Circle(String name, double radius, int x, int y)
    {
        //call the default constructor to instansiate the size and point
        this.name = DEFAULT_NAME;
        setName(name);
        point = new Point(x, y);
        size = new ShapeSize(radius);
    }
    public Point getPoint() {
        return point;
    }
    public ShapeSize getSize() {
        return size;
    }
    public void setName(String name) {

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
    private double area()	
    {
        return Math.PI * size.getSize() * size.getSize();
    }
    private double circumference() //computer the circumference of the circle
    {
        return 2 * Math.PI * size.getSize();
    }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(getName());
        str.append(" Circle Data");
        str.append("\n");
        str.append(point.toString());
        str.append("\n");
        str.append("Radius: ");
        str.append(size.toString());
        str.append("\n");
        str.append("Circumference: ");
        str.append(OutputHelpers.formattedDouble(circumference() , 2));
        str.append("\n");
        str.append("Area: ");
        str.append(OutputHelpers.formattedDouble(area(), 2));
       
       
        return str.toString();
    }
}
