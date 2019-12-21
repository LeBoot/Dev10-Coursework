/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.interestcalculatorrefactoredbd;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 *
 * @author Boone
 */
public class InterestCalculator {
    
    public void printSummaryOfInput(BigDecimal P, BigDecimal r, BigDecimal n, BigDecimal t) {
        BigDecimal PRound = P.setScale(2, RoundingMode.HALF_UP);
        BigDecimal rRound = r.setScale(2, RoundingMode.HALF_UP);
        BigDecimal nRound = n.setScale(0, RoundingMode.HALF_UP);
        BigDecimal tRound = t.setScale(2, RoundingMode.HALF_UP);
        
        System.out.println("\nYou chose to invest $" + PRound + " at an interest rate of " + rRound 
                + " (compounded " + nRound + " time(s) per year) for " + tRound + " years.");
    }
    
    public void printSummaryYear1(BigDecimal P, BigDecimal r, BigDecimal n) {
        BigDecimal one = new BigDecimal("1");
        BigDecimal nRound = n.setScale(0, RoundingMode.HALF_UP);        
        int nInt = nRound.intValue();
        
        BigDecimal intermediate1 = r.divide(nRound, 12, RoundingMode.HALF_UP).add(one);
        BigDecimal intermediate2 = intermediate1.pow(nInt).setScale(12, RoundingMode.HALF_UP);
        
        BigDecimal amountEndYear = P.multiply(intermediate2).setScale(12, RoundingMode.HALF_UP);
        BigDecimal amountEndYearRound = amountEndYear.setScale(2, RoundingMode.HALF_UP);
        BigDecimal profitEndYear = amountEndYear.subtract(P);
        BigDecimal profitEndYearRound = profitEndYear.setScale(2, RoundingMode.HALF_UP);
        
        System.out.println("At the end of the first year, your new amount of money is $" + amountEndYearRound + 
                ", which is a profit of $" + profitEndYearRound + ".");
    }
    
    public void printSummaryYearT(BigDecimal P, BigDecimal r, BigDecimal n, BigDecimal t) {
        BigDecimal one = new BigDecimal("1");
        BigDecimal nRound = n.setScale(0, RoundingMode.HALF_UP);        
        int nInt = nRound.intValue();
        
        BigDecimal intermediate1 = r.divide(nRound, 12, RoundingMode.HALF_UP).add(one);
        BigDecimal intermediate2 = n.multiply(t);
        int exponent = intermediate2.intValue();
        BigDecimal intermediate3 = intermediate1.pow(exponent).setScale(12, RoundingMode.HALF_UP);
        
        BigDecimal amountEndYearT = P.multiply(intermediate3).setScale(12, RoundingMode.HALF_UP);
        BigDecimal amountEndYearTRound = amountEndYearT.setScale(2, RoundingMode.HALF_UP);
        BigDecimal profitEndYearT = amountEndYearT.subtract(P);
        BigDecimal profitEndYearTRound = profitEndYearT.setScale(2, RoundingMode.HALF_UP);
        
        System.out.println("At the end of the last year, your new amount of money is $" + amountEndYearTRound
                + ", which is a profit of $" + profitEndYearTRound + ".");
    }

    public BigDecimal obtainValueFromUser(String prompt) {
        Scanner sc = new Scanner(System.in);
        
        BigDecimal bd = new BigDecimal("0");
        boolean isInputGood;
        do {
            try {
                System.out.println("Plese enter the " + prompt);
                String userInput = sc.nextLine();
                bd = new BigDecimal(userInput);
                isInputGood = true;
            } catch (NumberFormatException e) {
                System.out.println("You must enter a number.");
                isInputGood = false;
            }
        } while (!isInputGood);
        return bd;
    }
}