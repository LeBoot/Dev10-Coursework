package bl.simplecalculator2;

/**
 *
 * @author Boone
 */
public class App {
    public static void main(String[] args) {
        SimpleCalculator2 simC = new SimpleCalculator2();
        simC.welcomeMessage();
        
        boolean isPlayGame = true;
        String quit = simC.quit(); //user chooses operation or to exit
        if (quit.equals("y")) { //allow user choice to exit game
            isPlayGame = false;
        }
        
        while (isPlayGame) {
            int userOperation = simC.askOperation();
            double[] userNumbers = simC.getNumbers(userOperation); //ask for two numbers, return as array
            double num1 = userNumbers[0]; //get num1 from array
            double num2 = userNumbers[1]; //get num2 from array
            
            simC.performCalc(userOperation, num1, num2);
            
            isPlayGame = simC.playAgain();
        }
        
        simC.printGoodbye();
    }
}
