/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Boone
 */
public class NearTen {
        // Given an int n, return true if it is within 10 of 100 
    // or 200.
    // Hint: Check out the Math class for absolute value
    //
    // nearHundred(103) -> true
    // nearHundred(90) -> true
    // nearHundred(89) -> false
    public boolean nearHundred(int n) {
        if ((n >= 90) && (n <= 110)) {
            return true;
        } else if ((n >= 190) && (n <= 210)) {
            return true;
        } else {
            return false;
        }
    }

}
