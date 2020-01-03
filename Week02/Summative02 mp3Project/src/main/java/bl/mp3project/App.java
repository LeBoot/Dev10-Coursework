/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.mp3project;

//import bl.mp3project.controller.dao.mp3ProjectDao;
//import bl.mp3project.controller.dao.mp3ProjectDaoFileImpl;
//import bl.mp3project.ui.mp3ProjectUserIO;
//import bl.mp3project.ui.mp3ProjectUserIOImpl;
//import bl.mp3project.ui.mp3ProjectView;
import bl.mp3project.controller.mp3ProjectController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Boone
 */
public class App {
    public static void main(String[] args) {
        
//        mp3ProjectUserIO myIO = new mp3ProjectUserIOImpl();
//        mp3ProjectDao myDao = new mp3ProjectDaoFileImpl();
//        mp3ProjectView myView = new mp3ProjectView(myIO);
//        
//        mp3ProjectController controller = new mp3ProjectController(myDao, myView);
//        
//        controller.run();

        //Spring injection:
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        mp3ProjectController controller = ctx.getBean("controller", mp3ProjectController.class);
        controller.run();
    }
    
}
