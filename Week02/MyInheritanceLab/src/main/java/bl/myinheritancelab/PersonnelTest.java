/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.myinheritancelab;

import java.util.Arrays;

/**
 *
 * @author Boone
 */
public class PersonnelTest {
        
    //main method
    public static void main(String[] args) {
        
        Person[] personArray = new Person[4];
        
        //build some addresses
        Address address01 = new Address("Street1", "city1", "zip1");
        Address address02 = new Address("Street2", "city2", "zip2");
        Address address03 = new Address("Street3", "city3", "zip3");
        Address address04 = new Address("Street4", "city4", "zip4");
        
        //build some people
        Person newPerson01 = new Person("Person1", 24, address01);
        Person newPerson02 = new Person("Person2", 30, address02);
        Employee newEmployee03 = new Employee(30000, "Person3", 23, address03);
        Contractor newContractor04 = new Contractor(20.0, true, "Person4", 29, address04);
        
        //add people to array
        addPerson(personArray, newPerson01, 0);
        addPerson(personArray, newPerson02, 1);
        addPerson(personArray, newEmployee03, 2);
        addPerson(personArray, newContractor04, 3);
        
        //call print method
        System.out.println("First Go:");
        printPerson(personArray);
        
        System.out.println("\nSecond Go:");
        Arrays.sort(personArray); //sort by age
        printPerson(personArray);
    }
    
    public static void printPerson(Person[] arrayName) {
        for (Person person : arrayName) {
            System.out.println(person.toString());
        }
    }
    
    public static void addPerson(Person[] arrayName, Person personObject, int index) {
        arrayName[index] = personObject;
    }
    
         
    
    
}
