/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.userioclasslab;

import java.util.Scanner;

/**
 *
 * @author Boone
 */
public class UserIOClassLab implements UserIO {
    Scanner sc = new Scanner(System.in);
    
    @Override
    public void print(String message) {
        System.out.println(message);
    }
    
    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        String stringIn = sc.nextLine();       
        return stringIn;
    }
    
    @Override
    public String readStringAllowNoSpaces(String prompt) {
        String stringIn;
        String stringInRefined = "default string";
        boolean isInputGood = false;
        do {
            System.out.println(prompt);
            stringIn = sc.nextLine();
            if ((stringIn == null) || (stringIn.trim().length() == 0)) {
                System.out.println("Blank space is not an acceptable input.");
            } else {
                stringInRefined = stringIn.strip();
                isInputGood = true;
            }
        } while (isInputGood == false);
        return stringInRefined;
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
        float numIn = 0;
        boolean isInputGood = false;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            try {
                numIn = Float.parseFloat(stringIn);
                isInputGood = true;
            } catch (NumberFormatException e) {
                System.out.println("You must enter a number.");
            }
        } while (isInputGood == false);
        return numIn;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float numIn = 0;
        boolean isInputGood = false;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            try {
                numIn = Float.parseFloat(stringIn);
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
        long numIn = 0;
        boolean isInputGood = false;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            try {
                numIn = Long.parseLong(stringIn);
                isInputGood = true;
            } catch (NumberFormatException e) {
                System.out.println("You must enter a number.");
            }
        } while (isInputGood == false);
        return numIn;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long numIn = 0;
        boolean isInputGood = false;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            try {
                numIn = Long.parseLong(stringIn);
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
    
}