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
public class NearTenTest {
    
    NearTen nt = new NearTen();
    
    public NearTenTest() {
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

        // Given an int n, return true if it is within 10 of 100 
    // or 200.
    // Hint: Check out the Math class for absolute value
    //
    // nearHundred(103) -> true
    // nearHundred(90) -> true
    // nearHundred(89) -> false
    //nh(110) -> t
    //nh(111) -> f

    
    @Test
    public void testTrue103() {
        assertTrue(nt.nearHundred(103));
    }
    
    @Test
    public void testTrue110() {
        assertTrue(nt.nearHundred(110));
    }
    
    @Test
    public void testTrue90() {
        assertTrue(nt.nearHundred(90));
    }
    
    @Test
    public void testTrue203() {
        assertTrue(nt.nearHundred(203));
    }
    
    @Test
    public void testTrue210() {
        assertTrue(nt.nearHundred(210));
    }
    
    @Test
    public void testTrue190() {
        assertTrue(nt.nearHundred(190));
    }
    
    @Test
    public void testFalse89() {
        assertFalse(nt.nearHundred(89));
    }
    
    @Test
    public void testFalse189() {
        assertFalse(nt.nearHundred(189));
    }
    
    @Test
    public void testFalse111() {
        assertFalse(nt.nearHundred(111));
    }
    
    @Test
    public void testFalse211() {
        assertFalse(nt.nearHundred(211));
    }
    
}
