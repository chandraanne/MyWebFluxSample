package com.chandra.mywebfluxsamples.model;

public class Employee {
    String empId;
    String namePrefix;
    String firstName;
    String middleInitial;
    String gender;
    String email;

    public Employee(String empId, String namePrefix, String firstName, String middleInitial, String gender, String email) {
        this.empId = empId;
        this.namePrefix = namePrefix;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.gender = gender;
        this.email = email;
    }

    public String getEmpId() {
        return empId;
    }

    public String getNamePrefix() {
        return namePrefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }
}
