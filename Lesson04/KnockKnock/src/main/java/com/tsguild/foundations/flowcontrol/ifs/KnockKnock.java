/**
 * @author Boone
 */

package com.tsguild.foundations.flowcontrol.ifs;

import java.util.Scanner;

public class KnockKnock {
    public static void main(String[] args) {
        String nameGuess, nameGuessCorr;

        Scanner inputReader = new Scanner(System.in);

        System.out.print("Knock Knock! Guess who!! ");
        nameGuess = inputReader.nextLine();
        nameGuessCorr = nameGuess.toLowerCase();
        
        if (nameGuessCorr.equals("marty mcfly")) { //Using nameGuess == "Marty McFly" throws an error because == and != cannot be used with strings
            System.out.println("That's right.  I'm back...");
            System.out.println("...from the future!");
        } else {
            System.out.println("Huh?  Do I look like " + nameGuess + "??");
        }
    }    
}