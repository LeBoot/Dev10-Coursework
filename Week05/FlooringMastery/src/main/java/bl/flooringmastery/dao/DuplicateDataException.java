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
public class DuplicateDataException extends Exception {
    
    public DuplicateDataException(String message) {
        super(message);
    }
    
    public DuplicateDataException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
