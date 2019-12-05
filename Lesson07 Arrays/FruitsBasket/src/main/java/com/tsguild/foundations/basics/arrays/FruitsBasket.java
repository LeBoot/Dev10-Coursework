/**
 * @author Boone
 */

package com.tsguild.foundations.basics.arrays;

import java.util.ArrayList;

public class FruitsBasket {
    public static void main(String[] args) {
        
        int numApples = 0;
        int numOranges = 0;
        int numTotal = 0;
        int numOther = 0;
        
        String[] fruit = {"Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", 
            "Apple", "Orange", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", 
            "Orange", "Apple", "Apple", "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", 
            "Apple", "Apple", "Apple", "Orange", "Taco", "Orange", "Apple", "Apple", "Orange", "Orange", "Orange", 
            "Orange", "Apple", "Apple", "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", 
            "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", "Apple", 
            "Orange", "Apple", "Orange", "Apple", "Orange", "Orange"};        
        
        ArrayList<String> newApples = new ArrayList<String>();
        ArrayList<String> newOranges = new ArrayList<String>();
        ArrayList<String> newOther = new ArrayList<String>();
        
        for (int i = 0; i < fruit.length; i++) {
            if (fruit[i].equals("Apple")) {
                numApples++;  
                newApples.add(fruit[i]);
            } else if (fruit[i].equals("Orange")) {
                numOranges++;
                newOranges.add(fruit[i]);
            } else {
                numOther++;
                newOther.add(fruit[i]);
            }
            numTotal++;
        }
        
        String[] arrayApples = new String[newApples.size()];
        
        for (int i = 0; i < newApples.size(); i++) {
            arrayApples[i] = newApples.get(i);
        }
        
        for (int i = 0; i < arrayApples.length; i++) {
            System.out.print(arrayApples[i] + ", ");
        }  
        
        /*
        System.out.println(newApples);
        System.out.println(newOranges);
        System.out.println(newOther);
        */
        /* //This code alphabetizes the array FRUIT
        for (int i = 0; i < fruit.length; i++) {
            for (int j = 1; j < fruit.length; j++) { 
                if (fruit[j-1].compareTo(fruit[j]) > 0) {
                    String temp = fruit[j-1];
                    fruit[j-1] = fruit[j];
                    fruit[j] = temp;
                }
            }
        }
        */
        

        /*
        System.out.println("There are " + numTotal + " items in your fruit basket.");
        System.out.println("This includes " + numApples + " apples.");
        System.out.println("This includes " + numOranges + " oranges.");
        System.out.println("This includes " + numOther + " other object(s)."); 
        */
    }   
}