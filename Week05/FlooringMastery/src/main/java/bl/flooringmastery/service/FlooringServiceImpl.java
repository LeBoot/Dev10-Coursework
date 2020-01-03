/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.flooringmastery.service;

import bl.flooringmastery.dao.DataPersistenceException;
import bl.flooringmastery.dao.DuplicateDataException;
import bl.flooringmastery.dao.FlooringAuditDao;
import bl.flooringmastery.dao.FlooringOrderDao;
import bl.flooringmastery.dao.FlooringOrderDaoException;
import bl.flooringmastery.dao.OrderNumbersDao;
import bl.flooringmastery.dao.ProductInfoDao;
import bl.flooringmastery.dao.StateTaxesDao;
import bl.flooringmastery.dto.FlooringOrder;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author Boone
 */
public class FlooringServiceImpl implements FlooringService {
    
    //dependency injection -----------------------------------------------------
    ProductInfoDao productDao;
    StateTaxesDao stateTaxDao;
    OrderNumbersDao orderNumDao;
    FlooringOrderDao orderDao;
    FlooringAuditDao auditDao;

    public FlooringServiceImpl(ProductInfoDao productDao, StateTaxesDao stateTaxDao, 
            OrderNumbersDao orderNumDao, FlooringOrderDao orderDao, FlooringAuditDao auditDao) {
        this.productDao = productDao;
        this.stateTaxDao = stateTaxDao;
        this.orderNumDao = orderNumDao;
        this.orderDao = orderDao;
        this.auditDao = auditDao;
    }
    
    
    //pass-through methods -----------------------------------------------------
    @Override
    public void loadProductInfoCostsTextFile()
            throws DataPersistenceException {
        productDao.loadTextFile();
    }
    
    @Override
    public void loadStateTaxesTextFile()
            throws DataPersistenceException {
        stateTaxDao.loadTextFile();
    }
    
    @Override
    public Map<LocalDate, List<FlooringOrder>> getAllFlooringOrders(String testOrProd)
            throws FlooringOrderDaoException {
        return orderDao.getAllFlooringOrders(testOrProd);
    }
    
    @Override
    public List<FlooringOrder> getFlooringOrdersBySingleDate(LocalDate dateToPull, String testOrProd) 
            throws FlooringOrderDaoException {
        return orderDao.getFlooringOrdersBySingleDate(dateToPull, testOrProd);    
    }
    
    @Override
    public FlooringOrder getASingleFlooringOrder(String testOrProd, int orderNumber)
            throws FlooringOrderDaoException {
        return orderDao.getASingleFlooringOrder(testOrProd, orderNumber);
    }
    
    @Override
    public FlooringOrder deleteFlooringOrder(int orderNumber, String testOrProd)
            throws FlooringOrderDaoException, DataPersistenceException {
        auditDao.writeAuditEntry("Order " + orderNumber + " deleted.", testOrProd);
        return orderDao.deleteFlooringOrder(orderNumber, testOrProd);
    }
    
    @Override
    public BigDecimal getCostPerSquareFoot(String productType, String laborOrMaterial)
            throws DataPersistenceException {
        return productDao.getCostPerSqFt(productType, laborOrMaterial);
    }
    
    @Override
    public BigDecimal getTaxRate(String stateName)
            throws DataPersistenceException {
        return stateTaxDao.getTaxRate(stateName);
    }
    
    @Override
    public void addNewOrderNumberToList(int newNumber, String testOrProd)
            throws DataPersistenceException, DuplicateDataException {
        orderNumDao.addNumToList(newNumber, testOrProd);
    }
    
    
    //calculations -------------------------------------------------------------
    @Override
    public BigDecimal calculateCostLaborOrMaterialTotal(String productType, String laborOrMaterial, BigDecimal area) 
            throws DataPersistenceException {
        BigDecimal costPerSqFt = this.getCostPerSquareFoot(productType, laborOrMaterial);
        BigDecimal sumUnRounded = costPerSqFt.multiply(area);
        return sumUnRounded.setScale(2, RoundingMode.HALF_UP);
    }
    
    @Override
    public BigDecimal calculateTotalTax (String stateName, BigDecimal laborTotal, BigDecimal materialTotal) 
            throws DataPersistenceException {
        BigDecimal oneHundred = new BigDecimal("100");
        BigDecimal taxRate = this.getTaxRate(stateName).divide(oneHundred);
        BigDecimal totalCostLessTax = laborTotal.add(materialTotal);
        BigDecimal sumUnRounded = taxRate.multiply(totalCostLessTax);
        return sumUnRounded.setScale(2, RoundingMode.HALF_UP);        
    }
    
    @Override
    public BigDecimal calculateCostTotal (BigDecimal taxTotal, BigDecimal laborTotal, BigDecimal materialTotal) {
        BigDecimal sumUnRounded = taxTotal.add(laborTotal).add(materialTotal);
        return sumUnRounded.setScale(2, RoundingMode.HALF_UP);
    }
    
    
    //other methods ------------------------------------------------------------    
    @Override
    public String convertTestOrProd(int userInput) {
        if (userInput == 1) {
            return "TEST";
        } else {
            return "PROD";
        }
    }
    
    @Override
    public FlooringOrder addFlooringOrder(FlooringOrder orderToAdd, String testOrProd) 
            throws FlooringOrderDaoException, DataPersistenceException {
        //FlooringOrder comes in with the following parameters entered:
            //orderNumber, customerName, orderDate, stateName, productType, areaOfFlooring
        
        //Still need:
            //stateTaxRate, costMaterialSqFt, costLaborSqFt,
            //costMaterialTotal, costLaborTotal, totalTax, totalCost

        //set state tax rate
        String stateName = orderToAdd.getStateName();
            orderToAdd.setStateTaxRate(this.getTaxRate(stateName));
            
        //set costMaterialSqFt and costLaborSqFt
        String productType = orderToAdd.getProductType();
            orderToAdd.setCostMaterialSqFt(this.getCostPerSquareFoot(productType, "material"));
            orderToAdd.setCostLaborSqFt(this.getCostPerSquareFoot(productType, "labor"));
        
        //set costMaterialTotal and costLaborTotal
        BigDecimal area = orderToAdd.getAreaOfFlooring();
            orderToAdd.setCostMaterialTotal(this.calculateCostLaborOrMaterialTotal(productType, "material", area));
            orderToAdd.setCostLaborTotal(this.calculateCostLaborOrMaterialTotal(productType, "labor", area));
        
        //set totalTax
        BigDecimal materialCost = this.calculateCostLaborOrMaterialTotal(productType, "material", area);
        BigDecimal laborCost = this.calculateCostLaborOrMaterialTotal(productType, "labor", area);
            orderToAdd.setTotalTax(this.calculateTotalTax(stateName, laborCost, materialCost));
        
        //set totalCost
        BigDecimal taxTotal = this.calculateTotalTax(stateName, laborCost, materialCost);
            orderToAdd.setTotalCost(this.calculateCostTotal(taxTotal, laborCost, materialCost));
        
        //pass to audit method
        auditDao.writeAuditEntry("Order " + orderToAdd.getOrderNumber() + " added.", testOrProd);
        
        //pass to FlooringDAO method
        return orderDao.addFlooringOrder(orderToAdd, testOrProd);
    }
    
    @Override
    public int generateNewOrderNumber(String testOrProd) throws DataPersistenceException {
        Random randGen = new Random();
        int newOrderNum = -1;
        boolean isNumberInListAlready;
        do {
            newOrderNum = randGen.nextInt((99999 - 10001) + 1) + 10001;
            isNumberInListAlready = orderNumDao.checkIsNumberInList(newOrderNum, testOrProd);
        } while (isNumberInListAlready == true);
        return newOrderNum;
    }
    
    @Override
    public boolean validateStateName(String stateName)
            throws DataPersistenceException {
        Set<String> setOfStateNames = stateTaxDao.getListOfKeys();
        boolean isStateNameValid = false;
        for (String s : setOfStateNames) {
            if (stateName.equals(s)) {
                isStateNameValid = true;
            }
        }
        return isStateNameValid;
    }
    
    @Override
    public boolean validateProductType(String productType)
            throws DataPersistenceException {
        Set<String> setOfProductTypes = productDao.getListOfKeys();
        boolean isProductTypeValid = false;
        for (String s : setOfProductTypes) {
            if (productType.equals(s)) {
                isProductTypeValid = true;
            }
        }
        return isProductTypeValid;
    }
    
}