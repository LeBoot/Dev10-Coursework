/**
 * @author Boone
 */

import java.util.Scanner;
import java.lang.Math;

public class InterestCalculator {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("What is the principle amount (in dollars)? ");
        String PStr = sc.next();
        double P = Double.parseDouble(PStr);
        
        System.out.print("What is the annual interest rate (as a decimal)? ");
        String rStr = sc.next();
        double r = Double.parseDouble(rStr);
        
        System.out.print("How many times a year is interest compounded? ");
        String nStr = sc.next();
        double n = Double.parseDouble(nStr);
        
        System.out.print("For how many years do you want to invest? ");
        String tStr = sc.next();
        double t = Double.parseDouble(tStr);
        
        double amountEndYear = P * Math.pow(((1 + (r / n) )), n);
        double profitEndYear = amountEndYear - P;
        double amountEndYeart = P * Math.pow(((1 + (r / n) )), (n * t));
        double profitEndYeart = amountEndYeart - P;
        
        System.out.println("\nYou chose to invest $" + P + " at an interest rate of " + r 
                + " (compounded " + n + " time(s) per year) for " + t + " years.");
        System.out.println("At the end of the first year, your new amount of money is $" + amountEndYear + 
                ", which is a profit of $" + profitEndYear + ".");
        System.out.println("At the end of the last year, your new amount of money is $" + amountEndYeart + 
                ", which is a profit of $" + profitEndYeart + ".");
    }
}