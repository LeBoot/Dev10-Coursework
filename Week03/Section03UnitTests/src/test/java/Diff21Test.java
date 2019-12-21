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
public class Diff21Test {
    
    Diff21 diff = new Diff21();
    
    public Diff21Test() {
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

    
    
    
    
        // Given an int n, return the absolute value of the difference 
    // between n and 21, except return double the absolute value 
    // of the difference if n is over 21. 
    //
    // diff21(23) -> 4
    // diff21(10) -> 11
    // diff21(21) -> 0
    // diff21(50) -> 58
    // diff21(-3) -> 24

    @Test
    public void test23() {
        int toTest = 4;
        assertEquals(toTest, diff.diff21(23));
    }
    
    @Test
    public void test10() {
        int toTest = 11;
        assertEquals(toTest, diff.diff21(10));
    }
    
    @Test
    public void test21() {
        int toTest = 0;
        assertEquals(toTest, diff.diff21(21));
    }
    
    @Test
    public void test50() {
        int toTest = 58;
        assertEquals(toTest, diff.diff21(50));
    }
    
    @Test
    public void testNeg3() {
        int toTest = 24;
        assertEquals(toTest, diff.diff21(-3));
    }
    
}
