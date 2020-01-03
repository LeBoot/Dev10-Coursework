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
public class LongInMiddleTest {
    
    LongInMiddle mid = new LongInMiddle();
    
    public LongInMiddleTest() {
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

       // Given 2 Strings, a and b, return a String of the form 
    // short+long+short, with the shorter String on the outside 
    // and the longer String on the inside. The Strings will not 
    // be the same length, but they may be empty (length 0). 
    //
    // longInMiddle("Hello", "hi") -> "hiHellohi"
    // longInMiddle("hi", "Hello") -> "hiHellohi"
    // longInMiddle("aaa", "b") -> "baaab"
    
    @Test
    public void testSomeMethod1() {
        String expectedResult = "hiHellohi";
        assertEquals(expectedResult, mid.longInMiddle("hi", "Hello"));
    }
    @Test
    public void testSomeMethod2() {
        String expectedResult = "hiHellohi";
        assertEquals(expectedResult, mid.longInMiddle("Hello", "hi"));
    }
    @Test
    public void testSomeMethod3() {
        String expectedResult = "baaab";
        assertEquals(expectedResult, mid.longInMiddle("aaa", "b"));
    }
    
}
