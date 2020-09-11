/**
 * Simple Class and its members.
 */
package business.shapes;
import helpers.OutputHelpers;
import business.point.*;

public class Circle extends Shape
{
    private static final String DEFAULT_NAME = "Circle";
  
    public Circle() {
        super(ShapeTypes.Shapes.CIRCLE);
      
    }
     
    public Circle(String name, double radius, int x, int y) {
        super(ShapeTypes.Shapes.CIRCLE, name, x, y);
    }
   
    private double area()	
    {
        return Math.PI * dim.getLength() * dim.getLength();
    }
    public double perimeter() //computer the circumference of the circle
    {
        return 2 * Math.PI * dim.getLength();
    }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(super.toString());
        str.append("Perimeter: ");
        str.append(OutputHelpers.formattedDouble(perimeter() , 2));
        str.append("\n");
        str.append("Area: ");
        str.append(OutputHelpers.formattedDouble(area(), 2));
       
        return str.toString();
    }
}
