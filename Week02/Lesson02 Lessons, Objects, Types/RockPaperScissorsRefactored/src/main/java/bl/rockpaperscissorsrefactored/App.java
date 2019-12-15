package bl.rockpaperscissorsrefactored;

/**
 *
 * @author Boone
 */
public class App {
    public static void main(String[] args) {
        RockPaperScissorsRefactored rps = new RockPaperScissorsRefactored();
        String playAgain = "yes";
        String playerMoveStr, computerMoveStr;
        
        rps.welcomeMessage();
        
        do { //the whole game goes in this DO-WHILE loop
            
            //initialize variables that need to be reset with each game
            int playerWins = 0;
            int computerWins = 0;
            int draws = 0;
            String winner = "default";
            
            System.out.println(""); //some blank space for aesthetics
            
            //ask player how many rounds to play (1-10)
            int numRounds = rps.verifyInput(1 ,10 , "How many rounds would you like to play? (Enter a number between 1 and 10): ");
            
            for (int i = 1; i <= numRounds; i++) { //in this FOR LOOP, play the requested number of rounds
                
                //ask for player move (1-3)
                int playerMove = rps.verifyInput(1, 3, "\nEnter your Move!  '1' for Rock, '2' for Paper, '3' for Scissors: ");
                
                //randomly generate the computer's move (1-3)
                int computerMove = rps.computerMove();
                
                //convert numeric input to string input
                playerMoveStr = rps.convertChoice(playerMove);
                computerMoveStr = rps.convertChoice(computerMove);
                
                //Determine winner of round
                if (playerMove == computerMove) {
                    draws++;
                    winner = "No one";
                } else if ((playerMove == computerMove + 1) || (playerMove == computerMove - 2)){
                    playerWins++;
                    winner = "Player";
                } else if ((computerMove == playerMove + 1) || (computerMove == playerMove - 2)){
                    computerWins++;
                    winner = "Computer";
                }
                
                //print winner statement
                rps.printWinStatement1(playerMoveStr, computerMoveStr, winner, i);
                
            }
        
        //print overall results:
        rps.printWinStatement2(playerWins, computerWins, draws);
            
        playAgain = rps.playAgainQuestion();
            
        } while (playAgain.equalsIgnoreCase("y")); //repeat game if user answered "yes" to playing again
        
        rps.farewellMessage();
        
    }
}
