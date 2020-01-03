/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.flooringmastery.dao;

import bl.flooringmastery.dto.StateTaxObject;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Boone
 */

//this dao accesses ProductInfoCosts.txt and stores that data in a map
public class StateTaxesDaoImpl implements StateTaxesDao {
    
    Map<String, StateTaxObject> mapOfStateTaxInfo = new HashMap<>();
    
    @Override
    public BigDecimal getTaxRate(String nameOfState) throws DataPersistenceException {
        loadTextFile();
        StateTaxObject stateInQuestion = mapOfStateTaxInfo.get(nameOfState);
        return stateInQuestion.getTaxRate();
    }
    
    @Override
    public Set<String> getListOfKeys() throws DataPersistenceException {
        loadTextFile();
        return mapOfStateTaxInfo.keySet();
    }
    
    //unmarshalling ------------------------------------------------------------
    
    //unmasrhall infoAsText string and form a StateTaxObject
        //format=   StateName::TaxRate
    private StateTaxObject unmarshallInfo(String infoAsText) {
       String DELIMITER = "::";
       String[] tokens = infoAsText.split(DELIMITER);
       
       //pull info from tokens and data-type it correctly
       String nameOfState = tokens[0];
       String taxRateString = tokens[1];
       BigDecimal taxRateBD = new BigDecimal(taxRateString);
       
       //create a new StateTaxObject
       StateTaxObject objectFromFile = new StateTaxObject(nameOfState, taxRateBD);
       
       //return item
       return objectFromFile;
       
    }
    
    
    @Override
    //read the StateTaxInfo.txt and fill the map (at the top of this class)
    public void loadTextFile() throws DataPersistenceException {
        String textfile = "StateTaxInfo.txt";
        Scanner scanner;
        
        try {
            scanner = new Scanner(
                new BufferedReader(
                    new FileReader(textfile)));
        } catch (FileNotFoundException e) {
            throw new DataPersistenceException("Could read from " + textfile, e);
        }
        
        String currentLine; //holds the most recent line from the file
        StateTaxObject currentInfo; //holds the most recent unmarshalled item
        
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine(); //read the next line in the file
            currentInfo = unmarshallInfo(currentLine); //return a newly-formed StateTaxObject
            
            //put info into Map
            mapOfStateTaxInfo.put(currentInfo.getStateName(), currentInfo);
        }
        
        scanner.close();
    }
}
