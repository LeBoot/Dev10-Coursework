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
public class PayableTest {
    public static void main(String[] args) {
        Payable[] payableArray = new Payable[4];
        
        //build some addresses
        Address address011 = new Address("Street11", "city1", "zip1");
        Address address022 = new Address("Street22", "city2", "zip2");
        Address address033 = new Address("Street33", "city3", "zip3");
        Address address044 = new Address("Street44", "city4", "zip4");
        
        //build some people
        Employee newEmployeeA = new Employee(20000, "Person1", 24, address011);
        Contractor newContractorA = new Contractor(30.5, false, "Person2", 30, address022);
        Employee newEmployee03 = new Employee(30000, "Person3", 23, address033);
        Contractor newContractor04 = new Contractor(20.0, true, "Person4", 29, address044);
        
        //add people to array
        addPerson(payableArray, newEmployeeA, 0);
        addPerson(payableArray, newContractorA, 1);
        addPerson(payableArray, newEmployee03, 2);
        addPerson(payableArray, newContractor04, 3);
        
        printPaychecks(payableArray); //print results
    }
    
    public static void printPaychecks(Payable[] arrayName) {
        for (Payable person : arrayName) {
            System.out.println(person.toString());
            System.out.println("Weekly pay: " + person.calculateWeeklyPay());
            System.out.println("");
        }
    }
    
    public static void addPerson(Payable[] arrayName, Payable payableObject, int index) {
        arrayName[index] = payableObject;
    }
}
