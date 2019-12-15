/**
 * @author Boone
 */

import java.util.Scanner;

public class HealthyHearts {
    public static void main(String[] args) {
        int userAge, maxHR;
        
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("What is your age (in years)? ");
        userAge = inputReader.nextInt();
        maxHR = 220 - userAge;
        
        System.out.println("Your maximum heart rate should be " + maxHR + " beats per minute.");
        System.out.println("Your target heart rate zone is " + (.5 * maxHR) + " to " + (.85 * maxHR) + " beats per minute.");
    } 
}