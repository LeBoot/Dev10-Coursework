/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.addressbook.dao;

import bl.addressbook.dto.Address;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Boone
 */
public class AddressBookDaoTest {
    
    private AddressBookDao dao = new AddressBookDaoFileImpl();
    public AddressBookDaoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() throws Exception {
        List<Address> addressList = dao.getAllAddresses() ;
        for (Address address : addressList) {
            dao.removeAddress(address.getLastName());
        }
    }
    
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addAddress method, of class AddressBookDao.
     */
    @Test
    public void testAddAndGetAddress() throws Exception {
        Address address1 = new Address("Johnson");
        address1.setFirstName("John");
        address1.setHouseNumber("1");
        address1.setHouseStreet("First");
        address1.setCityName("City 1");
        address1.setStateName("First");
        address1.setZip("11111");
        
        dao.addAddress(address1.getLastName(), address1);
        
        Address fromDao = dao.getAddress(address1.getLastName());
        assertEquals(fromDao, address1);
    }

    
    
    
    
    /**
     * Test of removeAddress method, of class AddressBookDao.
     */
    @Test
    public void testRemoveAddress() throws Exception {
        Address address1 = new Address("Johnson");
        address1.setFirstName("John");
        address1.setHouseNumber("1");
        address1.setHouseStreet("First");
        address1.setCityName("City 1");
        address1.setStateName("First");
        address1.setZip("11111");
        
        dao.addAddress(address1.getLastName(), address1);
        
        Address address2 = new Address("Fawks");
        address2.setFirstName("Guy");
        address2.setHouseNumber("2");
        address2.setHouseStreet("Second");
        address2.setCityName("City 2");
        address2.setStateName("Second");
        address2.setZip("22222");
        
        dao.addAddress(address2.getLastName(), address2);
        
        assertEquals(2, dao.getAllAddresses().size());
        
        dao.removeAddress(address1.getLastName());
        assertEquals(1, dao.getAllAddresses().size());
        assertNull(dao.getAddress(address1.getLastName()));
        
        dao.removeAddress(address2.getLastName());
        assertEquals(0, dao.getAllAddresses().size());
        assertNull(dao.getAddress(address2.getLastName()));
        
        
    }

    /**
     * Test of getAllAddresses method, of class AddressBookDao.
     */
    @Test
    public void testGetAllAddresses() throws Exception {
        Address Address1 = new Address("Johnson");
        Address1.setFirstName("John");
        Address1.setHouseNumber("1");
        Address1.setHouseStreet("First");
        Address1.setCityName("City 1");
        Address1.setStateName("First");
        Address1.setZip("11111");
        
        dao.addAddress(Address1.getLastName(), Address1);
        
        Address Address2 = new Address("Fawks");
        Address2.setFirstName("Guy");
        Address2.setHouseNumber("2");
        Address2.setHouseStreet("Second");
        Address2.setCityName("City 2");
        Address2.setStateName("Second");
        Address2.setZip("22222");
        
        dao.addAddress(Address2.getLastName(), Address2);
        
        assertEquals(2, dao.getAllAddresses().size());
        
    }

    /**
     * Test of getAddress method, of class AddressBookDao.
     */
    @Test
    public void testGetAddress() throws Exception {
    }
    
}
