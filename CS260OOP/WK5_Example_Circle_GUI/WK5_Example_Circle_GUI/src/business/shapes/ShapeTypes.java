package business.shapes;

public class ShapeTypes {
    
    public enum Shapes {
        CIRCLE,
        SQUARE,
        RECTANGLE,
        GENERIC
    }
    public static String getShapeName(Shapes type) {
        String str;
        switch (type) {
            case CIRCLE: str="Circle"; break;
            case SQUARE: str="Square"; break;
            case RECTANGLE: str = "RECTANGLE"; break;
            default: str = "Generic"; break;
        }
        return str;
    } 
}
