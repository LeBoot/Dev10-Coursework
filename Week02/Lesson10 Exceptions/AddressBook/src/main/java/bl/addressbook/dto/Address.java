/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.addressbook.dto;

import java.util.Objects;

/**
 *
 * @author Boone
 */
public class Address {
    private String lastName;
    private String firstName;
    private String houseNumber;
    private String houseStreet;
    private String cityName;
    private String stateName;
    private String zip;
    
    //constructor, with just lastName as parameter
    public Address(String lastName) {
        this.lastName = lastName;
    }
    
    //getter (no setter) for lastName
    public String getLastName() {
        return lastName;
    }
    
    //getters and setters for all others

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getHouseStreet() {
        return houseStreet;
    }

    public void setHouseStreet(String houseStreet) {
        this.houseStreet = houseStreet;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    } 

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.lastName);
        hash = 47 * hash + Objects.hashCode(this.firstName);
        hash = 47 * hash + Objects.hashCode(this.houseNumber);
        hash = 47 * hash + Objects.hashCode(this.houseStreet);
        hash = 47 * hash + Objects.hashCode(this.cityName);
        hash = 47 * hash + Objects.hashCode(this.stateName);
        hash = 47 * hash + Objects.hashCode(this.zip);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Address other = (Address) obj;
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.houseNumber, other.houseNumber)) {
            return false;
        }
        if (!Objects.equals(this.houseStreet, other.houseStreet)) {
            return false;
        }
        if (!Objects.equals(this.cityName, other.cityName)) {
            return false;
        }
        if (!Objects.equals(this.stateName, other.stateName)) {
            return false;
        }
        if (!Objects.equals(this.zip, other.zip)) {
            return false;
        }
        return true;
    }
    
    
    
}