/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.classroster.dto;

/**
 *
 * @author Boone
 */
public class Student {
    private String firstName;
    private String lastName;
    private String studentId;
    private String cohort;

    //constructor (for just studentId)
    public Student(String studentId) {
        this.studentId = studentId;
    }

    //getters and setters for everything EXCEPT studentId
    //studentId is a read-only field, but all the others are read/write and must be set manually;
        //studentId, however, is set when a Student object is instantiated.
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCohort() {
        return cohort;
    }

    public void setCohort(String cohort) {
        this.cohort = cohort;
    }
    
    //getter for studentId (no setter)
    
    public String getStudentId() {
        return studentId;
    }
    
    
    
}
