package business.shapes;
import helpers.OutputHelpers;
import business.point.*;

public class Square extends Shape {
     private static final String DEFAULT_NAME = "Square";
     
    public Square() {
        super(ShapeTypes.Shapes.SQUARE);
    }
    public Square(String name, Point point) {
        super(ShapeTypes.Shapes.SQUARE, name, point);
    }
    public double area() {
        return dim.getLength() * dim.getLength();
    }
    public double perimeter() {
        return 4 * dim.getLength();
    }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(super.toString());
        str.append("Perimeter: ");
        str.append(OutputHelpers.formattedDouble(perimeter(), 0));
        str.append("\n");
        str.append("Area: ");
        str.append(OutputHelpers.formattedDouble(area(), 0));
       
        return str.toString();
    }
    
}
 