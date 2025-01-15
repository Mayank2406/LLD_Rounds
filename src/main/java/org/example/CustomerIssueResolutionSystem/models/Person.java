package org.example.CustomerIssueResolutionSystem.models;

public abstract class Person {
    String id;
    String name;
    String email;
    String contactNumber;

    public Person(String id, String name, String email, String contactNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }
}
