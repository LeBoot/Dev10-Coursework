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
public class MakeTagsTest {
    
    MakeTags mt = new MakeTags();
    
    public MakeTagsTest() {
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

    
        // The web is built with HTML Strings like "<i>Yay</i>" which 
    // draws Yay as italic text. In this example, the "i" tag makes 
    // <i> and </i> which surround the word "Yay". Given tag and word 
    // Strings, create the HTML String with tags around the word, e.g. 
    // “<i>Yay</i>". 
    //
    // makeTags("i", "Yay") -> "<i>Yay</i>"
    // makeTags("i", "Hello") -> "<i>Hello</i>"
    // makeTags("cite", "Yay") -> "<cite>Yay</cite>"

    @Test
    public void testiYay() {
        String toTest = "<i>Yay</i>";
        assertEquals(toTest, mt.makeTags("i", "Yay"));
    }
    
    @Test
    public void testiHello() {
        String toTest = "<i>Hello</i>";
        assertEquals(toTest, mt.makeTags("i", "Hello"));
    }
    
    @Test
    public void testciteYay() {
        String toTest = "<cite>Yay</cite>";
        assertEquals(toTest, mt.makeTags("cite", "Yay"));
    }
    
}
