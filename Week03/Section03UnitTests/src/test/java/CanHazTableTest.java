/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class CanHazTableTest {
    
    CanHazTable cht = new CanHazTable();
    
    public CanHazTableTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    // canHazTable(5, 10) → 2
    // canHazTable(5, 2) → 0
    // canHazTable(5, 5) → 1
    // canHazTable(8, 8) --> 2
    // canHazTable(8, 2) --> 0
    // canHazTable(8, 7) --> 2
    // canHazTable(8, 1) --> 0
    @Test
    public void testFiveTen() {
        assertEquals(2, cht.canHazTable(5, 10));
    }
    
    @Test
    public void testFiveTwo() {
        assertEquals(0, cht.canHazTable(5, 2));
    }
    
    @Test
    public void testFiveFive() {
        assertEquals(1, cht.canHazTable(5, 5));
    }
    
    @Test
    public void testEightEight() {
        assertEquals(2, cht.canHazTable(8, 8));
    }
    
    @Test
    public void testEightTwo() {
        assertEquals(0, cht.canHazTable(8, 2));
    }
    
    @Test
    public void testEightSeven() {
        assertEquals(2, cht.canHazTable(8, 7));
    }
    
    @Test
    public void testEightOne() {
        assertEquals(0, cht.canHazTable(8, 1));
    }
}
