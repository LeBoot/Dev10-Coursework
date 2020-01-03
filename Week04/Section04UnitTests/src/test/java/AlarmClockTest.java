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
public class AlarmClockTest {
    
    AlarmClock ac = new AlarmClock();
    
    public AlarmClockTest() {
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
    public void testSomeMethod() {
    }
    
        // Given a day of the week encoded as 
    // 0=Sun, 1=Mon, 2=Tue, ...6=Sat, and a boolean indicating 
    // if we are on vacation, return a String of the form "7:00" 
    // indicating when the alarm clock should ring. Weekdays, the 
    // alarm should be "7:00" and on the weekend it should be "10:00". 
    // Unless we are on vacation -- then on weekdays it should be 
    // “10:00" and weekends it should be "off". 
    //ac(5, true) -> 10
    //ac(5, false) -> 7
    //ac(60, true) -> off
    //ac(60, false) -> 10
    @Test
    public void oneTrue() {
        String expectedResult = "10:00";
        assertEquals(expectedResult, ac.alarmClock(1, true));
    }
    @Test
    public void oneFalse() {
        String expectedResult = "7:00";
        assertEquals(expectedResult, ac.alarmClock(1, false));
    }
    
    @Test
    public void fiveTrue() {
        String expectedResult = "10:00";
        assertEquals(expectedResult, ac.alarmClock(5, true));
    }
    @Test
    public void fiveFalse() {
        String expectedResult = "7:00";
        assertEquals(expectedResult, ac.alarmClock(5, false));
    }
    
    @Test
    public void zeroTrue() {
        String expectedResult = "off";
        assertEquals(expectedResult, ac.alarmClock(0, true));
    }
    @Test
    public void zeroFalse() {
        String expectedResult = "10:00";
        assertEquals(expectedResult, ac.alarmClock(0, true));
    }  
    
    @Test
    public void sixTrue() {
        String expectedResult = "off";
        assertEquals(expectedResult, ac.alarmClock(6, true));
    }
    @Test
    public void sixFalse() {
        String expectedResult = "10:00";
        assertEquals(expectedResult, ac.alarmClock(6, false));
    } 

}
