/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.classroster.dao;

import bl.classroster.dto.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Boone
 */
public class ClassRosterDaoStubImpl implements ClassRosterDao {

    Student onlyStudent;
    List<Student> studentList = new ArrayList<>();
    
    public ClassRosterDaoStubImpl() {
        //create a new student
        onlyStudent = new Student("0001");
        onlyStudent.setFirstName("John");
        onlyStudent.setLastName("Doe");
        onlyStudent.setCohort("Java Jan 2015");
        
        //add that new student to the list of students
        studentList.add(onlyStudent);
    }
    
    @Override
    public Student addStudent(String studentId, Student student) throws ClassRosterPersistenceException {
        if (studentId.equals(onlyStudent.getStudentId())) {
            return onlyStudent;
        } else {
            return null;
        }
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException {
        return studentList;
    }

    @Override
    public Student getStudent(String studentId) throws ClassRosterPersistenceException {
        //identical to add student logic
        if (studentId.equals(onlyStudent.getStudentId())) {
            return onlyStudent;
        } else {
            return null;
        }
    }

    @Override
    public Student removeStudent(String studentId) throws ClassRosterPersistenceException {
        //identical to add student logic
        if (studentId.equals(onlyStudent.getStudentId())) {
            return onlyStudent;
        } else {
            return null;
        }
    }
    
}