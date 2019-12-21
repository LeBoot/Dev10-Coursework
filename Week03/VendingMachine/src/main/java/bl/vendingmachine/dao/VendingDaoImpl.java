/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.vendingmachine.dao;

import bl.vendingmachine.dto.VendingItem;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author Boone
 */
public class VendingDaoImpl implements VendingDao {

    //VendingItem objects will be stored in this map, with key = nameOfItem
    Map<String, VendingItem> mapOfItems = new HashMap<>();
    
    
    //Overridden methods from interface ----------------------------------------
    //if loading/writing in these methods, the exception must be thrown and eventually
        //caught in the controller.  However, since requirements dictate loading
        //and writing only at start/end of program, it is not needed in these methods
        //I am only keeping it here as a refence b/c of personal preference.
    
    @Override
    public List<VendingItem> getAllItems() { //throws VendingPersistenceException {
        //loadTextFile();
        return new ArrayList<VendingItem>(mapOfItems.values());
    }

    @Override //this method uses a lambda
    public List<VendingItem> getAllItemsNonZero() {
        return mapOfItems.values()
                .stream()
                .filter(v -> v.getQuantityOfItem() > 0 )
                .collect(Collectors.toList());
    }
    
    @Override
    public VendingItem getItem(String nameOfItem) { //throws VendingPersistenceException {
        //loadTextFile();
        return mapOfItems.get(nameOfItem);
    }

    @Override
    public VendingItem removeItem(String nameOfItem) { //throws VendingPersistenceException {
        //loadTextFile();
        VendingItem removedItem = mapOfItems.remove(nameOfItem);
        //writeTextFile();
        return removedItem; //return this for audit's sake
    }
    
    @Override
    public void addItem(String nameOfItem, VendingItem item) { //throws VendingPersistenceException {
        //loadTextFile();
        VendingItem newItem = mapOfItems.put(nameOfItem, item);
        //writeTextFile();
    }
    
    
    //methods for persistence, marshalling, and unmarshalling ------------------
    
    //create constants
        //the textfile will not be final because I change it when testing, to
        //prevent loss of content when creating known good states
    public static final String DELIMITER = "::";
    public static String TEXTFILE = "Inventory.txt";
    
    
    
    //unmarshall item-as-text string and re-form a VendingItem
    //format=  nameOfItem::priceOfItem::quantityOfItem
    private VendingItem unmarshallItem(String itemAsText) {
        String[] tokens = itemAsText.split(DELIMITER);
        
        //create an item based off nameOfItem
        String nameOfItem = tokens[0];
        VendingItem itemFromTextFile = new VendingItem(nameOfItem);
        
        //create price
        String priceStr = tokens[1];
        BigDecimal priceBD = new BigDecimal(priceStr);
        itemFromTextFile.setPriceOfItem(priceBD);
        
        //create quantity
        int quantity = Integer.parseInt(tokens[2]);
        itemFromTextFile.setQuantityOfItem(quantity);
        
        //return new VendingItem
        return itemFromTextFile;
    }
    
    
    
    //read the text file and fill the HashMap (at top of this class)
    @Override
    public void loadTextFile() throws VendingPersistenceException {
        Scanner scanner;
        
        try {
            scanner = new Scanner(
                new BufferedReader(
                    new FileReader(TEXTFILE)));
        } catch (FileNotFoundException e) {
            throw new VendingPersistenceException("Could not load data from text file into memory", e);
        }
        
        String currentLine; //holds the most recent line from the file
        VendingItem currentItem; //holds the most recent unmarshalled VendingItem
        
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine(); //read the next line in the file
            currentItem = unmarshallItem(currentLine); //return a newly-formed VendingItem
            
            //put new VendingItem into the HashMap (at top of this class)
            mapOfItems.put(currentItem.getNameOfItem(), currentItem);
        }
        
        scanner.close(); 
    }
    
    
    
    //take a VendingItem and turn it into a string for the text file
    //format=  nameOfItem::priceOfItem::quantityOfItem
    private String marshallItem(VendingItem item) {
        
        //get everything as a string
        String itemAsText = item.getNameOfItem();
        
        BigDecimal itemPriceBD = item.getPriceOfItem();
        String itemPriceStr = String.valueOf(itemPriceBD);
        
        int itemQuantityInt = item.getQuantityOfItem();
        String itemQuantityStr = String.valueOf(itemQuantityInt);
        
        //create one big string
        itemAsText += DELIMITER;
        itemAsText += itemPriceStr + DELIMITER;
        itemAsText += itemQuantityStr;
        
        //return newly-created string
        return itemAsText;
    }
    
    
    
    //description
    @Override
    public void writeTextFile() throws VendingPersistenceException {
        PrintWriter out;
        
        try {
            out = new PrintWriter(
                new FileWriter(TEXTFILE));
        } catch (IOException e) {
            throw new VendingPersistenceException("Could not write data to text file", e);
        }
        
        //call method (defined above) to get all items in HashMap as a list
        List<VendingItem> listOfItems = this.getAllItems();
        
        //for every VendingItem, turn it into a text string (by calling method above)
        //and write it to the text file
        String itemAsText;
        for (VendingItem vi : listOfItems) {
            itemAsText = marshallItem(vi);
            out.println(itemAsText);
            out.flush(); //for any buffered data to print
        }
        
        out.close(); //to prevent memory leaks
    }
}