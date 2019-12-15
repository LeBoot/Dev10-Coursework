package bl.factorizerrefactored;

/**
 * @author Boone
 */

/*
This code works, but it is pretty haphazard. 
It needs to be refined when I have a better understanding of the best way to refactor using a different class.
*/

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        
        Factorizer myFactorizer = new Factorizer();
        
        int sumOfFactors = 0;
        
        int userNum = myFactorizer.askAndScanInput();
        ArrayList<Integer> ArrayList2 = myFactorizer.buildAndPrintArrayList(userNum);
        int sum = myFactorizer.determineSum(ArrayList2);
        myFactorizer.printPrime(userNum, ArrayList2);
        myFactorizer.printPerfect(userNum, sum);
        
    }  
}