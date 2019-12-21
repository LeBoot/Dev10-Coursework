
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Boone
 */
public class App {

    public static void main(String[] args) {
        boolean isInputValid;
        do {
            try {
                int userInput = getInput();
                System.out.println("You typed " + userInput);
                isInputValid = true;
            } catch (PracticeWithException e) {
                isInputValid = false;
                System.out.println("You caught 'PracticeWithException'");
                System.out.println(e.getMessage());
                System.out.println("");
            }
        } while (!isInputValid);
    }
    
    public static int getInput() throws PracticeWithException {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Please enter an integer: ");
            int userInput = Integer.parseInt(sc.nextLine());
            return userInput;
        } catch (NumberFormatException e) {
            throw new PracticeWithException("That was invalid input.");
        }
    }
    
}
