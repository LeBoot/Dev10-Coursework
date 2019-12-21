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
public class FrontTimesTest {
    
    FrontTimes ft = new FrontTimes();
    
    public FrontTimesTest() {
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

    // frontTimes("Chocolate", 2) -> "ChoCho"
    // frontTimes("Chocolate", 3) -> "ChoChoCho"
    // frontTimes("Abc", 3) -> "AbcAbcAbc"
    // ("abc" 0) --> ""
    // ("ab" 2) --> "abab"
    
    @Test
    public void testChocolate2() {
        String expectedResult = "ChoCho";
        assertEquals(expectedResult, ft.frontTimes("Chocolate", 2));
    }
    
    @Test
    public void testChocolate3() {
        String expectedResult = "ChoChoCho";
        assertEquals(expectedResult, ft.frontTimes("Chocolate", 3));
    }
    
    @Test
    public void testAbc3() {
        String expectedResult = "AbcAbcAbc";
        assertEquals(expectedResult, ft.frontTimes("Abc", 3));
    }
    
    @Test
    public void testabc0() {
        String expectedResult = "";
        assertEquals(expectedResult, ft.frontTimes("abc", 0));
    }
    
    @Test
    public void testAb2() {
        String expectedResult = "AbAb";
        assertEquals(expectedResult, ft.frontTimes("Ab", 2));
    }
}
