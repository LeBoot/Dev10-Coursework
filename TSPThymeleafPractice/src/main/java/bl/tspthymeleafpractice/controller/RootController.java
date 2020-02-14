/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.tspthymeleafpractice.controller;

import bl.tspthymeleafpractice.violation.Violation;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Boone
 */
@Controller
@RequestMapping("/")
public class RootController {
    
    @GetMapping({"/", "/home"})
    public String displayHomePage() {
        return "home";
    }
    
    @GetMapping("/login")
    public String displayLoginPage(Model model) {
        
        //practice adding options to a dropdown list
        List<String> dropdownList = new ArrayList<>();
        
        dropdownList.add("Option 1");
        dropdownList.add("Option 2");
        dropdownList.add("Best Option");
        
        model.addAttribute("nameOfDropdownBox", dropdownList);
        
        //practice filling in values
        model.addAttribute("displayUsername", "GoodUsername");
        
        //practice adding violations, if any exist
        if (Violation.getDoDisplayViolations()) {
            model.addAttribute("listOfViolations", Violation.getViolations());
            Violation.setDoDisplayViolations(false);
        }
        
        return "login";
    }
    
    @GetMapping("/loggedInPage")
    public String displayLoggedInPage() {
        return "logged-in";
    }

    
}
