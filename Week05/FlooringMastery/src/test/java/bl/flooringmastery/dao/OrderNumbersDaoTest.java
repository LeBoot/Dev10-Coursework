/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.flooringmastery.dao;

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
public class OrderNumbersDaoTest {
  
    //spring injection
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    OrderNumbersDao dao = ctx.getBean("orderNumDao", OrderNumbersDao.class);
    
//    //dependency injection
//    OrderNumbersDao dao = new OrderNumbersDaoImpl();
//    public OrderNumbersDaoTest() {
//    }
    
    @BeforeAll
    //change the text file, lest the @BeforeEach erase everything
    public static void setUpClass() {
        OrderNumbersDaoImpl.textfile = "OrderNumbers-UnitTesting.txt";
    }
    
    @AfterAll
    //change the text file back to what it was originally
    public static void tearDownClass() {
        OrderNumbersDaoImpl.textfile = "OrderNumbers.txt";
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of checkIsNumberInList method, of class OrderNumbersDao.
     */
    @Test
    public void testAllMethodsTogether() throws Exception {
        //use production mode, because the file is changed at the top
        String testOrProd = "PROD";
        
        //find the largest number currently in the list
        List<Integer> initialList = dao.getListOfNumbers(testOrProd);
        int maxNum = -1;
        for (int number : initialList) {
            if (number > maxNum) {
                maxNum = number;
            }
        }

        //check for a number that is guarenteed to be in the list
        assertTrue(dao.checkIsNumberInList(maxNum, testOrProd));
        
        //check for a number that is guarentted to not be in the list
        assertFalse(dao.checkIsNumberInList(maxNum + 1, testOrProd));
        
        //add a new number to list
        dao.addNumToList(maxNum + 1, testOrProd);
        
        //check that it is in the list
        assertTrue(dao.checkIsNumberInList(maxNum + 1, testOrProd));
        
    }

}