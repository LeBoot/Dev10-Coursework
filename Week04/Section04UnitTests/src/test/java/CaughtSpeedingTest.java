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
public class CaughtSpeedingTest {
    
    CaughtSpeeding cs = new CaughtSpeeding();
    
    public CaughtSpeedingTest() {
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

    // You are driving a little too fast, and a police 
    // officer stops you. Write code to compute the 
    // result, encoded as an int value: 0=no ticket, 
    // 1=small ticket, 2=big ticket. If speed is 60 or 
    // less, the result is 0. If speed is between 61 
    // and 80 inclusive, the result is 1. If speed is 
    // 81 or more, the result is 2. Unless it is your 
    // birthday -- on that day, your speed can be 5 
    // higher in all cases. 
    //
    // caughtSpeeding(60, false) → 0
    // caughtSpeeding(65, false) → 1
    //caughtSpeeding(65, true) → 0


    
    @Test
    public void testSomeMethod() {
        assertEquals(0, cs.caughtSpeeding(60, false));
        assertEquals(0, cs.caughtSpeeding(60, true));
        assertEquals(1, cs.caughtSpeeding(65, false));
        assertEquals(0, cs.caughtSpeeding(65, true));
        assertEquals(1, cs.caughtSpeeding(80, false));
        assertEquals(1, cs.caughtSpeeding(80, true));
        assertEquals(2, cs.caughtSpeeding(85, false));
        assertEquals(1, cs.caughtSpeeding(85, true));
        assertEquals(2, cs.caughtSpeeding(90, false));
        assertEquals(2, cs.caughtSpeeding(90, true));
    }
    
}
