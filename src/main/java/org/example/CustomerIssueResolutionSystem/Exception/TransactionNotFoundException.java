package org.example.CustomerIssueResolutionSystem.Exception;

public class TransactionNotFoundException extends  RuntimeException {
    public TransactionNotFoundException(String reason) {
        super(reason);
    }
}
