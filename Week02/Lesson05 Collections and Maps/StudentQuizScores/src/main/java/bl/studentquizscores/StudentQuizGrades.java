package bl.studentquizscores;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;
/**
 *
 * @author Boone
 */
public class StudentQuizGrades {

    public ArrayList<Integer> buildArrayList(int listSize, int minScore) {
        ArrayList<Integer> newArrayList = new ArrayList<>();
        Random randGen = new Random();
        for (int i = 0; i < listSize; i++) {
            int rand = randGen.nextInt((100 - minScore) + 1) + minScore;
            newArrayList.add(rand);  
        }
        return newArrayList;
    }
    
    public void welcomeMessage() {
        System.out.println("Welcome to the Student Quiz Grades Program.");
        System.out.println("\nTo view a list of all the students in the system, enter '1'");
        System.out.println("To add a student to the system, enter '2'");
        System.out.println("To remove a student from the system, enter '3'");
        System.out.println("To view a single studnet's quiz grades, enter '4'");
        System.out.println("To view a single student's quiz average, enter '5'");
        System.out.println("To view the quiz average for the entire class, enter '6'");
        System.out.println("To view the student with the highest quiz grade, enter '7'");
        System.out.println("To view the student with the lowest quiz grade, enter '8'");
        System.out.println("To exit this program, enter '9'");
        System.out.println("");
    }
    
    public String askMessage(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        String stringIn = sc.next();
        return stringIn;
    }
    
    public int askChoice() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nWhat would you like to do? (1, 2, 3, 4, 5, 6, 7, 8, or 9): ");
        String stringIn = sc.next();
        int num1 = Integer.parseInt(stringIn);
        return num1;
    }
    
//    public boolean askPlayAgain() {
//        boolean output;
//        Scanner sc = new Scanner(System.in);
//        System.out.print("\nWould you like to perform another action? (y/n): ");
//        String stringIn = sc.next();
//        if (stringIn.equals("y")) {
//            output = true;
//        } else {
//            output = false;
//        }
//        return output;
//    }
    
    public void exitMessage() {
        System.out.println("\nThank you for using this program!");
    }
    
    public void viewStudList(HashMap<String, ArrayList<Integer>> hashMap) {
        for(String i : hashMap.keySet()) {
            System.out.println(i);
        }    
    }
    
    public void addStudent(HashMap<String, ArrayList<Integer>> hashMap, String name) {
        hashMap.put(name, buildArrayList(10,80));
    }
    
    public void removeStudent(HashMap<String, ArrayList<Integer>> hashMap, String name) {
        hashMap.remove(name);
    }
    
    public void viewStudScore(HashMap<String, ArrayList<Integer>> hashMap, String name) {
        System.out.println(hashMap.get(name));
    }
    
    public void viewStudAvg(HashMap<String, ArrayList<Integer>> hashMap, String name) {
        ArrayList<Integer> arrayList1 = hashMap.get(name);
        int sumScores = 0;
        for (int i = 0; i < arrayList1.size(); i++) {
            sumScores += arrayList1.get(i);
        }
        double average = sumScores / arrayList1.size();
        System.out.println(average);
    }
    
    public void viewClassAvg(HashMap<String, ArrayList<Integer>> hashMap) {
        int scoreTotal = 0;
        int gradesTotal = 0;
        for (String i : hashMap.keySet()) {
            ArrayList<Integer> arrayList2 = hashMap.get(i);
            for (int j = 0; j < arrayList2.size(); j++) {
                scoreTotal += arrayList2.get(j);
            }
            gradesTotal += arrayList2.size();
        }
        double avgClass = scoreTotal / gradesTotal;
        System.out.println(avgClass);
    }
    
    public void studWithMax(HashMap<String, ArrayList<Integer>> hashMap) {
        
        //first, find what the max grade is
        int max = 0;
        for (String i : hashMap.keySet()) { //cycle through all keys
            ArrayList<Integer> arrayList = hashMap.get(i);
            for (int j = 0; j < arrayList.size(); j++) { //for each key, cycle through all grades
                if (arrayList.get(j) > max) {
                    max = arrayList.get(j); //max is the highest number that has been encountered thus far
                }
            }
        }
        
        //next, (since max is for-sure known) if an array list has that max, add that student's name to an arrayList
        ArrayList<String> arrayListNames = new ArrayList<>();
        for (String i : hashMap.keySet()) { //cycle through all keys
            ArrayList<Integer> arrayList3 = hashMap.get(i);
            for (int j = 0; j < arrayList3.size(); j++) { //for each key, cycle through all grades
                if (arrayList3.get(j) == max) {
                    arrayListNames.add(i);
                }
            }
        }
        
        //print result
        System.out.println(max + " is the highest grade, which is held by... " + arrayListNames);
    }
    
    public void studWithMin(HashMap<String, ArrayList<Integer>> hashMap) {
        
        //first, find what the min grade is
        int min = 1000;
        for (String i : hashMap.keySet()) { //cycle through all keys
            ArrayList<Integer> arrayList = hashMap.get(i);
            for (int j = 0; j < arrayList.size(); j++) { //for each key, cycle through all grades
                if (arrayList.get(j) < min) {
                    min = arrayList.get(j); //min is the lowest number that has been encountered thus far
                }
            }
        }
        
        //next, (since min is for-sure known) if an array list has that min, add that student's name to an arrayList
        ArrayList<String> arrayListNames = new ArrayList<>();
        for (String i : hashMap.keySet()) { //cycle through all keys
            ArrayList<Integer> arrayList3 = hashMap.get(i);
            for (int j = 0; j < arrayList3.size(); j++) { //for each key, cycle through all grades
                if (arrayList3.get(j) == min) {
                    arrayListNames.add(i);
                }
            }
        }
        
        //print result
        System.out.println(min + " is the lowest grade, which is held by... " + arrayListNames);
    }
}