/**
 * @author Boone
 * This file contains two programs: 1) a static adder.  2) a user-input-driven adder.
 */
package bl.adder;

import java.util.Scanner;

//This is a static adder.
/*
    public class Adder {
        public static void main(String[] args){
            int sum;
            int operand1 = 3;
            int operand2 = 10;
            sum = operand1 + operand2;
            System.out.println("The sum is " + sum); 
        }
    }
*/

//This is a user-input-driven adder.
public class Adder {
    public static void main(String[] args){
        int sum;
        int operand1;
        int operand2;
        Scanner myScanner = new Scanner(System.in);
        String stringOperand1 = "";
        String stringOperand2 = "";
        System.out.println("Please enter first number: ");
            stringOperand1 = myScanner.nextLine();
            operand1 = Integer.parseInt(stringOperand1);
        System.out.println("Please enter second number: ");
            stringOperand2 = myScanner.nextLine();
            operand2 = Integer.parseInt(stringOperand2);
        sum = operand1 + operand2;
        System.out.println("The sum is " + sum); 
    }
}