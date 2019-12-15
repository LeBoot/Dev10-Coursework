/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.mp3project.controller.dao;

/**
 *
 * @author Boone
 */
public class mp3ProjectDaoException extends Exception{
    
    public mp3ProjectDaoException(String message) {
        super(message);
    }
    
    public mp3ProjectDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}