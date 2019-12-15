/**
 * @author Boone
 */

import java.text.DecimalFormat;
import java.util.Scanner;

public class HealthyHearts {
    public static void main(String[] args) {
        int userAge, maxHR;
        
        Scanner inputReader = new Scanner(System.in);
        
        do { //check that input is a positive integer
            System.out.print("What is your age in years (must be a positive integer)? "); //initial prompt
            while (!inputReader.hasNextInt()) { //while input is not an integer
                System.out.print("What is your age in years (must be a positive integer)? "); //ask again
                inputReader.next(); //give the user a chance to respond; without this, infinite question loop!
            }
            userAge = inputReader.nextInt(); //now that an integer has been entered, store it as userAge
        } while (userAge < 0); //repeat the loop if the input was negative
        
        maxHR = 220 - userAge; //calculate max heart rate
        
        DecimalFormat df = new DecimalFormat("#.#"); //Rounds answers that might have long decimals
        
        //Print outputs
        System.out.println("\nYour maximum heart rate should be " + maxHR + " beats per minute.");
        System.out.println("Your target heart rate zone is " + df.format(.5 * maxHR) + " to " + df.format(.85 * maxHR) + " beats per minute.");
    }
}