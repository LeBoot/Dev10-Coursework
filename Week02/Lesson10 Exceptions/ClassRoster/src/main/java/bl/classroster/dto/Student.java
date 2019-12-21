/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.classroster.dto;

import java.util.Objects;

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

    
    
    //code for unit testing-----------------------------------------------------
    //inserted code: hashMap and equals
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.firstName);
        hash = 53 * hash + Objects.hashCode(this.lastName);
        hash = 53 * hash + Objects.hashCode(this.studentId);
        hash = 53 * hash + Objects.hashCode(this.cohort);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.studentId, other.studentId)) {
            return false;
        }
        if (!Objects.equals(this.cohort, other.cohort)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
