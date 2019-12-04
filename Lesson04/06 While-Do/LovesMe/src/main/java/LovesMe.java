/**
 * @author Boone
 */

import java.util.Random;

public class LovesMe {
    public static void main(String[] args) {
        
        Random rNumGen = new Random();
        int petals = rNumGen.nextInt((89-13) + 1) + 13;
        int petalsInitial = petals;
        
        while (petals > 0) {
            System.out.println("He loves me.");
            petals--;
            if (petals == 0) {
                System.out.println(" ");
                System.out.println("Yay, he loves me! I win!!");
            }
            else {
                System.out.println("He loves me not.");
                petals--;
                if (petals == 0) {
                    System.out.println(" ");
                    System.out.println("Oh no!  He doesn't love me!");
                }
            }
        }
        
        System.out.println(" ");
        System.out.println("Game Over.");
        System.out.println("Your daisy had " + petalsInitial + " petals.");
                       
    }
}
