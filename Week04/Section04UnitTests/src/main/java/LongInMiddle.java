/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Boone
 */
public class LongInMiddle {
       // Given 2 Strings, a and b, return a String of the form 
    // short+long+short, with the shorter String on the outside 
    // and the longer String on the inside. The Strings will not 
    // be the same length, but they may be empty (length 0). 
    //
    // longInMiddle("Hello", "hi") -> "hiHellohi"
    // longInMiddle("hi", "Hello") -> "hiHellohi"
    // longInMiddle("aaa", "b") -> "baaab"
    public String longInMiddle(String a, String b) {
        String longString;
        String shortString;
        if (a.length() > b.length()) {
            longString = a;
            shortString = b;
        } else {
            longString = b;
            shortString = a;
        }
        return shortString + longString + shortString;
        
    }

}
