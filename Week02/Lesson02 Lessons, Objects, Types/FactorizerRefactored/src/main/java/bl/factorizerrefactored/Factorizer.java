package bl.factorizerrefactored;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Boone
 */

public class Factorizer {
    
    private int sumOfFactors;
    private ArrayList<Integer> listFactors;
    
    
    
    public int askAndScanInput() {
        System.out.print("What number would you like to factor? ");
        Scanner sc = new Scanner(System.in);
        int userNum = sc.nextInt();
        return userNum;
    }
    
    public ArrayList<Integer> buildAndPrintArrayList(int num1) {
        ArrayList<Integer> listFactors = new ArrayList<>();
        for (int i = 1; i < num1; i++) {
            if (num1 % i == 0) {
                listFactors.add(i);
            }
        }
        System.out.println("The factors of " + num1 + " are " + listFactors);
        return listFactors;
    }
    
    public int determineSum(ArrayList<Integer> arrayList1) {
        int sumOfFactors = 0;
        for (int i = 0; i < arrayList1.size(); i++) {
            sumOfFactors = sumOfFactors + arrayList1.get(i);
        }
        return sumOfFactors;
    }
    
    public void printPrime(int userNum, ArrayList<Integer> ArrayList1) {
        if (ArrayList1.size() == 1) {
            System.out.println(userNum + " is a prime number.");
        } else {
            System.out.println(userNum + " is not a prime number.");
        }
    }
    
    public void printPerfect(int userNum, int sumOfFactors) {
        if (sumOfFactors == userNum) {
            System.out.println(userNum + " is a perfect number.");
        } else {
            System.out.println(userNum + " is not a perfect number.");
        }
    }
    
    
}