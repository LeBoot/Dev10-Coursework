/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corbos.fieldagent.controller;

import corbos.fieldagent.data.AgencyRepository;
import corbos.fieldagent.data.AgentRepository;
import corbos.fieldagent.data.AssignmentRepository;
import corbos.fieldagent.data.CountryRepository;
import corbos.fieldagent.data.SecurityClearanceRepository;
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
    AgencyRepository agencyRepo;
    
    @Autowired
    AgentRepository agentRepo;
    
    @Autowired
    AssignmentRepository assignmentRepo;
    
    @Autowired
    CountryRepository countryRepo;
    
    @Autowired
    SecurityClearanceRepository clearanceRepo;
    
    @GetMapping({"/", "/home"})
    public String homePage(Model model) {
        model.addAttribute("agents", agentRepo.findAll());
        return "home";
    }
    
    @GetMapping("redirectAddAgent")
    public String redirectAddAgent(Model model) {
        return "addAgent";
    }
    
}
