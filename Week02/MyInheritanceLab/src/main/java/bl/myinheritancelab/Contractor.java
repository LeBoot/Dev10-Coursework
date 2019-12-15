/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.myinheritancelab;

/**
 *
 * @author Boone
 */
public class Contractor extends Person implements Payable {
    private double hourlyRate;
    private boolean permanent;
    
    //constructor(s)

    public Contractor(double hourlyRate, boolean permanent, String name, int age, Address address) {
        super(name, age, address);
        this.hourlyRate = hourlyRate;
        this.permanent = permanent;
    }
    
    //main class
    public static void main(String[] args) {
        Address addressP = new Address("Fake Street", "Charlotte", "28270");
        //Person personP = new Person("Ben", 20, addressP);
        Contractor newContractor = new Contractor(100, true, "Ben", 40, addressP);
        
        //newContractor.setAddress( new Address("Real Street", "Allll", "28273"));
        System.out.println(newContractor);
    }
    
    
    //getter and setter

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public boolean isPermanent() {
        return permanent;
    }

    public void setPermanent(boolean permanent) {
        this.permanent = permanent;
    }

    @Override
    public String toString() {
        return super.toString() + " Contractor{" + "hourlyRate=" + hourlyRate + ", permanent=" + permanent + '}';
    }

    @Override
    public double calculateWeeklyPay() {
        double weeklyPay = hourlyRate * 40;
        return weeklyPay;
    }
    
    
}
