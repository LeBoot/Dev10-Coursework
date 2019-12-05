/**
 * @author Boone
 */

import java.util.Scanner;

public class WindowMaster {
    public static void main(String[] args) {
        float height, width;
        float areaOfWindow, perimeterOfWindow, cost;
        String stringHeight, stringWidth;
        
        Scanner myScanner = new Scanner(System.in);
        
        System.out.println("What is the height of your window? ");
        stringHeight = myScanner.nextLine();
        
        System.out.println("What is the width of your window? ");
        stringWidth = myScanner.nextLine();
        
        height = Float.parseFloat(stringHeight);
        width = Float.parseFloat(stringWidth);
        
        areaOfWindow = height * width;
        perimeterOfWindow = 2 * height + 2 * width;
        cost = (3.50f * areaOfWindow) + (2.25f * perimeterOfWindow);
                
        System.out.println("The area of your window is " + areaOfWindow + " square units.");
        System.out.println("The perimeter of your window is " + perimeterOfWindow + " units.");
        System.out.println("The total cost of the project is " + cost + " US dollars.");
    }
}