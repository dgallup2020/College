package business.dimension;

import helpers.OutputHelpers;

public class ShapeTwoDimenions extends ShapeDimensions {
    
    public ShapeTwoDimenions() {
        super(MIN_SIZE, MIN_SIZE);
     }
    public ShapeTwoDimenions(int length, int height) {
        super(length, height);
    }
    public void reduceSize() {
        super.reduceDimension(length);
        super.reduceDimension(height);
    }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Size: ");
        str.append("[length x width] = [");
        str.append(OutputHelpers.formattedDouble(length, 0));
        str.append(" x ");
        str.append(OutputHelpers.formattedDouble(height, 0));
        str.append("]");
        
        return str.toString();
        
    }
}
