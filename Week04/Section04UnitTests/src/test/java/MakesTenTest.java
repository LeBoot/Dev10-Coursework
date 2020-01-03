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
public class MakesTenTest {
    
    MakesTen mt = new MakesTen();
    
    public MakesTenTest() {
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

    
        // Given two ints, a and b, return true if one if them is 10 
    // or if their sum is 10. 
    //
    // makes10(9, 10) -> true
    // makes10(9, 9) -> false
    // makes10(1, 9) -> true

    @Test
    public void nineTenTrue() {
        assertTrue(mt.makes10(9, 10));
    }
    @Test
    public void tenZeroTrue() {
        assertTrue(mt.makes10(10, 0));
    }
    @Test
    public void nineNineFalse() {
        assertFalse(mt.makes10(9, 9));
    }
    @Test
    public void oneNineTrue() {
        assertTrue(mt.makes10(1, 9));
    }
    
}
