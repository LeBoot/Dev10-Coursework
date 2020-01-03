/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.flooringmastery.service;

import bl.flooringmastery.dao.DataPersistenceException;
import bl.flooringmastery.dao.DuplicateDataException;
import bl.flooringmastery.dao.FlooringOrderDaoException;
import bl.flooringmastery.dto.FlooringOrder;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Boone
 */
public interface FlooringService {

    //pass-through methods -----------------------------------------------------
    public void loadProductInfoCostsTextFile() 
            throws DataPersistenceException;
    
    public void loadStateTaxesTextFile() 
            throws DataPersistenceException;
    
    public Map<LocalDate, List<FlooringOrder>> getAllFlooringOrders(String testOrProd) 
            throws FlooringOrderDaoException;
    
    public List<FlooringOrder> getFlooringOrdersBySingleDate(LocalDate dateToPull, String testOrProd) 
            throws FlooringOrderDaoException;
    
    public FlooringOrder getASingleFlooringOrder(String testOrProd, int orderNumber) 
            throws FlooringOrderDaoException;
    
    public FlooringOrder deleteFlooringOrder(int orderNumber, String testOrProd) 
            throws FlooringOrderDaoException, DataPersistenceException;
    
    public BigDecimal getCostPerSquareFoot(String productType, String laborOrMaterial) 
            throws DataPersistenceException;
    
    public BigDecimal getTaxRate(String stateName) 
            throws DataPersistenceException;
    
    public void addNewOrderNumberToList(int newNumber, String testOrProd)
            throws DataPersistenceException, DuplicateDataException;
    
    //calculations -------------------------------------------------------------
    public BigDecimal calculateCostLaborOrMaterialTotal(String productType, String laborOrMaterial, BigDecimal area) 
            throws DataPersistenceException;
    
    public BigDecimal calculateTotalTax (String stateName, BigDecimal laborTotal, BigDecimal materialTotal) 
            throws DataPersistenceException;
    
    public BigDecimal calculateCostTotal (BigDecimal taxTotal, BigDecimal laborTotal, BigDecimal materialTotal);
    
    
    //other methods ------------------------------------------------------------    
    public String convertTestOrProd(int userInput);
    
    public FlooringOrder addFlooringOrder(FlooringOrder orderToAdd, String testOrProd) 
            throws FlooringOrderDaoException, DataPersistenceException;
    
    public int generateNewOrderNumber(String testOrProd)
            throws DataPersistenceException;
    
    public boolean validateStateName(String stateName)
            throws DataPersistenceException;
    
    public boolean validateProductType(String productType)
            throws DataPersistenceException;
    
}