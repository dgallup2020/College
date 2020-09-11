package business;

import static business.Rectangle.MAX_LENGTH;
import static business.Rectangle.MIN_LENGTH;
import helpers.InputHelpers;
import helpers.OutputHelpers;

//cube is a 3 dimensional and it then must
//override the Rectangle area and perimeter methods
//to allow for the third dimensions

public class Cube extends Rectangle implements I3DShape, IExpand {
	
    private static final int SIDES = 8;
    private static final String SHAPE_NAME = "Cube";
    protected int z = 0;
    protected int depth = 0;

    public Cube() {
        super(SHAPE_NAME, SIDES);
    }
    public Cube(int x, int y, int z, int height, int length, int depth) {
        super(SHAPE_NAME, SIDES, x, y, height, length);
        this.z = z;
        this.depth= depth;
    }
    public void setDepth(int depth) {
        this.depth = InputHelpers.setField(depth, MIN_LENGTH, MAX_LENGTH);
    }
    @Override
    public void draw() {
        StringBuilder str = new StringBuilder();

        str.append("\n------- Drawing Cube -----------\n");
        str.append(toString());
        str.append("\n------- End Drawing Cube  -----------\n");
        OutputHelpers.showStandardDialog(str.toString(), "Drawing: " + type);
    }
    @Override
    public double volume() {
        return (double) (length * height * depth);
    }
    @Override 
    public double perimeter() {
        return 2 * (super.perimeter())  + (4 * depth);
    }
    @Override
    public void expand() {
        length += 100;
        height += 100;
        depth += 100;
    }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(super.toString());
        str.append("\nDepth: " + depth);
        str.append("\nVolume: " + OutputHelpers.formattedDouble(volume(), 2));

        return str.toString();
    }
}
