
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.GregorianCalendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Boone
 */
public class DateTimePractice {
    public static void main(String[] args) {
        //get today's date
        LocalDate ld = LocalDate.now();
        System.out.println(ld);  
        
        
        //get a date from a string
        ld = LocalDate.parse("2019-01-01");
        System.out.println(ld);
        
        //create (ISO-formatted) dates from different formats
        ld = LocalDate.parse("07/02/2019", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        System.out.println(ld);
        
        ld = LocalDate.parse("2019/02/11", DateTimeFormatter.ofPattern("yyyy/dd/MM"));
        System.out.println(ld);
        
        ld = LocalDate.parse("07/02/19", DateTimeFormatter.ofPattern("dd/MM/yy"));
        System.out.println(ld);
        
        //convert string to date
        String isoDate = ld.toString();
        System.out.println(isoDate);
        ld = LocalDate.parse(isoDate);
        System.out.println(ld);
        
        
        
        //reformat date (in whatever way desired)-------------------------------
        String newFormat1 = ld.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        System.out.println(newFormat1);
        String newFormat2 = ld.format(DateTimeFormatter.ofPattern("MM::dd++yy+=="));
        System.out.println(newFormat2);
        
        String newFormat3 = ld.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
        System.out.println(newFormat3);
        String newFormat4 = ld.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
        System.out.println(newFormat4);
        String newFormat5 = ld.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
        System.out.println(newFormat5);
        String newFormat6 = ld.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
        System.out.println(newFormat6);
        
        
        
        //past and future dates-------------------------------------------------
        LocalDate past = ld.minusDays(6); //subtract 6 days from ld
        String newFormat7 = past.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
        System.out.println(newFormat7);
        
        past = ld.minusMonths(12); //subtract 12 months
        String newFormat8 = past.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
        System.out.println(newFormat8);
        
        LocalDate future = ld.plusYears(2); //add 2 years
        String newFormat9 = future.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
        System.out.println(newFormat9);
        
        
        
        //calculate difference between two times--------------------------------
        Period diff = ld.until(past);
        System.out.println(diff);
        System.out.println(diff.getMonths());
        System.out.println(diff.getDays());
        System.out.println(diff.getYears());
        
        
        
        //LocalDateTime --------------------------------------------------------
        LocalDateTime ldt = LocalDateTime.now(); //right this very moment
        System.out.println(ldt);
        String newFormat10 = ldt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
        System.out.println(newFormat10);
        
        
        
        //Legacy conversion ----------------------------------------------------
        //declare a legacy date
        Date legacyDate = new Date();
        System.out.println(legacyDate);
        
        //declare a gregorian calendar
        GregorianCalendar legacyCalendar = new GregorianCalendar();
        System.out.println(legacyCalendar);
        
        //convert legacy date to new date-time API
        ZonedDateTime zdt = ZonedDateTime.ofInstant(legacyDate.toInstant(), ZoneId.systemDefault());
        ld = zdt.toLocalDate();
        System.out.println(ld);
        
        //convert gregorian date to new date-time API
        zdt = legacyCalendar.toZonedDateTime();
        ld = zdt.toLocalDate();
        System.out.println(ld);
 
    }  
}