/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.flooringmastery.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 *
 * @author Boone
 */
public class FlooringAuditDaoImpl implements FlooringAuditDao {

    //the AUDITFILE will not be final because I change it when testing, to prevent 
        //loss of content when creating known good states
    public static String AUDITFILE = "Audit.txt";
    
    @Override
    public void writeAuditEntry(String entry, String testOrProd) throws DataPersistenceException {
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(AUDITFILE, true));
        } catch (IOException e) {
            throw new DataPersistenceException("Could not persist audit information", e);
        }
        
        if (testOrProd.equalsIgnoreCase("TEST")) {
            LocalDateTime timestamp = LocalDateTime.now();
            out.println(timestamp.toString() + " : TEST MODE : " + entry);
            out.flush();
        } else {
            LocalDateTime timestamp = LocalDateTime.now();
            out.println(timestamp.toString() + " : PRODUCTION MODE : " + entry);
            out.flush();
        }
        
        
    }
    
}
