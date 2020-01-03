/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Boone
 */
public class DoubleX {
       // Given a String, return true if the first instance 
    // of "x" in the String is immediately followed by 
    // another "x". 
    //
    // doubleX("axxbb") -> true
    // doubleX("axaxxax") -> false
    // doubleX("xxxxx") -> true
    public boolean doubleX(String str) {
        int stringLength = str.length();
        boolean isXFound = false;
        while (!isXFound) {
            for (int i = 0; (i < stringLength) && (!isXFound); i++) {
                int resultX = str.indexOf("x", i);
                int resultXX = str.indexOf("xx", i);
                if ((resultX >= 0) || (resultXX >= 0)) {
                    isXFound = true;
                    if (resultX == resultXX) {
                        return true;
                    }
                    else {
                        return false;
                    }
                }
            
            }
            
        }
        if (!isXFound) {
            return false;
        }
        //this line is no good
        return true;
    }
}
   