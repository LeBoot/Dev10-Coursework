/**
 * @author Boone
 */

package com.tsguild.foundations.flowcontrol.whiles;

public class WaitAWhile {
    public static void main(String[] args) {
        int timeNow = 8;
        int bedTime = 10;
        
        while (timeNow < bedTime) {
            System.out.println("It's only " + timeNow + " O'clock!");
            System.out.println("I think I'll stay up just a little longer.");
            timeNow++;
        }
        
        System.out.println("Oh, it's " + timeNow + " O'clock.");
        System.out.println("Guess I should go to bed.");
    }
}