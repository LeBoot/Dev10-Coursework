/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.flooringmastery.dao;

import bl.flooringmastery.dto.FlooringOrder;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
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
public class FlooringOrderDaoImpl implements FlooringOrderDao {

    Map<Integer, FlooringOrder> mapOfFlooringOrders = new HashMap<>();
    
    
    @Override
    public Map<LocalDate, List<FlooringOrder>> getAllFlooringOrders(String testOrProd) throws FlooringOrderDaoException {
        LoadOrdersTextFile(testOrProd);
        return mapOfFlooringOrders.values()
                .stream()
                .collect(Collectors.groupingBy(FlooringOrder :: getOrderDate));
    }

    @Override
    public List<FlooringOrder> getFlooringOrdersBySingleDate(LocalDate dateToPull, String testOrProd) throws FlooringOrderDaoException {
        LoadOrdersTextFile(testOrProd);
        return mapOfFlooringOrders.values()
                .stream()
                .filter(o -> o.getOrderDate().equals(dateToPull))
                .collect(Collectors.toList());        
    }

    @Override
    public FlooringOrder addFlooringOrder(FlooringOrder newOrder, String testOrProd) throws FlooringOrderDaoException {
        LoadOrdersTextFile(testOrProd);
        mapOfFlooringOrders.put(newOrder.getOrderNumber(), newOrder);
        writeTextFile(testOrProd);
        return newOrder;
    }

    @Override
    public FlooringOrder deleteFlooringOrder(int orderNumber, String testOrProd) throws FlooringOrderDaoException {
        LoadOrdersTextFile(testOrProd);
        FlooringOrder orderBeingRemoved = mapOfFlooringOrders.get(orderNumber);
        mapOfFlooringOrders.remove(orderNumber);
        writeTextFile(testOrProd);
        return orderBeingRemoved;
    }
    
    @Override
    public List<FlooringOrder> getAllOrdersByOrderNumber(String testOrProd) throws FlooringOrderDaoException {
        LoadOrdersTextFile(testOrProd);
        return new ArrayList<>(mapOfFlooringOrders.values());
    }
    
    @Override
    public FlooringOrder getASingleFlooringOrder(String testOrProd, int orderNumber) throws FlooringOrderDaoException {
        LoadOrdersTextFile(testOrProd);
        return mapOfFlooringOrders.get(orderNumber);
    }
    

//   --------------------------------------------------------------------------- 
//   --------------------------------------------------------------------------- 
//   ---------------------------------------------------------------------------
//    
//   For File Persistance
//   orderNumber::customerName::orderDate::stateName::productType::Area::stateTaxRate::
        //costMaterialSqFt::costLaborSqFt::costMaterialTotal::costLaborTotal::totalTax::totalCost
//            
    

    
    //declare a constant DELIMITER and a non-constant textfile      
    public static final String DELIMITER = "::";
    public static String textfile = "Orders.txt";
    
    
    
    //this method creats a FlooringOrder from each line of the text file 
    private FlooringOrder unmarshalTextFile(String orderAsText) throws EmptyFileException {
        
        try {
            
            //create an array of strings, which have been split at the delimiter
            String[] tokens = orderAsText.split(DELIMITER);

            //retrieve the orderNumber from index 0; convert to int
            String orderNumberString = tokens[0];
            int orderNumber = Integer.parseInt(orderNumberString);

            //create a FlooringOrder from that orderNumber
            FlooringOrder orderFromTextFile = new FlooringOrder(orderNumber);

            //build the remainder of the FlooringOrder
            orderFromTextFile.setCustomerName(tokens[1]);

            LocalDate orderDate = LocalDate.parse(tokens[2]);
            orderFromTextFile.setOrderDate(orderDate);

            orderFromTextFile.setStateName(tokens[3]);

            orderFromTextFile.setProductType(tokens[4]);

            BigDecimal area = new BigDecimal(tokens[5]);
            orderFromTextFile.setAreaOfFlooring(area);

            BigDecimal stateTaxRate = new BigDecimal(tokens[6]);
            orderFromTextFile.setStateTaxRate(stateTaxRate);

            BigDecimal costMaterialSqFt = new BigDecimal(tokens[7]);
            orderFromTextFile.setCostMaterialSqFt(costMaterialSqFt);

            BigDecimal costLaborSqFt = new BigDecimal(tokens[8]);
            orderFromTextFile.setCostLaborSqFt(costLaborSqFt);

            BigDecimal costMaterialTotal = new BigDecimal(tokens[9]);
            orderFromTextFile.setCostMaterialTotal(costMaterialTotal);

            BigDecimal costLaborTotal = new BigDecimal(tokens[10]);
            orderFromTextFile.setCostLaborTotal(costLaborTotal);

            BigDecimal totalTax = new BigDecimal(tokens[11]);
            orderFromTextFile.setTotalTax(totalTax);

            BigDecimal totalCost = new BigDecimal(tokens[12]);
            orderFromTextFile.setTotalCost(totalCost);

            //return the new FlooringOrder
            return orderFromTextFile;
        
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new EmptyFileException("File was empty");
        }
          
    }
    
    
    
    //this method reads from the text file
    private void LoadOrdersTextFile(String testOrProd) throws FlooringOrderDaoException {

        if (testOrProd.equalsIgnoreCase("test")) {
            textfile = "Orders-TestMode.txt";
        }
        
        Scanner scanner;
        
        try {
            scanner = new Scanner (
                new BufferedReader(
                    new FileReader(textfile)));
        } catch (FileNotFoundException e) {
            throw new FlooringOrderDaoException("Could not load " + textfile + " into memory", e);
        }
        
        String currentLine; //to hold most-recently read line from file
        FlooringOrder currentOrder; //to hold most-recenlty unmarshalled FlooringOrder
        
        while(scanner.hasNextLine()) {
            try {
                currentLine = scanner.nextLine();
                currentOrder = unmarshalTextFile(currentLine);
                mapOfFlooringOrders.put(currentOrder.getOrderNumber(), currentOrder);
            } catch (EmptyFileException ex) {
                //empty file; that's ok.  do nothing.
            }
        }
        
        scanner.close();
    }
    
    
    
    //this method formats a FlooringOrder for writing to the text file
    private String marshallTextFile(FlooringOrder order) {
        //orderNumber::customerName::orderDate::stateName::productType::Area::stateTaxRate::
        //costMaterialSqFt::costLaborSqFt::costMaterialTotal::costLaborTotal::totalTax::totalCost
        
        //get needed info and convert to strings
        int orderNumber = order.getOrderNumber();
        String orderNumberStr = String.valueOf(orderNumber);
        
        String customerName = order.getCustomerName();
        
        LocalDate orderDate = order.getOrderDate();
        String orderDateStr = orderDate.toString();
        
        String stateName = order.getStateName();
        
        String productType = order.getProductType();
        
        BigDecimal areaBD = order.getAreaOfFlooring();
        String areaStr = areaBD.toPlainString();
        
        BigDecimal stateTaxRateBD = order.getStateTaxRate();
        String stateTaxRateStr = stateTaxRateBD.toPlainString();
        
        BigDecimal costMaterialSqFtBD = order.getCostMaterialSqFt();
        String costMaterialSqFtStr = costMaterialSqFtBD.toPlainString();
        
        BigDecimal costLaborSqFtBD = order.getCostLaborSqFt();
        String costLaborSqFtStr = costLaborSqFtBD.toPlainString();
        
        BigDecimal costMaterialTotalBD = order.getCostMaterialTotal();
        String costMaterialTotalStr = costMaterialTotalBD.toPlainString();
        
        BigDecimal costLaborTotalBD = order.getCostLaborTotal();
        String costLaborTotalStr = costLaborTotalBD.toPlainString();
        
        BigDecimal totalTaxBD = order.getTotalTax();
        String totalTaxStr = totalTaxBD.toPlainString();
        
        BigDecimal totalCostBD = order.getTotalCost();
        String totalCostStr = totalCostBD.toPlainString();
        
        //create a giant string
        String orderAsText = orderNumberStr + DELIMITER;
        orderAsText += customerName + DELIMITER;
        orderAsText += orderDateStr + DELIMITER;
        orderAsText += stateName + DELIMITER;
        orderAsText += productType + DELIMITER;
        orderAsText += areaStr + DELIMITER;
        orderAsText += stateTaxRateStr + DELIMITER;
        orderAsText += costMaterialSqFtStr + DELIMITER;
        orderAsText += costLaborSqFtStr + DELIMITER;
        orderAsText += costMaterialTotalStr + DELIMITER;
        orderAsText += costLaborTotalStr + DELIMITER;
        orderAsText += totalTaxStr + DELIMITER;
        orderAsText += totalCostStr;
                
        //return FlooringOrder as text
        return orderAsText;
    }
    
    
    
    //this method writes the text-string to the text file
    private void writeTextFile(String testOrProd) throws FlooringOrderDaoException {
        if (testOrProd.equalsIgnoreCase("test")) {
            textfile = "Orders-TestMode.txt";
        }     
        
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(textfile));
        } catch (IOException e) {
            throw new FlooringOrderDaoException("Could not save data", e);
        }
        
        String flooringOrderAsText;
        
        List<FlooringOrder> listOfFlooringOrders = this.getAllOrdersByOrderNumber(testOrProd);
        for (FlooringOrder currentOrder : listOfFlooringOrders) {
            flooringOrderAsText = marshallTextFile(currentOrder);
            out.println(flooringOrderAsText);
            out.flush();
        }
        
        out.close();   
    }
    
}