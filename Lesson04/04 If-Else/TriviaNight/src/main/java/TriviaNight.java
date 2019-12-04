/**
 * @author Boone
 */

import java.util.Scanner;

public class TriviaNight {
    public static void main(String[] args) {
        
        int ans1, ans2, ans3, ans4;
        int score = 0;
        
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("It's Trivia Night.  Ready or not, here it comes!");
        
        System.out.println("");
        System.out.println("QUESTION 1:");
        System.out.println("What is the Lowest Level Programming Language?");
        System.out.println("1) Source code");
        System.out.println("2) Assembly language");
        System.out.println("3) C#");
        System.out.println("4) Machine code");
        System.out.println("");
        System.out.println("What's your answer? ");
        ans1 = inputReader.nextInt();
        
        System.out.println("");
        System.out.println("QUESTION 2:");
        System.out.println("Website security CAPTCHA forms are descended from the work of which person?");
        System.out.println("1) Grace Hopper");
        System.out.println("2) Alan Turing");
        System.out.println("3) Charles Babbage");
        System.out.println("4) Larry Page");
        System.out.println("");
        System.out.println("What's your answer? ");
        ans2 = inputReader.nextInt();
        
        System.out.println("");
        System.out.println("QUESTION 3:");
        System.out.println("Which of these Sci-Fi Ships was once slated for a full-size replica in Las Vegas?");
        System.out.println("1) Serenity");
        System.out.println("2) Battlestar Galactica");
        System.out.println("3) USS Enterprise");
        System.out.println("4) Millennium Falcon");
        System.out.println("");
        System.out.println("What's your answer? ");
        ans3 = inputReader.nextInt();
        
        System.out.println("");
        if (ans1 == 4) {
            score++;
        }
        if (ans2 == 2) {
            score++;
        }
        if (ans3 == 3) {
            score++;
        }
        
        if ((score != 0) && (score != 3)) {
            System.out.println("Your score is " + score + "/3");
        }
        else {
            if (score == 0) {
                System.out.println("You got a score of zero.  Chance to redeem yourself?");
            }
            if (score == 3) {
                System.out.println("You got a perfect score.  Chance to make it better?");
            }
            System.out.println("Question 4: What is seven factorial (7!) ? ");
            ans4 = inputReader.nextInt();
            
            if (ans4 == 5040) {
                score++;
            }
            System.out.println("");
            System.out.println("Your score is " + score + "/3");
        }      
    }  
}
