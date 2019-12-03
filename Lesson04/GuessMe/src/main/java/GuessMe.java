/**
 * @author Boone
 */

import java.util.Scanner;

public class GuessMe {
    public static void main(String[] args) {
        String userChoiceString;
        int num1 = 40;
        
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("Pick a number. ");
        userChoiceString = inputReader.nextLine();
        
        int userChoice = Integer.parseInt(userChoiceString);
        
        if (userChoice == num1) {
            System.out.println("Wow, nice guess!  That was it!");
        }
        if (userChoice < num1) {
            System.out.println("Nice try, but you're too low.  I chose " + num1 + ".");
        }
        if (userChoice > num1) {
            System.out.println("Wrong!  You're too high.  I chose " + num1 + ".");
        }
        else {
            System.out.println("You're playing the game wrong.");
        }
    }  
}