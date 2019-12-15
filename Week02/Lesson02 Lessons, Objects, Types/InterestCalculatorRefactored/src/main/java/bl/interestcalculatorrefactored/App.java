package bl.interestcalculatorrefactored;

/**
 *
 * @author Boone
 */

public class App {
    public static void main(String[] args) {
        InterestCalculator IC = new InterestCalculator();
        
        double P = IC.getPrinciple();
        double r = IC.getRate();
        double n = IC.getCompounds();
        double t = IC.getYears();
        
        IC.printReview(P, r, n, t);
        IC.printResultsYear1(P, r, n);
        IC.printResultsYearT(P, r, n, t);
  
    }    
}
