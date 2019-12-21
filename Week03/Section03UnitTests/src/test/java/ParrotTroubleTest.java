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
public class ParrotTroubleTest {
    
    ParrotTrouble pt = new ParrotTrouble();
    
    public ParrotTroubleTest() {
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
    public void testTrue6() {
        assertTrue(pt.parrotTrouble(true, 6));
    }
    
    @Test
    public void testFalse6() {
        assertFalse(pt.parrotTrouble(false, 6));
    }
    
    @Test
    public void testTrue7() {
        assertFalse(pt.parrotTrouble(true, 7));
    }
    
    @Test
    public void testFalse7() {
        assertFalse(pt.parrotTrouble(false, 7));
    }
    
    @Test
    public void testTrue20() {
        assertFalse(pt.parrotTrouble(true, 20));
    }
    
    @Test
    public void testFalse20() {
        assertFalse(pt.parrotTrouble(false, 20));
    }
    
    @Test
    public void testFalse21() {
        assertFalse(pt.parrotTrouble(false, 21));
    }
    
    @Test
    public void testTrue21() {
        assertTrue(pt.parrotTrouble(true, 21));
    }

}
