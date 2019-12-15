/**
 * @author Boone
 */

import java.util.Random;

public class LazyTeenager {
    public static void main(String[] args) {
        Random randNumGen = new Random();
        int x = randNumGen.nextInt(100) + 1; //x = random number between 1 and 100
        int y = 0;
        int asks = 0;
        boolean willCleanRoom = false;
        
        do {
            System.out.println("Honey, please clean your room.  Don't make me tell you again.");
            if (x <= (5 + y)) { //5% chance that x is 5 or less; increase interval by 5 with each iteration.
                willCleanRoom = true;
            }
            y = (y + 5);
            asks++;
            if (asks > 21) {
                break;
            }
        } while (willCleanRoom == false);
        
        if (asks == 1) {
            System.out.print("Thanks for cleaning your room the first time I asked.");
        } else {
            System.out.println("Good God, that took me asking " + asks + " times!");
        }
    }  
}
