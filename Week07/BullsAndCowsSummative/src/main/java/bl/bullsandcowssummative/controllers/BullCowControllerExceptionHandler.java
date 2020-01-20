/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.bullsandcowssummative.controllers;

import java.sql.SQLIntegrityConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author Boone
 */
@ControllerAdvice //indicates our class will assist all controllers in our project
@RestController //indicates our class is able to serve an HTTP response on behalf of a controller.
public class BullCowControllerExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String CONSTRAINT_MESSAGE = "Could not save your item. "
            + "Please ensure it is valid and try again.";

    //There can be one or more methods, but each method must accept a Java exception 
        //and WebRequest as parameters and return a ResponseEntity<T>
    
    //annotate each method to indicate which exception its handling
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public final ResponseEntity<Error> handleSqlException(
            SQLIntegrityConstraintViolationException ex,
            WebRequest request) {

        Error err = new Error();
        err.setMessage(CONSTRAINT_MESSAGE);
        return new ResponseEntity<>(err, HttpStatus.UNPROCESSABLE_ENTITY);
    }
    
    
    private static final String DATA_INTEGRITY_MESSAGE = "Your guess must be a number that is exactly four digits long.";
    
    @ExceptionHandler(DataIntegrityViolationException.class)
    public final ResponseEntity<Error> handleDataIntegrityViolation(
            DataIntegrityViolationException ex,
            WebRequest request) {

        Error err = new Error();
        err.setMessage(DATA_INTEGRITY_MESSAGE);
        return new ResponseEntity<>(err, HttpStatus.UNPROCESSABLE_ENTITY);
    }
    
    
    private static final String NULL_POINTER_MESSAGE = "Either you did not enter the keys appropriately, or that gameID does not exists.  Check your input.";
    
    @ExceptionHandler(NullPointerException.class)
    public final ResponseEntity<Error> handleNullPointerException(
            NullPointerException ex,
            WebRequest request) {

        Error err = new Error();
        err.setMessage(NULL_POINTER_MESSAGE);
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }
    
    
    private static final String ARRAY_BOUNDS_MESSAGE = "Your guess must be a number that is exactly four digits long.";
    
    @ExceptionHandler(StringIndexOutOfBoundsException.class)
    public final ResponseEntity<Error> handleStringIndexOutOfBoundsException(
            StringIndexOutOfBoundsException ex,
            WebRequest request) {

        Error err = new Error();
        err.setMessage(ARRAY_BOUNDS_MESSAGE);
        return new ResponseEntity<>(err, HttpStatus.UNPROCESSABLE_ENTITY);
    } 

}
