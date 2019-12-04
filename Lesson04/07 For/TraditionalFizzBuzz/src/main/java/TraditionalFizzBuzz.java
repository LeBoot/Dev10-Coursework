/**
 * @author Boone
 */

import java.util.Scanner;

public class TraditionalFizzBuzz {
    public static void main(String[] args) {
         
        int fizz = 0;
        int buzz = 0;
        int fizzbuzz = 0;
        int cycles = 0;
        int runningTotal = 0;
        
        
        Scanner numScanner = new Scanner(System.in);
        System.out.print("Pick a positive integer to which you'd like to count: ");
        int userNum = numScanner.nextInt();
        
        for (int i = 1; runningTotal < userNum; i++) {
            if (((i % 3) == 0) && ((i % 5) == 0)) {
                System.out.println("fizz buzz");
                fizzbuzz++;
            } else if (((i % 3) == 0) && ((i % 5) != 0)) {
                System.out.println("buzz");
                buzz++;
            } else if (((i % 3) != 0) && ((i % 5) == 0)) {
                System.out.println("fizz");
                fizz++;
            } else {
                System.out.println(i);  
            }
            runningTotal = fizzbuzz + fizz + buzz;
            cycles++;        
        } 
        System.out.println("\nTRADITION!");
    }
}