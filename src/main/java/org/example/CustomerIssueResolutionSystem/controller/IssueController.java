package org.example.CustomerIssueResolutionSystem.controller;

import org.example.CustomerIssueResolutionSystem.models.Issue;
import org.example.CustomerIssueResolutionSystem.models.IssueType;
import org.example.CustomerIssueResolutionSystem.models.Transaction;
import org.example.CustomerIssueResolutionSystem.service.CustomerService;
import org.example.CustomerIssueResolutionSystem.service.IssueService;
import org.example.CustomerIssueResolutionSystem.service.TransactionsService;
import org.example.CustomerIssueResolutionSystem.strategy.IssueAssigningStrategy;

public class IssueController {
    private final IssueService issueService;
    private final TransactionsService transactionService;
    private final CustomerService customerService;
    private final IssueAssigningStrategy issueAssigningStrategy;

    public IssueController(IssueService issueService, TransactionsService transactionService, CustomerService customerService, IssueAssigningStrategy issueAssigningStrategy) {
        this.issueService = issueService;
        this.transactionService = transactionService;
        this.customerService = customerService;
        this.issueAssigningStrategy = issueAssigningStrategy;
    }

    // Create an Issue:
    public Issue createIssue(String transactionId, IssueType issueType, String subject, String description, String email) throws Exception {
        try {
            // Validations required:
            // 1. Check if the transactionId exists in the system.
            Transaction transaction = transactionService.getTransaction(transactionId);

            // 2. Check if the transactionId belongs the user who made a complaint.
            if(!transactionService.checkUser(transaction, email)){
                throw new Exception("Transaction does not belong to the user who made the complaint.");
            }

            return issueService.createIssue(transaction, issueType, subject, description, email, customerService);
        }catch (Exception e){
            throw  e;
        }
    }

    // Assign Issues:
    public void assignIssueToAgent(String issueId) {
        issueAssigningStrategy.assignIssue(issueId);
    }

}
