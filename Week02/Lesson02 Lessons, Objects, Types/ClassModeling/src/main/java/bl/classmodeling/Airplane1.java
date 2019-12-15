/**
 * @author Boone
 */
package bl.classmodeling;

public class Airplane1 {
    
    //define properties
    private String nameAirplane;
    private String nameAirline;
    private String typeEquipment;
    private double velocitySpeedInKnots;
    private double velocityDirectionInDegrees;
    private int altitudeInFeet;
    
    //constructor
    public Airplane1() {
        
    }
    
    
    //below are getters and setters

    public String getNameAirplane() {
        return nameAirplane;
    }

    public void setNameAirplane(String nameAirplane) {
        this.nameAirplane = nameAirplane;
    }

    public String getNameAirline() {
        return nameAirline;
    }

    public void setNameAirline(String nameAirline) {
        this.nameAirline = nameAirline;
    }

    public String getTypeEquipment() {
        return typeEquipment;
    }

    public void setTypeEquipment(String typeEquipment) {
        this.typeEquipment = typeEquipment;
    }

    public double getVelocitySpeedInKnots() {
        return velocitySpeedInKnots;
    }

    public void setVelocitySpeedInKnots(double velocitySpeedInKnots) {
        this.velocitySpeedInKnots = velocitySpeedInKnots;
    }

    public double getVelocityDirectionInDegrees() {
        return velocityDirectionInDegrees;
    }

    public void setVelocityDirectionInDegrees(double velocityDirectionInDegrees) {
        this.velocityDirectionInDegrees = velocityDirectionInDegrees;
    }

    public int getAltitudeInFeet() {
        return altitudeInFeet;
    }

    public void setAltitudeInFeet(int altitudeInFeet) {
        this.altitudeInFeet = altitudeInFeet;
    }
    
    //methods
    public void landPlane() {
        System.out.println("The plane is landing.");
    }
    public void handoff() {
        System.out.println("The plane has been handed off...");
    }
    
}
