/**
 * @author Boone
 */

package com.tsguild.foundations.flowcontrol.whiles;

import java.util.Scanner;

public class DoOrDoNot {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.print("Should I do it? (y/n) ");
        boolean doIt;
        
        if (input.next().equals("y")) {
            doIt = true;
        } else {
            doIt = false;
        }
        
        boolean iDidIt = false;
        
        do {
            iDidIt = true;
            break;
        } while (doIt);
        
        if (doIt && iDidIt) {
            System.out.print("I did it!");
        } else if (!doIt && iDidIt) {
            System.out.print("I know you said not to, but I did it anyway.");
        } else {
            System.out.print("Don't look at me; I didn't do anything.");
        }
    }   
}
