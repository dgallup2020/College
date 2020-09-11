package business.shapes;
import business.point.*;
import business.dimension.*;

import helpers.*;

public class Shape {
    
    private static final String DEFAULT_NAME = "Shape";
    private static final int MAX_SHAPES = 3;
    private static final int MIN_SHAPES = 0;
    private static int shapeCount = MIN_SHAPES;
    
    protected String name;
    protected Point point;
    protected ShapeDimensions dim;
    protected ShapeTypes.Shapes shapeType;
            
    public Shape() {
        point = new Point();
        name = DEFAULT_NAME;
        shapeType = ShapeTypes.Shapes.GENERIC;
        dim = null;
    }
    public Shape(ShapeTypes.Shapes type) {
        this();
        setDimensions(type);
    }
    public Shape(ShapeTypes.Shapes type, String name, Point point) {
       setPoint(point);
       setDimensions(type);
       setName(name);
    }
    public Shape(ShapeTypes.Shapes type, String name, int x, int y) {
        setName(name);
        setDimensions(type);
        this.point = new Point(x, y);
    }
     public static void incrementShapeCount() {
        setShapeCount(++shapeCount);
    }
    public static void setShapeCount(int value) {
        if (value >= MIN_SHAPES && value <= MAX_SHAPES) {
            shapeCount = value;
        } 
        else if (value < MIN_SHAPES) {
            shapeCount = MIN_SHAPES;
        }
        else {
            shapeCount = MAX_SHAPES;
        }
    }
    public static int getShapeCount() {
        return shapeCount;
    }
    public static String getShapeCountToString() {
        String str = Integer.toString(shapeCount);
        return str;
    }
    public static void deleteShape() {
        setShapeCount(--shapeCount);
    }
    public static boolean validShapeCount() {
        boolean valid = false;
        if (shapeCount < MAX_SHAPES) {
            valid = true;
        }
        return valid;
    }
    public Point getPoint() {
        return point;
    }
    public final void setPoint(Point point) {
        if (point == null) {
            this.point = new Point();
        }
        else {
            this.point = point;
        }
    }
    public ShapeDimensions getDimensions() {
        return dim;
    }
    public void setDimensions(ShapeTypes.Shapes type) {
        this.shapeType = type;
        switch(this.shapeType) {
            case CIRCLE:  case SQUARE: 
                dim = new ShapeOneDimension();
                break;
            case RECTANGLE:
                dim = new ShapeTwoDimenions();
                break;
            default: 
                dim = null;
                break;
        }
    }
    public ShapeTypes.Shapes getType() {
        return this.shapeType;
    }
    public void setName(String name) {

        if(StringHelpers.IsNullOrEmpty(name)) {
                this.name = name;
        }
        else {
                this.name = DEFAULT_NAME;
        }
    }
    public String getName() {
            return name;
    }
   
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(ShapeTypes.getShapeName(shapeType));
        str.append(": ");
        str.append(getName());
        str.append("\n");
        str.append(point.toString());
        str.append("\n");
        str.append("Dimensions: ");
        str.append(dim.toString());
        str.append("\n");
        
        return str.toString();
    }
}
