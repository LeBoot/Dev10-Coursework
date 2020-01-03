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
public class SkipSumTest {
    
    SkipSum ss = new SkipSum();
    
    public SkipSumTest() {
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

    // Given 2 ints, a and b, return their sum. However, sums 
    // in the range 10..19 inclusive are forbidden, so in that case just return 20. 
    //
    // skipSum(3, 4) → 7
    // skipSum(9, 4) → 20
    // skipSum(10, 11) → 21
    
    @Test
    public void testThreeFourSeven() {
        int expectedResult = 7;
        assertEquals(expectedResult, ss.skipSum(3, 4));
    }
    
    @Test
    public void testNineFourTwenty() {
        int expectedResult = 20;
        assertEquals(expectedResult, ss.skipSum(9, 4));
    }
    
    @Test
    public void testTenElevenTwentyone() {
        int expectedResult = 20;
        assertEquals(expectedResult, ss.skipSum(10, 7));
    } 
}