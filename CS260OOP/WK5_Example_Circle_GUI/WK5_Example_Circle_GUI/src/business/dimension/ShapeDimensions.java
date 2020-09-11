package business.dimension;

import static business.dimension.ShapeDimensions.MIN_SIZE;
import helpers.OutputHelpers;
import java.awt.Dimension;


public class ShapeDimensions {
    
    //a class field can be be private or public 
    public static final int MIN_SIZE = 1;
    public static final int MAX_SIZE = 1000;
    protected static final int INVALID = 0; 
   
    protected static final int SIZE_RANGE1 = 100;
    protected static final int SIZE_RANGE2 = 400;
    protected static final int SIZE_RANGE3 = 600;
    protected static final int SIZE_RANGE4 = 900;
    
    protected static final double REDUCTION_RATE1 = .10;
    protected static final double REDUCTION_RATE2 = .20;
    protected static final double REDUCTION_RATE3 = .40;
    protected static final double REDUCTION_RATE4 = .60;
    protected static final double REDUCTION_RATE5 = .80;
    
    protected int length;
    protected int height;
    
    public ShapeDimensions() {
        length = INVALID;
        height = INVALID;
    }
    public ShapeDimensions(int length, int height) {
        setLength(length);
        setHeight(height);
    }
    public void setLength (int length) {
        this.length = setDimension(length); 
    }
    public int getLength() {
        return length;
    }
    public void setHeight(int height) {
        this.height = setDimension(height);
    }
    public int getHeight() {
        return height;
    }
    private int setDimension(int value) {
        int result;
        if (value >= MIN_SIZE && value <= MAX_SIZE) {
            result = value;
        }
        else {
            result = INVALID;
        }
        return result;
    }
    
    protected static int reduceDimension(double value) {
        double reducationRate;
        if (value < SIZE_RANGE1) {
            reducationRate = REDUCTION_RATE1;
        }
        else if (value < SIZE_RANGE2) {
            reducationRate = REDUCTION_RATE2;
        }
        else if (value < SIZE_RANGE3) {
            reducationRate = REDUCTION_RATE3;
        }
         else if (value < SIZE_RANGE4) {
            reducationRate = REDUCTION_RATE4;
        }
        else {
           reducationRate = REDUCTION_RATE5;  
        }
        return (int)((1- reducationRate) * value);
    }
    
}
