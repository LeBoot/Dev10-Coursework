/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.addressbook.dao;

import bl.addressbook.dto.Address;
import java.util.List;

/**
 *
 * @author Boone
 */
public interface AddressBookDao {
    
    Address addAddress(String lastName, Address address) throws AddressBookDaoException;
    
    Address removeAddress(String lastName) throws AddressBookDaoException;
    
    List<Address> getAllAddresses() throws AddressBookDaoException;
    
    Address getAddress(String lastName) throws AddressBookDaoException;
    
}