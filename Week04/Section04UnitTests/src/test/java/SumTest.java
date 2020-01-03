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
public class SumTest {
    
    Sum sumSum = new Sum();
    
    public SumTest() {
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

      // Given an array of ints, return the sum of all the elements. 
    //
    // sum({1, 2, 3}) -> 6
    // sum({5, 11, 2}) -> 18
    // sum({7, 0, 0}) -> 7
    @Test
    public void test1() {
        int expectedResult = 6;
        int[] testArray = {1, 2, 3};
        assertEquals(expectedResult, sumSum.sum(testArray));
    }
    
    @Test
    public void test2() {
        int expectedResult = 18;
        int[] testArray = {5, 11, 2};
        assertEquals(expectedResult, sumSum.sum(testArray));
    }
    
    @Test
    public void test3() {
        int expectedResult = 7;
        int[] testArray = {7, 0, 0};
        assertEquals(expectedResult, sumSum.sum(testArray));
    }
}
