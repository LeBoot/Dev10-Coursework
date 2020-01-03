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
public class FirstClassTest {
    
    FirstClass fc = new FirstClass();
    
    public FirstClassTest() {
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

        // Given a String of even length, return the first half. 
    // So the String "WooHoo" yields "Woo". 
    //
    // firstHalf("WooHoo") -> "Woo"
    // firstHalf("HelloThere") -> "Hello"
    // firstHalf("abcdef") -> "abc"

    
    @Test
    public void testSomeMethod1() {
        String expectedResult = "Woo";
        assertEquals(expectedResult, fc.firstHalf("WooHoo"));
    }
    
    @Test
    public void testSomeMethod2() {
        String expectedResult = "Hello";
        assertEquals(expectedResult, fc.firstHalf("HelloThere"));
    }
    
    @Test
    public void testSomeMethod3() {
        String expectedResult = "abc";
        assertEquals(expectedResult, fc.firstHalf("abcdef"));
    }
    
}
