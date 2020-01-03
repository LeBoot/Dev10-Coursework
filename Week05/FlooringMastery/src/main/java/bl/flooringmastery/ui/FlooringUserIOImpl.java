/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.flooringmastery.ui;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 *
 * @author Boone
 */
public class FlooringUserIOImpl implements FlooringUserIO {

    Scanner sc = new Scanner(System.in);
    
    @Override
    public void print(String message) {
        System.out.println(message);
    }
    
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
    public String readString(String prompt) {
        System.out.println(prompt);
        String stringIn = sc.nextLine();       
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
    public LocalDate readLocalDateDefaultPatternFutureOnly(String prompt) {
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
    public LocalDate readLocalDateSpecificPatternFutureOnly(String prompt, String pattern) {
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
}