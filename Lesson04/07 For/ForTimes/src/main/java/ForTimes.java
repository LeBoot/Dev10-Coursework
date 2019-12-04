/**
 * @author Boone
 */

import java.util.Scanner;

public class ForTimes {
    public static void main(String[] args ) {
      
        Scanner numScanner = new Scanner(System.in);
        
        System.out.print("For what number do you want to see a times table? ");
        int userNum = numScanner.nextInt();
        
        for (int i = 0; i < 16; i++) {
            System.out.println(i + " * " + userNum + " = " + (i*userNum));
        }
    }
}
