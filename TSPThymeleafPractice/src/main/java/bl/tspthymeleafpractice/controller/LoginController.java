/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.tspthymeleafpractice.controller;

import bl.tspthymeleafpractice.violation.Violation;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Boone
 */
@Controller
@RequestMapping("/cont-session")
public class LoginController {
    
    @PostMapping("/login-request")
    public String processLoginRequest(HttpServletRequest request) {
        Violation.emptyViolations();
        
        String username = request.getParameter("usernameInput");
        String password = request.getParameter("passwordInput");
        
        if (username.isEmpty() || password.isEmpty()) {
            Violation.addToViolations("Username and/or password cannot be blank.");
            Violation.setDoDisplayViolations(true);
            return "redirect:/login";
        }

        return "redirect:/";
    }
    
}
