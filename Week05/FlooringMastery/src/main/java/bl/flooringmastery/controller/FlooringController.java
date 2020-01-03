/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.flooringmastery.controller;

import bl.flooringmastery.dao.DataPersistenceException;
import bl.flooringmastery.dao.DuplicateDataException;
import bl.flooringmastery.dao.FlooringOrderDaoException;
import bl.flooringmastery.dto.FlooringOrder;
import bl.flooringmastery.service.FlooringService;
import bl.flooringmastery.ui.FlooringView;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Boone
 */
public class FlooringController {
    
    //dependency injection -----------------------------------------------------
    FlooringView view;
    FlooringService service;
    public FlooringController(FlooringView view, FlooringService service) {
        this.view = view;
        this.service = service;
    }
    
    
    //run method ---------------------------------------------------------------
    public void run() {
        
        boolean isProgramRunning = true;
        
        try {
            service.loadProductInfoCostsTextFile();
            service.loadStateTaxesTextFile();
        } catch (DataPersistenceException e) {
            view.displayErrorMessage(e.getMessage());
            isProgramRunning = false;
        }
        
        view.displayWelcomeMessage();
        
        String testOrProd = askTestOrProductionMode();
        notifyUserTypeOfPlay(testOrProd);
               
        while (isProgramRunning) {
            try {
                int userChoice = mainMenu();
                switch (userChoice) {
                    case 1: //display all orders
                        displayAllOrders(testOrProd);
                        break;
                    case 2: //display orders by date
                        displayOrdersForADate(testOrProd);
                        break;
                    case 3: //add an order
                        addOrder(testOrProd);
                        break;
                    case 4: //delete an order
                        deleteOrder(testOrProd);
                        break;
                    case 5: //edit an order
                        editOrder(testOrProd);
                        break;
                    case 6: //exit
                        isProgramRunning = false;
                        break;
                    default: //unknown option; exit the program
                        view.displayErrorMessage("That command did not register properly.");
                        isProgramRunning = false;                
                        break;
                }
            } catch (FlooringOrderDaoException | DataPersistenceException | DuplicateDataException ex) {
                view.displayErrorMessage(ex.getMessage());
            }
        }
        view.displayExitMessage();
    }
    
    
    //switch methods -----------------------------------------------------------
    
    private void displayAllOrders(String testOrProd) throws FlooringOrderDaoException { //switch case 1
        view.displayCommenceBanner("display all orders");
        Map<LocalDate, List<FlooringOrder>> mapOfOrders = service.getAllFlooringOrders(testOrProd);
        if (mapOfOrders.isEmpty()) {
            view.displayNoOrders();
        } else {
            view.displayAllFlooringOrders(mapOfOrders);
        }
    }
    
    private void displayOrdersForADate(String testOrProd) throws FlooringOrderDaoException { //switch case 2
        view.displayCommenceBanner("display orders for a certain date");
        LocalDate dateToCheck = view.askNewOrderDateToSearch();
        List<FlooringOrder> listOfOrders = service.getFlooringOrdersBySingleDate(dateToCheck, testOrProd);
        if (listOfOrders.isEmpty()) {
            view.displayNoOrdersForDate(dateToCheck);
        } else {
            view.displayAllOrdersForADate(listOfOrders, dateToCheck);
        }
    }
    
    private void addOrder(String testOrProd) 
            throws DataPersistenceException, 
            DuplicateDataException, 
            FlooringOrderDaoException { //switch case 3
        int newOrderNumber = service.generateNewOrderNumber(testOrProd);
        view.displayCommenceBanner("add an order");
        String customerName = view.askNewOrderComponentPart1();
        LocalDate orderDate = view.askNewOrderComponentPart2();
        
        boolean isStateNameValid;
        String stateName;
        do {
            stateName = view.askNewOrderComponentPart3().toUpperCase().strip();
            isStateNameValid = service.validateStateName(stateName);
            if (!isStateNameValid) {
                view.displayErrorMessage("That was not a valid input for a state.");
            }
        } while (!isStateNameValid);
        
        boolean isProductTypeValid;
        String productType;
        do {
            productType = view.askNewOrderComponentPart4().toLowerCase().strip();
            isProductTypeValid = service.validateProductType(productType);
            if (!isProductTypeValid) {
                view.displayErrorMessage("That was not a valid input for a product type.");
            }
        } while (!isProductTypeValid);
        
        BigDecimal area = view.askNewOrderComponentPart5();
        
        view.displaySummaryOfInput(customerName, orderDate, stateName, productType, area);
        int userChoice = view.askUserToConfirmSave();
        if (userChoice == 2) {
            view.displayOrderNotSaved();
        } else {
            FlooringOrder newOrder = new FlooringOrder(newOrderNumber);
            newOrder.setCustomerName(customerName);
            newOrder.setOrderDate(orderDate);
            newOrder.setStateName(stateName);
            newOrder.setProductType(productType);
            newOrder.setAreaOfFlooring(area);
            service.addNewOrderNumberToList(newOrderNumber, testOrProd);
            FlooringOrder orderAdded = service.addFlooringOrder(newOrder, testOrProd);
            view.displayOrderSaved(orderAdded.getOrderNumber());
        }    
    }
    
    private void deleteOrder(String testOrProd) throws FlooringOrderDaoException, DataPersistenceException { //switch case 4
        view.displayCommenceBanner("delete an order");
        int orderNumToDelete = view.askOrderNumber("Please enter the order number for the order you want to delete: ");
        FlooringOrder orderToDelete = service.getASingleFlooringOrder(testOrProd, orderNumToDelete);
        if (orderToDelete == null) {
            view.displayNoOrder(orderNumToDelete);
        } else {
            int orderNumber = orderToDelete.getOrderNumber();
            String customerName = orderToDelete.getCustomerName();
            LocalDate orderDate = orderToDelete.getOrderDate();           
            view.displaySummaryOfOrderForDeletion(orderNumber, customerName, orderDate);
            
            int userChoice = view.askUserToConfirmDelete();
            if (userChoice == 2) {
                view.displayOrderNotDeleted(orderNumber);
            } else {
                FlooringOrder deletedOrder = service.deleteFlooringOrder(orderNumber, testOrProd);
                int numOfDeletedOrder = deletedOrder.getOrderNumber();
                view.displayOrderDeleted(numOfDeletedOrder);
            }        
        }        
    }
    
    private void editOrder(String testOrProd) throws FlooringOrderDaoException, DataPersistenceException { //switch case 5
        view.displayCommenceBanner("edit an order");
        int orderNumToEdit = view.askOrderNumber("Please enter the order number for the order you want to Edit: ");
        FlooringOrder orderToEdit = service.getASingleFlooringOrder(testOrProd, orderNumToEdit);
        if (orderToEdit == null) {
            view.displayNoOrder(orderNumToEdit);
        } else {
            String customerName = orderToEdit.getCustomerName();
            LocalDate orderDate = orderToEdit.getOrderDate();
            String stateName = orderToEdit.getStateName();
            String productType = orderToEdit.getProductType();
            BigDecimal area = orderToEdit.getAreaOfFlooring();
            view.displayOrderToEdit(orderNumToEdit, customerName, orderDate, stateName, productType, area);
            
            boolean isDoneEditing = false;
            
            String newCustomerName = customerName;
            LocalDate newOrderDate = orderDate;
            String newStateName = stateName;
            String newProductType = productType;
            BigDecimal newArea = area;
            
            do {
                int userChoice = view.displayEditMenu();
                switch (userChoice) {
                    case 1: //edit customer name
                        newCustomerName = view.askNewOrderComponentPart1();
                        break;
                    case 2: //edit order date
                        newOrderDate = view.askNewOrderDate();
                        break;
                    case 3: //edit state
                        boolean isStateNameValid;
                        do {
                            newStateName = view.askNewOrderComponentPart3().toUpperCase().strip();
                            isStateNameValid = service.validateStateName(newStateName);
                            if (!isStateNameValid) {
                                view.displayErrorMessage("That was not a valid input for a state.");
                            }
                        } while (!isStateNameValid);
                        break;
                    case 4: //edit product type
                        boolean isProductTypeValid;
                        do {
                            newProductType = view.askNewOrderComponentPart4().toLowerCase().strip();
                            isProductTypeValid = service.validateProductType(newProductType);
                            if (!isProductTypeValid) {
                                view.displayErrorMessage("That was not a valid input for a product type.");
                            }
                        } while (!isProductTypeValid);
                        break;
                    case 5: //edit area
                        newArea = view.askNewOrderComponentPart5();
                        break;
                    case 6: //done editing, save
                        FlooringOrder deletedOrder = service.deleteFlooringOrder(orderNumToEdit, testOrProd);
                        FlooringOrder newEditedOrder = new FlooringOrder(deletedOrder.getOrderNumber());
                        newEditedOrder.setCustomerName(newCustomerName);
                        newEditedOrder.setOrderDate(newOrderDate);
                        newEditedOrder.setStateName(newStateName);
                        newEditedOrder.setProductType(newProductType);
                        newEditedOrder.setAreaOfFlooring(newArea);
                        FlooringOrder addedOrder = service.addFlooringOrder(newEditedOrder, testOrProd);
                        view.displayEditedOrderSaved(addedOrder.getOrderNumber());
                        isDoneEditing = true;
                        break;
                    case 7: //done editing, do not save
                        view.displayEditedOrderNotSaved();
                        isDoneEditing = true;
                        break;                                
                }                
            } while (!isDoneEditing);
        }
    }

    
    //other methods ------------------------------------------------------------
    
    private String askTestOrProductionMode() {
        int userInput = view.askTestOrProd();
        return service.convertTestOrProd(userInput);
    }
    
    private void notifyUserTypeOfPlay(String typeOfPlay) {
        switch (typeOfPlay) {
            case "TEST":
                view.displayModeEqualsTest();
                break;
            case "PROD":
                view.displayModeEqualsProd();
                break;
            default:
                view.displayErrorMessage("That command did not register properly.");
                break;
        }
    }
  
    private int mainMenu() {
        view.displayMainMenu();
        return view.askMainMenu();
    }

}