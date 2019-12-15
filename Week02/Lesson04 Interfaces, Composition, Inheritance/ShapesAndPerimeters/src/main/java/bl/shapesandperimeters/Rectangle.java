package bl.shapesandperimeters;

/**
 *
 * @author Boone
 */
public class Rectangle extends Shape {

    private int lengthSide1, lengthSide2;
    
    //constructor
    public Rectangle(int lengthSide1, int lengthSide2) { //when rectangle is instantiated, it requires 2 side lengths to be entered
        this.lengthSide1 = lengthSide1;
        this.lengthSide2 = lengthSide2;
    }

    //getters and setters 
    public int getLengthSide1() {
        return lengthSide1;
    }

    public void setLengthSide1(int lengthSide1) {
        this.lengthSide1 = lengthSide1;
    }

    public int getLengthSide2() {
        return lengthSide2;
    }

    public void setLengthSide2(int lengthSide2) {
        this.lengthSide2 = lengthSide2;
    }
    
    //methods
    @Override
    public double getPerimeter() {
        double perimeter = lengthSide1 + lengthSide2;
        return perimeter;
    }

    @Override
    public double getArea() {
        double area = lengthSide1 * lengthSide2;
        return area;
    }

}
