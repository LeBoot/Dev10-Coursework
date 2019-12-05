/**
 * @author Boone
 */

package com.tsguild.foundations.basics.arrays;

import java.util.ArrayList;
import java.util.Random;

public class FruitSalad {
    
    static ArrayList<String> listNewSalad = new ArrayList<String>(); //declaring this outside of main so that method buildArrayLists can see it.
    static int newSaladItems = 0; //declaring this outside of main so that method buildArrayLists can see it.
    
    public static void main(String[] args) {
        
        String[] fruit = {"Kiwi Fruit", "Gala Apple", "Granny Smith Apple", "Cherry Tomato", "Gooseberry", 
            "Beefsteak Tomato", "Braeburn Apple", "Blueberry", "Strawberry", "Navel Orange", "Pink Pearl Apple",  
            "Raspberry", "Blood Orange", "Sungold Tomato", "Fuji Apple", "Blackberry", "Banana", "Pineapple", 
            "Florida Orange", "Kiku Apple", "Mango", "Satsuma Orange", "Watermelon", "Snozzberry",
        };
        
        ArrayList<String> listBerry = new ArrayList<String>();
        ArrayList<String> listApple = new ArrayList<String>();
        ArrayList<String> listOrange = new ArrayList<String>();
        ArrayList<String> listTomato = new ArrayList<String>();
        ArrayList<String> listOther = new ArrayList<String>();
        //ArrayList<String> listNewSalad = new ArrayList<String>();
        //int newSaladItems = 0;
        
        for (int i = 0; i < fruit.length; i++) {
            if (fruit[i].contains("berry") == true) {
                listBerry.add(fruit[i]);
            } else if (fruit[i].contains("Apple") == true) {
                listApple.add(fruit[i]);
            } else if (fruit[i].contains("Orange") == true) {
                listOrange.add(fruit[i]);
            } else if (fruit[i].contains("Tomato") == true) {
                listTomato.add(fruit[i]);
            } else {
                listOther.add(fruit[i]);
            }
        }
        
        /*
        for (int i = 0; i < listBerry.size(); i++) {
            listNewSalad.add(listBerry.get(i));
            newSaladItems++;
        }
        
        for (int i = 0; i < 3; i++) {
            listNewSalad.add(listApple.get(i));
            newSaladItems++;
        }
        
        for (int i = 0; i < 2; i++) {
            listNewSalad.add(listOrange.get(i));
            newSaladItems++;
        }
        
        for (int i = 0; i < 12 - newSaladItems; i++) {
            listNewSalad.add(listOther.get(i));
            newSaladItems++;
        }
        */
        
        buildArrayLists(listBerry, listBerry.size());
        buildArrayLists(listApple, 3);
        buildArrayLists(listOrange, 2);
        buildArrayLists(listOther, 12 - newSaladItems);
        
        String[] fruitSalad = new String[listNewSalad.size()];
        
        for (int i = 0; i < listNewSalad.size(); i++) {
            fruitSalad[i] = listNewSalad.get(i);
        }
        
        for (int i = 0; i < fruitSalad.length; i++) {
            System.out.print(fruitSalad[i] + ", ");
        }
    }
    
    public static void buildArrayLists(ArrayList<String> arrayList1, int maxNum) {
        for (int i = 0; i < maxNum; i++) {
            listNewSalad.add(arrayList1.get(i));
            newSaladItems++;
        }
    }
    
}