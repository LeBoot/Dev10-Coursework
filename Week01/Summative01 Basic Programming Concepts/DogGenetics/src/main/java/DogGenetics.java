/**
 * @author Boone
 */

import java.util.Scanner;
import java.util.Random;

public class DogGenetics {
    public static void main(String[] args) {
        
        Random numGen = new Random();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("What is the name of your dog? "); //Ask for user input
        String nameDog = sc.nextLine();

        String dogSpecies[] = {"St. Bernard", "Husky", "German Shepherd", "Malamute", "Golden Retriever", "Hotdog", "Corndog"}; //Add as many dog species as desited
        int genome[] = new int[dogSpecies.length]; //length of GENOME array = length of DOgSPECIES array
        int sumPercentage = 0;
        int speciesUnassigned = dogSpecies.length; // SPECIEsUNASSIGNED will change value in the FOR LOOP, but it should begin based off of the length of array DOgSPECIES
        
        for (int i = 0; i < dogSpecies.length - 1; i++) { //"DOgSPECIES.LENGTH - 1" because the final pecentage assignment is not random
            int maxNum = (100 - sumPercentage - (speciesUnassigned - 1));
            int minNum = 1;
            genome[i] = numGen.nextInt((maxNum - minNum) + 1) + minNum; //generate a random number (in the proper limits) and place in GENOME[i]
            speciesUnassigned--; //one fewer species left to assign
            sumPercentage += genome[i]; //total percentages assigned increases with the new amount that was just assigned
        }
        
        genome[genome.length - 1] = 100 - sumPercentage; //final assignment is whatever is left from 100 percent
        sumPercentage += genome[genome.length - 1]; //add this final value to SUmPERCENTAGE
        
        System.out.println("\nAfter careful genetic testing, it has been concluded that " + nameDog + " is the following:");
        
        for (int i = 0; i < dogSpecies.length; i++) { //print out results, each on a separate line
            System.out.println(dogSpecies[i] + ": " + genome[i] + "%");
        }
        System.out.println("\n(Total percentage: " + sumPercentage + "%)");
        System.out.println("\nWow, that's quite the dog!");
    }  
}
