package org.example.CustomerIssueResolutionSystem.service;

import org.example.CustomerIssueResolutionSystem.Exception.TransactionNotFoundException;
import org.example.CustomerIssueResolutionSystem.models.Transaction;

import java.util.HashMap;
import java.util.Map;

public class TransactionsService {
    private Map<String, Transaction> transactions;

    public TransactionsService() {
        transactions = new HashMap<>();
    }

    // Check whether the transactionId exists in the system, if it does, return the transaction object else throw
    // TransactionNotFoundException

    public Transaction getTransaction(String transactionId) {
        if(!transactions.containsKey(transactionId)) {
            throw new TransactionNotFoundException("Transaction with id: " + transactionId + " not found.");
        }
        return transactions.get(transactionId);
    }

    // Check the user associated with the transactionId and the user who made the complaint are the same.
    public boolean checkUser(Transaction transaction, String email) {
        return transaction.getCustomer().getEmail().equals(email);
    }
}
