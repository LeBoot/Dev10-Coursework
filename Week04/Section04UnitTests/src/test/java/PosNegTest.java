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
public class PosNegTest {
    
    PosNeg pn = new PosNeg();
    
    public PosNegTest() {
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

        // Given two int values, return true if one is negative and 
    // one is positive. Except if the parameter "negative" is 
    // true, then return true only if both are negative. 
    //


    @Test
    public void testposNegFalse() {
        assertTrue(pn.posNeg(1, -1, false));
    }
    @Test
    public void testnegPosFalse() {
        assertTrue(pn.posNeg(-1, 1, false));
    }
    @Test
    public void testposPosFalse() {
        assertFalse(pn.posNeg(1, 1, false));
    }
    @Test
    public void testnegNegFalse() {
        assertFalse(pn.posNeg(-1, -1, false));
    }

    @Test
    public void testposNegTrue() {
        assertFalse(pn.posNeg(1, -1, true));
    }
    @Test
    public void testnegPosTrue() {
        assertFalse(pn.posNeg(-1, 1, true));
    }
    @Test
    public void testposPosTrue() {
        assertFalse(pn.posNeg(1, 1, true));
    }
    @Test
    public void testnegNegTrue() {
        assertTrue(pn.posNeg(-1, -1, true));
    }
}
