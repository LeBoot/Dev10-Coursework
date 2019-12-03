/**
 * @author Boone
 */
package com.tsguild.foundations.flowcontrol.ifs;

import java.util.Scanner;

public class PickyEater {
    public static void main(String[] args) {
        int timesFried, butterPats;
        String hasSpinach, cheeseCovered, chocolateCovered, funnyName, isBroccoli;
        
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("How many times has it been fried? (#) ");
            timesFried = Integer.parseInt(userInput.nextLine());
        System.out.println("Does it have spinach in it? (y/n) ");
            hasSpinach = userInput.nextLine();
        System.out.println("Doe it have cheese? (y/n) ");
            cheeseCovered = userInput.nextLine();
        System.out.println("How many pats of butter does it have? (#) ");
            butterPats = Integer.parseInt(userInput.nextLine()); 
        System.out.println("Is it covered in chocolate? (y/n) ");
            chocolateCovered = userInput.nextLine();
        System.out.println("Does it have a funny name? (y/n) ");
            funnyName = userInput.nextLine();
        System.out.println("Is it broccoli? (y/n) "); 
            isBroccoli = userInput.nextLine();
        
        if ((hasSpinach.equals("y")) || (funnyName.equals("y"))) {
            System.out.println("There's no way that'll get eaten.");
        }
        if (((timesFried > 2) && (timesFried < 4)) && (chocolateCovered.equals("y"))) {
            System.out.println("Oh, it's like a deep-fried Snickers. That'll be a hit!");
        }
        if ((timesFried == 2) && (cheeseCovered.equals("y"))) {
            System.out.println("Mmm. Yeah, fried cheesy doodles will get et.");
        }
        if (((isBroccoli.equals("y")) && (butterPats > 6)) && (cheeseCovered.equals("y"))) {
            System.out.println("As long as the green is hidden by cheddar, it'll happen!");
        }
        else if (isBroccoli.equals("y")) {
            System.out.println("Oh, green stuff like that might as well go in the bin.");
        }
    }
}