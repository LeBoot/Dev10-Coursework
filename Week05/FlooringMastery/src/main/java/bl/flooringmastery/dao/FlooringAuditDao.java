/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.flooringmastery.dao;

/**
 *
 * @author Boone
 */
public interface FlooringAuditDao {
    
    public void writeAuditEntry(String entry, String testOrProd) throws DataPersistenceException;
    
}