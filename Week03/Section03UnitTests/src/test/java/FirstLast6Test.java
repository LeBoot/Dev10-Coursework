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
public class FirstLast6Test {
    
    FirstLast6 fl = new FirstLast6();
    
    public FirstLast6Test() {
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

    
    // Given an array of ints, return true if 6 appears as either the 
    // first or last element in the array. The array will be length 1 or more. 
    //
    // firstLast6({1, 2, 6}) -> true
    // firstLast6({6, 1, 2, 3}) -> true
    // firstLast6({13, 6, 1, 2, 3}) -> false

    @Test
    public void test3last() {
        int [] testArray = {1, 2, 6};
        assertTrue(fl.firstLast6(testArray));
    }
    
    @Test
    public void test4First() {
        int [] testArray = {6, 1, 2, 3};
        assertTrue(fl.firstLast6(testArray));
    }
    
    @Test
    public void test5Mid() {
        int [] testArray = {13, 6, 1, 2, 3};
        assertFalse(fl.firstLast6(testArray));
    }
    
}
