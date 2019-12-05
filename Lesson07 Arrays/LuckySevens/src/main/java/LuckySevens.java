/**
 * @author Boone
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.text.*;

public class LuckySevens {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Random randGen = new Random();
        
        System.out.print("How much money would you like to wager (in dollars)? ");
        String userWagerStr = sc.next();
        double userWagerDbl = Double.parseDouble(userWagerStr);
        
        int turns = 0;
        double max = 0;
        int indexOfMax = 0;
        ArrayList<Double> moneyHeldArrayList = new ArrayList<>();
        moneyHeldArrayList.add(userWagerDbl);
        
        while ((userWagerDbl >= 1) && (turns < 10000)) { //play the game
           
            int die1 = randGen.nextInt(6) + 1;
            int die2 = randGen.nextInt(6) + 1;
            int dieSum = die1 + die2;
            
            if (dieSum == 7) {
                userWagerDbl = userWagerDbl + 4;
            } else {
                userWagerDbl--;
            }
            moneyHeldArrayList.add(userWagerDbl);
            turns++;
        }
        
        double moneyHeldArray[] = new double[moneyHeldArrayList.size()];
        
        for (int i = 0; i < moneyHeldArrayList.size(); i++) { //conver array list to array
            moneyHeldArray[i] = moneyHeldArrayList.get(i);
        }
        
        for (int i = 0; i < moneyHeldArray.length; i++) { //What is the maximum amount earned?
            if (moneyHeldArray[i] > max) {
                max = moneyHeldArray[i];
            }
        }
        
        for (int i = 0; i < moneyHeldArray.length; i++) { //What is the index of the max?
            if (moneyHeldArray[i] == max) {
                indexOfMax = i;
            }
        }
        
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("\nYou played " + (moneyHeldArray.length - 1) + " round of Lucky Sevens.");
        System.out.println("The maximum amount of money that you ever earned was $" + df.format(max));
        System.out.println("You held that maximum amount after turn " + indexOfMax + ".");
        System.out.println("");
        System.out.println(moneyHeldArrayList);

    }
}