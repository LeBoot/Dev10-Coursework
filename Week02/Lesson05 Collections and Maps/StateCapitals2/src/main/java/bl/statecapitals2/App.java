package bl.statecapitals2;

import java.util.HashMap;
import java.util.Scanner;
/**
 *
 * @author Boone
 */
public class App {
    public static void main(String[] args) {
        
        //Hard code some data using Capitals constructor
        Capitals capAL = new Capitals("Montgomery", 205000, 156);
        Capitals capAK = new Capitals("Juneau", 31000, 3255);
        Capitals capAZ = new Capitals("Phoenix", 1445000, 517);
        Capitals capAR = new Capitals("Little Rock", 193000, 116);
        
        //Create HashMap
        HashMap<String, Capitals> statesAndCapitals = new HashMap<>();
        
        //Add data to HashMap
        statesAndCapitals.put("Alabama", capAL);
        statesAndCapitals.put("Alaska", capAK);
        statesAndCapitals.put("Arizona", capAZ);
        statesAndCapitals.put("Arkansas", capAR);
        
        //print data to screen
        for(String i : statesAndCapitals.keySet()) {
            System.out.println(i + "-- capital: " + statesAndCapitals.get(i).getName() + 
                    " | pop of capital: " + statesAndCapitals.get(i).getPopulation() + " | sq milage of capital: " + statesAndCapitals.get(i).getSquareMilage());
        }
        System.out.println(""); //blank space
        
        int lowLimit = askQuestion("Please enter a lower limit for capital city population: "); //method to ask for user input
        
        //print only data with the appropriate low limit
        System.out.println("The states the meet your criterion are the following: ");
        for(String i : statesAndCapitals.keySet()) {
            if (statesAndCapitals.get(i).getPopulation() >= lowLimit) {
            System.out.println(i + "-- capital: " + statesAndCapitals.get(i).getName() + 
                    " | pop of capital: " + statesAndCapitals.get(i).getPopulation() + " | sq milage of capital: " + statesAndCapitals.get(i).getSquareMilage());
        
            }
        }
        
    }
    
    //method to ask for user input
    public static int askQuestion(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt);
        String stringIn = sc.next();
        System.out.println(""); //blank space
        int num1 = Integer.parseInt(stringIn);
        return num1;
    }
    
}
