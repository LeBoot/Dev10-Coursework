/**
 * @author Boone
 */

import java.util.Scanner;

public class YourLifeInMovies {
    public static void main(String[] args) {
        String userName;
        int userYear;
        
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("What is your name? ");
        userName = inputReader.nextLine();
       
        System.out.println("Hello, " + userName + ".  In what year were you born?");
        userYear = Integer.parseInt(inputReader.nextLine());
        
        if (userYear < 2005) {
            System.out.println("Pixar's 'Up' came out half a decade ago.");
        }
        if (userYear < 1995) {
            System.out.println("The first Harry Potter came out over 15 years ago.");
        }
        if (userYear < 1985) {
            System.out.println("Space Jam came out not last decade, but the one before THAT.");
        }
        if (userYear < 1975) {
            System.out.println("The original Jurassic Park release is closer to the date of the first lunar landing than it is to today.");
        }
        if (userYear < 1965) {
            System.out.println("The MASH TV series has been around for almost half a century!");
        }       
    }
}