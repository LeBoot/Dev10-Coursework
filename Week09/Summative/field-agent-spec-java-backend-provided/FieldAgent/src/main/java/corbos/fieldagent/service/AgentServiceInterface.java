/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corbos.fieldagent.service;

import corbos.fieldagent.entities.Agent;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Boone
 */
public interface AgentServiceInterface {
    public List<Agent> findAllAgents();
    public Optional<Agent> findById(String identifier);
    public void save(Agent agent);
    public void deleteAgent(String identifier);
}