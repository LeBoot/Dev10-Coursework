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
public class PlayOutsideTest {
    
    PlayOutside play = new PlayOutside();
    
    public PlayOutsideTest() {
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
    public void test70f() {
        assertTrue(play.playOutside(70, false));
    }
    
    @Test
    public void test95f() {
        assertFalse(play.playOutside(95, false));
    }
    
    @Test
    public void test95t() {
        assertTrue(play.playOutside(95, true));
    }
    
    @Test
    public void test59t() {
        assertFalse(play.playOutside(59, true));
    }
    
    @Test
    public void test59f() {
        assertFalse(play.playOutside(59, false));
    }
    
    @Test
    public void test60t() {
        assertTrue(play.playOutside(60, true));
    }
    
    @Test
    public void test60f() {
        assertTrue(play.playOutside(60, false));
    }
    
    @Test
    public void test90t() {
        assertTrue(play.playOutside(90, true));
    }
    
    @Test
    public void test90f() {
        assertTrue(play.playOutside(90, false));
    }
    
    @Test
    public void test91f() {
        assertFalse(play.playOutside(91, false));
    }
    
    @Test
    public void test100t() {
        assertTrue(play.playOutside(100, true));
    }
    
    @Test
    public void test101t() {
        assertFalse(play.playOutside(101, true));
    }
}