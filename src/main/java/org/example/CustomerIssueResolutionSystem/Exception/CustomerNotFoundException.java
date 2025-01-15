package org.example.CustomerIssueResolutionSystem.Exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String reason) {
        super(reason);
    }
}
