/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Boone
 */
public class CountXX {
    
    // Count the number of "xx" in the given String. We'll say 
    // that overlapping is allowed, so "xxx" contains 2 "xx".  
    //
    // countXX("abcxx") -> 1
    // countXX("xxx") -> 2
    // countXX("xxxx") -> 3
    public int countXX(String str) {
        int stringLength = str.length();
        int numOccurances = 0;
        for (int i = 0; i < stringLength; i++) {
            int result = str.indexOf("xx", i);
            if ((result != -1) && (result == i)){ //indexOf will return -1 if the string is not found
                numOccurances += 1;
            }           
        }
        return numOccurances;
    }
}


//public int indexOf(String str,
//          int fromIndex)
//
//Returns the index within this string of the first occurrence of the specified substring, starting at the specified index.
//
//The returned index is the smallest value k for which:
//
//     k >= fromIndex && this.startsWith(str, k)
//     
//
//If no such value of k exists, then -1 is returned.