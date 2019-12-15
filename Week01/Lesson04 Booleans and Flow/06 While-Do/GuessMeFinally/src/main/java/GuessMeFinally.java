/**
 * @author Boone
 */

import java.util.Scanner;
import java.util.Random;

public class GuessMeFinally {
    public static void main(String[] args) {
        String userChoiceString;
        int userChoice, num1;
        int numTries = 1;
               
        
        Random rGen = new Random();
        num1 = rGen.nextInt(201) - 100; //random number between -100 and 100, using randomGeneratorName((max - min) + 1) + min
                
        Scanner inputReader = new Scanner(System.in);
        
        System.out.print("Pick a number between -100 and 100. ");
        userChoiceString = inputReader.next();
        userChoice = Integer.parseInt(userChoiceString);
        
        while (userChoice != num1) {
            if (userChoice > num1) {
                System.out.print("Your guess was too high.  Guess again, but lower: ");
                userChoiceString = inputReader.next();
                userChoice = Integer.parseInt(userChoiceString);
            } else {
                System.out.print("Your guess was too low.  Guess again, but higher: ");
                userChoiceString = inputReader.next();
                userChoice = Integer.parseInt(userChoiceString);
            }
            numTries++;
        }
        
        System.out.println("");
        System.out.println("Good Job!  You guessed the number, which, of course, was " + num1 + ".");
        System.out.println("It took you " + numTries + " tries.");
   
    }
}