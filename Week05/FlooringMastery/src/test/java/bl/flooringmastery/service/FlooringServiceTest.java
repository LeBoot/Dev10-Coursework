/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.flooringmastery.service;

import bl.flooringmastery.dao.FlooringAuditDaoImpl;
import bl.flooringmastery.dao.FlooringOrderDao;
import bl.flooringmastery.dao.FlooringOrderDaoException;
import bl.flooringmastery.dao.FlooringOrderDaoImpl;
import bl.flooringmastery.dao.OrderNumbersDao;
import bl.flooringmastery.dao.OrderNumbersDaoImpl;
import bl.flooringmastery.dto.FlooringOrder;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
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
public class FlooringServiceTest {
    
    //spring injection
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    FlooringService service = ctx.getBean("service", FlooringService.class);
    FlooringOrderDao myOrderDao = ctx.getBean("orderDao", FlooringOrderDao.class);
    OrderNumbersDao myOrderNumDao = ctx.getBean("orderNumDao", OrderNumbersDao.class);
    
//    //dependency injection
//    ProductInfoDao myProductDao = new ProductInfoDaoImpl();
//    StateTaxesDao myStateTaxesDao = new StateTaxesDaoImpl();
//    OrderNumbersDao myOrderNumDao = new OrderNumbersDaoImpl();
//    FlooringOrderDao myOrderDao = new FlooringOrderDaoImpl();
//    FlooringAuditDao myAuditDao = new FlooringAuditDaoImpl();
//    FlooringService service = new FlooringServiceImpl(myProductDao, myStateTaxesDao, myOrderNumDao, myOrderDao, myAuditDao);
//    public FlooringServiceTest() {
//    }
    
    @BeforeAll
    //change the text file, lest the @BeforeEach erase everything
    public static void setUpClass() {
        OrderNumbersDaoImpl.textfile = "OrderNumbers-UnitTesting.txt";
        FlooringOrderDaoImpl.textfile = "Orders-UnitTesting.txt";
        FlooringAuditDaoImpl.AUDITFILE = "Audit-UnitTesting.txt";
    }
    
    @AfterAll
    //change the text file back to what it was originally
    public static void tearDownClass() {
        OrderNumbersDaoImpl.textfile = "OrderNumbers.txt";
        FlooringOrderDaoImpl.textfile = "Orders.txt";
        FlooringAuditDaoImpl.AUDITFILE = "Audit.txt";
    }
    
    @BeforeEach
    //call every item, and one by one remove them, leaving a blank text file
    public void setUp() {
        try {
            List<FlooringOrder> listOfOrders = myOrderDao.getAllOrdersByOrderNumber("PROD");
            for (FlooringOrder order : listOfOrders) {
                myOrderDao.deleteFlooringOrder(order.getOrderNumber(), "PROD");
            }
        } catch (FlooringOrderDaoException ex) {
            //should I do something here?
        }
    }
    
    @AfterEach
    public void tearDown() {
    }

    //methods to build orders --------------------------------------------------
    private FlooringOrder buildAnOrderPartial(int orderNumber, LocalDate date) {
        FlooringOrder newOrder = new FlooringOrder(orderNumber);
        
        newOrder.setCustomerName("Default Name");
        
        newOrder.setOrderDate(date);
        
        newOrder.setStateName("AK");
        
        newOrder.setProductType("tile");
        
        BigDecimal defaultArea = new BigDecimal("5.00");
        newOrder.setAreaOfFlooring(defaultArea);
        
        return newOrder;
    }
    
    
    private FlooringOrder buildAnOrder(int orderNumber, LocalDate date) {
        FlooringOrder newOrder = new FlooringOrder(orderNumber);
        
        newOrder.setCustomerName("Default Name");
        
        newOrder.setOrderDate(date);
        
        newOrder.setStateName("AK");
        
        newOrder.setProductType("tile");
        
        BigDecimal defaultArea = new BigDecimal("0.00");
        newOrder.setAreaOfFlooring(defaultArea);
        
        BigDecimal stateTaxRate = new BigDecimal("0.00");
        newOrder.setStateTaxRate(stateTaxRate);

        BigDecimal costMaterialSqFt = new BigDecimal("3.50");
        newOrder.setCostMaterialSqFt(costMaterialSqFt);

        BigDecimal costLaborSqFt = new BigDecimal("4.15");
        newOrder.setCostLaborSqFt(costLaborSqFt);

        BigDecimal costMaterialTotal = new BigDecimal("0.00");
        newOrder.setCostMaterialTotal(costMaterialTotal);

        BigDecimal costLaborTotal = new BigDecimal("0.00");
        newOrder.setCostLaborTotal(costLaborTotal);

        BigDecimal totalTax = new BigDecimal("0.00");
        newOrder.setTotalTax(totalTax);

        BigDecimal totalCost = new BigDecimal("0.00");
        newOrder.setTotalCost(totalCost);
        
        return newOrder;
    }
    
    //tests --------------------------------------------------------------------
    @Test
    public void testLoadProductInfoCostsTextFileANDGetCostsPerSquareFoot() throws Exception {
        BigDecimal testMaterial = new BigDecimal("2.25");
        BigDecimal testLabor = new BigDecimal("2.10");
        
        assertEquals(testMaterial, service.getCostPerSquareFoot("carpet", "material"));
        assertEquals(testLabor, service.getCostPerSquareFoot("carpet", "labor"));
    }


    @Test
    public void testLoadStateTaxesTextFileANDGetTaxRate() throws Exception {
        BigDecimal testAL = new BigDecimal("4.00");
        BigDecimal testAK = new BigDecimal("0.00");
        
        assertEquals(testAL, service.getTaxRate("AL"));
        assertEquals(testAK, service.getTaxRate("AK"));
    }


    @Test
    public void testGetAllFlooringOrders() throws Exception {
        //Choose "PROD" because that file is changed in "before all"
        String testOrProd = "PROD";
        
        //check that getAll yeilds exactly 0
        assertEquals(0, service.getAllFlooringOrders(testOrProd).size());
        
        //add an order
        LocalDate ld = LocalDate.now();
        FlooringOrder order1 = this.buildAnOrder(10001, ld);
        myOrderDao.addFlooringOrder(order1, testOrProd);

        //now, ensure that getAll yields exactly 1
        assertEquals(1, service.getAllFlooringOrders(testOrProd).size());
        
        //add another order with the same date
        FlooringOrder order2 = this.buildAnOrder(10002, ld);
        myOrderDao.addFlooringOrder(order2, testOrProd);
        
        //ensure that getAll still yields 1
        assertEquals(1, service.getAllFlooringOrders(testOrProd).size());
        
        //add another order with a different date
        LocalDate ld2 = LocalDate.parse("1999-12-12");
        FlooringOrder order3 = this.buildAnOrder(10003, ld2);
        myOrderDao.addFlooringOrder(order3, testOrProd);
                  
        //finally, ensure that getAll yields exactly 2
        assertEquals(2, service.getAllFlooringOrders(testOrProd).size());
    }


    @Test
    public void testGetFlooringOrdersBySingleDate() throws Exception {
        //Choose "PROD" because that file is changed in "before all"
        String testOrProd = "PROD";
        
        //create dates
        LocalDate ld1 = LocalDate.now();
        LocalDate ld2 = LocalDate.parse("1999-12-12");
        
        //check that getByDateMethod and getAll both yeild exactly 0
        assertEquals(0, service.getFlooringOrdersBySingleDate(ld1, testOrProd).size());
        assertEquals(0, service.getAllFlooringOrders(testOrProd).size());
        
        //add two orders with different dates
        FlooringOrder order1 = this.buildAnOrder(10001, ld1);
        FlooringOrder order2 = this.buildAnOrder(10002, ld2);
        myOrderDao.addFlooringOrder(order1, testOrProd);
        myOrderDao.addFlooringOrder(order2, testOrProd);

        //now, ensure that getByDateMethod yields exactly 1,
            //but getAll yields exactly 2
        assertEquals(1, service.getFlooringOrdersBySingleDate(ld1, testOrProd).size());
        assertEquals(2, service.getAllFlooringOrders(testOrProd).size());
    }


    @Test
    public void testGetASingleFlooringOrder() throws Exception {
        //Choose "PROD" because that file is changed in "before all"
        String testOrProd = "PROD";
        
        //add an order
        LocalDate ld = LocalDate.now();
        FlooringOrder order1 = this.buildAnOrder(10001, ld);
        myOrderDao.addFlooringOrder(order1, testOrProd);
        
        //pull the order from memory, and save it as a new object
        FlooringOrder fromDao = service.getASingleFlooringOrder(testOrProd, order1.getOrderNumber());
        
        //see if what was put-into and pulled-outfrom memory match
        assertEquals(fromDao, order1);
    }


    @Test
    public void testDeleteFlooringOrder() throws Exception {
        //Choose "PROD" because that file is changed in "before all"
        String testOrProd = "PROD";
        
        //add an order
        LocalDate ld = LocalDate.now();
        FlooringOrder order1 = this.buildAnOrder(10001, ld);
        myOrderDao.addFlooringOrder(order1, testOrProd);
        
        //check that getAll yeilds exactly 1
        assertEquals(1, myOrderDao.getAllFlooringOrders(testOrProd).size());
        
        //delete the item and check that getALL yields exactly 0
        service.deleteFlooringOrder(order1.getOrderNumber(), testOrProd);
        assertEquals(0, myOrderDao.getAllFlooringOrders(testOrProd).size());
        
        //check that memory of that deleted file is null
        assertNull(myOrderDao.getASingleFlooringOrder(testOrProd, order1.getOrderNumber()));
    }


    @Test
    public void testAddNewOrderNumberToList() throws Exception {
        //use production mode, because the file is changed at the top
        String testOrProd = "PROD";
        
        //find the largest number currently in the list
        List<Integer> initialList = myOrderNumDao.getListOfNumbers(testOrProd);
        int maxNum = -1;
        for (int number : initialList) {
            if (number > maxNum) {
                maxNum = number;
            }
        }

        //check for a number that is guarenteed to be in the list
        assertTrue(myOrderNumDao.checkIsNumberInList(maxNum, testOrProd));
        
        //check for a number that is guarentted to not be in the list
        assertFalse(myOrderNumDao.checkIsNumberInList(maxNum + 1, testOrProd));
        
        //add a new number to list
        service.addNewOrderNumberToList(maxNum + 1, testOrProd);
        
        //check that it is in the list
        assertTrue(myOrderNumDao.checkIsNumberInList(maxNum + 1, testOrProd));
    }
    
    
    // Tests for calculation methods -------------------------------------------
    
    @Test
    public void testCalculateCostLaborOrMaterialTotal() throws Exception {
        BigDecimal testArea = new BigDecimal("10");
        BigDecimal expectedResult = new BigDecimal("41.50");
        
        assertEquals(expectedResult, service.calculateCostLaborOrMaterialTotal("tile", "labor", testArea));
    }


    @Test
    public void testCalculateTotalTax() throws Exception {
        BigDecimal testLaborTotal = new BigDecimal("60.00");
        BigDecimal testMaterialTotal = new BigDecimal("40.00");
        BigDecimal expectedResult = new BigDecimal("4.00");
        
        assertEquals(expectedResult, service.calculateTotalTax("AL", testLaborTotal, testMaterialTotal)); 
    }
    

    @Test
    public void testCalculateCostTotal() {
        BigDecimal testTax = new BigDecimal("10.00");
        BigDecimal testLabor = new BigDecimal("12.00");
        BigDecimal testMaterial = new BigDecimal("15.00");
        BigDecimal expectedResult = new BigDecimal("37.00");
        
        assertEquals(expectedResult, service.calculateCostTotal(testTax, testLabor, testMaterial));
    }
    

    //tests for other methods --------------------------------------------------
    @Test
    public void testConvertTestOrProd() {
        assertEquals("TEST", service.convertTestOrProd(1));
        assertEquals("PROD", service.convertTestOrProd(2));
    }


    @Test
    public void testAddFlooringOrder() throws Exception {
        //Choose "PROD" because that file is changed in "before all"
        String testOrProd = "PROD";
        
        //add an order
        LocalDate ld = LocalDate.now();
        FlooringOrder order1 = this.buildAnOrderPartial(10001, ld);
        service.addFlooringOrder(order1, testOrProd);
        
        //pull the order from memory, and save it as a new object
        FlooringOrder fromDao = service.getASingleFlooringOrder(testOrProd, order1.getOrderNumber());
        
        //see if what was put-into and pulled-outfrom memory match
        assertEquals(fromDao, order1);
    }


    @Test
    public void testGenerateNewOrderNumber() throws Exception {
        String testOrProd = "PROD";
        assertFalse(myOrderNumDao.checkIsNumberInList(service.generateNewOrderNumber(testOrProd), testOrProd));
    }
    
    @Test
    public void testValidateStateName() throws Exception {
        assertTrue(service.validateStateName("NC"));
        assertTrue(service.validateStateName("AK"));
        assertTrue(service.validateStateName("CO"));
        assertFalse(service.validateStateName("AAA"));
        assertFalse(service.validateStateName(""));
        assertFalse(service.validateStateName("    kd"));
    }

    
    @Test
    public void testValidateProductType() throws Exception {
        assertTrue(service.validateProductType("carpet"));
        assertTrue(service.validateProductType("tile"));
        assertTrue(service.validateProductType("laminate"));
        assertTrue(service.validateProductType("wood"));
        assertFalse(service.validateProductType("taco"));
    }   

}