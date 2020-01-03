/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.flooringmastery.dao;

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
public class FlooringOrderDaoTest {
    
    //spring injection
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    FlooringOrderDao dao = ctx.getBean("orderDao", FlooringOrderDao.class);
    
//    //dependency injection
//    FlooringOrderDao dao = new FlooringOrderDaoImpl();
//    public FlooringOrderDaoTest() {
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
            List<FlooringOrder> listOfOrders = dao.getAllOrdersByOrderNumber("PROD");
            for (FlooringOrder order : listOfOrders) {
                dao.deleteFlooringOrder(order.getOrderNumber(), "PROD");
            }
        } catch (FlooringOrderDaoException ex) {
            //should I do something here?
        }
    }
    
    @AfterEach
    public void tearDown() {
    }

    
    //method to build orders ---------------------------------------------------
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
    public void testGetAllFlooringOrders() throws Exception {
        //Choose "PROD" because that file is changed in "before all"
        String testOrProd = "PROD";
        
        //check that getAll yeilds exactly 0
        assertEquals(0, dao.getAllFlooringOrders(testOrProd).size());
        
        //add an order
        LocalDate ld = LocalDate.now();
        FlooringOrder order1 = this.buildAnOrder(10001, ld);
        dao.addFlooringOrder(order1, testOrProd);

        //now, ensure that getAll yields exactly 1
        assertEquals(1, dao.getAllFlooringOrders(testOrProd).size());
        
        //add another order with the same date
        FlooringOrder order2 = this.buildAnOrder(10002, ld);
        dao.addFlooringOrder(order2, testOrProd);
        
        //ensure that getAll still yields 1
        assertEquals(1, dao.getAllFlooringOrders(testOrProd).size());
        
        //add another order with a different date
        LocalDate ld2 = LocalDate.parse("1999-12-12");
        FlooringOrder order3 = this.buildAnOrder(10003, ld2);
        dao.addFlooringOrder(order3, testOrProd);
                  
        //finally, ensure that getAll yields exactly 2
        assertEquals(2, dao.getAllFlooringOrders(testOrProd).size());
    }


    @Test
    public void testGetFlooringOrdersBySingleDate() throws Exception {
        //Choose "PROD" because that file is changed in "before all"
        String testOrProd = "PROD";
        
        //create dates
        LocalDate ld1 = LocalDate.now();
        LocalDate ld2 = LocalDate.parse("1999-12-12");
        
        //check that getByDateMethod and getAll both yeild exactly 0
        assertEquals(0, dao.getFlooringOrdersBySingleDate(ld1, testOrProd).size());
        assertEquals(0, dao.getAllFlooringOrders(testOrProd).size());
        
        //add two orders with different dates
        FlooringOrder order1 = this.buildAnOrder(10001, ld1);
        FlooringOrder order2 = this.buildAnOrder(10002, ld2);
        dao.addFlooringOrder(order1, testOrProd);
        dao.addFlooringOrder(order2, testOrProd);

        //now, ensure that getByDateMethod yields exactly 1,
            //but getAll yields exactly 2
        assertEquals(1, dao.getFlooringOrdersBySingleDate(ld1, testOrProd).size());
        assertEquals(2, dao.getAllFlooringOrders(testOrProd).size());
        
    }


    @Test
    public void testAddFlooringOrderANDGetASingleFlooringOrder() throws Exception {
        //Choose "PROD" because that file is changed in "before all"
        String testOrProd = "PROD";
        
        //add an order
        LocalDate ld = LocalDate.now();
        FlooringOrder order1 = this.buildAnOrder(10001, ld);
        dao.addFlooringOrder(order1, testOrProd);
        
        //pull the order from memory, and save it as a new object
        FlooringOrder fromDao = dao.getASingleFlooringOrder(testOrProd, order1.getOrderNumber());
        
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
        dao.addFlooringOrder(order1, testOrProd);
        
        //check that getAll yeilds exactly 1
        assertEquals(1, dao.getAllFlooringOrders(testOrProd).size());
        
        //delete the item and check that getALL yields exactly 0
        dao.deleteFlooringOrder(order1.getOrderNumber(), testOrProd);
        assertEquals(0, dao.getAllFlooringOrders(testOrProd).size());
        
        //check that memory of that deleted file is null
        assertNull(dao.getASingleFlooringOrder(testOrProd, order1.getOrderNumber()));
    }


    @Test
    public void testGetAllOrdersByOrderNumber() throws Exception {
        //Choose "PROD" because that file is changed in "before all"
        String testOrProd = "PROD";
        
        //check that getAll yeilds exactly 0
        assertEquals(0, dao.getAllOrdersByOrderNumber(testOrProd).size());
        
        //add an order
        LocalDate ld = LocalDate.now();
        FlooringOrder order1 = this.buildAnOrder(10001, ld);
        dao.addFlooringOrder(order1, testOrProd);

        //now, ensure that getAll yields exactly 1
        assertEquals(1, dao.getAllOrdersByOrderNumber(testOrProd).size());
        
        //add another order
        FlooringOrder order2 = this.buildAnOrder(10002, ld);
        dao.addFlooringOrder(order2, testOrProd);
        
        //finally, ensure that getAll yields exactly 2
        assertEquals(2, dao.getAllOrdersByOrderNumber(testOrProd).size());
    }
    
}