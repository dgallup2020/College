package presentation;

import helpers.OutputHelpers;
import business.*;

public class ShapeMain {

    public static void main(String[] args) 
    {
        Shape aCircle = new Circle(10, 100, 450);
        Shape aRectangle = new Rectangle(500, 500, 67, 42);
        Shape aCube = new Cube(75, 75, 76, 100, 150, 200); 

//        drawShape(aCircle);
//        drawShape(aRectangle);
//        drawShape(aCube);

//        iShapeTest(aCircle);
//        iShapeTest(aRectangle);
//        iShapeTest(aCube);
//
//        checkShapeType(aCircle);
//        checkShapeType(aRectangle);
//        checkShapeType(aCube);
//
        iDynamicShapeTest((Rectangle)aRectangle);

        //any class that implements the IDynamicShape Interface can be used
        DummyClass aDummy = new DummyClass();
        iDynamicShapeTest(aDummy);
    }
    //dynamic method that will accept any subclass of Shape
    private static void drawShape(Shape aShape) {
        aShape.draw();
    }
    private static void checkShapeType(Shape aShape) {
        if(aShape instanceof Circle){
            Circle aCircle = (Circle)aShape; //have to cast so that we can use the methods inside that class. 
            aCircle.setRadius(45);
        }//eventhanlder has to determine what type of car, if hotrod convert it to a hotrod. use this as an example. 
        else if (aShape instanceof Rectangle) {
            Rectangle aRectangle = (Rectangle)aShape;
            aRectangle.setHeight(25);
            aRectangle.setLength(50);
        }
        else if (aShape instanceof Cube) {
            Cube aCube = (Cube)aShape;
            aCube.setHeight(100);
            aCube.setLength(34);
            aCube.setDepth(20);
        }
        OutputHelpers.showStandardDialog(aShape.toString(), "Instance of " + aShape.getType());
    }
    private static void iShapeTest(IShape anyShape)
    {
        StringBuilder str = new StringBuilder();

        str.append("\nTesting IShape Interface");
        str.append("\n-----------------------\n");
        OutputHelpers.showConsole(str.toString());
        if (anyShape instanceof IShape) {
            anyShape.draw();
        }
        else {
            str.append("Object doesn't implement IShape Inteface");
        }
        OutputHelpers.showConsole("\n------End IShape Test -------\n");
    }
    private static void iDynamicShapeTest(IDynamicShape anyShape) {
        StringBuilder str = new StringBuilder();

        str.append("\nTesting IDynamicShape Interface");
        str.append("\n-----------------------\n");
        OutputHelpers.showConsole(str.toString());
        //check that argument implements IShape
        if (anyShape instanceof IDynamicShape) {
            anyShape.rotate();
            str.append(anyShape.toString());
        }
        else {
            str.append("Object doesn't implement IDynamicShape  Inteface");
        }
        OutputHelpers.showConsole("\n------End IDynamicShape Test -------\n");
    }
}
