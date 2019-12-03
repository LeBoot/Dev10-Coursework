/**
 * @author Boone
 */
import java.util.Random;

public class RandomNumberFun {
    public static void main(String[] args) {
        
        Random rGen = new Random(); //Generate a random number between 1 and 10
        //int randomNum = rGen.nextInt(10) + 1;
        int randomNum = rGen.nextInt((20 - 10) + 1) + 10; 
        //Generates a random number between 10 and 20, by use of format "((max - min) + 1) + min"
        
        while (randomNum < 19) {
            System.out.println(randomNum);
            randomNum = rGen.nextInt((20 - 10) + 1) + 10;
        }
    }
}
