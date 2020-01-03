/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Boone
 */
public class SkipSum {
        // Given 2 ints, a and b, return their sum. However, sums 
    // in the range 10..19 inclusive are forbidden, so in that case just return 20. 
    //
    // skipSum(3, 4) → 7
    // skipSum(9, 4) → 20
    // skipSum(10, 11) → 21
    public int skipSum(int a, int b) {
        int newSum = a + b;
        if ((newSum >= 10) && (newSum <= 19)) {
            return 20;
        } else {
            return newSum;
        }
    }

}
