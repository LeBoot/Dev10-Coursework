/**
 * @author Boone
 */

import java.util.Random;

public class ALittleChaos {
    public static void main(String[] args) {
        Random randomizer = new Random();
        
        System.out.println("Random can make integers: " + randomizer.nextInt());
        System.out.println("Or a double: " + randomizer.nextDouble());
        System.out.println("Or even a boolean: " + randomizer.nextBoolean());
        
        int num = randomizer.nextInt(100); //between 0 and 99
        
        System.out.println("You can store a randomized result: " + num);
        System.out.println("And use it over and over again: " + num + ", " + num + ", " + num);
        System.out.println("");
        System.out.println("Or just keep generating new values");
        System.out.println("Here's a bunch of numbers from 0 to 100: ");
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.println(randomizer.nextInt(101));
        
        System.out.println("");
        System.out.println("Here's a bunch of numbers from 50 to 99: ");
        System.out.print(randomizer.nextInt(50) + 50 + ", ");
        System.out.print(randomizer.nextInt(50) + 50 + ", ");
        System.out.print(randomizer.nextInt(50) + 50 + ", ");
        System.out.print(randomizer.nextInt(50) + 50 + ", ");
        System.out.print(randomizer.nextInt(50) + 50 + ", ");
        System.out.print(randomizer.nextInt(50) + 50 + ", ");
        System.out.println(randomizer.nextInt(50) + 50); 
    }
}