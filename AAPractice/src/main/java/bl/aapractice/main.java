/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.aapractice;

import bl.aapractice.IO.MasterUserIO;
import bl.aapractice.IO.MasterUserIOImpl;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 *
 * @author Boone
 */
public class main {
    public static void main(String[] args) {
        MasterUserIO io = new MasterUserIOImpl();
        String prompt = "Type input: ";
        
        String input = io.readStringNoBlankOrNullOrDelimiter(prompt, "abcd");
        
        System.out.println("");
        System.out.println(input);
        

    }
}
