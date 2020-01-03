/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Objects;
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
public class RotateLeftTest {
    
    RotateLeft rl = new RotateLeft();
    
    public RotateLeftTest() {
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

    
       // Given an array of ints, return an array with the elements 
    // “rotated left" so {1, 2, 3} yields {2, 3, 1}. 
    //
    // rotateLeft({1, 2, 3}) -> {2, 3, 1}
    // rotateLeft({5, 11, 9}) -> {11, 9, 5}
    // rotateLeft({7, 0, 0}) -> {0, 0, 7}

    @Test
    public void testSomeMethod() {
        int[] expectedArray = {2, 3, 1};
        int[] testArray = {1, 2, 3};
        int[] arrayFromMethod = rl.rotateLeft(testArray);
        for (int index = 0; index < arrayFromMethod.length; index++) {
            assertEquals(arrayFromMethod[index], expectedArray[index]);
        }         
    }
    
    @Test
    public void testSomeMethod2() {
        int[] expectedArray = {11, 9, 5};
        int[] testArray = {5, 11, 9};
        int[] arrayFromMethod = rl.rotateLeft(testArray);
        for (int index = 0; index < arrayFromMethod.length; index++) {
            assertEquals(arrayFromMethod[index], expectedArray[index]);
        }          
    }
    
    @Test
    public void testSomeMethod3() {
        int[] expectedArray = {0, 0, 7};
        int[] testArray = {7, 0, 0};
        int[] arrayFromMethod = rl.rotateLeft(testArray);
        for (int index = 0; index < arrayFromMethod.length; index++) {
            assertEquals(arrayFromMethod[index], expectedArray[index]);
        }   
    }
}
