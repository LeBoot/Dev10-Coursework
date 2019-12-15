/**
 * @author Boone
 */
package com.tsguild.foundations.scanner;

import java.util.Scanner;

public class DontForgetToStoreIT {
    public static void main(String[] args) {
        int meaningOfLifeAndEverything = 42;
        double pi = 3.14159;
        String cheese, color;
        
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("Give me pi to at least 5 decimal palces: ");
        pi = inputReader.nextDouble();
        
        System.out.println("What is the meaning of life, the universe, and everything? ");
        meaningOfLifeAndEverything = inputReader.nextInt();
        
        System.out.println("What is your favorite kind of cheese? ");
        cheese = inputReader.next();
        
        System.out.println("Which color do you like more: red or blue? ");
        color = inputReader.next();
        
        System.out.println("Color: " + color);
        System.out.println("Cheese: " + cheese);
        System.out.println("pi: " + pi);
        System.out.println("meaningOfLifeAndEverything: " + meaningOfLifeAndEverything);
        
        //System.out.println("Ooh, " + color + " " + cheese +" sounds delicious!");
        //System.out.println("The circumference of life is " +( 2 * pi * meaningOfLifeAndEverything)); 
    }
}





