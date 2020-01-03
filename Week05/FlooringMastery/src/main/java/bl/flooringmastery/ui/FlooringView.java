/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.flooringmastery.ui;

import bl.flooringmastery.dto.FlooringOrder;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author Boone
 */
public class FlooringView {
    
    //dependency injection -----------------------------------------------------
    FlooringUserIO io;
    public FlooringView(FlooringUserIO io) {
        this.io = io;
    }
    
    
    //methods with void returns ------------------------------------------------
    public void displayErrorMessage(String prompt) {
        io.print("There was an error: " + prompt);
    }
    
    public void displayWelcomeMessage() {
        io.print("****  FLOORING MASTERY  ****");
        io.print("");
    }
    
    public void displayExitMessage() {
        io.print("");
        io.print("Thank you for using this program.  Goodbye!");
        io.print("");
        io.print("-- Program terminated. --");
    }
    
    public void displayModeEqualsTest() {
        io.print("");
        io.print("You are using the program in TEST MODE.  "
                + "Nothing you do will be saved to the production records.");
        io.print("To use this program in production mode, "
                + "you must exit and start over.");
        io.print("");
    }
    
    public void displayModeEqualsProd() {
        io.print("");
        io.print("You are using the program in PRODUCTION MODE.  "
                + "Any changes you make will be saved.");
        io.print("To use this program in test mode, "
                + "you must exit and start over.");
        io.print("");
    }
    
    public void displayMainMenu() {
        io.print("");
        io.print("====== Main Menu ======");
        io.print("1. Display all orders. ");
        io.print("2. Display orders for a certain date.");
        io.print("3. Add an order.");
        io.print("4. Delete an order.");
        io.print("5. Edit an order.");
        io.print("6. Exit program.");
    }
    
    public void displayCommenceBanner(String prompt) {
        io.print("");
        io.print("=== You've chosen to " + prompt + " ===");
    }
    
    public void displayAnOrder(FlooringOrder orderToDisplay) {
        int orderNumber = orderToDisplay.getOrderNumber();
        LocalDate orderDate = orderToDisplay.getOrderDate();
        io.print("Order Number: " + this.convertIntToString(orderNumber) +
                ";  Order Date: " + this.convertLocalDateToString(orderDate));
        
        io.print("Customer: " + orderToDisplay.getCustomerName());
        
        BigDecimal area = orderToDisplay.getAreaOfFlooring();
        BigDecimal costMaterialSqFt = orderToDisplay.getCostMaterialSqFt();
        BigDecimal costLaborSqFt = orderToDisplay.getCostLaborSqFt();
        io.print("Product: " + orderToDisplay.getProductType() +
                ";  Area: " + this.convertBigDecimalToString(area) +
                ";  Cost of materials per square foot: $" + 
                this.convertBigDecimalToString(costMaterialSqFt) +
                ";  Cost of labor per square foot: $" + 
                this.convertBigDecimalToString(costLaborSqFt));
        
        BigDecimal costMaterialTotal = orderToDisplay.getCostMaterialTotal();
        BigDecimal costLaborTotal = orderToDisplay.getCostLaborTotal();
        io.print("Total cost of material: $" + this.convertBigDecimalToString(costMaterialTotal) +
                ";  Total cost of labor: $" + this.convertBigDecimalToString(costLaborTotal));
        
        BigDecimal taxRate = orderToDisplay.getStateTaxRate();
        BigDecimal taxTotal = orderToDisplay.getTotalTax();
        io.print("State: " + orderToDisplay.getStateName() + 
                ";  State tax rate: " + this.convertBigDecimalToString(taxRate) + "%" +
                ";  Total tax: $" + this.convertBigDecimalToString(taxTotal));
        
        BigDecimal totalCost = orderToDisplay.getTotalCost();
        io.print("Total Cost: $" + this.convertBigDecimalToString(totalCost));
        
        io.print("");
    }
    
    public void displayAllFlooringOrders(Map<LocalDate, List<FlooringOrder>> mapOfOrders) {
        
        //build a sorted map that will organize in ascending order of dates
        SortedMap<LocalDate, List<FlooringOrder>> sortedMapOfOrders = new TreeMap<>(new Comparator<LocalDate>() {
            @Override
            public int compare(LocalDate date1, LocalDate date2) {
                return date1.compareTo(date2);
            }
        });
        
        //put the information from the original map into the sorted map
        sortedMapOfOrders.putAll(mapOfOrders);
        
        //create an ordered set of all the keys (dates)
        Set<LocalDate> allDatesSorted = new TreeSet<>();
        allDatesSorted = sortedMapOfOrders.keySet();
        
        //for each date (coming in order), print a header and then call a method
            //print each order for that date (by calling method)
        allDatesSorted.stream()
                .forEach(date -> {
                    io.print("");
                    io.print("===== Orders for " + date.toString() + " =====");
                    sortedMapOfOrders.get(date).stream()
                            .forEach(o -> this.displayAnOrder(o));
                });
    }
    
    public void displaySummaryOfInput(String customerName, LocalDate orderDate, 
            String stateName, String productType, BigDecimal area) {
        io.print("");
        io.print("Please confirm that this is the correct information: ");
        io.print("Customer Name: " + customerName);
        io.print("Order Date: " + this.convertLocalDateToString(orderDate));
        io.print("State: " + stateName);
        io.print("Product type: " + productType);
        io.print("Area in square feet: " + this.convertBigDecimalToString(area));
    }
    
    public void displaySummaryOfOrderForDeletion(int orderNumber, String customerName, LocalDate orderDate) {
        io.print("");
        io.print("Please confirm that you wish to delete this order: ");
        io.print("Order Number " + orderNumber + " for customer " 
                + customerName + " on " + this.convertLocalDateToString(orderDate) + ".");
    }
    
    public void displayOrderNotSaved() {
        io.print("");
        io.print("That order was not saved.");
    }

    public void displayOrderSaved(int orderNumber) {
        io.print("");
        io.print("That order has been saved under order number " + orderNumber + ".");
    }
    
    public void displayOrderNotDeleted(int orderNumber) {
        io.print("");
        io.print("No problem.  Order " + orderNumber + " has NOT been deleted.");
    }
    
    public void displayOrderDeleted(int numOfDeletedOrder) {
        io.print("");
        io.print("Order number " + numOfDeletedOrder + " has been successfully deleted.");
    }
    
    public void displayEditedOrderNotSaved() {
        io.print("");
        io.print("Any edits you just made were not saved.");
    }

    public void displayEditedOrderSaved(int orderNumber) {
        io.print("");
        io.print("Order " + orderNumber + " has been successfully edited.");
    }
    
    public void displayNoOrders() {
        io.print("There are no orders in the system.");
    }
    
    public void displayNoOrdersForDate(LocalDate dateToCheck) {
        io.print("");
        io.print("There are no orders in the system for " + dateToCheck.toString() + ".");
    }
    
    public void displayAllOrdersForADate(List<FlooringOrder> listOfOrders, LocalDate dateToDisplay) {
        io.print("");
        io.print("===== Orders for " + dateToDisplay.toString() + " =====");
        for (FlooringOrder order : listOfOrders) {
            this.displayAnOrder(order);
        }
    }
    
    public void displayNoOrder(int orderNumber) {
        io.print("");
        io.print("Your request cannot be fulfilled because order number " + orderNumber + " is not in the system.");
    }
    
    public void displayOrderToEdit(int orderNumToEdit, String customerName, 
            LocalDate orderDate, String stateName, String productType, BigDecimal area) {
        io.print("");
        io.print("Here is a summary of the order " + orderNumToEdit + ".");
        io.print("Customer name: " + customerName);
        io.print("Order date: " + this.convertLocalDateToString(orderDate));
        io.print("State: " + stateName);
        io.print("Product type: " + productType);
        io.print("Area (in square feet): " + this.convertBigDecimalToString(area));
    }
    
    
    //methods with non-void returns --------------------------------------------
    private String convertIntToString(int number) {
        return String.valueOf(number);
    }
    
    private String convertLocalDateToString(LocalDate date) {
        return date.toString();
    }
    
    private String convertBigDecimalToString(BigDecimal number) {
        return number.toPlainString();
    }
    
    public int askTestOrProd() {
        io.print("This program has two modes: Test and Production.");
        return io.readInt("Enter '1' for Test.  Enter '2' for Production: ", 1, 2);
    }
    
    public int askMainMenu() {
        return io.readInt("Please select an option from the menu above. ", 1, 6);
    }
    
    public String askNewOrderComponentPart1() {
        return io.readStringNoBlankOrNull("What is the name of the customer? ");
        //does not need validation in service layer
    }
    
    public LocalDate askNewOrderComponentPart2() {
        return io.readLocalDateDefaultPatternFutureOnly("What is the order date? ");
        //does not need validation in service layer
    }
    
    public LocalDate askNewOrderDate() {
        return io.readLocalDateDefaultPattern("What is the order date? ");
        //does not need validation in service layer
    }
    
    public String askNewOrderComponentPart3() {
        return io.readStringNoBlankOrNull("What is the state (as a two-letter postal code)? ");
        //needs validation in service layer
    }
    
    public String askNewOrderComponentPart4() {
        return io.readStringNoBlankOrNull("What is the product type (carpet, laminate, tile, or wood)? ");
        //needs validation in service layer
    }
    
    public BigDecimal askNewOrderComponentPart5() {
        BigDecimal max = new BigDecimal("9999999");
        BigDecimal min = new BigDecimal("0");
        return io.readBigDecimal("What is the area (in square feet)? ", max, min);
        //does not need validation in service layer
    }
    
    public int askUserToConfirmSave() {
        String prompt = "Please enter '1' to confirm this order and save it.  "
                + "Enter '2' to return to the main menu without saving.";
        return io.readInt(prompt, 1, 2);
    }
    
    public int askUserToConfirmDelete() {
        String prompt = "Please enter '1' to confirm this order and delete it.  "
                + "Enter '2' to return to the main menu without deleting.";
        return io.readInt(prompt, 1, 2);
    }
    
    public LocalDate askNewOrderDateToSearch() {
        return io.readLocalDateDefaultPattern("For what date would you like to view orders? ");
        //does not need validation in service layer
    }
    
     public int askOrderNumber(String prompt) {
         return io.readInt(prompt);
     }
     
     public int displayEditMenu() {
        io.print("");
        io.print("=== Edit Menu ===");
        io.print("1. Edit customer name.");
        io.print("2. Edit order date.");
        io.print("3. Edit state.");
        io.print("4. Edit product type.");
        io.print("5. Edit area.");
        io.print("6. Done editing (save).");
        io.print("7. Done editing (do not save).");
        return io.readInt("Please enter your selection: ", 1, 7);
    }
}