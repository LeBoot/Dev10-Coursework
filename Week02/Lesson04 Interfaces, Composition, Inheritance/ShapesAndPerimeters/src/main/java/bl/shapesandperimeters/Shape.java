package bl.shapesandperimeters;

/**
 *
 * @author Boone
 */
abstract class Shape {
    
    //property called color
    private String color;
    
    //getter and setter for property
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    //methods
    public double getPerimeter() {
        return 0;
        //here, I can need to return a value, so I set a placeholder.
    }
    
    public double getArea() {
        return 0;
    }
    
    //abstract public int getArea();
    //Above, I can make the method using the keyword "abstract" and leaving out braces,
    //but it will not automatically import to child classes when I try to generate an override method
    
}