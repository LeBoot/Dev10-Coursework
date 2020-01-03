/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.classroster.service;

import bl.classroster.dao.ClassRosterAuditDao;
import bl.classroster.dao.ClassRosterAuditDaoStubImpl;
import bl.classroster.dao.ClassRosterDao;
import bl.classroster.dao.ClassRosterDaoStubImpl;
import bl.classroster.dao.ClassRosterPersistenceException;
import bl.classroster.dto.Student;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Boone
 */
public class ClassRosterServiceLayerTest {
    
//    //attribute and constructor
//    private ClassRosterServiceLayer service;    
//    public ClassRosterServiceLayerTest() {
//        ClassRosterDao dao = new ClassRosterDaoStubImpl(); //created a student with id "0001" to test against
//        ClassRosterAuditDao auditDao = new ClassRosterAuditDaoStubImpl();
//        
//        service = new ClassRosterServiceLayerImpl(dao, auditDao);
//    }
    
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    ClassRosterServiceLayer service = ctx.getBean("serviceLayer", ClassRosterServiceLayer.class);

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

    /**
     * Test of createStudent method, of class ClassRosterServiceLayer.
     */
    @Test
    public void testCreateStudent() throws Exception {
        
        //create a new student object
        Student student = new Student("0002");
        student.setFirstName("Sally");
        student.setLastName("Smith");
        student.setCohort("Java Jan 2015");
        
        //call service method for creating that student
        service.createStudent(student);
        
    }
    
    @Test
    public void testCreateStudentDuplicateID() throws Exception {
        //create a new student object
        Student student = new Student("0001");
        student.setFirstName("Sally");
        student.setLastName("Smith");
        student.setCohort("Java Jan 2015");
        
        //call service method for creating that student
        //try to catch a duplicate student error
        try { //if the program enters the "try" method, it failed
            service.createStudent(student);
            fail("Expected ClassRosterDuplicateIdException was not thrown");
        } catch (ClassRosterDuplicateIdException e) {
            return; //everything working fine if the program gets to here
        } 
    }
    
    @Test
    public void testCreateStudentInvalidData() throws Exception {
        //create a new student object
        Student student = new Student("0002");
        student.setFirstName(""); //blank first name should be invalid
        student.setLastName("Smith");
        student.setCohort("Java Jan 2015");
        
        //call service method for creating that student
        //try to catch a duplicate student error
        try { //if the program enters the "try" method, it failed
            service.createStudent(student);
            fail("Expected ClassRosterDataValidationException was not thrown");
        } catch (ClassRosterDataValidationException e) {
            return; //everything working fine if the program gets to here
        } 
    }

    /**
     * Test of getAllStudents method, of class ClassRosterServiceLayer.
     */
    @Test
    public void testGetAllStudents() throws Exception {
        assertEquals(1, service.getAllStudents().size()); //import equals must be imported
    }

    /**
     * Test of getStudent method, of class ClassRosterServiceLayer.
     */
    @Test
    public void testGetStudent() throws Exception {
        Student student = service.getStudent("0001");
        assertNotNull(student); //must import assertNotNull
        student = service.getStudent("999"); //should be null because it hasn't been created
        assertNull(student); //must be imported
    }

    /**
     * Test of removeStudent method, of class ClassRosterServiceLayer.
     */
    @Test
    public void testRemoveStudent() throws Exception {
      Student student = service.removeStudent("0001");
        assertNotNull(student); //must import assertNotNull
        student = service.removeStudent("999"); //should be null because it hasn't been created
        assertNull(student); //must be imported
    }
}