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
public class CountXXTest {
    
    CountXX count = new CountXX();
    
    public CountXXTest() {
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

    
    // Count the number of "xx" in the given String. We'll say 
    // that overlapping is allowed, so "xxx" contains 2 "xx".  
    //
    // countXX("abcxx") -> 1
    // countXX("xxx") -> 2
    // countXX("xxxx") -> 3
    // countXX("abcd") -> 0
    // countXX("xxabcdxx") -> 2
    // countXX("xxabcdxxx") -> 3
    
    @Test
    public void testabcxx() {
        assertEquals(1, count.countXX("abcxx"));
    }
    
    @Test
    public void testxxx() {
        assertEquals(2, count.countXX("xxx"));
    }
    
    @Test
    public void testxxxx() {
        assertEquals(3, count.countXX("xxxx"));
    }
    
    @Test
    public void testabcd() {
        assertEquals(0, count.countXX("abcd"));
    }
    
    @Test
    public void testxxabcdxx() {
        assertEquals(2, count.countXX("xxabcdxx"));
    }
    
    @Test
    public void testxxabcdxxx() {
        assertEquals(3, count.countXX("xxabcdxxx"));
    }
    
}
