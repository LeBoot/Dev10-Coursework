package bl.shapesandperimeters;

/**
 *
 * @author Boone
 */
public class Square extends Shape {
        
    private int sideLength; //declare the variables that I will use in the getArea and getPerimeter methods

    public Square(int sideLength) { //constructor that requires a side length
        this.sideLength = sideLength;
    }

    public int getSideLength() { //returns side length
        return sideLength;
    }

    public void setSideLength(int sideLength) { //sets side length (other than when first instantiated)
        this.sideLength = sideLength;
    }
    
    @Override
    public double getPerimeter() {
        double perimeter = (4 * sideLength);
        return perimeter;
    }
    
    @Override
    public double getArea() {
        double area = (sideLength * sideLength);
        return area;
    }
    
}