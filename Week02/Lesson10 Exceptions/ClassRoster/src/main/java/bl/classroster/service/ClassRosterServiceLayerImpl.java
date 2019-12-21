/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.classroster.service;

import bl.classroster.dao.ClassRosterAuditDao;
import bl.classroster.dao.ClassRosterDao;
import bl.classroster.dao.ClassRosterPersistenceException;
import bl.classroster.dto.Student;
import java.util.List;

/**
 *
 * @author Boone
 */
public class ClassRosterServiceLayerImpl implements ClassRosterServiceLayer {
    
    //add a member-field of type Dao, and make constructor for it
    ClassRosterDao dao;
    ClassRosterAuditDao auditDao;
    public ClassRosterServiceLayerImpl(ClassRosterDao dao, ClassRosterAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }
    
    
    @Override //not a pass-through method, because we must validate data
    public void createStudent(Student student) throws ClassRosterDuplicateIdException, ClassRosterDataValidationException, ClassRosterPersistenceException {
        
        //check if that student id exists already; if so, throw an error
        if (dao.getStudent(student.getStudentId()) != null) {
            throw new ClassRosterDuplicateIdException(
                "ERROR: Could not create studnet.  Studet Id " + student.getStudentId() + " already exists.");
        }
        
        //validate that the fields are filled in
        validateStudentData(student);
        
        //if the code has come this far, then all the business rules check have been fulfilled
        //persist the student object:
        dao.addStudent(student.getStudentId(), student);
        
        auditDao.writeAuditEntry("Student " + student.getStudentId() + " CREATED");
    }

    
    @Override //this is a simple pass-through method
    public List<Student> getAllStudents() throws ClassRosterPersistenceException {
        return dao.getAllStudents();
    }

    @Override //this is a simple pass-through method
    public Student getStudent(String studentId) throws ClassRosterPersistenceException {
        return dao.getStudent(studentId);
    }

    @Override //this is a simple pass-through method
    public Student removeStudent(String studentId) throws ClassRosterPersistenceException {
        Student removedStudent = dao.removeStudent(studentId);
        
        auditDao.writeAuditEntry("Student " + studentId + " REMOVED");
        return removedStudent;
    }
 
    
    //Method to validate data
    //If any fields are either null or just blankspace, an error will be thrown
    private void validateStudentData(Student student) throws ClassRosterDataValidationException {
        if (student.getFirstName() == null
                || student.getFirstName().trim().length() == 0
                || student.getLastName() == null
                || student.getLastName().trim().length() == 0
                || student.getCohort() == null
                || student.getCohort().trim().length() == 0 ) {
            
            throw new ClassRosterDataValidationException("ERROR: All fields (First Name, Last Name, Cohort) are required.");
        }
    }
       
}