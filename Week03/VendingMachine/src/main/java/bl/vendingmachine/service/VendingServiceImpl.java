/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.vendingmachine.service;

import bl.vendingmachine.dao.VendingAuditDao;
import bl.vendingmachine.dao.VendingDao;
import bl.vendingmachine.dao.VendingPersistenceException;
import bl.vendingmachine.dto.VendingItem;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

/**
 *
 * @author Boone
 */
public class VendingServiceImpl implements VendingService{

    //constructor
    VendingDao dao;
    VendingAuditDao auditDao;
    public VendingServiceImpl(VendingDao dao, VendingAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }
    
    @Override
    //this functaionality is accomplished by method getAllItemsNonZero()
    public List<VendingItem> getItemsToDisplay() {
        List<VendingItem> listOfItemsRaw = getAllItems();
        List<VendingItem> listOfItemsToDisplay = new ArrayList<>();
        for (VendingItem vi : listOfItemsRaw) {
            if (vi.getQuantityOfItem() > 0) {
                listOfItemsToDisplay.add(vi);
            }
        }
        return listOfItemsToDisplay;
    }
    
    @Override
    public boolean validateMoneyOrExit(String userInput) {
        if (userInput.equalsIgnoreCase("exit")) {
            return true;
        } else {
            try {
                BigDecimal bd = new BigDecimal(userInput);
                BigDecimal zero = new BigDecimal("0");
                if (bd.compareTo(zero) >= 0) {
                    return true;
                } else {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
    }
    
    @Override
    public boolean validateChoiceOrExit(String userResponse) throws NoItemInventoryException {//VendingPersistenceException {
        String userInput = userResponse.strip().toLowerCase();
        if (userInput.equals("exit")) {
            return true;
        } else {
            //try {
                if (dao.getItem(userInput) == null) {
                    return false;
                } else {
                    if (dao.getItem(userInput).getQuantityOfItem() == 0) {
                        throw new NoItemInventoryException("Item out of stock.");
                    } else {
                        return true;
                    }
                }
            //} catch (VendingPersistenceException ex) {
              //  throw new VendingPersistenceException("Could not 'getItem'", ex);
            //}
        }
    }
    
    @Override
    public boolean validatePurchaseAnother(String userInput) {
        if ((userInput == null) || (userInput.trim().length() == 0)) {
            return false;
        } else {
            String croppedInput = userInput.toLowerCase().strip().substring(0, 1);
            if ((croppedInput.equals("y")) || (croppedInput.equals("n"))) {
                return true;
            } else {
                return false;
            }   
        }   
    }
    
    @Override
    public String editUserPurchaseAnother(String userInput) {
        String croppedInput = userInput.toLowerCase().strip().substring(0, 1);
        return croppedInput;
    }
    
    @Override
    public String editUserChoice(String userInput) {
        String editedInput = userInput.strip().toLowerCase();
        return editedInput;
    }
    
    @Override
    public BigDecimal convertUserMoneyToBD(String userInput) {
        BigDecimal bd = new BigDecimal(userInput);
        BigDecimal bdRounded = bd.setScale(2, RoundingMode.HALF_UP);
        return bdRounded;
    }
    
    @Override
    public EnumMap<Coins, Integer> calculateChange(BigDecimal userMoney, VendingItem item) {
        BigDecimal itemPrice = item.getPriceOfItem();        
        BigDecimal difference = userMoney.subtract(itemPrice);
        
        int numQuarters = 0;
        int numDimes = 0;
        int numNickels = 0;
        int numPennies = 0;
        
        while (difference.compareTo(Coins.QUARTERS.getValue()) >= 0) {
            numQuarters += 1;
            difference = difference.subtract(Coins.QUARTERS.getValue());
        }
        while (difference.compareTo(Coins.DIMES.getValue()) >= 0) {
            numDimes += 1;
            difference = difference.subtract(Coins.DIMES.getValue());
        }
        while (difference.compareTo(Coins.NICKELS.getValue()) >= 0) {
            numNickels += 1;
            difference = difference.subtract(Coins.NICKELS.getValue());
        }
        while (difference.compareTo(Coins.PENNIES.getValue()) >= 0) {
            numPennies += 1;
            difference = difference.subtract(Coins.PENNIES.getValue());
        }
        
        EnumMap<Coins, Integer> mapOfCoins = new EnumMap<>(Coins.class);
        mapOfCoins.put(Coins.QUARTERS, numQuarters);
        mapOfCoins.put(Coins.DIMES, numDimes);
        mapOfCoins.put(Coins.NICKELS, numNickels);
        mapOfCoins.put(Coins.PENNIES, numPennies);
        
        return mapOfCoins;
    }
    
    @Override
    public EnumMap<Coins, Integer>calculateChangeInsufficientFunds(BigDecimal userMoney) {     
        int numQuarters = 0;
        int numDimes = 0;
        int numNickels = 0;
        int numPennies = 0;
        
        while (userMoney.compareTo(Coins.QUARTERS.getValue()) >= 0) {
            numQuarters += 1;
            userMoney = userMoney.subtract(Coins.QUARTERS.getValue());
        }
        while (userMoney.compareTo(Coins.DIMES.getValue()) >= 0) {
            numDimes += 1;
            userMoney = userMoney.subtract(Coins.DIMES.getValue());
        }
        while (userMoney.compareTo(Coins.NICKELS.getValue()) >= 0) {
            numNickels += 1;
            userMoney = userMoney.subtract(Coins.NICKELS.getValue());
        }
        while (userMoney.compareTo(Coins.PENNIES.getValue()) >= 0) {
            numPennies += 1;
            userMoney = userMoney.subtract(Coins.PENNIES.getValue());
        }
        
        EnumMap<Coins, Integer> mapOfCoins = new EnumMap<>(Coins.class);
        mapOfCoins.put(Coins.QUARTERS, numQuarters);
        mapOfCoins.put(Coins.DIMES, numDimes);
        mapOfCoins.put(Coins.NICKELS, numNickels);
        mapOfCoins.put(Coins.PENNIES, numPennies);
        
        return mapOfCoins;
    }
    
    @Override
    public void validateEnoughMoney(String userChoice, BigDecimal userMoney) throws InsufficientFundsException {
        VendingItem item = dao.getItem(userChoice);
        BigDecimal itemPrice = item.getPriceOfItem();
        int compareIsEnoughMoney = userMoney.compareTo(itemPrice);
        if (compareIsEnoughMoney < 0) {
            throw new InsufficientFundsException("You do not have enough money to purchase that item.");
        }
    }
    
    @Override
    public void removeItem(String nameOfItem) throws VendingPersistenceException {
        VendingItem removedItem = dao.removeItem(nameOfItem);
        int oldQuantity = removedItem.getQuantityOfItem();
        int newQuantity = oldQuantity - 1;
        removedItem.setQuantityOfItem(newQuantity);
        auditDao.writeAuditEntry(removedItem.getNameOfItem() + " removed.  Quantity before removal: " + oldQuantity
            + ".  Quantity after removal: " + newQuantity + ".");
        
        dao.addItem(nameOfItem, removedItem);
    }
    
    //pass-through methods -----------------------------------------------------
    @Override
    public List<VendingItem> getAllItems() {//throws VendingPersistenceException {
        return dao.getAllItems();
    }
    
    @Override
    public VendingItem getItem(String nameOfItem) {//throws VendingPersistenceException {
        return dao.getItem(nameOfItem);
    }
    
    @Override
    public void loadTextFile() throws VendingPersistenceException {
        dao.loadTextFile();
    }
    
    @Override
    public void writeTextFile() throws VendingPersistenceException {
        dao.writeTextFile();
    }
    
    @Override
    public List<VendingItem> getAllItemsNonZero() {
        return dao.getAllItemsNonZero();
    }
    
}