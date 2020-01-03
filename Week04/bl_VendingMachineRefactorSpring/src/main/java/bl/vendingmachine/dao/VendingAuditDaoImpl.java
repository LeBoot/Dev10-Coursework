/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.vendingmachine.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 *
 * @author Boone
 */
public class VendingAuditDaoImpl implements VendingAuditDao {
    
    //the AUDITFILE will not be final because I change it when testing, to prevent 
        //loss of content when creating known good states
    public static String AUDITFILE = "VendingAudit.txt";
    
    @Override
    public void writeAuditEntry(String entry) throws VendingPersistenceException {
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(AUDITFILE, true));
        } catch (IOException e) {
            throw new VendingPersistenceException("Could not persist audit information", e);
        }
        
        LocalDateTime timestamp = LocalDateTime.now();
        out.println(timestamp.toString() + " : " + entry);
        out.flush();
    }
    
}