/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.enumpractice3;

import java.math.BigDecimal;
import java.util.EnumMap;

/**
 *
 * @author Boone
 */
public class App {
    public static void main(String[] args) {
        BigDecimal bd1 = new BigDecimal("1.26");
        BigDecimal bd2 = new BigDecimal("1.10");
        calculateChange(bd1, bd2);
    }
    
    public static void calculateChange(BigDecimal userMoney, BigDecimal itemPrice) {
        BigDecimal bd25 = new BigDecimal("0.25");
        BigDecimal bd10 = new BigDecimal("0.10");
        BigDecimal bd05 = new BigDecimal("0.05");
        BigDecimal bd01 = new BigDecimal("0.01");
        
        BigDecimal difference = userMoney.subtract(itemPrice);
        
        int numQuarters = 0;
        int numDimes = 0;
        int numNickels = 0;
        int numPennies = 0;
        
        while (difference.compareTo(bd25) >=0) {
            numQuarters += 1;
            difference = difference.subtract(bd25);
        }
        while (difference.compareTo(bd10) >= 0) {
            numDimes += 1;
            difference = difference.subtract(bd10);
        }
        while (difference.compareTo(bd05) >= 0) {
            numNickels += 1;
            difference = difference.subtract(bd05);
        }
        while (difference.compareTo(bd01) >= 0) {
            numPennies += 1;
            difference = difference.subtract(bd01);
        }
        
        System.out.println("numQuarters: " + numQuarters);
        System.out.println("numDimes: " + numDimes);
        System.out.println("numNickels: " + numNickels);
        System.out.println("numPennies: " + numPennies);
        
        //EnumMap<Coins, Integer>
        
        
    }
    
}

//
//Following is the declaration for java.math.BigDecimal.compareTo() method.
//
//public int compareTo(BigDecimal val)
//
//Parameters
//
//val − Value to which this BigDecimal is to be compared.
//Return Value
//
//This method returns -1 if the BigDecimal is less than val, 1 if the BigDecimal is greater than val and 0 if the BigDecimal is equal to val