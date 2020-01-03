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
public class MultipleEndingsTest {
    
    MultipleEndings me = new MultipleEndings();
    
    public MultipleEndingsTest() {
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

    
        // Given a String, return a new String made of 3 copies 
    // of the last 2 chars of the original String. The String 
    // length will be at least 2. 
    //
    // multipleEndings("Hello") -> "lololo"
    // multipleEndings("ab") -> "ababab"
    // multipleEndings("Hi") -> "HiHiHi"

    @Test
    public void testSomeMethod3() {
        String expectedResult = "lololo";
        assertEquals(expectedResult, me.multipleEndings("Hello"));
    }
    
    @Test
    public void testSomeMethod2() {
        String expectedResult = "ababab";
        assertEquals(expectedResult, me.multipleEndings("ab"));
    }
    
    @Test
    public void testSomeMethod1() {
        String expectedResult = "HiHiHi";
        assertEquals(expectedResult, me.multipleEndings("Hi"));
    }
    
}
