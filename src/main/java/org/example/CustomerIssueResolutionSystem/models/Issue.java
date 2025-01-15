package org.example.CustomerIssueResolutionSystem.models;

import java.time.LocalDateTime;

public class Issue {
    String id;
    IssueType issueType;
    Transaction transaction;
    String subject;
    String description;
    Customer raisedBy;
    Agent assignedTo;
    IssueStatus issueStatus;
    LocalDateTime issueRaisedOn;
    LocalDateTime issueResolvedOn;

    public Issue(String id, IssueType issueType, Transaction transaction, String subject, String description, Customer raisedBy) {
        this.id = id;
        this.issueType = issueType;
        this.transaction = transaction;
        this.subject = subject;
        this.description = description;
        this.raisedBy = raisedBy;
        this.issueStatus = IssueStatus.TO_BE_ASSIGNED;
        this.issueRaisedOn = LocalDateTime.now();
    }

    public void assignAgentToIssue(Agent agent) {
        this.assignedTo = agent;
        this.issueStatus = IssueStatus.IN_PROGRESS;
    }

    public void resolveIssue() {
        this.issueStatus = IssueStatus.RESOLVED;
        this.issueResolvedOn = LocalDateTime.now();
    }

    public IssueType getIssueType() {
        return issueType;
    }
}
