package bl.shapesandperimeters;

/**
 *
 * @author Boone
 */
public class App {
    public static void main(String[] args) {
//        Square squareInstance = new Square(5);
//        
//        int length = squareInstance.getSideLength();
//        System.out.println(length);
//        
//        squareInstance.setSideLength(10000);
//        length = squareInstance.getSideLength();
//        
//        System.out.println(length);
//        
//        System.out.println(squareInstance.getArea());
//        System.out.println(squareInstance.getPerimeter());

        Rectangle newRect = new Rectangle(6, 7);
        System.out.println(newRect.getArea());
        
        Triangle newTri = new Triangle(5, 6);
        System.out.println(newTri.getPerimeter());
        
        Circle newCir = new Circle(5);
        System.out.println(newCir.getPerimeter());
        
        System.out.println(newRect.getColor());
    }
}
