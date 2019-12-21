/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.enumpractice1;

import java.util.Scanner;

/**
 *
 * @author Boone
 */
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String inputMod;
        DaysOfWeek day = DaysOfWeek.MONDAY;
        
        boolean isInputGood;
        do {
            try {
                System.out.println("Enter a day of the week: ");
                inputMod = sc.nextLine().toUpperCase().trim();
                day = DaysOfWeek.valueOf(inputMod);
                isInputGood = true;
            } catch (IllegalArgumentException e) {
                isInputGood = false;
                System.out.println("That day is not recognized.  Try again.");
                System.out.println("");
            }
        } while (!isInputGood);
        
        switch (day) {
            case MONDAY:
                System.out.println("There are 4 days until Friday!");
                break;
            case TUESDAY:
                System.out.println("There are 3 days until Friday!");
                break;
            case WEDNESDAY:
                System.out.println("There are 2 days until Friday!");
                break;
            case THURSDAY:
                System.out.println("There is 1 day until Friday!");
                break;
            case FRIDAY:
                System.out.println("Today is Friday!");
                break;
            case SATURDAY:
                System.out.println("There are 6 days until Friday!");
                break;
            case SUNDAY:
                System.out.println("There are 5 days until Friday!");
                break;
            default:
                System.out.println("The default case ran.");
             
        }
    }
    
}