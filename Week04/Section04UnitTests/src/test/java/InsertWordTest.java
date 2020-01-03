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
public class InsertWordTest {
    
    InsertWord iw = new InsertWord();
    
    public InsertWordTest() {
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

        // Given an "out" String length 4, such as "<<>>", and a 
    // word, return a new String where the word is in the middle 
    // of the out String, e.g. "<<word>>".
    //
    // Hint: SubStrings are your friend here 
    //
    // insertWord("<<>>", "Yay") -> "<<Yay>>"
    // insertWord("<<>>", "WooHoo") -> "<<WooHoo>>"
    // insertWord("[[]]", "word") -> "[[word]]"
    
    @Test
    public void testSomeMethod1() {
        String expectedResult = "<<Yay>>";
        assertEquals(expectedResult, iw.insertWord("<<>>", "Yay"));
    }
    
    @Test
    public void testSomeMethod2() {
        String expectedResult = "<<WooHoo>>";
        assertEquals(expectedResult, iw.insertWord("<<>>", "WooHoo"));
    }
    
    @Test
    public void testSomeMethod3() {
        String expectedResult = "[[word]]";
        assertEquals(expectedResult, iw.insertWord("[[]]", "word"));
    }
    
}
