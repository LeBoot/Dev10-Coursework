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
public class MakesTen2Test {
    
    MakesTen2 mt2 = new MakesTen2();
    
    public MakesTen2Test() {
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

    /**
     * Test of makes10 method, of class MakesTen2.
     */
    @Test
    public void testMakes10() {
        assertTrue(1+1 == 2);
    }
    @Test
    public void testnineTenTrue() {
        assertTrue(mt2.makes10(9, 10));
    }
    @Test
    public void testtenZeroTrue() {
        assertTrue(mt2.makes10(10, 0));
    }
    @Test
    public void testnineNineFalse() {
        assertFalse(mt2.makes10(9, 9));
    }
    @Test
    public void testoneNineTrue() {
        assertTrue(mt2.makes10(1, 9));
    }
    
}
