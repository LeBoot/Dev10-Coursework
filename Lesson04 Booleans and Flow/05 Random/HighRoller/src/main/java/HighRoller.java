/**
 * @author Boone
 */

import java.util.Random;
import java.util.Scanner;

public class HighRoller {
    public static void main(String[] args) {
        String userAnswerString;
        int userAnswerInt;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("How many sides do you want your die to have? ");
        userAnswerString = sc.nextLine();
        userAnswerInt = Integer.parseInt(userAnswerString);
        
        Random randGenerator = new Random();
        int randNum = randGenerator.nextInt(userAnswerInt) + 1;
        
        System.out.println("Your die has " + userAnswerInt + " sides,");
        System.out.println("and you rolled " + randNum);
        System.out.println("");
        
        if (randNum == 1) {
            System.out.println("You rolled a crit failure (1)... ouch!");
        }
        else if (randNum == userAnswerInt) {
            System.out.println("You rolled a critical.  Nice!");
        }
        else {
            System.out.println("You rolled neither a critical nor a crit failure.");
        }  
    }    
}