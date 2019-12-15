package bl.simplecalculator2;

import java.util.Scanner;

/**
 *
 * @author Boone
 */
public class SimpleCalculator2 {
    
    Scanner sc = new Scanner(System.in);
    
    public void welcomeMessage() {
        System.out.println("Hello, welcome to the Ben's SIMPLE CALCULATOR.");
        System.out.println("\nThere are four options: Addition, Subtraction, Multiplication, and Division.");
        System.out.println("Enter '1' for Addition,");
        System.out.println("Enter '2' for Subtraction,");
        System.out.println("Enter '3' for Multiplication,");
        System.out.println("Enter '4' for Division.");;
        System.out.println("");
    }
    
    public String quit() {
        System.out.print("Do you want to quit? (y/n) ");
        String choice = sc.next();
        return choice;
    }
    
    public int askOperation() {
        System.out.print("What would you like to do? (1, 2, 3, or 4) ");
        String userChoice = sc.next();
        int userChoiceInt = Integer.parseInt(userChoice);
        return userChoiceInt;
    }
    
    public double[] getNumbers(int int1) {
        switch (int1) {
            case 1:
                instructions("addition", "+");
                break;
            case 2:
                instructions("subtraction", "-");
                break;
            case 3:
                instructions("multiplication", "*");
                break;
            case 4:
                instructions("division", "/");
                break;
        }
        double[] newArray = getNum1Num2();
        return newArray;
    }
    
    public static void instructions(String string1, String string2) {
        System.out.println("You have chosen " + string1 + ".");
        System.out.println("Please use the following as your guide: ");
        System.out.println("num1 " + string2 + " num2 = num3");        
    }
    
    public double[] getNum1Num2() {
        double[] array1 = new double[2];
                
        System.out.print("What is 'num1'? ");
        String userNum1 = sc.next();
        double userNum1Dbl = Double.parseDouble(userNum1);
        array1[0] = userNum1Dbl;
        
        System.out.print("What is 'num2'? ");
        String userNum2 = sc.next();
        double userNum2Dbl = Double.parseDouble(userNum2);
        array1[1] = userNum2Dbl;
        
        return array1;
    }
    
    public void performCalc(int userOperation, double num1, double num2) {
        double num3 = 0;
        String operator = "!";
        switch (userOperation) {
            case 1:
                num3 = num1 + num2;
                operator = " + ";
                break;
            case 2:
                num3 = num1 - num2;
                operator = " - ";
                break;
            case 3:
                num3 = num1 * num2;
                operator = " * ";
                break;
            case 4:
                num3 = num1 / num2;
                operator = " / ";
                break;
        }
        System.out.println(num1 + operator + num2 + " = " + num3);
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

}