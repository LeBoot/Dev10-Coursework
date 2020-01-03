/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.flooringmastery.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Boone
 */
public class OrderNumbersDaoImpl implements OrderNumbersDao {
    
    List<Integer> listOfOrderNumbers = new ArrayList<>();
    
    @Override
    public List<Integer> getListOfNumbers(String testOrProd) throws DataPersistenceException {
        loadTextFile(testOrProd);
        return listOfOrderNumbers;
    }
    
    @Override
    public boolean checkIsNumberInList(int numberToCheck, String testOrProd) throws DataPersistenceException {
        loadTextFile(testOrProd);
        boolean isNumberInList = false;
        for (int number : listOfOrderNumbers) {
            if (numberToCheck == number) {
                isNumberInList = true;
            }
        }
        return isNumberInList;
    }
    
    @Override
    public int addNumToList(int numberToEnter, String testOrProd) throws DataPersistenceException, DuplicateDataException {
        loadTextFile(testOrProd);
        for (int number : listOfOrderNumbers) {
            if (numberToEnter == number) {
                throw new DuplicateDataException(numberToEnter + " is already used.");
            }
        }
        listOfOrderNumbers.add(numberToEnter);
        writeTextFile(testOrProd);
        return numberToEnter;
    }
 
    
    //loading and unloading text file ------------------------------------------
    
    //declare a non-constant textfile      
    public static String textfile = "OrderNumbers.txt";
    
    //this method reads from the text file
    private void loadTextFile(String testOrProd) throws DataPersistenceException {

        if (testOrProd.equalsIgnoreCase("test")) {
            textfile = "OrderNumbers-TestMode.txt";
        }
        
        Scanner scanner;
        
        try {
            scanner = new Scanner (
                new BufferedReader(
                    new FileReader(textfile)));
        } catch (FileNotFoundException e) {
            throw new DataPersistenceException("Could not load " + textfile + " into memory", e);
        }
        
        String currentLine; //to hold most-recently read line from file
        int currentLineInt; //to turn that string into an integer
        
        while(scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentLineInt = Integer.parseInt(currentLine);
            if (!listOfOrderNumbers.contains(currentLineInt)) {
                listOfOrderNumbers.add(currentLineInt); 
            }
        }
        
        scanner.close();
    }
    
    
    //this method writes the numbers to the text file
    private void writeTextFile(String testOrProd) throws DataPersistenceException {

        if (testOrProd.equalsIgnoreCase("test")) {
            textfile = "OrderNumbers-TestMode.txt";
        }        
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(textfile));
        } catch (IOException e) {
            throw new DataPersistenceException("Could not save data", e);
        }
        
        for (int number : listOfOrderNumbers) {
            out.println(number);
            out.flush();
        }
        
        out.close();   
    }
    
}