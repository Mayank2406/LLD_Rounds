package org.example.CustomerIssueResolutionSystem.service;

import org.example.CustomerIssueResolutionSystem.Exception.CustomerNotFoundException;
import org.example.CustomerIssueResolutionSystem.models.Customer;

import java.util.HashMap;
import java.util.Map;

public class CustomerService {
    private Map<String, Customer> customers;

    public CustomerService() {
        customers = new HashMap<>();
    }

    public Customer getCustomer(String email) {
        if(!customers.containsKey(email)) {
            throw new CustomerNotFoundException("Customer with email: " + email + " not found.");
        }

        return customers.get(email);
    }

    public Customer addCustomer(String id, String name, String email, String contactNumber) {
        Customer customer = new Customer(id, name, email, contactNumber);
        customers.put(email, customer);
        return customer;
    }
}
