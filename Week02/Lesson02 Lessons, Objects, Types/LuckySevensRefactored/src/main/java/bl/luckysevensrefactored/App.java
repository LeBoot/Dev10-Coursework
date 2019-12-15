package bl.luckysevensrefactored;

import java.util.ArrayList;

/**
 *
 * @author Boone
 */
public class App {
    public static void main(String[] args) {
        LuckySevens ls = new LuckySevens();
        
        double userBet = ls.getUserInput(); //ask user for starting bet
        
        ArrayList<Double> moneyHeldArrayList = new ArrayList<>(); //create ArrayList to record money
        moneyHeldArrayList.add(userBet); //add the initial amount to ArrayList
        while (userBet >= 1) { //play the game
            int sum = ls.rollDice(); //roll dice
            if (sum == 7) {
                userBet += 4; //increase purse
            } else {
                userBet--; //decrease purse
            }
            moneyHeldArrayList.add(userBet); //add amount after round to ArrayList
        }
        
        double[] moneyHeldArray = ls.buildArray(moneyHeldArrayList);
        
        double max = ls.findMax(moneyHeldArray);
        
        int indexOfMax = ls.findIndexOfMax(max, moneyHeldArray);
        
        ls.printResults(moneyHeldArray, max, indexOfMax);
        
        //Just for me to see.
        System.out.println("");
        System.out.println(moneyHeldArrayList);
        
    }
}
