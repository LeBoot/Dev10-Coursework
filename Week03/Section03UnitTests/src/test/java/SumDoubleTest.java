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
public class SumDoubleTest {
    
    SumDouble sd = new SumDouble();
    
    public SumDoubleTest() {
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
    public void testOneTwo() {
        int answerToTest = 3;
        assertEquals(answerToTest, sd.sumDouble(1, 2));
    }
    
    @Test
    public void testThreeTwo() {
        int answerToTest = 5;
        assertEquals(answerToTest, sd.sumDouble(3, 2));
    }
    
    @Test
    public void testTwoTwo() {
        int answerToTest = 8;
        assertEquals(answerToTest, sd.sumDouble(2, 2));
    }
    
    @Test
    public void testThreeThree() {
        int answerToTest = 12;
        assertEquals(answerToTest, sd.sumDouble(3, 3));
    }

}
