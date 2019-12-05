/**
 * @author Boone
 */

import java.util.Random;

public class FortuneCookie {
    public static void main(String[] args) {
        Random rand = new Random();
        System.out.println("Have a Fortune Cookie!");
        System.out.println("Here's what it says:");
        
        int x = rand.nextInt(9);
        
        if (x == 0) {
            System.out.println("Those aren't the droids you're looking for.");
            System.out.println("Your number was " + x);
        }
        if (x == 1) {
            System.out.println("Goonies never say die.");
            System.out.println("Your number was " + x);
        }
        if (x == 2) {
            System.out.println("Never go in against a Sicilian when death is on the line!");
            System.out.println("Your number was " + x);
        }
        if (x == 3) {
            System.out.println("With great power there must also come great responsibility.");
            System.out.println("Your number was " + x);
        }
        if (x == 4) {
            System.out.println("Never argue with the data.");
            System.out.println("Your number was " + x);
        }
        if (x == 5) {
            System.out.println("No, I am your father.");
            System.out.println("Your number was " + x);
        }
        if (x == 6) {
            System.out.println("Try not. Do, or do not. There is no try.");
            System.out.println("Your number was " + x);
        }
        if (x == 7) {
            System.out.println("Do absolutely nothing, and it will be everything that you thought it could be.");
            System.out.println("Your number was " + x);
        }
        if (x == 8) {
            System.out.println("Kneel before Zod.");
            System.out.println("Your number was " + x);
        }
        if (x == 9) {
            System.out.println("Make it so.");
            System.out.println("Your number was " + x);
        }   
    }   
}