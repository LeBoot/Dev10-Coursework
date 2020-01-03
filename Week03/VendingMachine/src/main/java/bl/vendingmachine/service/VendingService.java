/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.vendingmachine.service;

import bl.vendingmachine.dao.VendingPersistenceException;
import bl.vendingmachine.dto.VendingItem;
import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.List;

/**
 *
 * @author Boone
 */
public interface VendingService {
    
    public List<VendingItem> getItemsToDisplay();
            
    public boolean validateMoneyOrExit(String userInput);
    
    public boolean validateChoiceOrExit(String userInput)
            throws NoItemInventoryException;
                //VendingPersistenceException;
    
    public boolean validatePurchaseAnother(String userInput);
    
    public String editUserPurchaseAnother(String userInput);
    
    public String editUserChoice(String userInput);
    
    public BigDecimal convertUserMoneyToBD(String userInput);
    
    public EnumMap<Coins, Integer> calculateChange(BigDecimal userMoney, VendingItem item);
    
    public EnumMap<Coins, Integer>calculateChangeInsufficientFunds(BigDecimal userMoney);
    
    public void validateEnoughMoney(String userChoice, BigDecimal userMoney)
            throws //VendingPersistenceException,
                InsufficientFundsException;
    
    public void removeItem(String nameOfItem) throws VendingPersistenceException;
    
    //pass-through methods -----------------------------------------------------
    public List<VendingItem> getAllItems() ;//throws VendingPersistenceException;
    
    public VendingItem getItem(String nameOfItem) ;//throws VendingPersistenceException;
    
    public void loadTextFile() throws VendingPersistenceException;
    
    public void writeTextFile() throws VendingPersistenceException;
    
    public List<VendingItem> getAllItemsNonZero();
}