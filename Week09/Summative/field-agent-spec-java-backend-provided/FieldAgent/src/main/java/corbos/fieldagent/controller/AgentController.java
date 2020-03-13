/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corbos.fieldagent.controller;

import corbos.fieldagent.entities.Agency;
import corbos.fieldagent.entities.Agent;
import corbos.fieldagent.entities.Assignment;
import corbos.fieldagent.entities.Country;
import corbos.fieldagent.entities.SecurityClearance;
import corbos.fieldagent.service.AgentServiceLayer;
import corbos.fieldagent.service.AssignmentServiceLayer;
import corbos.fieldagent.service.LookupService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Boone
 */
@Controller
public class AgentController {

    @Autowired
    AgentServiceLayer agentService;

    @Autowired
    AssignmentServiceLayer assignmentService;

    @Autowired
    LookupService luService;

    //redirects to addAgent.html
    @GetMapping("/addAgent")
    public String addAgent(Model model) {
        model.addAttribute("listOfAgencies", luService.findAllAgencies());
        model.addAttribute("listOfClearances", luService.findAllSecurityClearances());
        model.addAttribute("listOfViolations", violations);
        return "addAgent";
    }

    //creates a new agent from addAgent.html
    @PostMapping("/addNewAgent")
    public String addNewAgent(Agent agent, HttpServletRequest request) {

        String agentId = request.getParameter("agentidentifier");
        agent.setIdentifier(agentId);

        agent.setFirstName(request.getParameter("agentfirstName"));
        agent.setMiddleName(request.getParameter("agentmiddleName"));
        agent.setLastName(request.getParameter("agentlastName"));
        agent.setPictureUrl(request.getParameter("agentpicutureUrl"));

        DateTimeFormatter formatFromHtml = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String agentBirthDate = request.getParameter("agentbirthDate");
        LocalDate birthDateConverted = LocalDate.parse(agentBirthDate, formatFromHtml);
        LocalDate renderedBirthDateConverted = birthDateConverted;
        agent.setBirthDate(renderedBirthDateConverted);

        String agentActivationDate = request.getParameter("agentactivationDate");
        LocalDate activationDateConverted = LocalDate.parse(agentActivationDate, formatFromHtml);
        LocalDate renderedActivationDateConverted = activationDateConverted;
        agent.setActivationDate(renderedActivationDateConverted);

        String agencyIdStr = request.getParameter("agencyName");
        int agencyIdInt = Integer.parseInt(agencyIdStr);
        Agency agency = luService.findAgencyById(agencyIdInt);
        agent.setAgency(agency);

        String clearanceIdStr = request.getParameter("securityClearance");
        int clearanceIdInt = Integer.parseInt(clearanceIdStr);
        SecurityClearance sc = luService.findSecurityClearanceById(clearanceIdInt);
        agent.setSecurityClearance(sc);

        String agentHeightStr = request.getParameter("agentheight");
        int agentHeightInt = Integer.parseInt(agentHeightStr);
        agent.setHeight(agentHeightInt);

        boolean isActive = false;
        if (request.getParameter("isActive") != null) {
            isActive = true;
        }
        agent.setActive(isActive);

        //determine existence of violations
        determineExistenceOfAgentViolations(renderedBirthDateConverted, renderedActivationDateConverted, agentHeightInt, agentId);

        if (violations.isEmpty()) {
            agentService.save(agent);
            return "redirect:/";
        } else {
            return "redirect:/addAgent";
        }
    }

    //load field agent page with requested agent's information
    @GetMapping("/fieldAgent")
    public String viewFieldAgent(HttpServletRequest request, Model model) {
        model.addAttribute("listOfViolations", violations);

        String identifier = request.getParameter("identifier");
        Optional<Agent> agentOptional = agentService.findById(identifier);
        Agent agentToView = agentOptional.get();

        model.addAttribute("agentFirstName", agentToView.getFirstName());
        model.addAttribute("agentMiddleName", agentToView.getMiddleName());
        model.addAttribute("agentLastName", agentToView.getLastName());
        model.addAttribute("agentBirthDate", agentToView.getBirthDate());
        model.addAttribute("agentHeight", agentToView.getHeight());
        model.addAttribute("agentIdentifier", agentToView.getIdentifier());

        List<Agency> listOfAgencies = luService.findAllAgencies();
        model.addAttribute("listOfAgencies", listOfAgencies);
        model.addAttribute("agentAgencyId", agentToView.getAgency().getAgencyId());

        List<SecurityClearance> listOfClearances = luService.findAllSecurityClearances();
        model.addAttribute("listOfClearances", listOfClearances);
        model.addAttribute("agentSecurityClearanceId", agentToView.getSecurityClearance().getSecurityClearanceId());

        model.addAttribute("agentActivationDate", agentToView.getActivationDate());
        model.addAttribute("agentPictureUrl", agentToView.getPictureUrl());

        List<Assignment> listOfAssignments = assignmentService.findByAgentIdentifier(identifier);
        Collections.sort(listOfAssignments, new Comparator<Assignment>() {
            @Override
            public int compare(Assignment A1, Assignment A2) {
                return (A1.getStartDate()).compareTo(A2.getStartDate());
            }
        });
        model.addAttribute("listOfAgentAssignments", listOfAssignments);

        model.addAttribute("isAgentActive", agentToView.isActive());

        return "fieldAgent";
    }

    //load an agent and edit the info (except for agentId)
    @PostMapping("/editAgent")
    public String editFieldAgent(HttpServletRequest request) {
        String agentId = request.getParameter("originalId");
        Optional<Agent> agentOptional = agentService.findById(agentId);
        Agent agent = agentOptional.get();

        agent.setFirstName(request.getParameter("agentfirstName"));
        agent.setMiddleName(request.getParameter("agentmiddleName"));
        agent.setLastName(request.getParameter("agentlastName"));
        agent.setPictureUrl(request.getParameter("agentpicutureUrl"));

        DateTimeFormatter formatFromHtml = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String agentBirthDate = request.getParameter("agentbirthDate");
        LocalDate birthDateConverted = LocalDate.parse(agentBirthDate, formatFromHtml);
        LocalDate renderedBirthDateConverted = birthDateConverted;
        agent.setBirthDate(renderedBirthDateConverted);

        String agentActivationDate = request.getParameter("agentactivationDate");
        LocalDate activationDateConverted = LocalDate.parse(agentActivationDate, formatFromHtml);
        LocalDate renderedActivationDateConverted = activationDateConverted;
        agent.setActivationDate(renderedActivationDateConverted);

        String agencyIdStr = request.getParameter("agencyName");
        int agencyIdInt = Integer.parseInt(agencyIdStr);
        Agency agency = luService.findAgencyById(agencyIdInt);
        agent.setAgency(agency);

        String clearanceIdStr = request.getParameter("securityClearance");
        int clearanceIdInt = Integer.parseInt(clearanceIdStr);
        SecurityClearance sc = luService.findSecurityClearanceById(clearanceIdInt);
        agent.setSecurityClearance(sc);

        String agentHeightStr = request.getParameter("agentheight");
        int agentHeightInt = Integer.parseInt(agentHeightStr);
        agent.setHeight(agentHeightInt);

        boolean isActive = false;
        if (request.getParameter("isActive") != null) {
            isActive = true;
        }
        agent.setActive(isActive);

        //determine existence of violations
        determineExistenceOfEditAgentViolations(renderedBirthDateConverted, renderedActivationDateConverted, agentHeightInt);

        //only save if no violations
        if (violations.isEmpty()) {
            agentService.save(agent);
        }

        //either way, return to the agent's page
        String returnValue = "redirect:/fieldAgent?identifier=" + agentId;
        return returnValue;
    }

    //view delete an agent page, with info filled in
    @GetMapping("/viewDeleteAgent")
    public String viewDeleteAgent(HttpServletRequest request, Model model) {
        violations.clear();

        String identifier = request.getParameter("identifier");
        Optional<Agent> agentOptional = agentService.findById(identifier);
        Agent agentToDelete = agentOptional.get();

        List<Assignment> listOfAssignments = assignmentService.findByAgentIdentifier(identifier);
        int numOfAssignments = listOfAssignments.size();
        String numOfAssignmentsString = Integer.toString(numOfAssignments);

        model.addAttribute("agentFirstName", agentToDelete.getFirstName());
        model.addAttribute("agentLastName", agentToDelete.getLastName());
        model.addAttribute("numAssignments", numOfAssignmentsString);
        model.addAttribute("agentId", identifier);

        return "viewDeleteAgent";
    }

    //delete an agent and all associated assignments; return to home page
    @GetMapping("/deleteAgent")
    public String deleteAgent(HttpServletRequest request) {
        violations.clear();

        String id = request.getParameter("identifier");
        assignmentService.deleteAllAssignmentsForAgent(id);
        agentService.deleteAgent(id);
        return "redirect:/home";
    }

    //delete an assignment
    @GetMapping("/deleteAssignment")
    public String deleteAssignment(HttpServletRequest request) {
        violations.clear();

        String assignmentIdStr = request.getParameter("assignmentId");
        int assignmentId = Integer.parseInt(assignmentIdStr);
        assignmentService.deleteAssignment(assignmentId);

        String agentId = request.getParameter("agentId");
        String returnValue = "redirect:/fieldAgent?identifier=" + agentId;
        return returnValue;
    }

    //view add assignment (assignment.html)
    @GetMapping("/addAssignment")
    public String addAssignment(HttpServletRequest request, Model model) {
        String agentId = request.getParameter("identifier");
        model.addAttribute("thisAgentId", agentId);

        model.addAttribute("listOfViolations", violations);

        List<Agent> listOfAgents = agentService.findAllAgents();
        model.addAttribute("listOfAgents", listOfAgents);

        List<Country> listOfCountries = luService.findAllCountries();
        model.addAttribute("listOfCountries", listOfCountries);

        return "addAssignment";
    }

    //add a new assignment from addAssignment.html
    @PostMapping("/addAssignment")
    public String addAssignmentPost(HttpServletRequest request) {
        Assignment assignment = new Assignment();

        DateTimeFormatter formatFromHtml = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String startDate = request.getParameter("startDate");
        LocalDate startDateConverted = LocalDate.parse(startDate, formatFromHtml);
//        LocalDate refactoredStartDateConverted = startDateConverted.minusDays(2);
//        assignment.setStartDate(refactoredStartDateConverted);
        assignment.setStartDate(startDateConverted);

        String projectedEnd = request.getParameter("projectedEndDate");
        LocalDate projectedEndConverted = LocalDate.parse(projectedEnd, formatFromHtml);
//        LocalDate refactoredprojectedEndConverted = projectedEndConverted.plusDays(1);
//        assignment.setProjectedEndDate(refactoredprojectedEndConverted);
        assignment.setProjectedEndDate(projectedEndConverted);
        
        String actualEnd = request.getParameter("actualEndDate");
        if (actualEnd.length() > 1) {
            LocalDate actualEndConverted = LocalDate.parse(actualEnd, formatFromHtml);
            LocalDate refactoredactualEndConverted = actualEndConverted;
            assignment.setActualEndDate(refactoredactualEndConverted);
        }

        assignment.setNotes(request.getParameter("assignmentNotes"));

        String agentId = request.getParameter("agentName");
        Optional<Agent> agentOptional = agentService.findById(agentId);
        Agent agent = agentOptional.get();
        assignment.setAgent(agent);

        String countryCode = request.getParameter("country");
        Country country = luService.findCountryByCode(countryCode);
        assignment.setCountry(country);

        determineExistenceOfAssignmentViolations(agent, startDateConverted, projectedEndConverted, actualEnd);

        if (violations.isEmpty()) {
            assignmentService.addAssignment(assignment);
            String returnValue = "redirect:/fieldAgent?identifier=" + agentId;
            return returnValue;
        } else {
            return "redirect:/addAssignment";
        }
    }

    //load assignment view page and upload assignment's specs
    @GetMapping("/viewAssignment")
    public String viewAssignment(HttpServletRequest request, Model model) {
        model.addAttribute("listOfViolations", violations);

        String assignmentIdStr = request.getParameter("assignmentId");
        model.addAttribute("assignmentId", assignmentIdStr);
        int assignmentId = Integer.parseInt(assignmentIdStr);
        Assignment assignment = assignmentService.getAssignmentById(assignmentId);

        String agentId = request.getParameter("agentId");
        Optional<Agent> agentOptional = agentService.findById(agentId);
        Agent agent = agentOptional.get();

        model.addAttribute("listOfAgents", agentService.findAllAgents());
        model.addAttribute("assignmentAgentIdentifier", agent.getIdentifier());

        model.addAttribute("listOfCountries", luService.findAllCountries());
        model.addAttribute("assignmentCountryCode", assignment.getCountry().getCountryCode());

        model.addAttribute("assignmentStart", assignment.getStartDate());
        model.addAttribute("originalStartDate", assignment.getStartDate());

        model.addAttribute("assignmentProjectedEnd", assignment.getProjectedEndDate());
        model.addAttribute("originalEndDate", assignment.getProjectedEndDate());

        boolean isActualEndDate = false;
        LocalDate actualEnd = LocalDate.now();
        try {
            actualEnd = assignment.getActualEndDate();
            isActualEndDate = true;
        } catch (NullPointerException e) {
        }
        model.addAttribute("isActualEndDate", isActualEndDate);
        model.addAttribute("assignmentAcutalDate", actualEnd);

        boolean doNotesExist = false;
        String notes = assignment.getNotes();
        if (notes != null) {
            doNotesExist = true;
        }
        model.addAttribute("doNotesExist", doNotesExist);
        model.addAttribute("notes", notes);

        return "viewAssignment";
    }

    //edit an assignment from the assignment view page
    @PostMapping("/editAssignment")
    public String editAssignment(HttpServletRequest request) {
        Assignment editedAssignment = new Assignment();

        DateTimeFormatter formatFromHtml = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String startDate = request.getParameter("startDate");
        LocalDate startDateConverted = LocalDate.parse(startDate, formatFromHtml);
        LocalDate refactoredStartDateConverted = startDateConverted;
        editedAssignment.setStartDate(refactoredStartDateConverted);

        String projectedEndDate = request.getParameter("projectedEndDate");
        LocalDate projectedEndDateConverted = LocalDate.parse(projectedEndDate, formatFromHtml);
        LocalDate refactoredProjectedEndDateConverted = projectedEndDateConverted;
        editedAssignment.setProjectedEndDate(refactoredProjectedEndDateConverted);

        String actualEnd = request.getParameter("actualEndDate");
        if (actualEnd.length() > 1) {
            LocalDate actualEndConverted = LocalDate.parse(actualEnd, formatFromHtml);
            LocalDate refactoredActualEndConverted = actualEndConverted;
            editedAssignment.setActualEndDate(refactoredActualEndConverted);
        }

        try {
            editedAssignment.setNotes(request.getParameter("assignmentNotes"));
        } catch (NullPointerException e) {

        }

        String agentId = request.getParameter("agentName");
        Optional<Agent> agentOptional = agentService.findById(agentId);
        Agent agent = agentOptional.get();
        editedAssignment.setAgent(agent);

        String countryCode = request.getParameter("country");
        Country country = luService.findCountryByCode(countryCode);
        editedAssignment.setCountry(country);

        //are dates the same as before
        String originalStartDate = request.getParameter("originalStartDate");
        LocalDate originalStartDateConverted = LocalDate.parse(originalStartDate, formatFromHtml);

        String originalEndDate = request.getParameter("originalEndDate");
        LocalDate originalEndDateConverted = LocalDate.parse(originalEndDate, formatFromHtml);

        violations.clear();
        if ((refactoredStartDateConverted.isBefore(originalStartDateConverted)
                || refactoredProjectedEndDateConverted.isAfter(originalEndDateConverted))) {
            determineExistenceOfAssignmentViolations(agent, refactoredStartDateConverted, refactoredProjectedEndDateConverted, actualEnd);
        }

        String assignmentIdStr = request.getParameter("assignmentId");

        if (violations.isEmpty()) {
            //delete previous assignment
            int assignmentId = Integer.parseInt(assignmentIdStr);
            editedAssignment.setAssignmentId(assignmentId);
            assignmentService.deleteAssignment(assignmentId);

            //create a new one
            assignmentService.addAssignment(editedAssignment);
            String returnValue = "redirect:/fieldAgent?identifier=" + agentId;
            return returnValue;
        } else {
            String returnValue = "redirect:/viewAssignment?assignmentId=" + assignmentIdStr + "&agentId=" + agentId;
            return returnValue;
        }
    }

    //violations and validations
    Set<String> violations = new HashSet<>();

    public void clearViolations() {
        violations.clear();
    }

    //validation for the initial agent add
    private void determineExistenceOfAgentViolations(LocalDate birthDate, LocalDate activationDate, int height, String identifier) {
        violations.clear();

        LocalDate earliestDate = LocalDate.parse("1900-01-01");
        LocalDate latestDate = LocalDate.now().plusYears(10);
        if (birthDate.isBefore(earliestDate) || birthDate.isAfter(latestDate)) {
            violations.add("Agent birthdate must be between " + earliestDate + " and " + latestDate + ".");
        }

        if (activationDate.isBefore(birthDate)) {
            violations.add("Activation date cannot precede birthdate.");
        }

        if ((height < 36) || (height > 96)) {
            violations.add("Agent height must be between 36 and 96 inches, inclusively.");
        }

        List<Agent> listOfAllAgents = agentService.findAllAgents();
        boolean isIdUnique = true;
        for (Agent agent : listOfAllAgents) {
            if (agent.getIdentifier().equals(identifier)) {
                isIdUnique = false;
            }
        }
        if (isIdUnique == false) {
            violations.add("The identifier you entered is already taken.  You must choose another.");
        }

    }

    //validation for an edited agent.  Same as previous validation less checking the id
    private void determineExistenceOfEditAgentViolations(LocalDate birthDate, LocalDate activationDate, int height) {
        violations.clear();

        LocalDate earliestDate = LocalDate.parse("1900-01-01");
        LocalDate latestDate = LocalDate.now().plusYears(10);
        if (birthDate.isBefore(earliestDate) || birthDate.isAfter(latestDate)) {
            violations.add("Agent birthdate must be between " + earliestDate + " and " + latestDate + ".");
        }

        if (activationDate.isBefore(birthDate)) {
            violations.add("Activation date cannot precede birthdate.");
        }

        if ((height < 36) || (height > 96)) {
            violations.add("Agent height must be between 36 and 96 inches, inclusively.");
        }
    }

    //validation for assignments
    public void determineExistenceOfAssignmentViolations(Agent agent, LocalDate S2, LocalDate E2, String actualEnd) {
        violations.clear();

        String agentIdentifier = agent.getIdentifier();
        List<Assignment> assignmentsForAgent = assignmentService.findByAgentIdentifier(agentIdentifier);
        for (Assignment assign : assignmentsForAgent) {
            LocalDate S1 = assign.getStartDate();
            LocalDate E1 = assign.getProjectedEndDate();
            if (S2.equals(S1)
                    && E2.equals(E1)
                    || S2.isAfter(S1) && S2.isBefore(E1)
                    || E2.isAfter(S1) && E2.isBefore(E1)
                    || S2.compareTo(S1) == 0 && E2.compareTo(E1) == 0) {
                violations.add("The new assignment's date range cannot confllict with that of any previous assignment.");
            }
            if (actualEnd.length() > 1) {
                DateTimeFormatter formatFromHtml = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate A2b = LocalDate.parse(actualEnd, formatFromHtml);
                LocalDate A2 = A2b;
                if (S2.equals(S1)
                        || A2.equals(E1)
                        || (S2.isAfter(S1) && S2.isBefore(E1))
                        || (A2.isAfter(S1) && A2.isBefore(E1))) {
                    violations.add("The new assignment's date range cannot confllict with that of any previous assignment.");
                }
            }
            try {
                LocalDate A1 = assign.getActualEndDate();
                if (((S2.isBefore(S1)) && (E2.isAfter(A1)))
                        || ((S2.isAfter(S1)) && (S2.isBefore(A1)))
                        || ((S2.equals(S1)) || (E2.equals(E1)))
                        || ((E2.isAfter(S1)) && (E2.isBefore(A1)))) {
                    violations.add("The new assignment's date range cannot confllict with that of any previous assignment.");
                }
                if (actualEnd.length() > 1) {
                    DateTimeFormatter formatFromHtml = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate A2 = LocalDate.parse(actualEnd, formatFromHtml);
                    if (((S2.isBefore(S1)) && (A2.isAfter(A1)))
                            || ((S2.isAfter(S1)) && (S2.isBefore(A1)))
                            || ((S2.equals(S1)) || (A2.equals(E1)))
                            || ((A2.isAfter(S1)) && (A2.isBefore(A1)))) {
                        violations.add("The new assignment's date range cannot confllict with that of any previous assignment.");
                    }
                }
            } catch (NullPointerException e) {
                int newNum = 4;
            }
        }
        if (S2.isAfter(E2)) {
            violations.add("The start date cannot precede the end date.");
        }
        if (actualEnd.length() > 1) {
            DateTimeFormatter formatFromHtml = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate A2b = LocalDate.parse(actualEnd, formatFromHtml);
            LocalDate A2 = A2b;
            if (S2.isAfter(A2)) {
                violations.add("The start date cannot precede the end date.");
            }
        }
    }

}
