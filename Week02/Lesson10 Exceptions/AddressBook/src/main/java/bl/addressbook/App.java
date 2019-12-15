/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.addressbook;

import bl.addressbook.controller.AddressBookController;
import bl.addressbook.dao.AddressBookDao;
import bl.addressbook.dao.AddressBookDaoFileImpl;
import bl.addressbook.ui.AddressBookView;
import bl.addressbook.ui.UserIO;
import bl.addressbook.ui.UserIOConsoleImpl;

/**
 *
 * @author Boone
 */
public class App {
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        AddressBookView myView = new AddressBookView(myIo);
        AddressBookDao myDao = new AddressBookDaoFileImpl();
        AddressBookController controller = new AddressBookController(myDao, myView);
        
        controller.run();
    } 
}