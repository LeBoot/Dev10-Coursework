/**
 * @author Boone
 */

import java.util.Scanner;

public class TheCount {
    public static void main(String[] args ) {
      
        int userAnswerStart, userAnswerStop, userAnswerIncrement;
        int list = 0;
                
        Scanner numScanner = new Scanner(System.in);
        
        System.out.print("At what number do you want to begin counting? ");
            userAnswerStart = numScanner.nextInt();
        System.out.print("At what number do you want to stop counting? ");
            userAnswerStop = numScanner.nextInt();    
        System.out.print("By what increment do you want to count? ");
            userAnswerIncrement = numScanner.nextInt();
        System.out.println("");
        System.out.println("Here you go: ");
        
        for (int i = userAnswerStart; i < userAnswerStop + 1; i = i + userAnswerIncrement) {
            list++;
            System.out.print(i + "  ");
            if (list%3 == 0) {
                System.out.println("Ah ah ah!  I love to Count!");
            }
        }
    }
}