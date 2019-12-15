/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.addressbook.ui;

import bl.addressbook.dto.Address;
import java.util.List;

/**
 *
 * @author Boone
 */
public class AddressBookView {
    
    //attribute and constructor
    UserIO io;
    public AddressBookView(UserIO io) {
        this.io = io;
    }
    
    
    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Add an address");
        io.print("2. Remove an address");
        io.print("3. View number of contacts");
        io.print("4. List all addresses");
        io.print("5. Return a single address");
        io.print("6. Edit an address");
        io.print("7. Exit");

        return io.readInt("Please select from the above choices.", 1, 7);
    }
    
    public int printEditAddressMenuAndGetSelection() {
        io.print("Edit Menu");
        io.print("1. Edit first name");
        io.print("2. Edit house number");
        io.print("3. Edit street name");
        io.print("4. Edit city name");
        io.print("5. Edit state name");
        io.print("6. Edit zip code");
        io.print("7. Done editing");

        return io.readInt("Please select from the above choices.", 1, 7);
    }
    
    public String newInfo(String prompt) {
        String newInfo = io.readString("Please enter the new " + prompt + ": ");
        return newInfo;
    }
    
    public void displayExitBanner() {
        io.print("Goodbye!");
    }
    
    public Address getInfoForAddAddress() {
        //ask for information
        String lastName = io.readString("What is the last name? ");
        String firstName = io.readString("What is the first name? ");
        String houseNumber = io.readString("What is the house number? ");
        String houseStreet = io.readString("What is the street name? ");
        String cityName = io.readString("What is the city name? ");
        String stateName = io.readString("What is the state name? ");
        String zip = io.readString("What is the zip code? ");
        
        //create new address object via DAO implement method
        Address newAddress = new Address(lastName);
        
        //set parameters for the new Adddress
        newAddress.setFirstName(firstName);
        newAddress.setHouseNumber(houseNumber);
        newAddress.setHouseStreet(houseStreet);
        newAddress.setCityName(cityName);
        newAddress.setStateName(stateName);
        newAddress.setZip(zip);
        
        //return the new Address
        return newAddress;
    }
    
    public String getNameOfPersonChoice() {
        String nameOfPerson = io.readString("What is the last name of the person? ");
        return nameOfPerson;
    }
    
    public void displayNumberOfContacts(List<Address> addressList) {
        String sizeOfList = String.valueOf(addressList.size()); //convert int to string
        io.print(sizeOfList);
    } 
    
    public void displayAllAddresses(List<Address> addressList) {
        for (Address currentAddress: addressList) {
            io.print(currentAddress.getLastName() + ", " + currentAddress.getFirstName());
            io.print(currentAddress.getHouseNumber() + " " + currentAddress.getHouseStreet());
            io.print(currentAddress.getCityName() + ", " + currentAddress.getStateName() + " " + currentAddress.getZip());
            io.print("");
        }
    }
    
    public void displayReturnAnAddress(Address address) {
        if (address != null) {
            io.print(address.getLastName() + ", " + address.getFirstName());
            io.print(address.getHouseNumber() + " " + address.getHouseStreet());
            io.print(address.getCityName() + ", " + address.getStateName() + " " + address.getZip());
        } else {
            io.print("No such person in your address book");
        }
    }
    
    public void displayUnknownCommmand() {
        io.print("That command is not recognized.  Try again.");
    }

    
    //Banners
    
    public void displayCommenceBanner(String action) {
        io.print("");
        io.print("=== " + action + " ===");
    }
    
    public void displayConcludedBanner(String action) {
        io.readString(action + " has been successfully achieved.  Hit enter to continue");
    }
    
    
    //error for marshalling/unmarshalling
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
      
}