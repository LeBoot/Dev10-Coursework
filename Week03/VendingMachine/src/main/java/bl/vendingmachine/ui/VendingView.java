/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.vendingmachine.ui;

import bl.vendingmachine.dto.VendingItem;
import bl.vendingmachine.service.Coins;
import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.List;

/**
 *
 * @author Boone
 */
public class VendingView {
    
    //dependency injection
    VendingUserIO io;
    public VendingView(VendingUserIO io) {
        this.io = io;
    }
    
    //banners and other void methods -------------------------------------------
    public void displayWelcomeMessage() {
        io.print("");
        io.print("Welcome to Ben's Vending Machine!");
        io.print("");
    }
    
    public void displayFarewellMessage() {
        io.print("");
        io.print("Program terminated.  Goodbye!");
    }
    
    public void displayErrorMessage(String prompt) {
        io.print("There was an error: " + prompt);
    }
    
    public void displaySelections(List<VendingItem> mapOfItems) {
        io.print("");
        io.print("========== SELECTIONS ==========");
        for (VendingItem vi : mapOfItems) {
            io.print(vi.getNameOfItem() + ":  price = $"
            + vi.getPriceOfItem() + ", quantity remaining = "
            + vi.getQuantityOfItem());
        }
        io.print("");
    }
    
    public void displayItemAndChange(VendingItem item, EnumMap<Coins, Integer> map) {
        int numQuarters = map.get(Coins.QUARTERS);
        int numDimes = map.get(Coins.DIMES);
        int numNickels = map.get(Coins.NICKELS);
        int numPennies = map.get(Coins.PENNIES);
        io.print("");
        io.print("Congratulations!  You have purchased " + item.getNameOfItem());
        io.print("Your change is the following:");
        io.print("Quarters: " + numQuarters + "; Dimes: " + numDimes
            + "; Nickels: " + numNickels + "; Pennies: " + numPennies);
    }
    
    public void displayOnlyChange(BigDecimal moneyEntered, EnumMap<Coins, Integer> map) {
        int numQuarters = map.get(Coins.QUARTERS);
        int numDimes = map.get(Coins.DIMES);
        int numNickels = map.get(Coins.NICKELS);
        int numPennies = map.get(Coins.PENNIES);
        io.print("Your change is the following:");
        io.print("Quarters: " + numQuarters + "; Dimes: " + numDimes
            + "; Nickels: " + numNickels + "; Pennies: " + numPennies);
        io.print("");
    }
    
    //methods that have non-void returns ---------------------------------------
    
    public String askForMoneyOrExit() {
        return io.readString("Please enter the amount you wish to spend, or enter 'exit' to leave.");
    }
    
    public String askForChoiceOrExit() {
        return io.readString("Please enter your choice, or enter 'exit' to leave.");
    }
    
    public String askPurchaseAnother() {
        return io.readString("Would you like to purchase something else? (y/n): ");
    }
     
}