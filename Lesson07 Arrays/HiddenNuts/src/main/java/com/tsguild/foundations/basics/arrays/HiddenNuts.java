/**
 * @author Boone
 */

package com.tsguild.foundations.basics.arrays;

import java.util.Random;

public class HiddenNuts {
    public static void main(String[] args) {
        
        String[] hidingSpots = new String[100];
        Random squirrel = new Random();
        int randIndex = squirrel.nextInt(hidingSpots.length);
        hidingSpots[randIndex] = "Nut";
        System.out.println("The nut has been hidden...");
        
        for (int i = 0; i < hidingSpots.length; i++) {
            if (hidingSpots[i] == null) {
                //System.out.println("Index " + i + " is null.");
            } else if (hidingSpots[i].equals("Nut")) {
                System.out.println("The nut is in array index " + i);
                break;
            }
        }
    }
}