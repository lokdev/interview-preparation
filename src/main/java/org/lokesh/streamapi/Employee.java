package org.lokesh.streamapi;

import java.util.List;

public class Employee {
    private String firstName;
    private String LastName;
    private Double salary;
    private List<String> projects;

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", salary=" + salary +
                ", project=" + projects +
                '}';
    }

    public Employee(String firstName, String lastName, Double salary, List<String> project) {
        this.firstName = firstName;
        LastName = lastName;
        this.salary = salary;
        this.projects = project;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<String> getProjects() {
        return projects;
    }

    public void setProjects(List<String> projects) {
        this.projects = projects;
    }
}
