package bl.rockpaperscissorsrefactored;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Boone
 */
public class RockPaperScissorsRefactored {
    
    Scanner sc = new Scanner(System.in);
    
    public void welcomeMessage() {
        System.out.println("Welcome to ROCK, PAPER, SCISSORS!");
    }
    
    public void farewellMessage() {
        System.out.println("\nThanks for playing!  Come back soon.");
    }
    
    public String playAgainQuestion() {
        String playAgain;
        System.out.println("\nDo you want to play again? (y/n) ");
        playAgain = sc.next();
        playAgain = playAgain.substring(0, 1); //only take the first letter, so that "yes" or "y" are both acceptable options
        return playAgain;
    }
   
    public int verifyInput(int minRange, int maxRange, String prompt) {
        Scanner sc = new Scanner(System.in);
        int output;
        do {
            System.out.print(prompt); //initial prompt
            while (!sc.hasNextInt()) { //while input is not an integer
                System.out.print(prompt); //ask again
                sc.next(); //give the user a chance to respond; without this, infinite question loop!
            }
        output = sc.nextInt(); //now that an integer has been entered, store it
        } while ((output < minRange) || (output > maxRange)); //repeat the loop if the input was out of the range
        return output;
    }
    
    public int computerMove() {
        Random randGen = new Random();
        int computerMove = randGen.nextInt(2) + 1;
        return computerMove;
    }
    
    public String convertChoice(int choice) { //convert numberic input to text
        String output = "default";
        switch (choice) {
            case 1:
                output = "Rock";
                break;
            case 2:
                output = "Paper";
                break;
            case 3:
                output = "Scissors";
                break;
        }
        return output;
    }
    
    public void printWinStatement1(String playerMoveStr, String computerMoveStr, String winner, int i) {
        System.out.print("You chose " + playerMoveStr + ".  Computer chose " + computerMoveStr + ".  " + winner + " wins round " + i + "!");
    }
    
    public void printWinStatement2(int playerWins, int computerWins, int draws) {
        System.out.println("");
        System.out.println("\nHere are the overall results: ");
        System.out.println("Your wins " + playerWins);
        System.out.println("Computer wins " + computerWins);
        System.out.println("Draws: " + draws);
        
    }
    
    public String determineWinner(int playerWins, int computerWins) { //generate a winner statement
        String winnerString = "";
        if (playerWins == computerWins) {
            winnerString = "It's a tie!  No winner!";
        } else if (playerWins > computerWins) {
            winnerString = "You win!";
        } else if (computerWins > playerWins) {
            winnerString = "The computer wins!";
        }
        return winnerString;
    }

}
