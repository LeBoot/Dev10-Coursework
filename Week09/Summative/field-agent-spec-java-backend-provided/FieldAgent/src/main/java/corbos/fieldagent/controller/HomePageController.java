/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corbos.fieldagent.controller;

import corbos.fieldagent.service.AgentServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Boone
 */
@Controller
public class HomePageController {
    
    @Autowired
    AgentServiceLayer agentService;

    @Autowired
    AgentController ac;
    
    //load the home page with all agents listed in a table
    @GetMapping({"/", "/home"})
    public String homePage(Model model) {
        ac.clearViolations();
        model.addAttribute("agents", agentService.findAllAgents());
        return "home";
    }

}