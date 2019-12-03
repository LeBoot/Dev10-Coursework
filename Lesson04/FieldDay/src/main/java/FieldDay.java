/**
 * @author Boone
 */

import java.util.Scanner;

public class FieldDay {
    public static void main(String[] args) {
        int timesFried, butterPats;
        String s1 = "baggins";
        String s2 = "dresden";
        String s3 = "howl";
        String s4 = "potter";
        String s5 = "vimes";
        String userName;
        String userNameCorr;
        
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("What is your last name?");        
        userName = userInput.nextLine();
        userNameCorr = userName.toLowerCase();
        
        if (userNameCorr.compareTo(s1) < 0) {
            System.out.println("You have been assigned to RED DRAGONS.");
        }
        else if ((userNameCorr.compareTo(s1) >= 0) && (userNameCorr.compareTo(s2) < 0)) {
            System.out.println("You have been assigned to DARK WIZARDS.");
        }
        else if ((userNameCorr.compareTo(s2) >= 0) && (userNameCorr.compareTo(s3) < 0)) {
            System.out.println("You have been assigned to MOVING CASTLES.");
        }
        else if ((userNameCorr.compareTo(s3) >= 0) && (userNameCorr.compareTo(s4) < 0)) {
            System.out.println("You have been assigned to GOLDEN SNITCHES.");
        } 
        else if ((userNameCorr.compareTo(s4) >= 0) && (userNameCorr.compareTo(s5) < 0)) {
            System.out.println("You have been assigned to NIGHT GUARDS.");
        }
        else if (userNameCorr.compareTo(s5) >= 0 ) {
            System.out.println("You have been assigned to BLACK HOLES.");
        }
        else {
            System.out.println("Whoops, the programmer overlooked something.");
        }
    }
}