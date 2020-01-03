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
public class TrimOneTest {
    
    TrimOne trim = new TrimOne();
    
    public TrimOneTest() {
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

        // Given a String, return a version without the first and 
    // last char, so "Hello" yields "ell". The String length will be at least 2. 
    //
    // trimOne("Hello") -> "ell"
    // trimOne("java") -> "av"
    // trimOne("coding") -> "odin"
    
    @Test
    public void testSomeMethod1() {
        String expectedResult = "ell";
        assertEquals(expectedResult, trim.trimOne("Hello"));
    }
    
    @Test
    public void testSomeMethod2() {
        String expectedResult = "av";
        assertEquals(expectedResult, trim.trimOne("Java"));
    }
    
    @Test
    public void testSomeMethod3() {
        String expectedResult = "odin";
        assertEquals(expectedResult, trim.trimOne("Coding"));
    }
    
}
