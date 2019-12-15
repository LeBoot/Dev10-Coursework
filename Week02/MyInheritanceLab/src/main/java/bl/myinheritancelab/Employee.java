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
public class Employee extends Person implements Payable {
    private double Salary;
    
    //constructor
    public Employee(double Salary, String name, int age, Address address) {
        super(name, age, address);
        this.Salary = Salary;
    }
    
    //main
    public static void main(String[] args) {
        Address addressP = new Address("Fake Street", "Charlotte", "28270");
        Employee emp1 = new Employee(10000.00, "Johnny", 25, addressP);
        System.out.println(emp1);
    }
    
    //getter and setter
    public double getSalary() {
        return Salary;
    }

    public void setSalary(double Salary) {
        this.Salary = Salary;
    }

    @Override
    public String toString() {
        return super.toString() + " Employee{" + "Salary=" + Salary + '}';
    }  

    @Override
    public double calculateWeeklyPay() {
        double weeklyPay = Salary/52;
        return weeklyPay;
    }
   
}
