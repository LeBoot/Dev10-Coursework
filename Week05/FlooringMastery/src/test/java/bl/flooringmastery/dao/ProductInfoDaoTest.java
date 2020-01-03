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
public class ProductInfoDaoTest {
    
    //spring injection
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    ProductInfoDao dao = ctx.getBean("productDao", ProductInfoDao.class);
    
//    //dependency injection
//    ProductInfoDao dao = new ProductInfoDaoImpl();
//    public ProductInfoDaoTest() {
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
    public void testGetCostPerSqFtANDLoadTextFile() throws Exception {
        BigDecimal testMaterial = new BigDecimal("2.25");
        BigDecimal testLabor = new BigDecimal("2.10");
        
        assertEquals(testMaterial, dao.getCostPerSqFt("carpet", "material"));
        assertEquals(testLabor, dao.getCostPerSqFt("carpet", "labor"));
    }


    @Test
    public void testGetListOfKeysANDLoadTextFile() throws Exception {
        assertTrue(dao.getListOfKeys().contains("carpet"));
        assertTrue(dao.getListOfKeys().contains("tile"));
        assertTrue(dao.getListOfKeys().contains("laminate"));
        assertTrue(dao.getListOfKeys().contains("wood"));
        assertFalse(dao.getListOfKeys().contains("AAAAA"));
    }

}