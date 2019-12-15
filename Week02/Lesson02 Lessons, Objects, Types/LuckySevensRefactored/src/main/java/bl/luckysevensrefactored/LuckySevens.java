package bl.luckysevensrefactored;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Boone
 */
public class LuckySevens {
    
    public double getUserInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("How much money would you like to wager (in dollars)? ");
        String userWagerStr = sc.next();
        double userWagerDbl = Double.parseDouble(userWagerStr);
        return userWagerDbl;
    }
    
    public int rollDice() {
        Random randGen = new Random();
        int die1 = randGen.nextInt(6) + 1;
        int die2 = randGen.nextInt(6) + 1;
        int dieSum = die1 + die2;
        return dieSum;
    }
    
    public double[] buildArray(ArrayList<Double> arrayList) {
        double newArray[] = new double[arrayList.size()]; //make an array that is the size of the array list
        for (int i = 0; i < arrayList.size(); i++) { //conver array list to array
            newArray[i] = arrayList.get(i);
        }
        return newArray;
    }
    
    public double findMax(double[] array1) { //What is the maximum amount earned?
        double max = 0;
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] > max) {
                max = array1[i];
            }
        }
        return max;
    }
    
    public int findIndexOfMax(double max, double[] array1) { //What is the index of the max?
        int indexOfMax = 0;
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == max) {
                indexOfMax = i;
                break;
            }
        }
        return indexOfMax;
    }
    
    public void printResults(double[] array1, double max, int indexOfMax) {
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("\nYou played " + (array1.length - 1) + " round of Lucky Sevens.");
        System.out.println("The maximum amount of money that you ever earned was $" + df.format(max));
        System.out.println("You held that maximum amount after turn " + indexOfMax + ".");
        
    }
}
