/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.tspthymeleafpractice.violation;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Boone
 */
public class Violation {
    
    private static final Set<String> VIOLATIONS = new HashSet<>();
    private static boolean doDisplayViolations = false;

    public static Set<String> getViolations() {
        return VIOLATIONS;
    }
    
    public static Set<String> addToViolations(String violation) {
        VIOLATIONS.add(violation);
        return VIOLATIONS;
    }
    
    public static Set<String> emptyViolations() {
        VIOLATIONS.clear();
        return VIOLATIONS;
    }

    public static boolean getDoDisplayViolations() {
        return doDisplayViolations;
    }

    public static void setDoDisplayViolations(boolean doDisplayViolations) {
        Violation.doDisplayViolations = doDisplayViolations;
    }

}
