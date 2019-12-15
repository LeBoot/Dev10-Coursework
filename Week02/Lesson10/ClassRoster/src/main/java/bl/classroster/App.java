/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.classroster;

import bl.classroster.controller.ClassRosterController;
import bl.classroster.dao.ClassRosterDao;
import bl.classroster.dao.ClassRosterDaoException;
import bl.classroster.dao.ClassRosterDaoFileImpl;
import bl.classroster.ui.ClassRosterView;
import bl.classroster.ui.UserIO;
import bl.classroster.ui.UserIOConsoleImpl;

/**
 *
 * @author Boone
 */
public class App {
    public static void main(String[] args) throws ClassRosterDaoException {
        
        //dependency injection
        UserIO myIo = new UserIOConsoleImpl();
        ClassRosterView myView = new ClassRosterView(myIo);
        
        //dependency injection
        ClassRosterDao myDao = new ClassRosterDaoFileImpl();
        ClassRosterController controller = new ClassRosterController(myDao, myView);
        
        //run the controller
        controller.run();
    }
    
}