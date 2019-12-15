package bl.interestcalculatorrefactored;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Boone
 */
public class InterestCalculator {
    
    Scanner sc = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("#.##");
    
    public double getPrinciple() {
        System.out.print("What is the principle amount (in dollars)? ");
        String PStr = sc.next();
        double numP = Double.parseDouble(PStr);
        return numP;
    }
    
    public double getRate() {
        System.out.print("What is the annual interest rate (as a decimal)? ");
        String rStr = sc.next();
        double numR = Double.parseDouble(rStr);
        return numR;
    }
    
    public double getCompounds() {
        System.out.print("How many times a year is interest compounded? ");
        String nStr = sc.next();
        double numN = Double.parseDouble(nStr);
        return numN;
    }
    
    public double getYears() {
        System.out.print("For how many years do you want to invest? ");
        String tStr = sc.next();
        double numT = Double.parseDouble(tStr);
        return numT;
    }
    
    public void printReview(double P, double r, double n, double t) {
        System.out.println("\nYou chose to invest $" + P + " at an interest rate of " + r 
                + " (compounded " + n + " time(s) per year) for " + t + " years.");
    }
    
    public void printResultsYear1(double P, double r, double n) {
        double amountEndYear = P * Math.pow(((1 + (r / n) )), n);
        String amountEndYearRounded = df.format(amountEndYear);;
        double profitEndYear = amountEndYear - P;
        String profitEndYearRounded = df.format(profitEndYear);
        System.out.println("At the end of the first year, your new amount of money is $" + amountEndYearRounded + 
                ", which is a profit of $" + profitEndYearRounded + ".");
    }
    
    public void printResultsYearT(double P, double r, double n, double t) {
        double amountEndYeart = P * Math.pow(((1 + (r / n) )), (n * t));
        String amountEndYeartRounded = df.format(amountEndYeart);
        double profitEndYeart = amountEndYeart - P;
        String profitEndYeartRounded = df.format(profitEndYeart);
        System.out.println("At the end of the last year, your new amount of money is $" + amountEndYeartRounded + 
                ", which is a profit of $" + profitEndYeartRounded + ".");
    }
    
}
    

        
        
