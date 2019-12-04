/**
 * @author Boone
 */

import java.util.Random;

public class Opinionator {
    public static void main(String[] args) {
        Random rand = new Random();
        System.out.println("I can't decide what animal I like best.");
        System.out.println("I know! Random can decide FOR ME!");
        
        int x = rand.nextInt(5);
        
        System.out.println("The number that Random chose was " + x);
        
        switch (x) {
            case 0:
                System.out.println("Llamas are my favorite.");
                break;
            case 1:
                System.out.println("Dodos are my favorite.");
                break;
            case 2:
                System.out.println("Woolly Mammoths are my favorite.");
                break;
            case 3:
                System.out.println("Cockatoos are my favorite.");
                break;
            default:
                System.out.println("Rats are my favorite.");
                break;              
        }
        
        System.out.println("Thanks Random, maybe YOU'RE the best!");
    }
}