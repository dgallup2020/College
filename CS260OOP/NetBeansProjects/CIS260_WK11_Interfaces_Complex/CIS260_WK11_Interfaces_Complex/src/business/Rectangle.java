package business;

import helpers.InputHelpers;
import helpers.OutputHelpers;
public class Rectangle extends Shape implements IDynamicShape {
    
    public static final int MIN_LENGTH = 1;
    public static final int MAX_LENGTH = 1000;
    private static final int SIDES = 4;
    private static final String SHAPE_NAME = "Rectangle";
    protected int length = 0;
    protected int height = 0;

    public void setLength(int length) {
        this.length = InputHelpers.setField(length, MIN_LENGTH, MAX_LENGTH);
    }
    public void setHeight(int height) {
        this.height = InputHelpers.setField(height, MIN_LENGTH, MAX_LENGTH);
    }
    public Rectangle() {
        super(SHAPE_NAME, SIDES);
    }
    public Rectangle(int x, int y, int height, int length) {
        super(SHAPE_NAME, SIDES, x, y);  //pass x and y to super class
        this.height = height;
        this.length = length;
    }
    public Rectangle(String type, int numSide, int x, int y, int height, int length) {
        super(type, numSide, x, y); 
        this.height = height;
        this.length = length;
    }
    public Rectangle(String type, int numSides) {
        super(type, numSides);
    }
    
    
    //draw,and translate are methods form the IShape interface
    @Override
    public void draw() {
        StringBuilder str = new StringBuilder();
        str.append("\n------- Drawing Rectangle -----------\n");
        str.append(toString());
        str.append("\n------- End Drawing Rectangle  -----------\n");
        OutputHelpers.showStandardDialog(str.toString(), "Drawing: " + type);
    }
    @Override
    public void rotate() {
         x = x + 100;
         y = y + 100;
         draw();
    }
    @Override
    public void translate() {
         x = x + 100;
    }
    @Override
    public double area() {
        return (double)(length * height);
    }
    public double perimeter() {
        return 2 * (length + height);
    }    
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append(super.toString());
        str.append("\nHeight: " + height);
        str.append("\nLength: " + length);

        return str.toString();
    }
}
