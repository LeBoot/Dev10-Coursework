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
public class MischeviousChildrenTest {
    
    MischeviousChildren misC = new MischeviousChildren();
    
    public MischeviousChildrenTest() {
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

    
    @Test
    public void testTrueTrue() {
        assertTrue(misC.areWeInTrouble(true, true));
    }
    
    @Test
    public void testTrueFalse() {
        assertFalse(misC.areWeInTrouble(true, false));
    }
    
    @Test
    public void testFalseFalse() {
        assertTrue(misC.areWeInTrouble(false, false));
    }
    
    @Test
    public void testFalseTrue() {
        assertFalse(misC.areWeInTrouble(false, true));
    }
    
}
