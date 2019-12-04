/**
 * @author Boone
 */

import java.util.Scanner;

public class BirthStones {
    public static void main(String[] args) {
        int userInput;
        
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("In what month (1-12) were you born?");
        userInput = inputReader.nextInt();
        System.out.println("");
        System.out.println("Your birth stone is:");
        
        switch (userInput) {
            case 1:
                System.out.println("Garnet");
                break;
            case 2:
                System.out.println("Amethyst");
                break;
            case 3:
                System.out.println("Aquamarine");
                break;
            case 4:
                System.out.println("Diamond");
                break;
            case 5:
                System.out.println("Emerald");
                break;
            case 6:
                System.out.println("Pearl");
                break;
            case 7:
                System.out.println("Ruby");
                break;
            case 8:
                System.out.println("Peridot");
                break;
            case 9:
                System.out.println("Sapphire");
                break;
            case 10:
                System.out.println("Opal");
                break;
            case 11:
                System.out.println("Topaz");
                break;
            case 12:
                System.out.println("Turqoise");
                break;
            default:
                System.out.println("You're playing the game wrong.");
                break;
        }
    }
}
