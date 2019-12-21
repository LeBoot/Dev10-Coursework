/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.classroster.dao;

import bl.classroster.dto.Student;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Boone
 */
public class ClassRosterDaoFileImpl implements ClassRosterDao { //chose "implements all abstract methods" to clear error after attempting to implement
    public static final String ROSTER_FILE = "roster.txt"; //for marshalling/demarshalling
    public static final String DELIMITER = "::"; //for marshalling/demarshalling
    
    private Student unmarshallStudnet(String studentAsText) {
        //the input comes as a long string, with the information separated by the delimiter
        String[] studentTokens = studentAsText.split(DELIMITER);
        String studentId = studentTokens[0]; //the student id is in the index 0
        Student studentFromFile = new Student(studentId); //create a new student from the student id found in index 0
        studentFromFile.setFirstName(studentTokens[1]);
        studentFromFile.setLastName(studentTokens[2]);
        studentFromFile.setCohort(studentTokens[3]);
        return studentFromFile;
    }
    
    //from ROSTER_FILE, create a map with the new students, will call the unmarshallStudnet method above
    private void loadRoster() throws ClassRosterPersistenceException {
        Scanner scanner;
        
        try {
            scanner = new Scanner(
                    new BufferedReader(
                        new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new ClassRosterPersistenceException("-_- could not load roster data into memory", e);
        }
        
        String currentLine; //holds most recent line read from file
        Student currentStudent; //hold the most recent student unmarshalled
        
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine(); //get the next line in the file
            currentStudent = unmarshallStudnet(currentLine); //call unmarshall method for the studentn on that line
            
            //put currentStudent into the map by using its id as the key
            students.put(currentStudent.getStudentId(), currentStudent);
        }
        
        scanner.close(); //close scanner
    }
    
    private String marshallStudent(Student aStudent) {
        //create String studentAsText in the proper format
        String studentAsText = aStudent.getStudentId() + DELIMITER;
        studentAsText += aStudent.getFirstName() + DELIMITER;
        studentAsText += aStudent.getLastName() + DELIMITER;
        studentAsText += aStudent.getCohort();
        return studentAsText;
    }
    
    
    //writes students in roster (map) to ROSTER_FILE, will call marshallStudent method above
    private void writeRoster() throws ClassRosterPersistenceException {
        PrintWriter out;
        
        try {
            out = new PrintWriter(
                new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new ClassRosterPersistenceException("Could not save student data", e);
        }
        
         // NOTE: We could just grab the student map, get the Collection of Students and iterate over them...
         //but we've already created a method that gets a List of Students, so we'll reuse it.
         String studentAsText;
         List<Student> studentList = this.getAllStudents();
         for (Student currentStudent : studentList) {
             studentAsText = marshallStudent(currentStudent); //turn a student object into the string described in the marhsall method
             out.println(studentAsText); //write that string as a new line in the file
             out.flush(); //force PrintWriter to write all the lines, in case it hasn't done so already
         }
         out.close(); //close to prevent memory leaks
    }
    
    
    
    private Map<String, Student> students = new HashMap<>();
    
    @Override
    public Student addStudent(String studentId, Student student) throws ClassRosterPersistenceException {
        loadRoster();
        Student newStudent = students.put(studentId, student);
        writeRoster();
        return newStudent;  
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException {
        loadRoster();
        return new ArrayList<Student>(students.values());
    }

    @Override
    public Student getStudent(String studentId) throws ClassRosterPersistenceException {
        loadRoster();
        return students.get(studentId);
    }

    @Override
    public Student removeStudent(String studentId) throws ClassRosterPersistenceException {
        loadRoster();
        Student removedStudent = students.remove(studentId);
        writeRoster();
        return removedStudent;  
    }    
    
}
