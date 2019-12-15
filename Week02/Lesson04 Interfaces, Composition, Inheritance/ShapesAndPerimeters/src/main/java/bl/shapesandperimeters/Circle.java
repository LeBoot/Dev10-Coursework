package bl.shapesandperimeters;

/**
 *
 * @author Boone
 */
public class Circle extends Shape {
    private double radius;
    double pi = Math.PI;
    
    //constructor
    public Circle(double radius) {
        this.radius = radius;
    }
    
    //getters and setters
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    //methods
    @Override
    public double getArea() {
        double area = pi * (radius * radius); 
        return area;
    }

    @Override
    public double getPerimeter() {
        double perimeter = 2 * pi * radius; 
        return perimeter;
    }
    
    
}
