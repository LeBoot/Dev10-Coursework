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
public class CommonEndTest {
    
    CommonEnd CE = new CommonEnd();
    
    public CommonEndTest() {
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
    public void testSomeMethod() {
        assertEquals(1, 1);
    }
    
    @Test
    public void OneThreeSevenThreeTrue() {
        int[] array1 = {1, 2, 3};
        int[] array2 = {7, 3};
        
        assertTrue(CE.commonEnd(array1, array2));
    }
    
    @Test
    public void OneThreeOneThreeTrue() {
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 3};
        
        assertTrue(CE.commonEnd(array1, array2));
    }
    
    @Test
    public void OneThreeOneFiveTrue() {
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 5, 5};
        
        assertTrue(CE.commonEnd(array1, array2));
    }
    
    @Test
    public void OneThreeSevenFourTrue() {
        int[] array1 = {1, 2, 3};
        int[] array2 = {7, 4};
        
        assertFalse(CE.commonEnd(array1, array2));
    }
    
}
