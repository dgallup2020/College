package Business;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dgallup14
 */
public class Circle {
    
    private static final double DEFAULT_RADIUS = 2.0;
    private static final string DEFAULT_NAME = "Circle";
    
    public static final int MIN_RADIUS = 1; 
    public static final int MAX_RADIUS = 1000;
    public static final int MIN_COORDINATE = 0;
    public static final int MAX_COORDINATE = 1024;
    
    private double radius;
    private double area;

    public double getArea() {
        calcArea();
        return area;
    }
    
    
    public double getRadius() {
            return radius;
    }
    
    public Circle() {
        this.radius = MIN_RADIUS;
    }
    
    public Circle(double radius) {
        setRadius(radius);
    }
    
    public void setRadius(double radius){
        if (radius >= Circle.MIN_RADIUS && radius <= Circle.MAX_RADIUS)
            this.radius = radius;
        else
            this.radius = DEFAULT_RADIUS;
    }
    
    private void calcArea() {
        this.area = 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle{" + "radius=" + radius + "area =" + getArea() + '}';
    }
    
    
    
}
