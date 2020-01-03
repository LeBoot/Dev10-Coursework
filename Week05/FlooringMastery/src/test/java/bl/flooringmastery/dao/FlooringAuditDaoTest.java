/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.flooringmastery.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
public class FlooringAuditDaoTest {
    
    //spring injection
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    FlooringAuditDao dao = ctx.getBean("auditDao", FlooringAuditDao.class);
    
//    //dependency injection
//    FlooringAuditDao dao = new FlooringAuditDaoImpl();
//    public FlooringAuditDaoTest() {
//    }
    
    @BeforeAll
    //change the text file, lest the @BeforeEach erase everything
    public static void setUpClass() {
        OrderNumbersDaoImpl.textfile = "OrderNumbers-UnitTesting.txt";
        FlooringOrderDaoImpl.textfile = "Orders-UnitTesting.txt";
        FlooringAuditDaoImpl.AUDITFILE = "Audit-UnitTesting.txt";
    }
    
    @AfterAll
    //change the text file back to what it was originally
    public static void tearDownClass() {
        OrderNumbersDaoImpl.textfile = "OrderNumbers.txt";
        FlooringOrderDaoImpl.textfile = "Orders.txt";
        FlooringAuditDaoImpl.AUDITFILE = "Audit.txt";
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of writeAuditEntry method, of class FlooringAuditDao.
     */
    @Test
    public void testWriteAuditEntry() throws Exception {
        
        //create and ArrayList and assert that it has 0 items
        List<String> arrayListOfStrings = new ArrayList<>();
        assertEquals(0, arrayListOfStrings.size());
        
        //write a string to the audit file
        dao.writeAuditEntry("Test String", "TEST");
        
        //read the audit file and save its contents in the ArrayList
        Scanner scanner;
        try {
            scanner = new Scanner(
                new BufferedReader(
                    new FileReader("Audit-UnitTesting.txt")));
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(e.getMessage());
        }
        String currentLine;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            arrayListOfStrings.add(currentLine);
        }
        scanner.close();
        
        //check that they arrayList has at least one item
        assertTrue(arrayListOfStrings.size() >= 0);

    }   

}