/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.mp3project.ui;

import java.util.Scanner;
/**
 *
 * @author Boone
 */
public class mp3ProjectUserIOImpl implements mp3ProjectUserIO {

Scanner sc = new Scanner(System.in);
    
    @Override
    public void print(String message) {
        System.out.println(message);
    }
    
    @Override
    public double readDouble(String prompt) {
        double numIn = 0;
        boolean isInputGood = false;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            try {
                numIn = Double.parseDouble(stringIn);
                isInputGood = true;
            } catch (NumberFormatException e) {
                System.out.println("You must enter a number.");
            }
        } while (isInputGood == false);
        return numIn;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        double numIn = 0;
        boolean isInputGood = false;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            try {
                numIn = Double.parseDouble(stringIn);
                if (numIn < min || numIn > max) {
                    System.out.println("The number you enter must be between " + min + " and " + max + " (inclusively)");
                } else {
                    isInputGood = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("You must enter a number.");
            }
        } while (isInputGood == false || numIn < min || numIn > max);
        return numIn;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        String stringIn = sc.nextLine();
        float numIn = Float.parseFloat(stringIn);
        return numIn;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float numIn = 0;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            numIn = Float.parseFloat(stringIn);
        } while ((numIn < min) || (numIn > max));
        return numIn;
    }

    @Override
    public int readInt(String prompt) {
        int numIn = 0;
        boolean isInputGood = false;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            try {
                numIn = Integer.parseInt(stringIn);
                isInputGood = true;
            } catch (NumberFormatException e) {
                System.out.println("You must enter an integer.");
            } 
        } while (isInputGood == false);
        return numIn;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int numIn = 0;
        boolean isInputGood = false;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            try {
                numIn = Integer.parseInt(stringIn);
                if (numIn < min || numIn > max) {
                    System.out.println("The number you enter must be between " + min + " and " + max + " (inclusively)");
                } else {
                    isInputGood = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("You must enter an integer.");
            }
        } while (isInputGood == false || numIn < min || numIn > max);
        return numIn;
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        String stringIn = sc.nextLine();
        long numIn = Long.parseLong(stringIn);
        return numIn;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long numIn = 0;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            numIn = Long.parseLong(stringIn);
        } while ((numIn < min) || (numIn > max));
        return numIn;
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        String stringIn = sc.nextLine();       
        return stringIn;
    }   
    
}