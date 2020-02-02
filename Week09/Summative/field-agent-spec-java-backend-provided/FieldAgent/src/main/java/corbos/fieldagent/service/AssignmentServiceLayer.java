/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corbos.fieldagent.service;

import corbos.fieldagent.data.AssignmentRepository;
import corbos.fieldagent.entities.Assignment;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Boone
 */
@Service
public class AssignmentServiceLayer {
    
    @Autowired
    AssignmentRepository assignmentRepo;
    
    public List<Assignment> findByAgentIdentifier(String indentifier) {
        return assignmentRepo.findByAgentIdentifier(indentifier);
    }
    
    public void deleteAllAssignmentsForAgent(String identifier) {        
        List<Assignment> listOfAssignments = findByAgentIdentifier(identifier);
        for (Assignment assignment : listOfAssignments) {
            assignmentRepo.deleteById(assignment.getAssignmentId());
        }
    } 
    
    public void deleteAssignment(int assignmentId) {
        assignmentRepo.deleteById(assignmentId);
    }
    
    public void addAssignment(Assignment assignment) {
        assignmentRepo.save(assignment);
    }
}
