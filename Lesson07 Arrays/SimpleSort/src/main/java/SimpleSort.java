/**
 * @author Boone
 */

import java.util.Arrays;

public class SimpleSort {
    public static void main(String[] args) {
        int[] firstHalf = {3, 7, 9, 10, 16, 19, 20, 34, 55, 67, 88, 99, 1009};
        int[] secondHalf = {1, 4, 8, 11, 15, 18, 21, 44, 54, 79, 89, 100};

        int[] wholeNumbers = new int[firstHalf.length + secondHalf.length];

        for (int i = 0; i < wholeNumbers.length; i++) {
            if (i < firstHalf.length) {
                wholeNumbers[i] = firstHalf[i];
            } else {
                wholeNumbers[i] = secondHalf[i - firstHalf.length];
            }
        }
        
        Arrays.sort(wholeNumbers);
        
        for (int i = 0; i < wholeNumbers.length; i++) {
            System.out.print(wholeNumbers[i] + ", ");
        }  
    }
}
