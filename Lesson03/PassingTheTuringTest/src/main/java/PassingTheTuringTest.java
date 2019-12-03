/**
 * @author Boone
 */

import java.util.Scanner;

public class PassingTheTuringTest {
    public static void main(String[] args) {
        String userName, userColor, userFruit;
        int userNum;
        
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("Hello, there!");
        
        System.out.println("What's your name?");
        userName = inputReader.nextLine();
        
        System.out.println("Hi, " + userName + "!  What's your favorite color?");
        userColor = inputReader.nextLine();
        
        System.out.println("Huh, " + userColor + "?  Mine's electric lime!");
        System.out.println("I really like limes.  They're my favorite fruit, too.");
        System.out.println("What's your favorite fruit, " + userName + "?");
        userFruit = inputReader.nextLine();
        
        System.out.println("Really? " + userFruit + "?  That's wild!");
        System.out.println("Speaking of favorites... what's your favorite number?");
        userNum = inputReader.nextInt();
        
        System.out.println(userNum + "is a cool number.  Mine's -7");
        System.out.println("Did you know that " + userNum + " * -7 is " + (userNum * -7) + "?  That's a cool number, too!");
        
        System.out.println("Well, thanks for listening to me, " + userName + ".");
        System.out.println("Bye, bye now!");
    }
}