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
public class MakePiTest {
    
    MakePi mpi = new MakePi();
    
    public MakePiTest() {
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

    
    // Return an int array length n containing the first n digits of pi.
    //
    // makePi(3) -> {3, 1, 4}


    @Test
    public void test3Pi() {
        int[] testArray = {3, 1, 4};
        for (int i = 0; i < 3; i++) {
            assertEquals(testArray[i], mpi.makePi(3)[i]);
        }
    }
    
    @Test
    public void test6Pi() {
        int[] testArray = {3, 1, 4, 1, 5, 9};
        for (int i = 0; i < 6; i++) {
            assertEquals(testArray[i], mpi.makePi(6)[i]);
        }
    }   
    
}
