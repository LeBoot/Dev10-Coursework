/**
 * @author Boone
 */

import java.util.Scanner;

public class MiniMadLibs {
    public static void main(String[] args) {
        String ML1, ML2, ML3, ML5, ML6, ML7, ML8, ML9, ML10;
        int ML4;
        
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("We're going to play madlibs.");
        System.out.println("Type a noun: ");
        ML1 = inputReader.nextLine();
        
        System.out.println("Type an adjective: ");
        ML2 = inputReader.nextLine();
        
        System.out.println("Type a second noun: ");
        ML3 = inputReader.nextLine();
        
        System.out.println("Type a number: ");
        ML4 = inputReader.nextInt();
        inputReader.nextLine(); //This consumes the "return" that came when the user entered their number.
        //Can also save ML4 as a string and use: ML4 = inputReader.nextLine()
            //and then convert that string to an int if necessary.
        
        System.out.println("Type another adjective: ");
        ML5 = inputReader.nextLine();
        
        System.out.println("Type a plural noun: ");
        ML6 = inputReader.nextLine();
        
        System.out.println("Type a second plural noun: ");
        ML7 = inputReader.nextLine();
        
        System.out.println("Type a third plural noun: ");
        ML8 = inputReader.nextLine();
        
        System.out.println("Type a verb in infinitive form: ");
        ML9 = inputReader.nextLine();
        
        System.out.println("Type the past participle of that verb: ");
        ML10 = inputReader.nextLine();
        
        System.out.println(ML1 + ": the " + ML2 + " frontier. These are the voyages of the starship " + ML3 + ".");
        System.out.println("Its " + ML4 + "-year mission: To explore strange " + ML5 + " " + ML6 + ", ");
        System.out.println("to seek out " + ML5 + " " + ML7 + " and " + ML5 + " " + ML8 + ", ");
        System.out.println("to boldly " + ML9 + " where no one has " + ML10 + " before.");
    } 
}