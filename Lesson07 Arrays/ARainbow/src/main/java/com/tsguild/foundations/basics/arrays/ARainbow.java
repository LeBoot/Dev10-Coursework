/**
 * @author Boone
 */

package com.tsguild.foundations.basics.arrays;

public class ARainbow {
    public static void main(String[] args) {
        String [] colors = {"Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Violet"};
              
        for (int i = 0; i < colors.length; i++) {
            System.out.print(colors[i] + ", ");
        }
        
        System.out.println("");
        
        for (int i = colors.length - 1; i >= 0; i--) {
            System.out.print(colors[i] + ", ");
        }
    }
}