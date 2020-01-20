/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.aapractice.IO;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author Boone
 */
public interface MasterUserIO {
    
    
    //void methods -------------------------------------------------------------
    //--------------------------------------------------------------------------    
    public void print(String message);
    
    
    //string readers -----------------------------------------------------------
    //--------------------------------------------------------------------------
    public String readString(String prompt);
    public String readStringYesOrNo(String prompt);
    public String readStringYesOrNoPartial(String prompt);
    public String readStringNoBlankOrNull(String prompt);
    public String readStringOrEnterKey(String prompt);
    public String readStringNoColon(String prompt);
    public String readStringNoBlankOrNullOrColon(String prompt);
    public String readStringOrEnterKeyNoColon(String prompt);
    public String readStringNoDelimiter(String prompt, String delimiter);
    public String readStringNoBlankOrNullOrDelimiter(String prompt, String delimiter);
    public String readStringOrEnterNoDelimiter(String prompt, String delimiter);
    
    //number readers -----------------------------------------------------------
    //--------------------------------------------------------------------------
    
    //int readers --------------------------------------------------------------
    public int readInt(String prompt);
    public int readInt(String prompt, int min, int max);
    public int readIntGreaterThanOrEqualTo(String prompt, int min);
    public int readIntLessThanOrEqualTo(String prompt, int max);
    public int readIntOrPassword(String prompt, int min, int max, String password);
    public int readIntOrEnterKey(String prompt);
    public int readIntOrEnterKey(String prompt, int min, int max);
    
    //double readers -----------------------------------------------------------
    public double readDouble(String prompt);
    public double readDouble(String prompt, double min, double max);
    public double readDoubleGreaterThanOrEqualTo(String prompt, double min);
    public double readDoubleLessThanOrEqualTo(String prompt, double max);
    public double readDoubleOrPassword(String prompt, double min, double max, String password);
    public double readDoubleOrEnterKey(String prompt);
    public double readDoubleOrEnterKey(String prompt, double min, double max);

    //float readers ------------------------------------------------------------
    public float readFloat(String prompt);
    public float readFloat(String prompt, float min, float max);
    public float readFloatGreaterThanOrEqualTo(String prompt, float min);
    public float readFloatLessThanOrEqualTo(String prompt, float max);
    public float readFloatOrPassword(String prompt, float min, float max, String password);
    public float readFloatOrEnterKey(String prompt);
    public float readFloatOrEnterKey(String prompt, float min, float max);

    //long readers -------------------------------------------------------------
    public long readLong(String prompt);
    public long readLong(String prompt, long min, long max);
    public long readLongGreaterThanOrEqualTo(String prompt, long min);
    public long readLongLessThanOrEqualTo(String prompt, long max);
    public long readLongOrPassword(String prompt, long min, long max, String password);
    public long readLongOrEnterKey(String prompt);
    public long readLongOrEnterKey(String prompt, long min, long max);
    
    //big decimal readers ------------------------------------------------------
    public BigDecimal readBigDecimal(String prompt);
    public BigDecimal readBigDecimal(String prompt, BigDecimal max, BigDecimal min);
    public BigDecimal readBigDecimalGreaterThanOrEqualTo(String prompt, BigDecimal min);
    public BigDecimal readBigDecimalLessThanOrEqualTo(String prompt, BigDecimal max);
    public BigDecimal readBigDecimalOrPassword(String prompt, BigDecimal min, BigDecimal max, String password);
    public BigDecimal readBigDecimalOrEnterKey(String prompt);
    public BigDecimal readBigDecimalOrEnterKey(String prompt, BigDecimal min, BigDecimal max);
    
    //local date readers -------------------------------------------------------
    //--------------------------------------------------------------------------
    public LocalDate readLocalDateDefaultPattern(String prompt);
    public LocalDate readLocalDateSpecificPattern(String prompt, String pattern);
    public LocalDate readLocalDateDefaultPatternAfterTodayOnly(String prompt);
    public LocalDate readLocalDateSpecificPatternAfterTodayOnly(String prompt, String pattern);
    public LocalDate readLocalDateDefaultPatternRange(String prompt, LocalDate minDate, LocalDate maxDate);
    public LocalDate readLocalDateSpecificPatternRange(String prompt, String pattern, LocalDate minDate, LocalDate maxDate);
    public LocalDate readLocalDateDefaultPatternAfterMinDate(String prompt, LocalDate minDate);
    public LocalDate readLocalDateSpecificPatternAfterMinDate(String prompt, String pattern, LocalDate minDate);
    public LocalDate readLocalDateDefaultPatternBeforeMaxDate(String prompt, LocalDate maxDate);
    public LocalDate readLocalDateSpecificPatternBeforeMaxDate(String prompt, String pattern, LocalDate maxDate);
    
}