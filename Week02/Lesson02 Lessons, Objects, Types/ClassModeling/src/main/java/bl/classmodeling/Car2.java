package bl.classmodeling;

/**
 *
 * @author Boone
 */
public class Car2 {
    
    //properties
    private int carNum;
    private int carHealth;
    private int carCapacity;
    
    //constructor
    public Car2() {
        
    }
    
    //getters and setters

    public int getCarNum() {
        return carNum;
    }

    public void setCarNum(int carNum) {
        this.carNum = carNum;
    }

    public int getCarHealth() {
        return carHealth;
    }

    public void setCarHealth(int carHealth) {
        this.carHealth = carHealth;
    }

    public int getCarCapacity() {
        return carCapacity;
    }

    public void setCarCapacity(int carCapacity) {
        this.carCapacity = carCapacity;
    }
    
    //methods
    public void carDriving() {
        System.out.println("The car is being driven.");
    }
    
    public void carTurning() {
        System.out.println("The car is turning.");
    }
    
    public void leavingMap() {
        System.out.println("The car is leaving the map.");
    }
}
