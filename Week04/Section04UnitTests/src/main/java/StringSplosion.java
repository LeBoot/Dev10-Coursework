/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Boone
 */
public class StringSplosion {
       // Given a non-empty String like "Code" return a String like 
    // “CCoCodCode".  (first char, first two, first 3, etc)
    //
    // stringSplosion("Code") -> "CCoCodCode"
    // stringSplosion("abc") -> "aababc"
    // stringSplosion("ab") -> "aab"
    public String stringSplosion(String str) {
        int stringLength = str.length();
        String newString = "";
        for (int i = 0; i < stringLength; i++) {
            newString += str.substring(0, i + 1);
        }
        return newString;
    }

}
