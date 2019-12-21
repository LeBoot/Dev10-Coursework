
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Boone
 */
public class MakePi {

    public int[] makePi(int n) {
        double piDivide10 = Math.PI / 10;
        String piToString = String.valueOf(piDivide10);
        int[] arrayInt = new int[n];
        for (int i = 2; i < n + 2; i++) {
            String newString = piToString.substring(i, i + 1);
            int newInt = Integer.parseInt(newString);
            arrayInt[i - 2] = newInt;
        }
        return arrayInt;
    }
    
}
