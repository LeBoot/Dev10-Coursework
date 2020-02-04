/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corbos.fieldagent.service;

import corbos.fieldagent.data.AgentRepository;
import corbos.fieldagent.entities.Agent;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Boone
 */
@Service
public class AgentServiceLayer implements AgentServiceInterface{
    
    @Autowired
    AgentRepository agentRepo;
    
    @Override
    public List<Agent> findAllAgents() {
        return agentRepo.findAll();
    }
    
    @Override
    public Optional<Agent> findById(String identifier) {
        return agentRepo.findById(identifier);
    }
    
    @Override
    public void save(Agent agent) {
        agentRepo.save(agent);
    }
    
    @Override
    public void deleteAgent(String identifier) {
        agentRepo.deleteById(identifier);
    }
    
}