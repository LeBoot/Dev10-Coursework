/**
 * @author Boone
 */

//Simpler version
/*
public class ForByFor {
    public static void main(String[] args) {
        
        for (int i = 0; i < 3; i++) {
            System.out.print("|"); //three pipes, next to each other, but combine with line 16 to put them on different lines
            
            for (int j = 0; j < 3; j++) { //puts three pipes between each of the pipes line 8
                for (int k = 0; k < 3; k++) { //puts stars between each of the pipes from line 10
                    System.out.print("*"); //goes with line 11
                }
                System.out.print("|"); //goes with line 10
            }
            System.out.println(""); //puts the three pipes from line 8 on different lines
        }
    }  
}
*/


//fancier verion
public class ForByFor {
    public static void main(String[] args) {
        
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
                switch (i) {
                    case 0:
                    case 2:
                        //table rows 1 and 3
                        for (int j = 0; j < 3; j++) {
                            switch (j) {
                                case 0:
                                case 2:
                                    //table columns 1 and 3
                                    for (int k = 0; k < 3; k++) {
                                        System.out.print("*");                      
                                    }
                                    break;
                                case 1:
                                    //table column 2
                                    for (int k = 0; k < 3; k++) {
                                        System.out.print("$");                      
                                    }
                                break;
                            }
                        System.out.print("|");
                        }
                        break;
                    case 1:
                        //table row 2
                        for (int j = 0; j < 3; j++) {
                            switch (j) {
                                case 0:
                                case 2:
                                    //table columns 1 and 3
                                    for (int k = 0; k < 3; k++) {
                                        System.out.print("@");                      
                                    }
                                    break;
                                case 1:
                                    //table column 2
                                    for (int k = 0; k < 3; k++) {
                                        System.out.print("#");                      
                                    }
                                break;
                            }
                        System.out.print("|");
                        }
                        break;
                }
            System.out.println("");                    
        }
    }  
}