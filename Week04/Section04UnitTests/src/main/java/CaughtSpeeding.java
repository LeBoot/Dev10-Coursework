/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Boone
 */
public class CaughtSpeeding {
 // You are driving a little too fast, and a police 
    // officer stops you. Write code to compute the 
    // result, encoded as an int value: 0=no ticket, 
    // 1=small ticket, 2=big ticket. If speed is 60 or 
    // less, the result is 0. If speed is between 61 
    // and 80 inclusive, the result is 1. If speed is 
    // 81 or more, the result is 2. Unless it is your 
    // birthday -- on that day, your speed can be 5 
    // higher in all cases. 
    //
    // caughtSpeeding(60, false) → 0
    // caughtSpeeding(65, false) → 1
    //caughtSpeeding(65, true) → 0
    public int caughtSpeeding(int speed, boolean isBirthday) {
        int ticketSize = -1;
        if (speed <= 60) {
            ticketSize = 0;
        }
        else if ((speed >= 61) && (speed <= 65)) {
            if (isBirthday) {
                ticketSize = 0;
            } else {
                ticketSize = 1;
            }
        }
        else if (speed <= 80) {
            ticketSize = 1;
        }
        else if ((speed >= 81) && (speed <= 85)) {
            if (isBirthday) {
                ticketSize = 1;
            } else {
                ticketSize = 2;
            }
            
        }
        else {
            ticketSize = 2;
        }
        return ticketSize;
    }
   
}
