/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.vendingmachine.dao;

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

/**
 *
 * @author Boone
 */
public class VendingAuditDaoTest {
    
    VendingAuditDao auditDao = new VendingAuditDaoImpl();
    
    public VendingAuditDaoTest() {
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
    public void setUp() {
        
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Tests -------------------------------------------------------------------
     */

    @Test
    public void testWriteAuditEntry() throws Exception {
        
        //create and ArrayList and assert that it has 0 items
        List<String> arrayListOfStrings = new ArrayList<>();
        assertEquals(0, arrayListOfStrings.size());
        
        //write a string to the audit file
        auditDao.writeAuditEntry("Test String");
        
        //read the audit file and save its contents in the ArrayList
        Scanner scanner;
        try {
            scanner = new Scanner(
                new BufferedReader(
                    new FileReader("VendingAudit-test.txt")));
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