package org.example.CustomerIssueResolutionSystem.strategy;

import org.example.CustomerIssueResolutionSystem.models.Agent;
import org.example.CustomerIssueResolutionSystem.service.AgentService;

public class FreeAgentAssignStrategy implements IssueAssigningStrategy {
    private AgentService agentService;

    public FreeAgentAssignStrategy(AgentService agentService) {
        this.agentService = agentService;
    }

    @Override
    public void assignIssue(String issueId) {
        // Find a free agent and assign the issue to him
        Agent agent =  agentService.getAvailableAgentFor(issueId);
        if (agent != null) {
            agentService.assignIssue(agent,issueId);
        }else{
            System.out.println("No free agent available");
        }
    }
}
