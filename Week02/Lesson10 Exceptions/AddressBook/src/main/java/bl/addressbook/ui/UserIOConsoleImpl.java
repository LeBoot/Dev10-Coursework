/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.addressbook.ui;

/**
 *
 * @author Boone
 */
import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO {
    Scanner sc = new Scanner(System.in);
    
    @Override
    public void print(String message) {
        System.out.println(message);
    }
    
    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        String stringIn = sc.nextLine();
        double numIn = Double.parseDouble(stringIn);
        return numIn;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        double numIn = 0;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            numIn = Double.parseDouble(stringIn);
        } while ((numIn < min) || (numIn > max));
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
        System.out.println(prompt);
        String stringIn = sc.nextLine();
        int numIn = Integer.parseInt(stringIn);
        return numIn;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int numIn = 0;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            numIn = Integer.parseInt(stringIn);
        } while ((numIn < min) || (numIn > max));
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