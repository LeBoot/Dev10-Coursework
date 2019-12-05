/**
 * @author Boone
 */

package com.tsguild.foundations.flowcontrol.whiles;

import java.util.Scanner;

public class RollerCoster { //Spelling error, I know

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        System.out.println("We're going to go on a roller coaster...");
        System.out.println("Let me know when you want to get off.");
        
        int loopsLooped = 0;
        
        /*
        String keepRiding = "y";
        while (keepRiding.equals("y")) {
            System.out.println("WHEEEEE!");
            System.out.print("Would you like to keep riding? (y/n) : ");
            keepRiding = userInput.nextLine();
            loopsLooped++;
        }
        */
        
        String getOff = "n";     
        while (getOff.equals("n")) {
            System.out.println("WHEEEE!");
            System.out.print("Would you like to get off? (y/n) :");
            getOff = userInput.nextLine();
            loopsLooped++;
        }
         
        
        System.out.println("Wow, that was FUN!");
        System.out.println("We looped that loop " + loopsLooped + " times!!");

    }
}