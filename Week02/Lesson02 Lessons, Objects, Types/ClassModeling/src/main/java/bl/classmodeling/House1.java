/**
 * @author Boone
 */
package bl.classmodeling;

public class House1 {
    //These are some properties
    private String boundaryNorth;
    private String boundarySouth;
    private String boundaryEast;
    private String boundaryWest;
    private double squareFootage;
    private String county;

    public House1() { //This is the constructor
        
    }
    
    //Below are the getters and setters
    public String getBoundaryNorth() {
        return boundaryNorth;
    }

    public void setBoundaryNorth(String boundaryNorth) {
        this.boundaryNorth = boundaryNorth;
    }

    public String getBoundarySouth() {
        return boundarySouth;
    }

    public void setBoundarySouth(String boundarySouth) {
        this.boundarySouth = boundarySouth;
    }

    public String getBoundaryEast() {
        return boundaryEast;
    }

    public void setBoundaryEast(String boundaryEast) {
        this.boundaryEast = boundaryEast;
    }

    public String getBoundaryWest() {
        return boundaryWest;
    }

    public void setBoundaryWest(String boundaryWest) {
        this.boundaryWest = boundaryWest;
    }

    public double getSquareFootage() {
        return squareFootage;
    }

    public void setSquareFootage(double squareFootage) {
        this.squareFootage = squareFootage;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }
    
    //below are methods
    public void buildNewHouse() {
        System.out.println("So you want to build a new house...");
    }
    
    public void buildNewAddition() {
        System.out.println("So you want to add an addition to your house...");
    }
    
}
