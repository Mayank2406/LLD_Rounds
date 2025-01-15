package org.example.CustomerIssueResolutionSystem.service;

import org.example.CustomerIssueResolutionSystem.models.Customer;
import org.example.CustomerIssueResolutionSystem.models.Issue;
import org.example.CustomerIssueResolutionSystem.models.IssueType;
import org.example.CustomerIssueResolutionSystem.models.Transaction;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class IssueService {
    private Map<String, Issue> issues;

    public IssueService(CustomerService customerService) {
        issues = new HashMap<>();
    }

    public Issue getIssue(String issueId) {
        return issues.get(issueId);
    }

    public Issue createIssue(Transaction transaction, IssueType issueType, String subject, String description, String email, CustomerService customerService) {
        String issueId = UUID.randomUUID().toString();
        Customer customer = customerService.getCustomer(email);
        Issue issue = new Issue(issueId, issueType, transaction, subject, description, customer);
        issues.put(issueId, issue);
        return issue;
    }
}
