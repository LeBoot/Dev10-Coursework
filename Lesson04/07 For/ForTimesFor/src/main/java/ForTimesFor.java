/**
 * @author Boone
 */

import java.util.Scanner;

public class ForTimesFor {
    public static void main(String[] args ) {
      
        int userAnswer;
        int score = 0;
        float scorePercentage;
        
        Scanner numScanner = new Scanner(System.in);
        
        System.out.print("For what number do you want a times table quiz? ");
        int userNum = numScanner.nextInt();
        
        for (int i = 0; i < 16; i++) {
            System.out.print(i + " * " + userNum + " = ");
            userAnswer = numScanner.nextInt();
            if (userAnswer == (i*userNum)) {
                System.out.println("Correct!");
                System.out.println("");
                score++;
            } else {
                System.out.println("Sorry, the correct answer was " + (i*userNum));
                System.out.println("");
            }
        }
        
        scorePercentage = (float) score / 16;
        
        System.out.println("");
        System.out.println("Your score is " + score + "/16, which is " + (100 * scorePercentage) + "%");
            
        if (scorePercentage <= .5) {
            System.out.println("You ought to study more.");
        }
        if (scorePercentage > .9) {
            System.out.println("Good Job!");
        }
    }
}
