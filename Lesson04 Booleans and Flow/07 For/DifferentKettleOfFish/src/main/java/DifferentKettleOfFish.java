/**
 * @author Boone
 */

//This is the version with the WHILE LOOP.
/* 
public class DifferentKettleOfFish {
    public static void main(String[] args) {
        
        int fish = 1;
        while (fish < 10) {
            if (fish == 3) {
                System.out.println("RED fish!");
            } else if (fish == 4) {
                System.out.println("BLUE fish!");
            } else {
                System.out.println(fish + " fish!");
            }
            
            fish++;
        }
    }  
}
*/

//This is the version with the FOR LOOP.
public class DifferentKettleOfFish {
    public static void main(String[] args) {
        
        for (int fish = 1; fish < 10; fish++) {
            switch (fish) {
                case 3:
                    System.out.println("RED fish!");
                    break;
                case 4:
                    System.out.println("BLUE fish!");
                    break;
                default:
                    System.out.println(fish + " fish!");
                    break;
            }
        }
    }
}