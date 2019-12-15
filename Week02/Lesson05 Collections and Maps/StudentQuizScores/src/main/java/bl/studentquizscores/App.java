package bl.studentquizscores;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Boone
 */
public class App {
    public static void main(String[] args) {
        StudentQuizGrades studQG = new StudentQuizGrades();
        
        studQG.welcomeMessage(); //print welcome message
        
        //build and add to HashMap
        HashMap<String, ArrayList<Integer>> studentScores = new HashMap<>();
        studentScores.put("Student1", studQG.buildArrayList(10,75));
        studentScores.put("Student2", studQG.buildArrayList(10,85));
        studentScores.put("Student3", studQG.buildArrayList(10,90));
        studentScores.put("Student4", studQG.buildArrayList(10,65));
        studentScores.put("Student5", studQG.buildArrayList(10,80));
        
        //get user choice and do what it asks
        boolean isPlayAgain = true;
        do {
            int userChoice = studQG.askChoice();
            switch (userChoice) {
                case 1: //view a list of students in the system
                    studQG.viewStudList(studentScores);
                    break;
                case 2: //add a new student to the system
                    String studNameAdd = studQG.askMessage("What is the name of the student you'd like to add? ");
                    studQG.addStudent(studentScores, studNameAdd);
                    break;
                case 3: //remove a student from the system
                    String studNameRemove = studQG.askMessage("What is the name of the student you'd like to remove? ");
                    studQG.removeStudent(studentScores, studNameRemove);
                    break;
                case 4: //view a student's scores            
                    String studNameViewScores = studQG.askMessage("What is the name of the student whose scores you'd like to view? ");
                    studQG.viewStudScore(studentScores, studNameViewScores);
                    break;
                case 5: //view a student's average
                    String studNameViewAvg = studQG.askMessage("What is the name of the student whose quiz average you'd like to view? ");
                    studQG.viewStudAvg(studentScores, studNameViewAvg);
                    break;
                case 6: //view class average
                    studQG.viewClassAvg(studentScores);
                    break;
                case 7: //student with highest grade
                    studQG.studWithMax(studentScores);
                    break;  
                case 8: //student with lowest grade
                    studQG.studWithMin(studentScores);
                    break;
                default:
                    isPlayAgain = false;
                    break;
            }
            //I decided not to use the code below
            //isPlayAgain = studQG.askPlayAgain(); //check if user wants to play again
        } while (isPlayAgain == true);
        studQG.exitMessage(); //print a goodbye message
    }
    
}
