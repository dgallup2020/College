package business.shapes;
import helpers.OutputHelpers;
import business.point.*;

public class Rectangle extends Shape {
    
    private static final String DEFAULT_NAME = "Rectangle";
  
    public Rectangle() {
        super(ShapeTypes.Shapes.RECTANGLE);
      
    }
     
    public Rectangle(String name, double radius, int x, int y) {
        super(ShapeTypes.Shapes.RECTANGLE, name, x, y);
    }
   
    private double area()	
    {
        return Math.PI * dim.getLength() * dim.getHeight();
    }
    public double perimeter() //computer the circumference of the circle
    {
        return 2 * dim.getLength() + 2 * dim.getHeight();
    }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(super.toString());
        str.append("Perimeter: ");
        str.append(OutputHelpers.formattedDouble(perimeter() , 0));
        str.append("\n");
        str.append("Area: ");
        str.append(OutputHelpers.formattedDouble(area(), 0));
       
        return str.toString();
    }
    
}
