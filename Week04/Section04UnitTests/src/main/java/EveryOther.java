/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Boone
 */
public class EveryOther {
  // char starting with the first, so "Hello" yields "Hlo". 
    //
    // everyOther("Hello") -> "Hlo"
    // everyOther("Hi") -> "H"
    // everyOther("Heeololeo") -> "Hello"
    public String everyOther(String str) {
        int stringLength = str.length();        
        String newString = "";
        
        for (int i = 0; i < stringLength; i = i + 2) {
            newString += str.substring(i, i + 1); 
        }
        
        return newString;
    }
    
}
