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
public class StringSplosionTest {
    
    StringSplosion ss = new StringSplosion();
    
    public StringSplosionTest() {
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

       // Given a non-empty String like "Code" return a String like 
    // “CCoCodCode".  (first char, first two, first 3, etc)
    //
    // stringSplosion("Code") -> "CCoCodCode"
    // stringSplosion("abc") -> "aababc"
    // stringSplosion("ab") -> "aab"
    
    @Test
    public void testSomeMethod1() {
        String expectedResult = "CCoCodCode";
        assertEquals(expectedResult, ss.stringSplosion("Code"));
    }
    
    @Test
    public void testSomeMethod2() {
        String expectedResult = "aababc";
        assertEquals(expectedResult, ss.stringSplosion("abc"));
    }
    
    @Test
    public void testSomeMethod3() {
        String expectedResult = "aab";
        assertEquals(expectedResult, ss.stringSplosion("ab"));
    }
    
}
