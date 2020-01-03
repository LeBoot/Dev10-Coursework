/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.flooringmastery.dao;

import java.math.BigDecimal;
import java.util.Set;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Boone
 */
public class StateTaxesDaoTest {
       
    //spring injection
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    StateTaxesDao dao = ctx.getBean("stateTaxesDao", StateTaxesDao.class);
    
//    //dependency injection
//    StateTaxesDao dao = new StateTaxesDaoImpl();
//    public StateTaxesDaoTest() {
//    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    //Tests --------------------------------------------------------------------

    @Test
    public void testGetTaxRateANDLoadTextFile() throws Exception {
        BigDecimal testAL = new BigDecimal("4.00");
        BigDecimal testAK = new BigDecimal("0.00");
        
        assertEquals(testAL, dao.getTaxRate("AL"));
        assertEquals(testAK, dao.getTaxRate("AK"));
        
    }
    
    @Test
    public void testGetListOfKeysANDLoadTextFile() throws Exception {
        assertTrue(dao.getListOfKeys().contains("AL"));
        assertTrue(dao.getListOfKeys().contains("AK"));
        assertTrue(dao.getListOfKeys().contains("FL"));
        assertTrue(dao.getListOfKeys().contains("MI"));
        assertFalse(dao.getListOfKeys().contains("AAAAA"));
    }
   
}
