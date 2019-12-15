package bl.simplecaclulator;

/**
 *
 * @author Boone
 */
import java.util.Scanner;

public class SimpleCaclulator {
    
    Scanner sc = new Scanner(System.in);
    
    public void welcomeMessage() {
        System.out.println("Hello, welcome to the SIMPLE CALCULATOR.");
        System.out.println("\nYou have four options: Addition, Subtraction, Multiplication, and Division.");
        System.out.println("Enter '1' for Addition,");
        System.out.println("Enter '2' for Subtraction,");
        System.out.println("Enter '3' for Multiplication,");
        System.out.println("Enter '4' for Division.");
        System.out.println("Enter '5' to exit the program");
        System.out.println("");
    }
    
    public int getChoice() {
        System.out.print("What would you like to do? (1, 2, 3, or 4) ");
        String userChoice = sc.next();
        int userChoiceInt = Integer.parseInt(userChoice);
        switch (userChoiceInt) {
            case 1:
                System.out.println("You've chosen addition.");
                break;
            case 2:
                System.out.println("You've chosen subtraction.");
                break;
            case 3:
                System.out.println("You've chosen multiplication.");
                break;
            case 4:
                System.out.println("You've chosen division.");
                break;
            default:
                System.out.println("You must choose one of the choices.");
                break;
        }
        System.out.println("");
        return userChoiceInt; 
    }
    
    public int[] askNumbersIn(int userChoice) {
        int[] inputArray = new int[2];
        System.out.println("Use the following to direct your entries:.");
        switch (userChoice) {
            case 1:
                System.out.println("num3 = num1 + num2");
                break;
            case 2:
                System.out.println("num3 = num1 - num2");
                break;
            case 3:
                System.out.println("num3 = num1 * num2");
                break;
            case 4:
                System.out.println("num3 = num1 / num2");
                break;
            default:
                System.out.println("Error 2");
                break;
        }
        System.out.print("What is 'num1'? ");
        String userNum1 = sc.next();
        int userNum1Int = Integer.parseInt(userNum1);
        inputArray[0] = userNum1Int;
        
        System.out.print("What is 'num2'? ");
        String userNum2 = sc.next();
        int userNum2Int = Integer.parseInt(userNum2);
        inputArray[1] = userNum2Int;
        
        return inputArray;
    }
      
    public void printAnswer(int userChoice, int num1, int num2, double answer){
        System.out.println("");
        switch (userChoice) {
            case 1:
                System.out.println(num1 + " + " + num2 + " = " + answer);
                break;
            case 2:
                System.out.println(num1 + " - " + num2 + " = " + answer);
                break;
            case 3:
                System.out.println(num1 + " * " + num2 + " = " + answer);
                break;
            case 4:
                System.out.println(num1 + " / " + num2 + " = " + answer);
                break;
            default:
                System.out.println("Error 3");
                break;
        }
    }
          
    public boolean playAgain() {
        boolean bool1;
        System.out.println("");
        System.out.print("Would you like to play again? (y/n) ");
        String response = sc.next();
        if (response.equals("y")) {
            bool1 = true;
        } else {
            bool1 = false;
        }
        System.out.println("");
        return bool1;
    }
    
    public void printGoodbye() {
        System.out.println("");
        System.out.println("Goodbye.  Thanks for using this program.");
    }
    
    public double addition(int num1, int num2) {
        double num3 = num1 + num2;
        return num3;
    }
    
    public double subtraction(int num1, int num2) {
        double num3 = num1 - num2;
        return num3;
    }
    
    public double division(int num1, int num2) {
        double num3 = num1 / num2;
        return num3;
    }
    
    public double multiplication(int num1, int num2) {
        double num3 = num1 * num2;
        return num3;
    }
    
}
