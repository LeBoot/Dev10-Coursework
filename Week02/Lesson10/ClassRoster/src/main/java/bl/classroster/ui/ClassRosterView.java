/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.classroster.ui;

import bl.classroster.dto.Student;
import java.util.List;

/**
 *
 * @author Boone
 */
public class ClassRosterView {

    //dependency injection
    UserIO io; 
    public ClassRosterView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List student IDs");
        io.print("2. Create new student");
        io.print("3. View a student");
        io.print("4. Remove a student");
        io.print("5. Exit");

        return io.readInt("Plese select from the above choices.", 1, 5);
    }

    public Student getNewStudentInfo() {
        //this method prompts user for new student information, creates a new student object, and returns that object to the caller
        String studentID = io.readString("Please enter Student ID");
        String firstName = io.readString("Please enter First Name");
        String lastName = io.readString("Please enter Last Name");
        String cohort = io.readString("Please enter cohort");
        Student currentStudent = new Student(studentID);
        currentStudent.setFirstName(firstName);
        currentStudent.setLastName(lastName);
        currentStudent.setCohort(cohort);
        return currentStudent;
    }

    public void displayCreateStudentBanner() {
        io.print("=== Create Student ===");
    }

    public void displayCreateSuccessBanner() {
        //moves forward once user hits enter
        io.readString("Student successfully created.  Please hit enter to continue");
    }

    public void displayStudentList(List<Student> studentList) {
        //run through each student in the list of students, and print out each student's information
        for (Student currentStudent : studentList) {
            io.print(currentStudent.getStudentId() + ": "
                    + currentStudent.getFirstName() + " "
                    + currentStudent.getLastName());
        }
        //wait for user to hit enter before moving forward
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All Students ===");
    }
    
    public void displayDisplayStudentBanner() {
        io.print("=== Display Student ===");
    }
    
    public String getStudentIdChoice() {
        return io.readString("Please enter the student ID");
    }
    
    public void displayStudent(Student student) {
        if (student != null) {
            io.print(student.getStudentId());
            io.print(student.getFirstName() + " " + student.getLastName());
            io.print(student.getCohort());
            io.print("");
        } else {
            io.print("No such student.");
        }
        io.readString("Please hit enter to continue");
    }
    
    public void displayRemoveStudentBanner() {
        io.print("=== Remove Student ====");
    }
    
    public void displayRemoveSuccessBanner() {
        io.readString("Student successfully removed.  Please hit enter to continue.");
    }
    
    public void displayExitBanner() {
        io.print("Goodbye!");
    }
     
    public void displayUnknownCommandBanner() {
        io.print("Unknonw command...");
    }
    
    public void displayErrorMessage(String errorMsg) {
        io.print("=== Error ===");
        io.print(errorMsg);
    }
}
