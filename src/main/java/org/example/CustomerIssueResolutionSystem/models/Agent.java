package org.example.CustomerIssueResolutionSystem.models;

import java.util.ArrayList;
import java.util.List;

public class Agent extends Person{
    List<IssueType> expertise;
    List<Issue> assignedIssues;
    Issue currentIssue;

    public Agent(String id, String name, String email, String contactNumber, List<IssueType> expertise) {
        super(id, name, email, contactNumber);
        this.expertise = expertise;

        assignedIssues = new ArrayList<>();
    }

    public Issue getCurrentIssue() {
        return currentIssue;
    }

    public List<IssueType> getExpertise() {
        return expertise;
    }

    public void assignIssue(Issue issue) {
        assignedIssues.add(issue);
        currentIssue = issue;
    }

}
