/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.vendingmachine.service;

import bl.vendingmachine.dao.VendingAuditDao;
import bl.vendingmachine.dao.VendingAuditDaoImpl;
import bl.vendingmachine.dao.VendingDao;
import bl.vendingmachine.dao.VendingDaoImpl;
import bl.vendingmachine.dto.VendingItem;
import java.math.BigDecimal;
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
public class VendingServiceTest {

    private VendingDao dao = new VendingDaoImpl();
    private VendingAuditDao auditDao = new VendingAuditDaoImpl();
    private VendingService service = new VendingServiceImpl(dao, auditDao);
    
    public VendingServiceTest() {
    }
    
    @BeforeAll
    //change the text file, lest the @BeforeEach erase everything
    public static void setUpClass() {
        VendingDaoImpl.TEXTFILE = "Inventory-test.txt";
        VendingAuditDaoImpl.AUDITFILE = "VendingAudit-test.txt";
    }
    
    @AfterAll
    //change the text file back to what it was originally
    public static void tearDownClass() {
        VendingDaoImpl.TEXTFILE = "Inventory.txt";
        VendingAuditDaoImpl.AUDITFILE = "VendingAudit.txt";
    }
    
    @BeforeEach
    //call every item, and one by one remove them, leaving a blank text file
    public void setUp() {
        List<VendingItem> listOfItems = dao.getAllItems();
        for (VendingItem vi : listOfItems) {
            dao.removeItem(vi.getNameOfItem());
        }
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Tests -------------------------------------------------------------------
     */
    @Test
    public void testGetItemsToDisplay() {
        
        //add an item with non-zero quantity
        VendingItem item1 = new VendingItem("item1");
        BigDecimal price = new BigDecimal("0.75");
        item1.setPriceOfItem(price);
        item1.setQuantityOfItem(2);
        dao.addItem(item1.getNameOfItem(), item1);
        
        //add an item with zero quantity
        VendingItem item2 = new VendingItem("item2");
        item2.setPriceOfItem(price);
        item2.setQuantityOfItem(0);
        dao.addItem(item2.getNameOfItem(), item2);
        
        //call service method.  It should have exaclty one item in it
        assertEquals(1, service.getItemsToDisplay().size());
    }


    @Test
    public void testValidateMoneyOrExit() {
        assertTrue(service.validateMoneyOrExit("exit"));
        assertTrue(service.validateMoneyOrExit("1.23"));
        assertTrue(service.validateMoneyOrExit("0"));
        assertFalse(service.validateMoneyOrExit("-1"));
        assertFalse(service.validateMoneyOrExit("text"));
        assertFalse(service.validateMoneyOrExit(""));
    }
    
    
    @Test
    public void testValidateChoiceOrExit() throws Exception {
        //add an item with non-zero quantity
        VendingItem item1 = new VendingItem("item1");
        BigDecimal price = new BigDecimal("0.75");
        item1.setPriceOfItem(price);
        item1.setQuantityOfItem(2);
        dao.addItem(item1.getNameOfItem(), item1);
        
        //add an item with zero quantity
        VendingItem item2 = new VendingItem("item2");
        item2.setPriceOfItem(price);
        item2.setQuantityOfItem(0);
        dao.addItem(item2.getNameOfItem(), item2);
        
        //test different inputs
        assertTrue(service.validateChoiceOrExit("exit"));
        assertTrue(service.validateChoiceOrExit("item1"));
        assertFalse(service.validateChoiceOrExit("item3"));
        try {
            service.validateChoiceOrExit("item2");
            fail("Expected error to be thrown");
        } catch (NoItemInventoryException e) {
            return;
        }
    } 

    

    @Test
    public void testValidatePurchaseAnother() {
        assertTrue(service.validatePurchaseAnother("y"));
        assertTrue(service.validatePurchaseAnother("YeS"));
        assertTrue(service.validatePurchaseAnother("n"));
        assertTrue(service.validatePurchaseAnother("   y"));
        assertFalse(service.validatePurchaseAnother("Maybe"));
        assertFalse(service.validatePurchaseAnother("2"));
        assertFalse(service.validatePurchaseAnother(""));        
    }

    
    
    @Test
    public void testEditUserPurchaseAnother() {
        assertEquals("y", service.editUserPurchaseAnother("YAAAASSSSS"));
        assertEquals("y", service.editUserPurchaseAnother("   YES"));
        assertEquals("n", service.editUserPurchaseAnother("n"));
        assertEquals("n", service.editUserPurchaseAnother("no"));
    }
    
    

    @Test
    public void testEditUserChoice() {
        assertEquals("a", service.editUserChoice("   A   "));
        assertEquals("abcd", service.editUserChoice("   ABcd   "));
        assertEquals("bb", service.editUserChoice("BB"));
        assertEquals("bb", service.editUserChoice("bb"));
    }

    

    @Test
    public void testConvertUserMoneyToBD() {
        BigDecimal BDtest1 = new BigDecimal("1.23");
        BigDecimal BDtest2 = new BigDecimal("1.24");
        assertEquals(BDtest1, service.convertUserMoneyToBD("1.23"));
        assertEquals(BDtest1, service.convertUserMoneyToBD("1.2345"));
        assertEquals(BDtest2, service.convertUserMoneyToBD("1.2399"));
    }


    @Test
    public void testCalculateChange() {
        
        //add two items of different price item
        VendingItem item1 = new VendingItem("item1");
        BigDecimal price1 = new BigDecimal("1.00");
        item1.setPriceOfItem(price1);
        item1.setQuantityOfItem(2);
        dao.addItem(item1.getNameOfItem(), item1);
        
        VendingItem item2 = new VendingItem("item2");
        BigDecimal price2 = new BigDecimal("0.00");
        item2.setPriceOfItem(price2);
        item2.setQuantityOfItem(2);
        dao.addItem(item2.getNameOfItem(), item2);
        
        //create some possible user amounts
        BigDecimal BDtest1A = new BigDecimal("1.00");
        BigDecimal BDtest2A = new BigDecimal("0.00");
        BigDecimal BDtest1B = new BigDecimal("1.11");
        BigDecimal BDtest2B = new BigDecimal("0.11");
        BigDecimal BDtest1C = new BigDecimal("1.73");
        BigDecimal BDtest2C = new BigDecimal("0.73");
        
        assertEquals(service.calculateChange(BDtest1A, item1), service.calculateChange(BDtest2A, item2));
        assertEquals(service.calculateChange(BDtest1B, item1), service.calculateChange(BDtest2B, item2));
        assertEquals(service.calculateChange(BDtest1C, item1), service.calculateChange(BDtest2C, item2));     
    }
    
    
    

    @Test
    public void testValidateEnoughMoney() throws Exception {
        //add an item
        VendingItem item1 = new VendingItem("item1");
        BigDecimal price1 = new BigDecimal("1.00");
        item1.setPriceOfItem(price1);
        item1.setQuantityOfItem(2);
        dao.addItem(item1.getNameOfItem(), item1);
        
        //add a test BigDecimal
        BigDecimal BDtest1 = new BigDecimal("0.50");
        BigDecimal BDtest2 = new BigDecimal("1.00");
        BigDecimal BDtest3 = new BigDecimal("1.50");
        
        //if BD is less than price of item, method should throw error
        try {
            service.validateEnoughMoney("item1", BDtest1);
            fail("Expected error to be thrown");
        } catch (InsufficientFundsException e) {
            return;
        }
        
        //if BD is equal to or greater than price of item, method should not throw error
        try {
            service.validateEnoughMoney("item1", BDtest2);
        } catch (InsufficientFundsException e) {
            fail("Error was thrown when it should not have been.");
        }
        
        try {
            service.validateEnoughMoney("item1", BDtest3);
        } catch (InsufficientFundsException e) {
            fail("Error was thrown when it should not have been.");
        }
    }

    

    @Test
    public void testRemoveItem() throws Exception {
        //add an item
        VendingItem item1 = new VendingItem("item1");
        BigDecimal price1 = new BigDecimal("1.00");
        item1.setPriceOfItem(price1);
        item1.setQuantityOfItem(2);
        dao.addItem(item1.getNameOfItem(), item1);
        
        //check that quantity is 2
        assertTrue(item1.getQuantityOfItem() == 2);
        
        //remove one copy and assert that quantity is now 1
        service.removeItem(item1.getNameOfItem());
        assertTrue(item1.getQuantityOfItem() == 1);  
    }

    

    @Test
    public void testGetAllItems() {
        //add an item
        VendingItem item1 = new VendingItem("item1");
        BigDecimal price1 = new BigDecimal("1.00");
        item1.setPriceOfItem(price1);
        item1.setQuantityOfItem(2);
        dao.addItem(item1.getNameOfItem(), item1);
        
        assertEquals(1, service.getAllItems().size());
    }

    

    @Test
    public void testGetItem() {
        //add an item and assert that it is not null
        VendingItem item1 = new VendingItem("item1");
        BigDecimal price1 = new BigDecimal("1.00");
        item1.setPriceOfItem(price1);
        item1.setQuantityOfItem(2);
        dao.addItem(item1.getNameOfItem(), item1);
        
        assertNotNull(item1);
        
        //check for a item that has not been created
        item1 = service.getItem("item100");
        assertNull(item1);
        
    }

    
    
    
    @Test
    public void testWriteAndLoadTextFile() throws Exception {
        
        //nearly identical to testWriteAndLoadTextFile() from VendingDaoTest
            //only change is calling the writeTextFile() and loadTextFile() methods  

        //add an item to program memory
        VendingItem item1 = new VendingItem("item1");
        BigDecimal price = new BigDecimal("0.75");
        item1.setPriceOfItem(price);
        item1.setQuantityOfItem(2);
        dao.addItem(item1.getNameOfItem(), item1);
        
        //confirm that that one file is in memory
        assertEquals(1, dao.getAllItems().size());
                
        //write to text file
        service.writeTextFile();
        
        //now remove that item from program memory
        dao.removeItem(item1.getNameOfItem());
        
        //check that item was successfully removed
        assertEquals(0, dao.getAllItems().size());
        
        //now load the text file again and check that afterwards there is one file
            //in the memory.  If true, it demonstrates that the loaded file had
            //been written to
        service.loadTextFile();
        assertEquals(1, dao.getAllItems().size()); 
        
    }


    
    
    @Test
    public void testGetAllItemsNonZero() {
        //identitcal to testGetItemsToDisplay()
        
        //add an item with non-zero quantity
        VendingItem item1 = new VendingItem("item1");
        BigDecimal price = new BigDecimal("0.75");
        item1.setPriceOfItem(price);
        item1.setQuantityOfItem(2);
        dao.addItem(item1.getNameOfItem(), item1);
        
        //add an item with zero quantity
        VendingItem item2 = new VendingItem("item2");
        item2.setPriceOfItem(price);
        item2.setQuantityOfItem(0);
        dao.addItem(item2.getNameOfItem(), item2);
        
        //call service method.  It should have exaclty one item in it
        assertEquals(1, service.getItemsToDisplay().size());
    }

    
}