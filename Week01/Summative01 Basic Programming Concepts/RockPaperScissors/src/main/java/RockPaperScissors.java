/**
 * @author Boone
 */

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {
        
        //declare (and initialize some) variables
        String playAgain, playerMoveStr, computerMoveStr;
        String winner = "default";
        int computerMove;
        int numRounds;
        int playerMove;
        
        Random randGen = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to ROCK, PAPER, SCISSORS!");      
        
        do { //the entire game goes in this DO-WHILE LOOP; it is here in case the user wants to play again
            
            //initialize variables that need to be reset with each game
            int playerWins = 0;
            int computerWins = 0;
            int draws = 0;
            
            System.out.println(""); //some blank space for aesthetics
            
            //ask player how many rounds to play (1-10)
            numRounds = verifyInput(1 ,10 , "How many rounds would you like to play? (Enter a number between 1 and 10): ");
            
            for (int i = 1; i <= numRounds; i++) { //in this FOR LOOP, play the requested number of rounds
                
                //ask for player move (1-3)
                playerMove = verifyInput(1, 3, "\nEnter your Move!  '1' for Rock, '2' for Paper, '3' for Scissors: ");
                
                //randomly generate the computer's move (1-3)
                computerMove = randGen.nextInt(2) + 1;
                
                //convert numeric input to string input
                playerMoveStr = convertChoice(playerMove);
                computerMoveStr = convertChoice(computerMove);
                
                //Determine winner of round
                if (playerMove == computerMove) {
                    draws++;
                    winner = "No one";
                } else if (playerMove == computerMove + 1) {
                    playerWins++;
                    winner = "Player";
                } else if (playerMove == computerMove - 2) {
                    playerWins++;
                    winner = "Player";
                } else if (computerMove == playerMove + 1) {
                    computerWins++;
                    winner = "Computer";
                } else if (computerMove == playerMove - 2) {
                    computerWins++;
                    winner = "Computer";
                }
                
                //print winner statement
                System.out.print("You chose " + playerMoveStr + ".  Computer chose " + computerMoveStr + ".  " + winner + " wins round " + i + "!");
            }
            
            //print overall results:
            System.out.println("");
            System.out.println("\nHere are the overall results: ");
            System.out.println("Your wins " + playerWins);
            System.out.println("Computer wins " + computerWins);
            System.out.println("Draws: " + draws);
            System.out.println(determineWinner(playerWins, computerWins)); //print statement about who wins
          
            //check if the user wants to play again
            System.out.println("\nDo you want to play again? (y/n) ");
            playAgain = sc.next();
            playAgain = playAgain.substring(0, 1); //only take the first letter, so that "yes" or "y" are both acceptable options
            
        } while (playAgain.equalsIgnoreCase("y")); //repeat game if user answered "yes" to playing again
        
        System.out.print("\nThanks for playing!  Come back soon.");
    } 
    
    public static int verifyInput(int minRange, int maxRange, String prompt) {
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
    
    public static String convertChoice(int choice) { //convert numberic input to text
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
    
    public static String determineWinner(int playerWins, int computerWins) { //generate a winner statement
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