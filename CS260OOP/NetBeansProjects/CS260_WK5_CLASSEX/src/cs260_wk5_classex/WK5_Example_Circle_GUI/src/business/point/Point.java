
package business.point;

public class Point {
    
    public static final int MIN_COORDINATE = 0;
    public static final int MAX_COORDINATE = 1024;
    
    private int x;
    private int y;
    
    public Point() {
        x = MIN_COORDINATE;
        y = MIN_COORDINATE;
    }
    public Point(int x, int y) {
        setX(x);
        setY(y);
    }
    
     public int getX() {
        return x;
    }
    public void setX(int x) {
        if (x >= MIN_COORDINATE && x <= MAX_COORDINATE) {
            this.x = x;
        }
        else if(x < MIN_COORDINATE) {
          x = MIN_COORDINATE;
        }
        else {
           x = MAX_COORDINATE;
        }
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        if (y >= MIN_COORDINATE && y <= MAX_COORDINATE) {
            this.y = y;
        }
        else if(y < MIN_COORDINATE) {
          y = MIN_COORDINATE;
        }
        else {
           y = MAX_COORDINATE;
        }
    }
    public void translatePoint(int x_delta, int y_delta) {
        setX(x + x_delta);
        setY(y + y_delta);
    }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        
        str.append("Point (x, y) = (");
        str.append(x);
        str.append(",");
        str.append(y);
        str.append(")");
        
        return str.toString();
    }
}
