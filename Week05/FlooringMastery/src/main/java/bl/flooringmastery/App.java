/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.flooringmastery;

import bl.flooringmastery.controller.FlooringController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Boone
 */
public class App {
    public static void main(String[] args) {
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	FlooringController controller = ctx.getBean("controller", FlooringController.class);
        controller.run();
        
//        FlooringUserIO myIO = new FlooringUserIOImpl();
//        FlooringView myView = new FlooringView(myIO);
//        
//        ProductInfoDao myProductDao = new ProductInfoDaoImpl();
//        StateTaxesDao myStateTaxesDao = new StateTaxesDaoImpl();
//        OrderNumbersDao myOrderNumDao = new OrderNumbersDaoImpl();
//        FlooringOrderDao myOrderDao = new FlooringOrderDaoImpl();
//        FlooringAuditDao myAuditDao = new FlooringAuditDaoImpl();
//        FlooringService myService = new FlooringServiceImpl(myProductDao, myStateTaxesDao, myOrderNumDao, myOrderDao, myAuditDao);
//        
//        FlooringController controller = new FlooringController(myView, myService);
//        controller.run();

    }
  
}