/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.vendingmachine;

import bl.vendingmachine.controller.VendingController;
import bl.vendingmachine.dao.VendingAuditDao;
import bl.vendingmachine.dao.VendingAuditDaoImpl;
import bl.vendingmachine.dao.VendingDao;
import bl.vendingmachine.dao.VendingDaoImpl;
import bl.vendingmachine.service.VendingService;
import bl.vendingmachine.service.VendingServiceImpl;
import bl.vendingmachine.ui.VendingUserIO;
import bl.vendingmachine.ui.VendingUserIOImpl;
import bl.vendingmachine.ui.VendingView;

/**
 *
 * @author Boone
 */
public class App {
    public static void main(String[] args) {
        VendingUserIO myIO = new VendingUserIOImpl();
        VendingView myView = new VendingView(myIO);
        
        VendingDao myDao = new VendingDaoImpl();
        VendingAuditDao myAuditDao = new VendingAuditDaoImpl();
        VendingService myService = new VendingServiceImpl(myDao, myAuditDao);
        
        VendingController controller = new VendingController(myView, myService);
        controller.run();
    }
    
}