package business.dimension;

import helpers.OutputHelpers;


public class ShapeOneDimension extends ShapeDimensions {
    
    public ShapeOneDimension() {
        super(MIN_SIZE, INVALID);
    }
    public ShapeOneDimension(double length) {
        super(MIN_SIZE, INVALID);
    }
    public void reduceSize() {
        super.reduceDimension(length);
    }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Size: ");
        str.append("[length] = [");
        str.append(OutputHelpers.formattedDouble(length, 1));
        str.append("]");
        
        return str.toString();
    }
}
