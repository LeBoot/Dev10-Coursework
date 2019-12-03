/**
 * @author Boone
 */

//There are two programs in this text.  The first is commented out; the second is active.
//int day applies to both programs.
//String dayName, dayType applies to one or the other.

public class SwitchStatement {
     public static void main(String[] args) {
        int day = 5;
        String dayName;
        String dayType;
        /*
        switch (day) {
            case 1:
                dayName = "Monday";
                break;
            case 2:
                dayName = "Tuesday";
                break;
            case 3:
                dayName = "Wednesday";
                break;
            case 4:
                dayName = "Thor's Day";
                break;
            case 5:
                dayName = "Friday";
                break;
            case 6:
                dayName = "Saturday";
                break;
            case 7:
                dayName = "Sunday";
                break;
            default:
                dayName = "Invalid day";
        }
        System.out.println(dayName);
        */

        switch (day) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                dayType = "Weekday";
                    break;
            case 6:
            case 7:
                dayType = "Weekend";
                    break;
            default:
                dayType = "Invalid Day";
        }

    System.out.println(dayType);
        
    }
}
