/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.vendingmachine.dao;

import bl.vendingmachine.dto.VendingItem;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Boone
 */
public class VendingDaoTest {
    
//    VendingDao dao = new VendingDaoImpl();
//    public VendingDaoTest() {
//    }
    
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    VendingDao dao = ctx.getBean("dao", VendingDao.class);
    
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
    public void testGetAllItems() {
    
        //check that getAllItems yeilds exactly 0
        assertEquals(0, dao.getAllItems().size());
        
        //add an item
        VendingItem item1 = new VendingItem("item1");
        BigDecimal price = new BigDecimal("0.75");
        item1.setPriceOfItem(price);
        item1.setQuantityOfItem(2);
        dao.addItem(item1.getNameOfItem(), item1);
        
        //now, ensure that getAllItems yields exactly 1
        assertEquals(1, dao.getAllItems().size());
        
        //add another item
        VendingItem item2 = new VendingItem("item2");
        item2.setPriceOfItem(price);
        item2.setQuantityOfItem(2);
        dao.addItem(item2.getNameOfItem(), item2);
        
        //finally, ensure that getAllItems yields exactly 2
        assertEquals(2, dao.getAllItems().size());
        
    }
    
    @Test
    public void getAllItemsNonZero() {
        
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
        
        //check that getAllItems yields exactly 2
        assertEquals(2, dao.getAllItems().size());
        
        //check that getAllItemsNonZero yields exactly 1
        assertEquals(1, dao.getAllItemsNonZero().size());
    }
    
    @Test
    public void testGetItemAndAddItem() {
        
        //add an item
        VendingItem item1 = new VendingItem("item1");
        BigDecimal price = new BigDecimal("0.75");
        item1.setPriceOfItem(price);
        item1.setQuantityOfItem(2);
        dao.addItem(item1.getNameOfItem(), item1);
        
        //pull the item from memory, and save it as a new object
        VendingItem fromDao = dao.getItem(item1.getNameOfItem());
        
        //see if what was put-into and pulled-outfrom memory match
        assertEquals(fromDao, item1);
    }
    
    
    @Test
    public void testRemoveItem() {
        
        //add an item
        VendingItem item1 = new VendingItem("item1");
        BigDecimal price = new BigDecimal("0.75");
        item1.setPriceOfItem(price);
        item1.setQuantityOfItem(2);
        dao.addItem(item1.getNameOfItem(), item1);
        
        //check that getAllItems yeilds exactly 1
        assertEquals(1, dao.getAllItems().size());
        
        //remove the item and check that getALL yields exactly 0
        dao.removeItem(item1.getNameOfItem());
        assertEquals(0, dao.getAllItems().size());
        
        //check that memory of that removed file is null
        assertNull(dao.getItem(item1.getNameOfItem()));
    }
    
    @Test
    public void testWriteAndLoadTextFile() throws Exception {
        
        //add an item to program memory
        VendingItem item1 = new VendingItem("item1");
        BigDecimal price = new BigDecimal("0.75");
        item1.setPriceOfItem(price);
        item1.setQuantityOfItem(2);
        dao.addItem(item1.getNameOfItem(), item1);
        
        //confirm that that one file is in memory
        assertEquals(1, dao.getAllItems().size());
                
        //write to text file
        dao.writeTextFile();
        
        //now remove that item from program memory
        dao.removeItem(item1.getNameOfItem());
        
        //check that item was successfully removed
        assertEquals(0, dao.getAllItems().size());
        
        //now load the text file again and check that afterwards there is one file
            //in the memory.  If true, it demonstrates that the loaded file had
            //been written to
        dao.loadTextFile();
        assertEquals(1, dao.getAllItems().size());        
        
    }
}