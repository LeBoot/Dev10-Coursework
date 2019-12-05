/**
 * @author Boone
 */

import java.util.Scanner;

public class DoItBetter {
    public static void main(String[] args) {
        int userMiles, userHotdogs, userLang;
        
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("How many miles can you run at one time? ");
        userMiles = inputReader.nextInt();
        System.out.println("That's cool, but I can run " + (userMiles * 2 + 1) + " miles.");
        
        System.out.println("How many hot dogs can you eat in ten minutes? ");
        userHotdogs = inputReader.nextInt();
        System.out.println("Not bad, but I can eat " + (userHotdogs * 2 + 1) + " hot dogs.");
        
        System.out.println("How many languages do you know? ");
        userLang = inputReader.nextInt();
        System.out.println("Nice!  But I know " + (userLang * 2 + 1) + " languages.");
    }
}

