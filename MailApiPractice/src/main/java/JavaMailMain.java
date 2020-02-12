

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Boone
 */
public class JavaMailMain {
    
    public static void main(String[] args) {
        try {
            JavaMailUtil.sendEmail("BenLeBoot@gmail.com");
        } catch (Exception ex) {
            System.out.println("Error.  Location 2.");
        }
    }
    
}
