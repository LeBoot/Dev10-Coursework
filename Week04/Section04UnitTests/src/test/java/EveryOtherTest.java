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
public class EveryOtherTest {
    
    EveryOther other = new EveryOther();
    
    public EveryOtherTest() {
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

      // char starting with the first, so "Hello" yields "Hlo". 
    //
    // everyOther("Hello") -> "Hlo"
    // everyOther("Hi") -> "H"
    // everyOther("Heeololeo") -> "Hello"


    
    @Test
    public void testSomeMethod1() {
        String expectedResult = "Hlo";
        assertEquals(expectedResult, other.everyOther("Hello"));
    }
    
    @Test
    public void testSomeMethod2() {
        String expectedResult = "H";
        assertEquals(expectedResult, other.everyOther("Hi"));
    }
    
    @Test
    public void testSomeMethod3() {
        String expectedResult = "Hello";
        assertEquals(expectedResult, other.everyOther("Heeololeo"));
    }
}
