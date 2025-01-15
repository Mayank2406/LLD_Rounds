package org.example.CustomerIssueResolutionSystem.controller;

import org.example.CustomerIssueResolutionSystem.models.Agent;
import org.example.CustomerIssueResolutionSystem.models.IssueType;
import org.example.CustomerIssueResolutionSystem.service.AgentService;

import java.util.List;

public class AgentController {
    private final AgentService agentService;

    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    public Agent createAgent(String name, String email, String contactNumber, List<IssueType> expertise) {
        return agentService.createAgent(name, email, contactNumber, expertise);
    }
}
