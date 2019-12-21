
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Boone
 */
public class App {
    
    public static void main(String[] args) throws UnsupportedOperatrionException {
        Scanner sc = new Scanner(System.in);
        IntMath intMath = new IntMath();
        boolean isStillUsing = true;
        do {
            
            int num1 = 0;
            int num2 = 0;
            MathOperator operation = MathOperator.PLUS;
            
            //validate num1
            boolean isInt1Valid;
            do {
                try {
                    System.out.println("Enter the first integer: ");
                    num1 = Integer.parseInt(sc.nextLine());
                    isInt1Valid = true;
                } catch (NumberFormatException e) {
                    isInt1Valid = false;
                    System.out.println("You must enter an integer.  Try again.");
                }
            } while (!isInt1Valid);
            
            //validate num2
            boolean isInt2Valid;
            do {
                try {
                    System.out.println("Enter the second integer: ");
                    num2 = Integer.parseInt(sc.nextLine());
                    isInt2Valid = true;
                } catch (NumberFormatException e) {
                    isInt2Valid = false;
                    System.out.println("You must enter an integer.  Try again.");
                }
            } while (!isInt2Valid);
            
            //validate operation
            boolean isOpValid;
            do {
                try {
                    System.out.println("Enter the operation to perform ('plus', 'minus', 'multiply', 'divide'): ");
                    String operationStr = sc.nextLine().toUpperCase().trim();
                    operation = MathOperator.valueOf(operationStr);
                    isOpValid = true;
                } catch (IllegalArgumentException e) {
                    isOpValid = false;
                    System.out.println("That operation is not recognized.  Try again.");
                }
            } while (!isOpValid);                    
            
            switch (operation) {
                case PLUS:
                    System.out.println(intMath.calculate(MathOperator.PLUS, num1, num2));
                    break;
                case MINUS:
                    System.out.println(intMath.calculate(MathOperator.MINUS, num1, num2));
                    break;
                case MULTIPLY:
                    System.out.println(intMath.calculate(MathOperator.MULTIPLY, num1, num2));
                    break;
                case DIVIDE:
                    System.out.println(intMath.calculate(MathOperator.DIVIDE, num1, num2));
                    break;
                default:
                    System.out.println("Default case ran.");
                    break;
            }
            
            System.out.println("Continue? (y/n): ");
            String response = sc.nextLine();
            if (response.equals("n")) {
                isStillUsing = false;
            } else if (!response.equals("y")) {
                System.out.println("Whoopsi!  That command was not recognized... I'll assume you said 'y'!");
            }
                        
        } while (isStillUsing);
                
    }
     
}