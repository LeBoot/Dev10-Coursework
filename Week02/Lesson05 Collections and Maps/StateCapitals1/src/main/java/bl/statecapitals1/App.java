package bl.statecapitals1;

import java.util.HashMap;
/**
 *
 * @author Boone
 */
public class App {
    public static void main(String[] args) {
        
        //create a HashMap
        HashMap<String, String> statesAndCapitals = new HashMap<>();
        
        //input some values
        statesAndCapitals.put("Alabama", "Montgomery");
        statesAndCapitals.put("Alaska", "Juneau");
        statesAndCapitals.put("Arizona", "Phoenix");
        statesAndCapitals.put("Arkansas", "Little Rock");
        
        //print state names (keys) to screen
        for(String i : statesAndCapitals.keySet()) {
            System.out.println(i);
        }
        
        System.out.println(""); //some blank space
        
        //print capitals (values) to screen
        for(String i : statesAndCapitals.values()) {
            System.out.println(i);
        }
        
        System.out.println(""); //some blank space
        
        //print states and capitals (keys and values) to screen
        for(String i : statesAndCapitals.keySet()) {
            System.out.println("The capital of " + i + " is " + statesAndCapitals.get(i));
        }
        
        
    }
    
}
