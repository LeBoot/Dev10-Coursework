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
public class SameFirstLastTest {
    
    SameFirstLast sfl = new SameFirstLast();
    
    public SameFirstLastTest() {
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

      // Given an array of ints, return true if the array is length 
    // 1 or more, and the first element and the last element are equal. 
    //
    // sameFirstLast({1, 2, 3}) -> false
    // sameFirstLast({1, 1, 3}) -> false
    // sameFirstLast({}) -> false
    // sameFirstLast({1, 2, 3, 1}) -> true
    // sameFirstLast({1, 2, 1}) -> true

    @Test
    public void test3No1() {
        int[] testArray = {1, 2, 3};
        assertFalse(sfl.sameFirstLast(testArray));
    }
    
    @Test
    public void test3No2() {
        int[] testArray = {1, 1, 3};
        assertFalse(sfl.sameFirstLast(testArray));
    }
    
    @Test
    public void test0() {
        int[] testArray = {};
        assertFalse(sfl.sameFirstLast(testArray));
    }
    
    @Test
    public void test4Yes() {
        int[] testArray = {1, 2, 3, 1};
        assertTrue(sfl.sameFirstLast(testArray));
    }
    
    @Test
    public void test3Yes() {
        int[] testArray = {1, 2, 1};
        assertTrue(sfl.sameFirstLast(testArray));
    }
    
}
