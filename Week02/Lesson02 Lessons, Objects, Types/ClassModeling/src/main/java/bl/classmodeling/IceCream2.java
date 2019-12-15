package bl.classmodeling;

/**
 *
 * @author Boone
 */
public class IceCream2 {
    
    //properties
    private int unitsOnShelf;
    private int unitsInBack;
    private String nameIC;
    private double priceIC;
    private boolean isOnSale;
    
    //constructor
    public IceCream2() {
        
    }
    
    //getters and setters

    public int getUnitsOnShelf() {
        return unitsOnShelf;
    }

    public void setUnitsOnShelf(int unitsOnShelf) {
        this.unitsOnShelf = unitsOnShelf;
    }

    public int getUnitsInBack() {
        return unitsInBack;
    }

    public void setUnitsInBack(int unitsInBack) {
        this.unitsInBack = unitsInBack;
    }

    public String getNameIC() {
        return nameIC;
    }

    public void setNameIC(String nameIC) {
        this.nameIC = nameIC;
    }

    public double getPriceIC() {
        return priceIC;
    }

    public void setPriceIC(double priceIC) {
        this.priceIC = priceIC;
    }

    public boolean isIsOnSale() {
        return isOnSale;
    }

    public void setIsOnSale(boolean isOnSale) {
        this.isOnSale = isOnSale;
    }
    
    //methods
    public void stocking() {
        System.out.println("The ice cream is being stocked right now.");
    }
    public void reOrder() {
        System.out.println("The ice cream has been re-ordered.");
    }
}
