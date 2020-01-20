/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.aapractice.IO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 *
 * @author Boone
 */
public class MasterUserIOImpl implements MasterUserIO {    
    
Scanner sc = new Scanner(System.in);
    
    //void methods -------------------------------------------------------------
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    
    @Override
    public void print(String message) {
        System.out.println(message);
    }
    
    
    //string readers -----------------------------------------------------------
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    
    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        String stringIn = sc.nextLine();       
        return stringIn;
    }
    
    @Override
    public String readStringYesOrNo(String prompt) {
        String stringIn = "Default String--- This is an bug in the IO method";
        boolean isInputValid;
        do {
            try {
                do {
                    System.out.println(prompt);
                    String stringInUnTrimmed = sc.nextLine();
                    stringIn = stringInUnTrimmed.trim().toLowerCase();
                    if ((stringIn.length() == 0) || ((stringIn.isBlank() || (stringIn.isEmpty())))) {
                        isInputValid = false;
                        System.out.println("Input cannot be blank.");
                    } else if ((stringIn.equalsIgnoreCase("yes")) || (stringIn.equalsIgnoreCase("no"))) {
                        isInputValid = true;
                    } else {
                        isInputValid = false;
                    }
                } while (!isInputValid);
            } catch (NullPointerException e) {
                isInputValid = false;
                System.out.println("Input cannot be blank.");
            }
        } while (!isInputValid);
        return stringIn;
    }
    
    @Override
    public String readStringYesOrNoPartial(String prompt) {
        String stringIn = "Default String--- This is an bug in the IO method";
        boolean isInputValid;
        do {
            try {
                do {
                    System.out.println(prompt);
                    String stringInUnTrimmed = sc.nextLine();
                    stringIn = stringInUnTrimmed.trim().toLowerCase();
                    if ((stringIn.length() == 0) || ((stringIn.isBlank() || (stringIn.isEmpty())))) {
                        isInputValid = false;
                        System.out.println("Input cannot be blank.");
                    } else {
                        stringIn = stringIn.substring(0, 1);
                        if ((stringIn.equalsIgnoreCase("y")) || (stringIn.equalsIgnoreCase("n"))) {
                        isInputValid = true;
                        } else {
                            isInputValid = false;
                        }
                    }
                } while (!isInputValid);
            } catch (NullPointerException e) {
                isInputValid = false;
                System.out.println("Input cannot be blank.");
            }
        } while (!isInputValid);
        return stringIn;
    }
    
    @Override
    public String readStringNoBlankOrNull(String prompt) {
        String stringIn = "Default String--- This is an bug in the IO method";
        boolean isInputValid;
        do {
            try {
                do {
                    isInputValid = true;
                    System.out.println(prompt);
                    stringIn = sc.nextLine();
                    if ((stringIn.trim().length() == 0) || ((stringIn.isBlank() || (stringIn.isEmpty())))) {
                        isInputValid = false;
                        System.out.println("Input cannot be blank.");
                    }
                } while (!isInputValid);
            } catch (NullPointerException e) {
                isInputValid = false;
                System.out.println("Input cannot be blank.");
            }
        } while (!isInputValid);
        return stringIn;
    }
    
    @Override
    public String readStringOrEnterKey(String prompt) {
        String stringIn = "Default String--- This is an bug in the IO method";
        boolean isInputValid;
        do {
            try {
                do {
                    isInputValid = true;
                    System.out.println(prompt);
                    stringIn = sc.nextLine();
                    if (stringIn.isEmpty()) {
                        stringIn = "returnKeyEntered";
                    }
                    else if ((stringIn.trim().length() == 0) || (stringIn.trim().equals("returnKeyEntered"))) {
                        isInputValid = false;
                        System.out.println("That was invalid input.");
                    }
                } while (!isInputValid);
            } catch (NullPointerException e) {
                System.out.println("That was invalid input.");
                isInputValid = false;
            }
        } while (!isInputValid);
        return stringIn;
    }
    
    @Override
    public String readStringNoColon(String prompt) {
        String stringIn = "Default String--- This is an bug in the IO method";
        boolean isInputValid = true;
        do {
            System.out.println(prompt);
            stringIn = sc.nextLine();
            isInputValid = true;
            if (stringIn.contains(":")) {
                isInputValid = false;
                System.out.println("Sorry, but your input cannot contain a colon.");
            }
        } while (!isInputValid);   
        return stringIn;
    }
    
    @Override
    public String readStringNoBlankOrNullOrColon(String prompt) {
        String stringIn = "Default String--- This is an bug in the IO method";
        boolean isInputValid;
        do {
            try {
                do {
                    isInputValid = true;
                    System.out.println(prompt);
                    stringIn = sc.nextLine();
                    if ((stringIn.trim().length() == 0) || ((stringIn.isBlank() || (stringIn.isEmpty())))) {
                        isInputValid = false;
                        System.out.println("Input cannot be blank.");
                    } else if (stringIn.contains(":")) {
                        isInputValid = false;
                        System.out.println("Sorry, but your input cannot contain a colon.");
                    }
                } while (!isInputValid);
            } catch (NullPointerException e) {
                isInputValid = false;
                System.out.println("Input cannot be blank.");
            }
        } while (!isInputValid);
        return stringIn;
    }
    
    @Override
    public String readStringOrEnterKeyNoColon(String prompt) {
        String stringIn = "Default String--- This is an bug in the IO method";
        boolean isInputValid;
        do {
            try {
                do {
                    isInputValid = true;
                    System.out.println(prompt);
                    stringIn = sc.nextLine();
                    if (stringIn.isEmpty()) {
                        stringIn = "returnKeyEntered";
                    }
                    else if ((stringIn.trim().length() == 0) || (stringIn.trim().equals("returnKeyEntered"))) {
                        isInputValid = false;
                        System.out.println("That was invalid input.");
                    } else if (stringIn.contains(":")) {
                        isInputValid = false;
                        System.out.println("Sorry, but your input cannot contain a colon.");
                    }
                } while (!isInputValid);
            } catch (NullPointerException e) {
                System.out.println("That was invalid input.");
                isInputValid = false;
            }
        } while (!isInputValid);
        return stringIn;
    }
    
    @Override
    public String readStringNoDelimiter(String prompt, String delimiter) {
        String stringIn = "Default String--- This is an bug in the IO method";
        boolean isInputValid = true;
        do {
            System.out.println(prompt);
            stringIn = sc.nextLine();
            isInputValid = true;
            if (stringIn.contains(delimiter)) {
                isInputValid = false;
                System.out.println("Sorry, but your input cannot contain '" + delimiter + "'.");
            }
        } while (!isInputValid);   
        return stringIn;
    }
    
    @Override
    public String readStringNoBlankOrNullOrDelimiter(String prompt, String delimiter) {
        String stringIn = "Default String--- This is an bug in the IO method";
        boolean isInputValid;
        do {
            try {
                do {
                    isInputValid = true;
                    System.out.println(prompt);
                    stringIn = sc.nextLine();
                    if ((stringIn.trim().length() == 0) || ((stringIn.isBlank() || (stringIn.isEmpty())))) {
                        isInputValid = false;
                        System.out.println("Input cannot be blank.");
                    } else if (stringIn.contains(delimiter)) {
                        isInputValid = false;
                        System.out.println("Sorry, but your input cannot contain '" + delimiter + "'.");
                    }
                } while (!isInputValid);
            } catch (NullPointerException e) {
                isInputValid = false;
                System.out.println("Input cannot be blank.");
            }
        } while (!isInputValid);
        return stringIn;
    }
    
    @Override
    public String readStringOrEnterNoDelimiter(String prompt, String delimiter) {
        String stringIn = "Default String--- This is an bug in the IO method";
        boolean isInputValid;
        do {
            try {
                do {
                    isInputValid = true;
                    System.out.println(prompt);
                    stringIn = sc.nextLine();
                    if (stringIn.isEmpty()) {
                        stringIn = "returnKeyEntered";
                    }
                    else if ((stringIn.trim().length() == 0) || (stringIn.trim().equals("returnKeyEntered"))) {
                        isInputValid = false;
                        System.out.println("That was invalid input.");
                    } else if (stringIn.contains(delimiter)) {
                        isInputValid = false;
                        System.out.println("Sorry, but your input cannot contain '" + delimiter + "'.");
                    }
                } while (!isInputValid);
            } catch (NullPointerException e) {
                System.out.println("That was invalid input.");
                isInputValid = false;
            }
        } while (!isInputValid);
        return stringIn;
    }
    
 
    
    //number readers -----------------------------------------------------------
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    
    //int readers --------------------------------------------------------------
    
    @Override
    public int readInt(String prompt) {
        int numIn = 0;
        boolean isInputGood = false;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            try {
                numIn = Integer.parseInt(stringIn);
                isInputGood = true;
            } catch (NumberFormatException e) {
                System.out.println("You must enter an integer.");
            } 
        } while (isInputGood == false);
        return numIn;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int numIn = 0;
        boolean isInputGood = false;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            try {
                numIn = Integer.parseInt(stringIn);
                if (numIn < min || numIn > max) {
                    System.out.println("The number you enter must be between " + min + " and " + max + " (inclusively)");
                } else {
                    isInputGood = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("You must enter an integer.");
            }
        } while (isInputGood == false || numIn < min || numIn > max);
        return numIn;
    }
    
    @Override
    public int readIntGreaterThanOrEqualTo(String prompt, int min) {
       int numIn = 0;
        boolean isInputGood = false;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            try {
                numIn = Integer.parseInt(stringIn);
                if (numIn < min) {
                    System.out.println("The number you enter must be greater than or equal to " + min + ".");
                } else {
                    isInputGood = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("You must enter an integer.");
            }
        } while (isInputGood == false);
        return numIn;
    }
    
    @Override
    public int readIntLessThanOrEqualTo(String prompt, int max) {
        int numIn = 0;
        boolean isInputGood = false;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            try {
                numIn = Integer.parseInt(stringIn);
                if (numIn > max) {
                    System.out.println("The number you enter must be less than or equal to " + max + ".");
                } else {
                    isInputGood = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("You must enter an integer.");
            }
        } while (isInputGood == false);
        return numIn;
    }
    
    @Override
    public int readIntOrPassword(String prompt, int min, int max, String password) {
        int numIn = 0;
        boolean isInputGood = false;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            if (stringIn.equals(password)) {
                numIn = -1123581;
                isInputGood = true;
            } else {
                try {
                    numIn = Integer.parseInt(stringIn);
                    if (numIn < min || numIn > max) {
                        System.out.println("The number you enter must be between " + min + " and " + max + " (inclusively)");
                    } else {
                        isInputGood = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You must enter an integer.");
                }
            }
        } while (isInputGood == false);
        return numIn;
    }
    
    @Override
    public int readIntOrEnterKey(String prompt) {
        int numIn = 0;
        boolean isInputGood = false;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            if (stringIn.isEmpty()) {
                numIn = -1123581;
                isInputGood = true;
            } else {
                try {
                    numIn = Integer.parseInt(stringIn);
                    if (numIn == -1123581) {
                        System.out.println("Sorry, but that input is not valid.");
                    } else {
                        isInputGood = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You must enter an integer.");
                } 
            }
        } while (isInputGood == false);
        return numIn;
    }
    
    @Override
    public int readIntOrEnterKey(String prompt, int min, int max) {
        int numIn = 0;
        boolean isInputGood = false;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            if (stringIn.isEmpty()) {
                numIn = -1123581;
                isInputGood = true;
            }
            else {
                try {
                    numIn = Integer.parseInt(stringIn);
                    if (numIn == -1123581) {
                            System.out.println("Sorry, but that input is not valid.");
                    }
                    else if (numIn < min || numIn > max) {
                        System.out.println("The number you enter must be between " + min + " and " + max + " (inclusively)");
                    } else {
                        isInputGood = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You must enter an integer.");
                }
            }
        } while (isInputGood == false);
        return numIn;
    }
    
    //double readers -----------------------------------------------------------
    
    @Override
    public double readDouble(String prompt) {
        double numIn = 0;
        boolean isInputGood = false;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            try {
                numIn = Double.parseDouble(stringIn);
                isInputGood = true;
            } catch (NumberFormatException e) {
                System.out.println("You must enter a number.");
            }
        } while (isInputGood == false);
        return numIn;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        double numIn = 0;
        boolean isInputGood = false;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            try {
                numIn = Double.parseDouble(stringIn);
                if (numIn < min || numIn > max) {
                    System.out.println("The number you enter must be between " + min + " and " + max + " (inclusively)");
                } else {
                    isInputGood = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("You must enter a number.");
            }
        } while (isInputGood == false || numIn < min || numIn > max);
        return numIn;
    }
    
    @Override
    public double readDoubleGreaterThanOrEqualTo(String prompt, double min) {
        double numIn = 0;
        boolean isInputGood = false;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            try {
                numIn = Double.parseDouble(stringIn);
                if (numIn < min) {
                    System.out.println("The number you enter must be greater than or equal to " + min + ".");
                } else {
                    isInputGood = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("You must enter a number.");
            }
        } while (isInputGood == false);
        return numIn;
    }
    
    @Override
    public double readDoubleLessThanOrEqualTo(String prompt, double max) {
        double numIn = 0;
        boolean isInputGood = false;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            try {
                numIn = Double.parseDouble(stringIn);
                if (numIn > max) {
                    System.out.println("The number you enter must be less than or equal to " + max + ".");
                } else {
                    isInputGood = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("You must enter a number.");
            }
        } while (isInputGood == false);
        return numIn;
    }
    
    @Override
    public double readDoubleOrPassword(String prompt, double min, double max, String password) {
        double numIn = 0;
        boolean isInputGood = false;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            if (stringIn.equals(password)) {
                numIn = -1123581;
                isInputGood = true;
            } else {
                try {
                    numIn = Double.parseDouble(stringIn);
                    if (numIn < min || numIn > max) {
                        System.out.println("The number you enter must be between " + min + " and " + max + " (inclusively)");
                    } else {
                        isInputGood = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You must enter a number.");
                }
            }
        } while (isInputGood == false);
        return numIn;
    }
    
    @Override
    public double readDoubleOrEnterKey(String prompt) {
        double numIn = 0;
        boolean isInputGood = false;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            if (stringIn.isEmpty()) {
                numIn = -1123581;
                isInputGood = true;
            } else {
                try {
                    numIn = Double.parseDouble(stringIn);
                    if (numIn == -1123581) {
                        System.out.println("Sorry, but that input is not valid.");
                    } else {
                        isInputGood = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You must enter a number.");
                } 
            }
        } while (isInputGood == false);
        return numIn;
    }
    
    @Override
    public double readDoubleOrEnterKey(String prompt, double min, double max) {
        double numIn = 0;
        boolean isInputGood = false;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            if (stringIn.isEmpty()) {
                numIn = -1123581;
                isInputGood = true;
            }
            else {
                try {
                    numIn = Double.parseDouble(stringIn);
                    if (numIn == -1123581) {
                            System.out.println("Sorry, but that input is not valid.");
                    }
                    else if (numIn < min || numIn > max) {
                        System.out.println("The number you enter must be between " + min + " and " + max + " (inclusively)");
                    } else {
                        isInputGood = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You must enter a number.");
                }
            }
        } while (isInputGood == false);
        return numIn;
    }

    //float readers ------------------------------------------------------------
    
    @Override
    public float readFloat(String prompt) {
        float numIn = 0;
        boolean isInputGood = false;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            try {
                numIn = Float.parseFloat(stringIn);
                isInputGood = true;
            } catch (NumberFormatException e) {
                System.out.println("You must enter a number.");
            }
        } while (isInputGood == false);
        return numIn;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float numIn = 0;
        boolean isInputGood = false;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            try {
                numIn = Float.parseFloat(stringIn);
                if (numIn < min || numIn > max) {
                    System.out.println("The number you enter must be between " + min + " and " + max + " (inclusively)");
                } else {
                    isInputGood = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("You must enter a number.");
            }
        } while (isInputGood == false || numIn < min || numIn > max);
        return numIn;
    }

    @Override
    public float readFloatGreaterThanOrEqualTo(String prompt, float min) {
        float numIn = 0;
        boolean isInputGood = false;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            try {
                numIn = Float.parseFloat(stringIn);
                if (numIn < min) {
                    System.out.println("The number you enter must be greater than or equal to " + min + ".");
                } else {
                    isInputGood = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("You must enter a number.");
            }
        } while (isInputGood == false);
        return numIn;
    }
    
    @Override
    public float readFloatLessThanOrEqualTo(String prompt, float max) {
        float numIn = 0;
        boolean isInputGood = false;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            try {
                numIn = Float.parseFloat(stringIn);
                if (numIn > max) {
                    System.out.println("The number you enter must be less than or equal to " + max + ".");
                } else {
                    isInputGood = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("You must enter a number.");
            }
        } while (isInputGood == false);
        return numIn;
    }
    @Override
    public float readFloatOrPassword(String prompt, float min, float max, String password) {
        float numIn = 0;
        boolean isInputGood = false;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            if (stringIn.equals(password)) {
                numIn = -1123581;
                isInputGood = true;
            } else {
                try {
                    numIn = Float.parseFloat(stringIn);
                    if (numIn < min || numIn > max) {
                        System.out.println("The number you enter must be between " + min + " and " + max + " (inclusively)");
                    } else {
                        isInputGood = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You must enter a number.");
                }
            }
        } while (isInputGood == false);
        return numIn;
    }
    
    @Override
    public float readFloatOrEnterKey(String prompt) {
        float numIn = 0;
        boolean isInputGood = false;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            if (stringIn.isEmpty()) {
                numIn = -1123581;
                isInputGood = true;
            } else {
                try {
                    numIn = Float.parseFloat(stringIn);
                    if (numIn == -1123581) {
                        System.out.println("Sorry, but that input is not valid.");
                    } else {
                        isInputGood = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You must enter a number.");
                } 
            }
        } while (isInputGood == false);
        return numIn;
    }
    
    @Override
    public float readFloatOrEnterKey(String prompt, float min, float max) {
        float numIn = 0;
        boolean isInputGood = false;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            if (stringIn.isEmpty()) {
                numIn = -1123581;
                isInputGood = true;
            }
            else {
                try {
                    numIn = Float.parseFloat(stringIn);
                    if (numIn == -1123581) {
                            System.out.println("Sorry, but that input is not valid.");
                    }
                    else if (numIn < min || numIn > max) {
                        System.out.println("The number you enter must be between " + min + " and " + max + " (inclusively)");
                    } else {
                        isInputGood = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You must enter a number.");
                }
            }
        } while (isInputGood == false);
        return numIn;
    }
    
    //long readers -------------------------------------------------------------

    @Override
    public long readLong(String prompt) {
        long numIn = 0;
        boolean isInputGood = false;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            try {
                numIn = Long.parseLong(stringIn);
                isInputGood = true;
            } catch (NumberFormatException e) {
                System.out.println("You must enter an integer.");
            } 
        } while (isInputGood == false);
        return numIn;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long numIn = 0;
        boolean isInputGood = false;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            try {
                numIn = Long.parseLong(stringIn);
                if (numIn < min || numIn > max) {
                    System.out.println("The number you enter must be between " + min + " and " + max + " (inclusively)");
                } else {
                    isInputGood = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("You must enter an integer.");
            }
        } while (isInputGood == false || numIn < min || numIn > max);
        return numIn;
    }
    
    @Override
    public long readLongGreaterThanOrEqualTo(String prompt, long min) {
        long numIn = 0;
        boolean isInputGood = false;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            try {
                numIn = Long.parseLong(stringIn);
                if (numIn < min) {
                    System.out.println("The number you enter must be greater than or equal to " + min + ".");
                } else {
                    isInputGood = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("You must enter a number.");
            }
        } while (isInputGood == false);
        return numIn;
    }
    
    @Override
    public long readLongLessThanOrEqualTo(String prompt, long max) {
        long numIn = 0;
        boolean isInputGood = false;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            try {
                numIn = Long.parseLong(stringIn);
                if (numIn > max) {
                    System.out.println("The number you enter must be less than or equal to " + max + ".");
                } else {
                    isInputGood = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("You must enter a number.");
            }
        } while (isInputGood == false);
        return numIn;
    }
    
    @Override
    public long readLongOrPassword(String prompt, long min, long max, String password) {
        long numIn = 0;
        boolean isInputGood = false;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            if (stringIn.equals(password)) {
                numIn = -1123581;
                isInputGood = true;
            } else {
                try {
                    numIn = Long.parseLong(stringIn);
                    if (numIn < min || numIn > max) {
                        System.out.println("The number you enter must be between " + min + " and " + max + " (inclusively)");
                    } else {
                        isInputGood = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You must enter a number.");
                }
            }
        } while (isInputGood == false);
        return numIn;
    }
    
    @Override
    public long readLongOrEnterKey(String prompt) {
        long numIn = 0;
        boolean isInputGood = false;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            if (stringIn.isEmpty()) {
                numIn = -1123581;
                isInputGood = true;
            } else {
                try {
                    numIn = Long.parseLong(stringIn);
                    if (numIn == -1123581) {
                        System.out.println("Sorry, but that input is not valid.");
                    } else {
                        isInputGood = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You must enter a number.");
                } 
            }
        } while (isInputGood == false);
        return numIn;
    }
    
    @Override
    public long readLongOrEnterKey(String prompt, long min, long max) {
        long numIn = 0;
        boolean isInputGood = false;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            if (stringIn.isEmpty()) {
                numIn = -1123581;
                isInputGood = true;
            }
            else {
                try {
                    numIn = Long.parseLong(stringIn);
                    if (numIn == -1123581) {
                            System.out.println("Sorry, but that input is not valid.");
                    }
                    else if (numIn < min || numIn > max) {
                        System.out.println("The number you enter must be between " + min + " and " + max + " (inclusively)");
                    } else {
                        isInputGood = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You must enter a number.");
                }
            }
        } while (isInputGood == false);
        return numIn;
    }
    
    //big decimal readers ------------------------------------------------------
    
    @Override
    public BigDecimal readBigDecimal(String prompt) {
        BigDecimal numIn = new BigDecimal("0");
        boolean isInputGood = false;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            try {
                numIn = new BigDecimal(stringIn);
                isInputGood = true;
            } catch (NumberFormatException e) {
                System.out.println("You must enter a number.");
            }
        } while (isInputGood == false);
        return numIn;
    }
    
    @Override
    public BigDecimal readBigDecimal(String prompt, BigDecimal max, BigDecimal min) {
        BigDecimal numIn = new BigDecimal("0");
        boolean isInputGood = false;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            try {
                numIn = new BigDecimal(stringIn);
                if (numIn.compareTo(max) >= 1 || numIn.compareTo(min) <= -1) {
                    System.out.println("The number you enter must be between " + 
                            min.toPlainString() + " and " + 
                            max.toPlainString() + " (inclusively)");
                } else {
                    isInputGood = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("You must enter a number.");
            }
        } while (isInputGood == false || numIn.compareTo(max) >= 1 || numIn.compareTo(min) <= -1);
        return numIn;
    }
    
    @Override
    public BigDecimal readBigDecimalGreaterThanOrEqualTo(String prompt, BigDecimal min) {
        BigDecimal numIn = new BigDecimal("0");
        boolean isInputGood = false;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            try {
                numIn = new BigDecimal(stringIn);
                if (numIn.compareTo(min) < 0) {
                    System.out.println("The number you enter must be greater than or equal to " + min.toPlainString() + ".");
                } else {
                    isInputGood = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("You must enter a number.");
            }
        } while (isInputGood == false);
        return numIn;
    }
    
    @Override
    public BigDecimal readBigDecimalLessThanOrEqualTo(String prompt, BigDecimal max) {
        BigDecimal numIn = new BigDecimal("0");
        boolean isInputGood = false;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            try {
                numIn = new BigDecimal(stringIn);
                if (numIn.compareTo(max) > 0) {
                    System.out.println("The number you enter must be less than or equal to " + max.toPlainString() + ".");
                } else {
                    isInputGood = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("You must enter a number.");
            }
        } while (isInputGood == false);
        return numIn;
    }
    
    @Override
    public BigDecimal readBigDecimalOrPassword(String prompt, BigDecimal min, BigDecimal max, String password) {
        BigDecimal numIn = new BigDecimal("0");
        boolean isInputGood = false;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            if (stringIn.equals(password)) {
                numIn = new BigDecimal("-1123581");
                isInputGood = true;
            } else {
                try {
                    numIn = new BigDecimal(stringIn);
                    if (numIn.compareTo(max) >= 1 || numIn.compareTo(min) <= -1) {
                    System.out.println("The number you enter must be between " + 
                            min.toPlainString() + " and " + 
                            max.toPlainString() + " (inclusively)");
                } else {
                    isInputGood = true;
                }
                } catch (NumberFormatException e) {
                    System.out.println("You must enter a number.");
                }
            }
        } while (isInputGood == false);
        return numIn;
    }
    
    @Override
    public BigDecimal readBigDecimalOrEnterKey(String prompt) {
        BigDecimal numIn = new BigDecimal("0");
        boolean isInputGood = false;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            if (stringIn.isEmpty()) {
                numIn = new BigDecimal("-1123581");
                isInputGood = true;
            } else {
                try {
                    numIn = new BigDecimal(stringIn);
                    BigDecimal numPass = new BigDecimal("-1123581");
                    if (numIn.equals(numPass)) {
                            System.out.println("Sorry, but that input is not valid.");
                    } else {
                        isInputGood = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You must enter a number.");
                } 
            }
        } while (isInputGood == false);
        return numIn;
    }
    
    @Override
    public BigDecimal readBigDecimalOrEnterKey(String prompt, BigDecimal min, BigDecimal max) {
        BigDecimal numIn = new BigDecimal("0");
        boolean isInputGood = false;
        do {
            System.out.println(prompt);
            String stringIn = sc.nextLine();
            if (stringIn.isEmpty()) {
                numIn = new BigDecimal("-1123581");
                isInputGood = true;
            }
            else {
                try {
                    numIn = new BigDecimal(stringIn);
                    BigDecimal numPass = new BigDecimal("-1123581");
                    if (numIn.equals(numPass)) {
                            System.out.println("Sorry, but that input is not valid.");
                    }
                    else if (numIn.compareTo(max) >= 1 || numIn.compareTo(min) <= -1) {
                        System.out.println("The number you enter must be between " + 
                                min.toPlainString() + " and " + 
                                max.toPlainString() + " (inclusively)");
                    } else {
                        isInputGood = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You must enter a number.");
                }
            }
        } while (isInputGood == false);
        return numIn;
    }
    
    
    //local date readers -------------------------------------------------------
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    
    @Override
    public LocalDate readLocalDateDefaultPattern(String prompt) {
        LocalDate ld = LocalDate.parse("1055-05-05");
        boolean isInputValid;
        do {
            isInputValid = true;
            try {
                System.out.println("Please use the date format 'yyyy-MM-dd'. " + prompt);
                String stringIn = sc.nextLine();
                ld = LocalDate.parse(stringIn);
            } catch (DateTimeParseException e) {
                isInputValid = false;
                System.out.println("That was not a valid date format.  Follow the prompt carefully.");
            }
        } while (!isInputValid);
        return ld;
    }
    
    @Override
    public LocalDate readLocalDateSpecificPattern(String prompt, String pattern) {
        LocalDate ld = LocalDate.parse("1055-05-05");
        boolean isInputValid;
        do {
            isInputValid = true;
            try {
                System.out.println("Please use the date format '" + pattern + "'. " + prompt);
                String stringIn = sc.nextLine();
                ld = LocalDate.parse(stringIn, DateTimeFormatter.ofPattern(pattern));
            } catch (DateTimeParseException e) {
                isInputValid = false;
                System.out.println("That was not a valid date format.  Follow the prompt carefully.");
            }
        } while (!isInputValid);
        return ld;
    }
    
    @Override
    public LocalDate readLocalDateDefaultPatternAfterTodayOnly(String prompt) {
        LocalDate ld = LocalDate.parse("1055-05-05");
        LocalDate today = LocalDate.now();
        boolean isInputValid;
        do {
            isInputValid = true;
            try {
                System.out.println("Please use the date format 'yyyy-MM-dd'. " + prompt);
                String stringIn = sc.nextLine();
                ld = LocalDate.parse(stringIn);
                if (ld.isBefore(today)) {
                    System.out.println("The date you enter cannot be earlier than today.");
                    isInputValid = false;
                }
            } catch (DateTimeParseException e) {
                isInputValid = false;
                System.out.println("That was not a valid date format.  Follow the prompt carefully.");
            }
        } while (!isInputValid);
        return ld;
    }
        
    @Override
    public LocalDate readLocalDateSpecificPatternAfterTodayOnly(String prompt, String pattern) {
        LocalDate ld = LocalDate.parse("1055-05-05");
        LocalDate today = LocalDate.now();
        boolean isInputValid;
        do {
            isInputValid = true;
            try {
                System.out.println("Please use the date format '" + pattern + "'. " + prompt);
                String stringIn = sc.nextLine();
                ld = LocalDate.parse(stringIn, DateTimeFormatter.ofPattern(pattern));
                if (ld.isBefore(today)) {
                    System.out.println("The date you enter cannot be earlier than today.");
                    isInputValid = false;
                }
            } catch (DateTimeParseException e) {
                isInputValid = false;
                System.out.println("That was not a valid date format.  Follow the prompt carefully.");
            }
        } while (!isInputValid);
        return ld;
    }
    
    @Override
    public LocalDate readLocalDateDefaultPatternRange(String prompt, LocalDate minDate, LocalDate maxDate) {
        LocalDate ld = LocalDate.parse("1055-05-05");
        boolean isInputValid;
        do {
            isInputValid = true;
            try {
                System.out.println("Please use the date format 'yyyy-MM-dd'. " + prompt);
                String stringIn = sc.nextLine();
                ld = LocalDate.parse(stringIn);
                if (ld.isBefore(minDate) || ld.isAfter(maxDate)) {
                    System.out.println("The date you enter must be between " + 
                            minDate.toString() + " and " + maxDate.toString() + ".");
                    isInputValid = false;
                }
            } catch (DateTimeParseException e) {
                isInputValid = false;
                System.out.println("That was not a valid date format.  Follow the prompt carefully.");
            }
        } while (!isInputValid);
        return ld;
    }
    
    @Override
    public LocalDate readLocalDateSpecificPatternRange(String prompt, String pattern, LocalDate minDate, LocalDate maxDate) {
        LocalDate ld = LocalDate.parse("1055-05-05");
        
        String minDateStr = minDate.format(DateTimeFormatter.ofPattern(pattern));
        String maxDateStr = maxDate.format(DateTimeFormatter.ofPattern(pattern));
       
        boolean isInputValid;
        do {
            isInputValid = true;
            try {
                System.out.println("Please use the date format '" + pattern + "'. " + prompt);
                String stringIn = sc.nextLine();
                ld = LocalDate.parse(stringIn, DateTimeFormatter.ofPattern(pattern));
                if (ld.isBefore(minDate) || ld.isAfter(maxDate)) {
                    System.out.println("The date you enter must be between " + 
                            minDateStr + " and " + maxDateStr + ".");
                    isInputValid = false;
                }
            } catch (DateTimeParseException e) {
                isInputValid = false;
                System.out.println("That was not a valid date format.  Follow the prompt carefully.");
            }
        } while (!isInputValid);
        return ld;
    }
    
    @Override
    public LocalDate readLocalDateDefaultPatternAfterMinDate(String prompt, LocalDate minDate) {
        LocalDate ld = LocalDate.parse("1055-05-05");
        boolean isInputValid;
        do {
            isInputValid = true;
            try {
                System.out.println("Please use the date format 'yyyy-MM-dd'. " + prompt);
                String stringIn = sc.nextLine();
                ld = LocalDate.parse(stringIn);
                if (ld.isBefore(minDate)) {
                    System.out.println("The date you enter cannot be before " + minDate.toString() + ".");
                    isInputValid = false;
                }
            } catch (DateTimeParseException e) {
                isInputValid = false;
                System.out.println("That was not a valid date format.  Follow the prompt carefully.");
            }
        } while (!isInputValid);
        return ld;
    }
    
    @Override
    public LocalDate readLocalDateSpecificPatternAfterMinDate(String prompt, String pattern, LocalDate minDate) {
        LocalDate ld = LocalDate.parse("1055-05-05");
        String minDateStr = minDate.format(DateTimeFormatter.ofPattern(pattern));
        boolean isInputValid;
        do {
            isInputValid = true;
            try {
                System.out.println("Please use the date format '" + pattern + "'. " + prompt);
                String stringIn = sc.nextLine();
                ld = LocalDate.parse(stringIn);
                if (ld.isBefore(minDate)) {
                    System.out.println("The date you enter cannot be before " + minDateStr + ".");
                    isInputValid = false;
                }
            } catch (DateTimeParseException e) {
                isInputValid = false;
                System.out.println("That was not a valid date format.  Follow the prompt carefully.");
            }
        } while (!isInputValid);
        return ld;
    }
    
    @Override
    public LocalDate readLocalDateDefaultPatternBeforeMaxDate(String prompt, LocalDate maxDate) {
        LocalDate ld = LocalDate.parse("1055-05-05");
        boolean isInputValid;
        do {
            isInputValid = true;
            try {
                System.out.println("Please use the date format 'yyyy-MM-dd'. " + prompt);
                String stringIn = sc.nextLine();
                ld = LocalDate.parse(stringIn);
                if (ld.isAfter(maxDate)) {
                    System.out.println("The date you enter cannot be after " + maxDate.toString() + ".");
                    isInputValid = false;
                }
            } catch (DateTimeParseException e) {
                isInputValid = false;
                System.out.println("That was not a valid date format.  Follow the prompt carefully.");
            }
        } while (!isInputValid);
        return ld;
    }
    
    @Override
    public LocalDate readLocalDateSpecificPatternBeforeMaxDate(String prompt, String pattern, LocalDate maxDate) {
        LocalDate ld = LocalDate.parse("1055-05-05");
        String maxDateStr = maxDate.format(DateTimeFormatter.ofPattern(pattern));
        boolean isInputValid;
        do {
            isInputValid = true;
            try {
                System.out.println("Please use the date format '" + pattern + "'. " + prompt);
                String stringIn = sc.nextLine();
                ld = LocalDate.parse(stringIn);
                if (ld.isAfter(maxDate)) {
                    System.out.println("The date you enter cannot be after " + maxDateStr + ".");
                    isInputValid = false;
                }
            } catch (DateTimeParseException e) {
                isInputValid = false;
                System.out.println("That was not a valid date format.  Follow the prompt carefully.");
            }
        } while (!isInputValid);
        return ld;
    }

}