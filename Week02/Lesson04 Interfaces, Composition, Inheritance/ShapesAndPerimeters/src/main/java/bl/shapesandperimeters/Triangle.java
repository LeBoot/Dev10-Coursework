package bl.shapesandperimeters;

/**
 *
 * @author Boone
 */
public class Triangle extends Shape {
    private int base, height;

    //constructor
    public Triangle(int base, int height) {
        this.base = base;
        this.height = height;
    }
    
    //getters and setters
    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    //methods

    @Override
    public double getPerimeter() {
        double num1 = (base * base) + (4 * height * height);
        double perimeter = base + Math.sqrt(num1);
        return perimeter;
        //Note, this is the SMALLEST POSSIBLE perimeter.  Calculating a true perimeter with just base and height
        //either isn't possible, or it takes hella trig (law of cosines maybe)
    }
    
    @Override
    public double getArea() {
        double area = .5 * base * height;
        return area;
    }
    
    
    
}
