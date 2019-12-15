package bl.classmodeling;

/**
 *
 * @author Boone
 */
public class Car1 {
    //properties
    private String carMake;
    private String carModel;
    private int carYear;
    private String carColor;
    private boolean isCarNew;
    private boolean isLeatherSeats;
    
    //constructor
    public Car1() {
        
    }
    
    //getters and setters

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getCarYear() {
        return carYear;
    }

    public void setCarYear(int carYear) {
        this.carYear = carYear;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public boolean isIsCarNew() {
        return isCarNew;
    }

    public void setIsCarNew(boolean isCarNew) {
        this.isCarNew = isCarNew;
    }

    public boolean isIsLeatherSeats() {
        return isLeatherSeats;
    }

    public void setIsLeatherSeats(boolean isLeatherSeats) {
        this.isLeatherSeats = isLeatherSeats;
    }
    
    //methods
    public void carIsRunning() {
        System.out.println("The car is running.");
    }
    
    public void carAlarm() {
        System.out.println("The car alarm has been activated...");
    }
}
