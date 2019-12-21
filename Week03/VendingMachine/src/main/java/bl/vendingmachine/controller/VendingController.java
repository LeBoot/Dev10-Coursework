/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.vendingmachine.controller;

import bl.vendingmachine.dao.VendingPersistenceException;
import bl.vendingmachine.dto.VendingItem;
import bl.vendingmachine.service.Coins;
import bl.vendingmachine.service.InsufficientFundsException;
import bl.vendingmachine.service.NoItemInventoryException;
import bl.vendingmachine.service.VendingService;
import bl.vendingmachine.ui.VendingView;
import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.List;

/**
 *
 * @author Boone
 */
public class VendingController {
    
    //dependency injection
    VendingView view;
    VendingService service;
    public VendingController(VendingView view, VendingService service) {
        this.view = view;
        this.service = service;
    }
    
    
    public void run() {
        try {
            service.loadTextFile();
            view.displayWelcomeMessage();

            boolean isStillUsing = true;
            do {
                try {
                    displaySelections();
                    String userMoney = getMoneyAndValidateIt();
                    if (userMoney.equalsIgnoreCase("exit")) {
                        isStillUsing = false;
                    } else {
                        BigDecimal moneyEntered = service.convertUserMoneyToBD(userMoney);
                        String userChoice = getChoiceAndValidateIt();
                        if (userChoice.equalsIgnoreCase("exit")) {
                            isStillUsing = false;
                        } else {
                            String userChoiceEdited = service.editUserChoice(userChoice);
                            removeItem(userChoiceEdited, moneyEntered);
                            String userPurchaseAnother = askPurchaseAnother();
                            String userPurchaseAnotherEdited = service.editUserPurchaseAnother(userPurchaseAnother);
                            if (userPurchaseAnotherEdited.equals("y")) {
                                isStillUsing = true;
                            } else {
                                isStillUsing = false;
                            }
                        }
                    }
                } catch (NoItemInventoryException e) {
                    view.displayErrorMessage(e.getMessage());
                }    
            } while (isStillUsing);
            service.writeTextFile();
        } catch (VendingPersistenceException ex) {
            view.displayErrorMessage(ex.getMessage());
        }
        view.displayFarewellMessage();
    }

    public void displaySelections() {
        //List<VendingItem> listOfItems = service.getItemsToDisplay(); <--No lambda in method
        List<VendingItem> listOfItems = service.getAllItemsNonZero(); //<-- uses lambda
        view.displaySelections(listOfItems);
    }
    
    public String getMoneyAndValidateIt() {
        String userInput;
        boolean isUserInputGood;
        do {
            userInput = view.askForMoneyOrExit();
            isUserInputGood = service.validateMoneyOrExit(userInput);
        } while (!isUserInputGood);
        return userInput;
    }
    
    public String getChoiceAndValidateIt() throws NoItemInventoryException {//, VendingPersistenceException {
        String userInput;
        boolean isUserInputGood;
        do {
            userInput = view.askForChoiceOrExit();
            isUserInputGood = service.validateChoiceOrExit(userInput);
        } while (!isUserInputGood);
        return userInput;
    }
    
    public void removeItem(String userChoice, BigDecimal userMoney) throws VendingPersistenceException {
        VendingItem itemToPurchase = service.getItem(userChoice);
        try {
            service.validateEnoughMoney(userChoice, userMoney);
            service.removeItem(userChoice);
            EnumMap<Coins, Integer> mapOfChange = service.calculateChange(userMoney, itemToPurchase);
            view.displayItemAndChange(itemToPurchase, mapOfChange);
        } catch (InsufficientFundsException e) {
            view.displayErrorMessage("You do not have enough money to purchase that item.  You only entered " 
                    + userMoney + " dollars.");
        }
    }
    
    public String askPurchaseAnother() {
        String userResponse;
        boolean isUserResponseGood;
        do {
            userResponse = view.askPurchaseAnother();
            isUserResponseGood = service.validatePurchaseAnother(userResponse);
        } while (!isUserResponseGood);
        return userResponse;
    }

}
