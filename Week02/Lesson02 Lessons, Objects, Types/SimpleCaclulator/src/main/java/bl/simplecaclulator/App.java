package bl.simplecaclulator;

/**
 *
 * @author Boone
 */
public class App {
    public static void main(String[] args) {
        SimpleCaclulator simC = new SimpleCaclulator(); //typo... I know
        
        simC.welcomeMessage();
    
        boolean isPlayAgain;
        do {
            int userChoice = simC.getChoice();

            int[] userArray = simC.askNumbersIn(userChoice);

            int num1 = userArray[0];
            int num2 = userArray[1];

            double answer = 0;
            switch (userChoice) {
                case 1:
                    answer = simC.addition(num1, num2);
                    break;
                case 2:
                    answer = simC.subtraction(num1, num2);
                    break;
                case 3:
                    answer = simC.multiplication(num1, num2);
                    break;
                case 4:
                    answer = simC.division(num1, num2);
                    break;
                default:
                    System.out.println("Error 3");
                    break;
            }

            simC.printAnswer(userChoice, num1, num2, answer);

            isPlayAgain = simC.playAgain();
        } while (isPlayAgain);
        
        simC.printGoodbye();
        
    }
}
