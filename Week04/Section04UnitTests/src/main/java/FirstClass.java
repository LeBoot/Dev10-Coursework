/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Boone
 */
public class FirstClass {
        // Given a String of even length, return the first half. 
    // So the String "WooHoo" yields "Woo". 
    //
    // firstHalf("WooHoo") -> "Woo"
    // firstHalf("HelloThere") -> "Hello"
    // firstHalf("abcdef") -> "abc"
    public String firstHalf(String str) {
        int stringLength = str.length();
        return str.substring(0, stringLength/2);
    }
}
