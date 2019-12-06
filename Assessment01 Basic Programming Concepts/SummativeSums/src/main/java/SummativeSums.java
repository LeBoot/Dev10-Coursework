/**
 * @author Boone
 */

public class SummativeSums {
    public static void main(String[] args) {
        int[] array01 = { 1, 90, -33, -55, 67, -16, 28, -55, 15 };
        int[] array02 = { 999, -60, -77, 14, 160, 301 };
        int[] array03 = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 
            140, 150, 160, 170, 180, 190, 200, -99 };
        
        int sumOfArray01 = sumArrays(array01);
        int sumOfArray02 = sumArrays(array02);
        int sumOfArray03 = sumArrays(array03);
        
        System.out.println(printStatement("array01", sumOfArray01));
        System.out.println(printStatement("array02", sumOfArray02));
        System.out.println(printStatement("array03", sumOfArray03)); 
    }
    
    public static int sumArrays(int[] arrayParam) {
        int sumOfElements = 0;
        for (int i = 0; i < arrayParam.length; i++) {
            sumOfElements += arrayParam[i];
        }
        return sumOfElements;
    }
    
    public static String printStatement(String arrayName, int sumOfArray) {
        String stringToPrint = "The sum of the elements in " + arrayName + " is " + sumOfArray + ".";
        return stringToPrint;
    }
    
}