package bl.classmodeling;

/**
 *
 * @author Boone
 */
public class IceCream1 {
    
    //properties
    private int numIC;
    private String nameIC;
    private double weightIC;
    private double galMilkInIC;
    private boolean isLowFat;
    
    //constructor
    public IceCream1() {
        
    }
    
    //getters and setters

    public int getNumIC() {
        return numIC;
    }

    public void setNumIC(int numIC) {
        this.numIC = numIC;
    }

    public String getNameIC() {
        return nameIC;
    }

    public void setNameIC(String nameIC) {
        this.nameIC = nameIC;
    }

    public double getWeightIC() {
        return weightIC;
    }

    public void setWeightIC(double weightIC) {
        this.weightIC = weightIC;
    }

    public double getGalMilkInIC() {
        return galMilkInIC;
    }

    public void setGalMilkInIC(double galMilkInIC) {
        this.galMilkInIC = galMilkInIC;
    }

    public boolean isIsLowFat() {
        return isLowFat;
    }

    public void setIsLowFat(boolean isLowFat) {
        this.isLowFat = isLowFat;
    }
    
    //methods
    public void isMelting() {
        System.out.println("The ice cream is melting.");
    }
    public void isMaking() {
        System.out.println("The ice cream is being made.");
    }
}
