/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.vendingmachine.dao;

import bl.vendingmachine.dto.VendingItem;
import java.util.List;

/**
 *
 * @author Boone
 */
public interface VendingDao {
    
    //if loading/writing in these methods, the exception must be thrown and eventually
        //caught in the controller.  However, since requirements dictate loading
        //and writing only at start/end of program, it is not needed in these methods
        //I am only keeping it here as a refence b/c of personal preference.
    
    List<VendingItem> getAllItems() ;//throws VendingPersistenceException;
    
    public List<VendingItem> getAllItemsNonZero();
            
    VendingItem getItem(String nameOfItem) ;//throws VendingPersistenceException;
    
    VendingItem removeItem(String nameOfItem) ;//throws VendingPersistenceException;
    
    void addItem(String nameOfItem, VendingItem item) ;//throws VendingPersistenceException;
    
    //these two methods were made public so that loading and unloading of the
        //text file could happen when the program starts and loads (per requirements),
        //instead of each time a DAO add/remove/list/etc. method is called
    public void loadTextFile() throws VendingPersistenceException;
    
    public void writeTextFile() throws VendingPersistenceException;
}