/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.interestcalculatorrefactoredbd;

import java.math.BigDecimal;

/**
 *
 * @author Boone
 */
public class App {
    public static void main(String[] args) {
        InterestCalculator iCalc = new InterestCalculator();
    
        BigDecimal P = iCalc.obtainValueFromUser("principle (in dollars): ");
        BigDecimal r = iCalc.obtainValueFromUser("rate (as a decimal): ");
        BigDecimal n = iCalc.obtainValueFromUser("number of compoundings per year (as a whole number): ");
        BigDecimal t = iCalc.obtainValueFromUser("amount of years for which to invest: ");
        
        iCalc.printSummaryOfInput(P, r, n, t);
        System.out.println("");
        iCalc.printSummaryYear1(P, r, n);
        System.out.println("");
        iCalc.printSummaryYearT(P, r, n, t);
                
    }
}