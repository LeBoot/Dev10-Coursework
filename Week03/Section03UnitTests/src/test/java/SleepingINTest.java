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
public class SleepingINTest {
    
    SleepingIN sleep = new SleepingIN();
    
    public SleepingINTest() {
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

    
     // The parameter weekday is true if it is a weekday, and the 
    // parameter vacation is true if we are on vacation. We sleep 
    // in if it is not a weekday or we're on vacation. Return true 
    // if we sleep in. 
    //
    // canSleepIn(false, false) -> true
    // canSleepIn(true, false) -> false
    // canSleepIn(false, true) -> true
    // canSleepIn(true, true) -> true


    @Test
    public void testFalseFalse() {
        assertTrue(sleep.canSleepIn(false, false));
    }
    
    @Test
    public void testTrueFalse() {
        assertFalse(sleep.canSleepIn(true, false));
    }
    
    @Test
    public void testFalseTrue() {
        assertTrue(sleep.canSleepIn(false, true));
    }
    
    @Test
    public void testTrueTrue() {
        assertTrue(sleep.canSleepIn(true, true));
    }
    
}
