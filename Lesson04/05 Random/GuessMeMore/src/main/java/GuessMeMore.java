/**
 * @author Boone
 */

import java.util.Scanner;
import java.util.Random;

public class GuessMeMore {
    public static void main(String[] args) {
        String userChoiceString, userChoiceString2;
        Random rGen = new Random();
        int num1 = rGen.nextInt(201) - 100; //random number between -100 and 100, using randomGeneratorName((max - min) + 1) + min
        int userChoice2;
        
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("Pick a number. ");
        userChoiceString = inputReader.nextLine();
        
        int userChoice = Integer.parseInt(userChoiceString);
        
        if (userChoice == num1) {
            System.out.println("Wow, nice guess!  That was it!");
        }
        else {
            if (userChoice < num1) {
                System.out.println("Nice try, but you're too low.  Guess Again: ");
                userChoiceString2 = inputReader.nextLine();
                userChoice2 = Integer.parseInt(userChoiceString2);
                
                if (userChoice2 == num1) {
                    System.out.println("Wow, nice guess!  That was it!");
                }
                else if (userChoice2 < num1) {
                    System.out.println("Nice try, but you're too low.  I chose " + num1 + ".");
                }
                else if (userChoice2 > num1) {
                    System.out.println("Wrong!  You're too high.  I chose " + num1 + ".");
                }
                else {
                    System.out.println("You're playing the game wrong.");
                }
            }
            if (userChoice > num1) {
                System.out.println("Wrong!  You're too high.  Guess Again: ");
                userChoiceString2 = inputReader.nextLine();
                userChoice2 = Integer.parseInt(userChoiceString2);
                
                if (userChoice2 == num1) {
                    System.out.println("Wow, nice guess!  That was it!");
                }
                else if (userChoice2 < num1) {
                    System.out.println("Nice try, but you're too low.  I chose " + num1 + ".");
                }
                else if (userChoice2 > num1) {
                    System.out.println("Wrong!  You're too high.  I chose " + num1 + ".");
                }
                else {
                    System.out.println("You're playing the game wrong.");
                }
            }
        }
    }
}