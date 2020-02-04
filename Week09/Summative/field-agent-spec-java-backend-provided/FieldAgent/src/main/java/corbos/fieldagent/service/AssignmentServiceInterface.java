/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corbos.fieldagent.service;

import corbos.fieldagent.entities.Assignment;
import java.util.List;

/**
 *
 * @author Boone
 */
public interface AssignmentServiceInterface {
    public List<Assignment> findByAgentIdentifier(String indentifier);
    public void deleteAllAssignmentsForAgent(String identifier);
    public void deleteAssignment(int assignmentId);
    public void addAssignment(Assignment assignment);
    public Assignment getAssignmentById(int assignmentId);
}
