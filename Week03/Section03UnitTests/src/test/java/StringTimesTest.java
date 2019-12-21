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
public class StringTimesTest {
    
    StringTimes st = new StringTimes();
    
    public StringTimesTest() {
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
    public void testHi1() {
        String expectedResult = "Hi";
        assertEquals(expectedResult, st.stringTimes("Hi", 1));
    }
    
    @Test
    public void testHi2() {
        String expectedResult = "HiHi";
        assertEquals(expectedResult, st.stringTimes("Hi", 2));
    }
    
    @Test
    public void testHi3() {
        String expectedResult = "HiHiHi";
        assertEquals(expectedResult, st.stringTimes("Hi", 3));
    }
    
    @Test
    public void testYes1() {
        String expectedResult = "Yes";
        assertEquals(expectedResult, st.stringTimes("Yes", 1));
    }
    
    @Test
    public void testYes2() {
        String expectedResult = "YesYes";
        assertEquals(expectedResult, st.stringTimes("Yes", 2));
    }
    
    @Test
    public void testYes3() {
        String expectedResult = "YesYesYes";
        assertEquals(expectedResult, st.stringTimes("Yes", 3));
    }
    
}
