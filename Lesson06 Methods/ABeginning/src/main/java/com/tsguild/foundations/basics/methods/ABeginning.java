/**
 * @author Boone
 */
package com.tsguild.foundations.basics.methods;

public class ABeginning {
    public static void main(String[] args) {
        
        int aSecret = secret();
        double aSurprise = surprise();
        char aMystery = mystery();
        boolean itsClassified = classified();
        String totallyUnexpected = unexpected();
        
        System.out.println("The methods have returned! Their results...\n");
        System.out.println("Mysterious: " + aMystery);
        System.out.println("    Secret: " + aSecret);
        System.out.println("Surprising: " + aSurprise);
        System.out.println("Classified: " + itsClassified);
        System.out.println("Unexpected: " + totallyUnexpected);
    }
    public static int secret() {
        return 42;
    }
    public static double surprise() {
        return 3.14;
    }
    public static char mystery() {
        return 'X';
    }
    public static boolean classified() {
        return true;
    }
    public static String unexpected() {
        return "Spanish Inquisition";
    }    
}
