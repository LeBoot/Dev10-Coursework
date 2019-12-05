/**
 * @author Boone
 */

import java.util.Random;

public class BarelyControlledChaos {
    public static void main(String[] args) {
        
        String color = pickColor();
        String animal = pickAnimal();
        String color2 = pickColor();
        int weight = pickNumber(200, 5);
            //range 5 - 200
        int distance = pickNumber(20, 10);
            //range 10-20
        int number = pickNumber(20000, 10000);
            //range 10000,20000
        int time = pickNumber(6, 2);
            //range 2-6
        
        System.out.println("Once, when I was very small...");

        System.out.println("I was chased by a " + color + ", "
            + weight + "-lb " + " miniature " + animal 
            + " for over " + distance + " miles!!");

        System.out.println("I had to hide in a field of over " 
            + number + " " + color2 + " poppies for nearly " 
            + time + " hours until it left me alone!");

        System.out.println("\nIt was QUITE the experience, " 
            + "let me tell you!");
    }
   
    public static String pickColor() {
        Random randGen = new Random();
        int randNumColor = randGen.nextInt(4);
        String color;
        switch (randNumColor) {
            case 0:
                color = "bandaid color";
                break;
            case 1:
                color = "brown";
                break;
            case 2:
                color = "red";
                break;
            case 3:
                color = "teal";
                break;
            case 4:
                color = "orange";
                break;
            default:
                color = "whoopsi";
                break;
        }
        return color;
    }
    
    public static String pickAnimal() {
        Random randGen = new Random();
        int randNumAnimal = randGen.nextInt(4);
        String animal;
        switch (randNumAnimal) {
            case 0:
                animal = "cuddlefish";
                break;
            case 1:
                animal = "zebra";
                break;
            case 2:
                animal = "kangaroo";
                break;
            case 3:
                animal = "buffalo";
                break;
            case 4:
                animal = "kitty";
                break;
            default:
                animal = "whoopsi";
                break;
        }
        return animal;
    }
    
    public static int pickNumber(int max, int min) {
        Random randGen = new Random();
        int randNum = randGen.nextInt((max - min) + 1) + min;
        return randNum;
    }
}