package org.example.CustomerIssueResolutionSystem.service;

import org.example.CustomerIssueResolutionSystem.models.Agent;
import org.example.CustomerIssueResolutionSystem.models.Issue;
import org.example.CustomerIssueResolutionSystem.models.IssueType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class AgentService {
    private Map<String, Agent> agents;
    private IssueService issueService;

    public AgentService() {
        agents = new HashMap<>();
    }

    public Agent getAgent(String email) {
        return agents.get(email);
    }

    public Agent createAgent(String name, String email, String contactNumber, List<IssueType> expertise) {
        String agentId = UUID.randomUUID().toString();

        Agent agent = new Agent(agentId, name, email, contactNumber, expertise);
        agents.put(email, agent);
        return agent;
    }

    public Agent getAvailableAgentFor(String issueId) {
        Issue issue = issueService.getIssue(issueId);

        for (Agent agent : agents.values()) {
            if (agent.getCurrentIssue() == null && agent.getExpertise().contains(issue.getIssueType())) {
                return agent;
            }
        }
        return null;
    }

    public void assignIssue(Agent agent, String issueId) {
        Issue issue = issueService.getIssue(issueId);
        agent.assignIssue(issue);
    }
}

