/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Boone
 */
public class FrontTimes {
    
    // Given a String and a non-negative int n, we'll say that the 
    // front of the String is the first 3 chars, or whatever is there 
    // if the String is less than length 3. Return n copies of the front; 
    //
    // frontTimes("Chocolate", 2) -> "ChoCho"
    // frontTimes("Chocolate", 3) -> "ChoChoCho"
    // frontTimes("Abc", 3) -> "AbcAbcAbc"
    public String frontTimes(String str, int n) {
        if (n == 0) {
            return "";
        } else if (str.length() < 3) {
            String subString = str.substring(0, str.length());
            String newString = subString;
            for (int i = 1; i <= n-1; i++) {
                newString += subString;
            }
            return newString;
        } else {
            String subString = str.substring(0, 3);
            String newString = subString;
            for (int i = 1; i <= n-1; i++) {
                newString += subString;
            }
            return newString;
        }
    }

    
}
