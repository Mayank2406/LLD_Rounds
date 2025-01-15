package org.example.CustomerIssueResolutionSystem.models;

import java.time.LocalDateTime;

public class Transaction {
   String id;
   String transactionId;
   TransactionStatus transactionStatus;
   LocalDateTime createdAt;
   Customer customer;

   public Customer getCustomer() {
      return customer;
   }
}

