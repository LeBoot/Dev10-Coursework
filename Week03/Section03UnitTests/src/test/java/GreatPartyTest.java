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
public class GreatPartyTest {
    
    //instantiate the class to be tested
    GreatParty party = new GreatParty();
    
    public GreatPartyTest() {
    }

//    @org.junit.jupiter.api.BeforeAll
//    public static void setUpClass() throws Exception {
//    }
//
//    @org.junit.jupiter.api.AfterAll
//    public static void tearDownClass() throws Exception {
//    }
//
//    @org.junit.jupiter.api.BeforeEach
//    public void setUp() throws Exception {
//    }
//
//    @org.junit.jupiter.api.AfterEach
//    public void tearDown() throws Exception {
//    }
//    
//    @BeforeAll
//    public static void setUpClass() {
//    }
//    
//    @AfterAll
//    public static void tearDownClass() {
//    }
//    
//    @BeforeEach
//    public void setUp() {
//    }
//    
//    @AfterEach
//    public void tearDown() {
//    }
//
//    @org.junit.jupiter.api.Test
//    public void testSomeMethod() {
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
    
    //code that I am writing
    @Test
    public void test30False() {
        assertFalse(party.greatParty(30, false));
    }
    
    @Test
    public void test50False() {
        assertTrue(party.greatParty(50, false));
    }
    
    @Test
    public void test70true() {
        assertTrue(party.greatParty(70, true));
    }
    
    @Test
    public void test39true() {
        assertFalse(party.greatParty(39, true));
    }
    
    @Test
    public void test39false() {
        assertFalse(party.greatParty(39, false));
    }
    
    @Test
    public void test40true() {
        assertTrue(party.greatParty(40, true));
    }
    
    @Test
    public void test40false() {
        assertTrue(party.greatParty(40, false));
    }
    
    @Test
    public void test60true() {
        assertTrue(party.greatParty(60, true));
    }
    
    @Test
    public void test60false() {
        assertTrue(party.greatParty(60, false));
    }
    
    @Test
    public void test61true() {
        assertTrue(party.greatParty(61, true));
    }
    
    @Test
    public void test61false() {
        assertFalse(party.greatParty(61, false));
    }
}