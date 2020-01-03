/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.flooringmastery.dao;

import bl.flooringmastery.dto.ProductInfoCosts;
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
public class ProductInfoDaoImpl implements ProductInfoDao {
    
    Map<String, ProductInfoCosts> mapOfProductInfoCosts = new HashMap<>();
    
    @Override
    public BigDecimal getCostPerSqFt(String productType, String whichCost) throws DataPersistenceException {
        loadTextFile();
        ProductInfoCosts productInQuestion = mapOfProductInfoCosts.get(productType);
        if (whichCost.equalsIgnoreCase("labor")) {
            return productInQuestion.getCostLaborSqFt();
        } else {
            return productInQuestion.getCostMaterialSqFt();
        }
    }    
    
    @Override
    public Set<String> getListOfKeys() throws DataPersistenceException {
        loadTextFile();
        return mapOfProductInfoCosts.keySet();
    }
    
    
    //unmarshalling ------------------------------------------------------------
        
    
    //unmasrhall productAsText string and form a ProductInfoCosts object
        //format=   productType::costMaterialSqFt::costLaborSqFt
    private ProductInfoCosts unmarshallProduct(String productAsText) {
       String DELIMITER = "::";
       String[] tokens = productAsText.split(DELIMITER);
       
       //create an item based off of the productType
       String productType = tokens[0];
       ProductInfoCosts productFromTextFile = new ProductInfoCosts(productType);
       
       //set costMaterialSqFt
       String costMaterialSqFtString = tokens[1];
       BigDecimal costMaterialSqFtBD = new BigDecimal(costMaterialSqFtString);
       productFromTextFile.setCostMaterialSqFt(costMaterialSqFtBD);
       
       //set costLaborSqFt
       String costLaborSqFtString = tokens[2];
       BigDecimal costLaborSqFtBD = new BigDecimal(costLaborSqFtString);
       productFromTextFile.setCostLaborSqFt(costLaborSqFtBD);
       
       //return product
       return productFromTextFile;
       
    }

    
    //read the ProductInfoCosts.txt and fill the map (at the top of this class)
    @Override
    public void loadTextFile() throws DataPersistenceException {
        String textfile = "ProductInfoCosts.txt";
        Scanner scanner;
        
        try {
            scanner = new Scanner(
                new BufferedReader(
                    new FileReader(textfile)));
        } catch (FileNotFoundException e) {
            throw new DataPersistenceException("Could read from " + textfile, e);
        }
        
        String currentLine; //holds the most recent line from the file
        ProductInfoCosts currentProduct; //holds the most recent unmarshalled item
        
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine(); //read the next line in the file
            currentProduct = unmarshallProduct(currentLine); //return a newly-formed ProductInfoCosts
            
            //put info into MAP
            mapOfProductInfoCosts.put(currentProduct.getProductType(), currentProduct);
        }
        
        scanner.close();
    }
}