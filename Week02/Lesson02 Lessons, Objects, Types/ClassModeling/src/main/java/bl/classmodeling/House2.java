/**
 * @author Boone
 */
package bl.classmodeling;

public class House2 {
    //properties
    private double squareFootage;
    private int numBedrooms;
    private int numBaths;
    private int numRoomsTotal;
    private int numStories;
    private String address;

    public House2() { //this is the constructor
        
    }
    
    //below are getters and setters
    public double getSquareFootage() {
        return squareFootage;
    }

    public void setSquareFootage(double squareFootage) {
        this.squareFootage = squareFootage;
    }

    public int getNumBedrooms() {
        return numBedrooms;
    }

    public void setNumBedrooms(int numBedrooms) {
        this.numBedrooms = numBedrooms;
    }

    public int getNumBaths() {
        return numBaths;
    }

    public void setNumBaths(int numBaths) {
        this.numBaths = numBaths;
    }

    public int getNumRoomsTotal() {
        return numRoomsTotal;
    }

    public void setNumRoomsTotal(int numRoomsTotal) {
        this.numRoomsTotal = numRoomsTotal;
    }

    public int getNumStories() {
        return numStories;
    }

    public void setNumStories(int numStories) {
        this.numStories = numStories;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    //below are behaviors (methods):
    public void mowLawn(boolean isLawnMowed) {
        if (isLawnMowed) {
            System.out.println("The lawn has been mowed.");
        } else {
            System.out.println("The lawn needs to be mowed.");
        }
    }
    
    public void turnWaterOn() {
        System.out.println("The water is on.");
    }
    
}
