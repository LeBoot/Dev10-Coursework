/**
 * @author Boone
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Factorizor {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("What number would you like to factor? ");
        int userNum = sc.nextInt();
        int sumOfFactors = 0;
        ArrayList<Integer> listFactors = new ArrayList<>();
        
        for (int i = 1; i < userNum; i++) {
            if (userNum % i == 0) {
                listFactors.add(i);
            }
        }
        
        System.out.println("The factors of " + userNum + " are: ");
        System.out.println(listFactors);
        
        for (int i = 0; i < listFactors.size(); i++) {
            sumOfFactors = sumOfFactors + listFactors.get(i);
        }
        
        if (sumOfFactors == userNum) {
            System.out.println(userNum + " is a perfect number.");
        } else {
            System.out.println(userNum + " is not a perfect number.");
        }
        
        if (listFactors.size() == 1) {
            System.out.println(userNum + " is a prime number.");
        } else {
            System.out.println(userNum + " is not a prime number.");
        }

    }
}
