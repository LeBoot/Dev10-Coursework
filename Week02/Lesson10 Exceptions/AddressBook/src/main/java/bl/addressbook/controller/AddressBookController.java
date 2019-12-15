/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.addressbook.controller;

import bl.addressbook.dao.AddressBookDao;
import bl.addressbook.dao.AddressBookDaoException;
import bl.addressbook.dto.Address;
import bl.addressbook.ui.AddressBookView;
import bl.addressbook.ui.UserIO;
import bl.addressbook.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author Boone
 */
public class AddressBookController {
    
    private UserIO io = new UserIOConsoleImpl();
    
    //arrtibutes and constructor
    AddressBookDao dao;
    AddressBookView view;
    public AddressBookController(AddressBookDao dao, AddressBookView view) {
        this.dao = dao;
        this.view = view;
    }
    
    public void run() { //add throws AddressBookDaoException
        boolean keepGoing = true;
        int menuSelection;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection(); //method defined below

                switch (menuSelection) {
                    case 1:
                        addAddress();
                        break;
                    case 2:
                        removeAddress();
                        break;
                    case 3:
                        listNumOfContacts();
                        break;
                    case 4:
                        listAllContacts();
                        break;
                    case 5:
                        returnAnAddress();
                        break;
                    case 6:
                        editAnAddress();
                        break;
                    case 7:
                        keepGoing = false;
                        break;
                    default:
                       unknownCommand();
                }
            }
            exitMessage(); //mehod defined below
        } catch (AddressBookDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
   }

    private void exitMessage() {
       view.displayExitBanner();
   }
    
   private void unknownCommand() {
       view.displayUnknownCommmand();
   }
    
   private void addAddress() throws AddressBookDaoException {
       view.displayCommenceBanner("Add Address");
       Address newAddress = view.getInfoForAddAddress();
       dao.addAddress(newAddress.getLastName(), newAddress);
       view.displayConcludedBanner("Add Address");
   }
   
   private void removeAddress() throws AddressBookDaoException {
       view.displayCommenceBanner("Remove Address");
       String nameOfPerson = view.getNameOfPersonChoice();
       dao.removeAddress(nameOfPerson);
       view.displayConcludedBanner("Remove Address");
   }
   
   private void listNumOfContacts() throws AddressBookDaoException {
       view.displayCommenceBanner("List Number Of Contacts");
       List<Address> addressList = dao.getAllAddresses();
       view.displayNumberOfContacts(addressList);
       view.displayConcludedBanner("List Number of Contacts");
   }
   
   private void listAllContacts() throws AddressBookDaoException {
       view.displayCommenceBanner("List All Contacts");
       List<Address> addressList = dao.getAllAddresses();
       view.displayAllAddresses(addressList);
       view.displayConcludedBanner("List All Contacts");
   }
   
   private void returnAnAddress() throws AddressBookDaoException {
       view.displayCommenceBanner("Return An Address");
       String nameOfPerson = view.getNameOfPersonChoice();
       Address address = dao.getAddress(nameOfPerson);
       view.displayReturnAnAddress(address);
       view.displayConcludedBanner("Return An Address");
   }
   
   private void editAnAddress() throws AddressBookDaoException {
       view.displayCommenceBanner("Edit An Address");
       String nameOfPerson = view.getNameOfPersonChoice();
       Address addressToEdit = dao.removeAddress(nameOfPerson);
       boolean isStayingInLoop = true;
       int userSelection;

       while (isStayingInLoop) {
           
           userSelection = view.printEditAddressMenuAndGetSelection();
           
           switch (userSelection) {
               case 1:
                   String newFirstName = view.newInfo("first name");
                   addressToEdit.setFirstName(newFirstName);
                   break;
               case 2:
                   String newHouseNumber = view.newInfo("street number");
                   addressToEdit.setHouseNumber(newHouseNumber);
                   break;
               case 3:
                   String newStreetName = view.newInfo("street name");
                   addressToEdit.setHouseStreet(newStreetName);
                   break;
               case 4:
                   String newCityName = view.newInfo("city name");
                   addressToEdit.setCityName(newCityName);
                   break;
               case 5:
                   String newStateName = view.newInfo("state name");
                   addressToEdit.setStateName(newStateName);
                   break;
               case 6:
                   String newZip = view.newInfo("zip code");
                   addressToEdit.setZip(newZip);
                   break;
               case 7:
                   isStayingInLoop = false;
                   break;
               default:
                   unknownCommand();
           }
       }
       dao.addAddress(nameOfPerson, addressToEdit);
       view.displayConcludedBanner("Edit address");
   }
   
}