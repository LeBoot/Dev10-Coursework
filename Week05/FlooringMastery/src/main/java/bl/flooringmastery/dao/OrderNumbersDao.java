/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.flooringmastery.dao;

import java.util.List;

/**
 *
 * @author Boone
 */
public interface OrderNumbersDao {
    
    public List<Integer> getListOfNumbers(String testOrProd) throws DataPersistenceException;
    
    public boolean checkIsNumberInList(int numberToCheck, String testOrProd) throws DataPersistenceException;
    
    public int addNumToList(int numberToEnter, String testOrProd) throws DataPersistenceException, DuplicateDataException;

}