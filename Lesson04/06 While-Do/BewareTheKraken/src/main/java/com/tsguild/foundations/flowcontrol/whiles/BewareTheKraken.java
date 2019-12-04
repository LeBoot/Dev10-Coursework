/**
 * @author Boone
 */

package com.tsguild.foundations.flowcontrol.whiles;

import java.util.Scanner;
import java.util.Random;

public class BewareTheKraken {
    public static void main(String[] args) {
        
        String keepGoing, randFish;
        Scanner inputReader = new Scanner(System.in);
        
        Random randNumGen = new Random();
        
        System.out.println("Get ready!  Get those flippers and wetsuit on.   We're going diving!");
        System.out.println("Here we... weee... *SPLASH*");
        System.out.println("");
        
        int depthDivedInFt = 0;
        
        while (depthDivedInFt < 36200) { //because the ocean is only 36200 feet deep at its deepest.
            System.out.println("So far, we've swum " + depthDivedInFt + " feet.");
            
            if (depthDivedInFt >= 20000) {
                System.out.println("Uh oh, I think I see the Kraken...");
                System.out.println("Time to Go!");
                break;
            }
            
            int randFishInt = randNumGen.nextInt(3);
            switch (randFishInt) {
                case 0:
                    randFish = "Catfish";
                    break;
                case 1:
                    randFish = "Whale";
                    break;
                default:
                    randFish = "Angler";
                    break;
            }
                
            System.out.println("Ooo, look, it's a " + randFish);
            System.out.print("Do you want to keep diving? (y/n) : ");
            keepGoing = inputReader.next();
            System.out.println("");
            if (keepGoing.equals("n")) {
                break;
            }
            
            depthDivedInFt += 2000;
        }
        
        System.out.println("");
        System.out.println("We ended up swimming " + depthDivedInFt + " feet down.");
        System.out.println("I bet we can do better next time!");
    }
    
}