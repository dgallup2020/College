package business;

import helpers.OutputHelpers;


public class ShapeSize {
    

    //a class field can be be private or public 
    public static final int MIN_SIZE = 1;
    public static final int MAX_SIZE = 1000;
   
    private static final double SIZE_RANGE1 = 100;
    private static final double SIZE_RANGE2 = 400;
    private static final double SIZE_RANGE3 = 600;
    private static final double SIZE_RANGE4 = 900;
    
    private static final double REDUCTION_RATE1 = .10;
    private static final double REDUCTION_RATE2 = .20;
    private static final double REDUCTION_RATE3 = .40;
    private static final double REDUCTION_RATE4 = .60;
    private static final double REDUCTION_RATE5 = .80;
  
    private double size;
    
    public ShapeSize() {
        size = MIN_SIZE;
    }
    public ShapeSize(double size) {
        setSize(size);
    }
    
    public final void setSize(double size)
    {
        if (size >= MIN_SIZE && size <= ShapeSize.MAX_SIZE)
                this.size = size;
        else
                this.size = MIN_SIZE;
    }
    public void setSize(String size) {
        try {
            this.setSize(Double.parseDouble(size));
        }
        catch (NumberFormatException ex) {
            setSize(MIN_SIZE);
        }
    }
    public double getSize()
    {
        return size;
    }
    public double reduceSize() {
        double reducationRate;
        if (this.size < SIZE_RANGE1) {
            reducationRate = REDUCTION_RATE1;
        }
        else if (this.size < SIZE_RANGE2) {
            reducationRate = REDUCTION_RATE2;
        }
        else if (this.size < SIZE_RANGE3) {
            reducationRate = REDUCTION_RATE3;
        }
         else if (this.size < SIZE_RANGE4) {
            reducationRate = REDUCTION_RATE4;
        }
        else {
           reducationRate = REDUCTION_RATE5;  
        }
        return (1- reducationRate) * size;
    }
     @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Initial size: ");
        str.append(OutputHelpers.formattedDouble(getSize(), 2));
        str.append("\n");
        str.append("Normalized Radius: ");
        str.append(OutputHelpers.formattedDouble(reduceSize(), 2));
        
        return str.toString();
    }
    
    
}
