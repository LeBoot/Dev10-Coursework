/**
 * @author Boone
 */

import java.util.Scanner;

public class StayPositive {
    public static void main(String[] args) {
        
        String userNum;
        int userNumInt;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("From what number (positive integer) would you like me to count down? ");
        userNum = sc.nextLine();
        userNumInt = Integer.parseInt(userNum);
        
        if (userNumInt <= 0) {
            System.out.print("This game only works with a positive integer... follow instructions.");
        }
        
        while (userNumInt > 0) {
            System.out.print(userNumInt + " ");
            userNumInt--;
        }        
    } 
}
