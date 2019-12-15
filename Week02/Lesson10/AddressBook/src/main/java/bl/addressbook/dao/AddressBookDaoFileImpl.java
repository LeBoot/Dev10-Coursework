/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.addressbook.dao;

import bl.addressbook.dto.Address;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Boone
 */
public class AddressBookDaoFileImpl implements AddressBookDao {
    
    private Map<String, Address> addresses = new HashMap<>();
    
    @Override
    public Address addAddress(String lastName, Address address) throws AddressBookDaoException {
        loadAddressBook();
        Address newAddress = addresses.put(lastName, address);
        writeAddressBook();
        return newAddress;
    }

    @Override
    public Address removeAddress(String lastName) throws AddressBookDaoException {
        loadAddressBook();
        Address removedAddress = addresses.remove(lastName);
        writeAddressBook();
        return removedAddress;
    }
    
    @Override
    public List<Address> getAllAddresses() throws AddressBookDaoException {
        loadAddressBook();
        return new ArrayList<Address>(addresses.values());
    }

    @Override
    public Address getAddress(String lastName) throws AddressBookDaoException {
        loadAddressBook();
        return addresses.get(lastName);
    } 
    
    
    
//    
//    
//    
//    FOR MARSHALLING AND UNMARSHALLING
//            
//     LastName::FirstName::HouseNum::StreetName::CityName::StateName::Zip       
//            
    
    
    //declare constants
    public static final String DELIMITER = "::";
    public static final String ADDRESS_FILE = "AddressBook.txt";
    
    //method to format the text string that will be retrieved when the text file is unmarshalled
    private Address unmarshallAddress(String addressAsText) {
        
        //create array of items that have been split at the delimiter
        String[] addressTokens = addressAsText.split(DELIMITER);
        
        //retrieve last name from index 0 of the new array
        String lastName = addressTokens[0];
        
        //Create a new address object based on the last name just retrieved
        Address addressFromFile = new Address(lastName);
        
        //complete the new address object with the appropriate setters
        addressFromFile.setFirstName(addressTokens[1]);
        addressFromFile.setHouseNumber(addressTokens[2]);
        addressFromFile.setHouseStreet(addressTokens[3]);
        addressFromFile.setCityName(addressTokens[4]);
        addressFromFile.setStateName(addressTokens[5]);
        addressFromFile.setZip(addressTokens[6]);
        
        //return the address
        return addressFromFile;        
    }
    
    
    
    private void loadAddressBook() throws AddressBookDaoException {
        Scanner scanner;
        
        try {
            //Scanner to read the file
            scanner = new Scanner (
                new BufferedReader(
                    new FileReader(ADDRESS_FILE)));
        } catch (FileNotFoundException e) {
            throw new AddressBookDaoException ("Could not load address book into memory", e);
        }
        
        String currentLine; //to hold most-recently read line from file
        Address currentAddress; //to hold most-recenlty unmarshalled Address
        
        while(scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentAddress = unmarshallAddress(currentLine); //call method above, to convert line of text file into address
            addresses.put(currentAddress.getLastName(), currentAddress); //add to Map
        }
        
        scanner.close(); //to prevent memory leaks
    }
    
    
    
    private String marshallAddress(Address aAddress) {
        //Format= LastName::FirstName::HouseNum::StreetName::CityName::StateName::Zip
        
        //Place all components of address object into a giant string (in proper format)
        String addressAsText = aAddress.getLastName() + DELIMITER;
        addressAsText += aAddress.getFirstName() + DELIMITER;
        addressAsText += aAddress.getHouseNumber() + DELIMITER;
        addressAsText += aAddress.getHouseStreet() + DELIMITER;
        addressAsText += aAddress.getCityName() + DELIMITER;
        addressAsText += aAddress.getStateName() + DELIMITER;
        addressAsText += aAddress.getZip(); //no delimiter on last bit of information
        
        //return address as text
        return addressAsText;  
    }
    
    
    
    private void writeAddressBook() throws AddressBookDaoException {
        PrintWriter out;
        
        try {
            out = new PrintWriter(
                new FileWriter(ADDRESS_FILE));
        } catch (IOException e) {
            throw new AddressBookDaoException("Could not save data", e);
        }
        
        String addressAsText;
        
        //previously-established method for iterating over the collection and returning an arrayList of the values
        List<Address> addressList = this.getAllAddresses();
        
        for (Address currentAddress : addressList) {
            addressAsText = marshallAddress(currentAddress); //turn address into string using method above
            out.println(addressAsText); //write that line to the text file
            out.flush(); //force-print anything un-printed
        }
        
        out.close(); //to prevent memory leaks
    }
   
}