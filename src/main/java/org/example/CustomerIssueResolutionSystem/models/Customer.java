package org.example.CustomerIssueResolutionSystem.models;

import java.util.List;

public class Customer extends Person {
    List<Transaction> transactions;
    List<Issue> issuesRaised;

    public Customer(String id, String name, String email, String contactNumber) {
        super(id, name, email, contactNumber);
    }
}
