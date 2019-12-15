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
public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private Address address;
    
    
    //main method
    public static void main(String[] args) {
        Address addressP = new Address("Fake Street", "Charlotte", "28270");
        
        Person personP = new Person("Ben", 20, addressP);
        
        System.out.println(personP);
    }
    
    
    //constructor

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    
    //gettter and setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", age=" + age + ", address=" + address + '}';
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public int compareTo(Person personObject) { //sorts by age
        //Person o = (Person)personObject;
        if (age == personObject.getAge()) {
            return 0;
        } else if (age > personObject.getAge()) {
            return 1;
        } else {
            return -1;
        }
    }

}