/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.classroster;

import bl.classroster.controller.ClassRosterController;
import bl.classroster.dao.ClassRosterAuditDao;
import bl.classroster.dao.ClassRosterAuditDaoFileImpl;
import bl.classroster.dao.ClassRosterDao;
import bl.classroster.dao.ClassRosterPersistenceException;
import bl.classroster.dao.ClassRosterDaoFileImpl;
import bl.classroster.service.ClassRosterServiceLayer;
import bl.classroster.service.ClassRosterServiceLayerImpl;
import bl.classroster.ui.ClassRosterView;
import bl.classroster.ui.UserIO;
import bl.classroster.ui.UserIOConsoleImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Boone
 */
public class App {
    public static void main(String[] args) throws ClassRosterPersistenceException {
        
//        //dependency injection
//        UserIO myIo = new UserIOConsoleImpl(); //instantiate UserIO iimplementation
//        ClassRosterView myView = new ClassRosterView(myIo); //Instantiate View and wire UserIO to it
//        
//        ClassRosterDao myDao = new ClassRosterDaoFileImpl(); //Instantiate DAO implementation
//        ClassRosterAuditDao myAuditDao = new ClassRosterAuditDaoFileImpl(); //instantiate auditDAO implementation
//        ClassRosterServiceLayer myService = new ClassRosterServiceLayerImpl(myDao, myAuditDao); //instantiate Service and wire DAO and auditDAO to it
//        
//        ClassRosterController controller = new ClassRosterController(myService, myView); //instantiate Controller and wire Service and View to it
//        
//        //run the controller
//        controller.run();
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ClassRosterController controller = ctx.getBean("controller", ClassRosterController.class);
        controller.run();

        
    }
    
}