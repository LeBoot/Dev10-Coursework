/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.flooringmastery.dao;

import java.math.BigDecimal;
import java.util.Set;

/**
 *
 * @author Boone
 */
public interface ProductInfoDao {
    
    public BigDecimal getCostPerSqFt(String productType, String whichCost) throws DataPersistenceException;
    
    public Set<String> getListOfKeys() throws DataPersistenceException;
    
    public void loadTextFile() throws DataPersistenceException;
    
}