package org.lokesh.streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPIMain {
    public static void main(String[] args) {

        StreamAPIMain streamAPIMain = new StreamAPIMain();
        List<Employee> employeeList = streamAPIMain.getEmployee();

        //foreach
        employeeList.stream()
         .forEach(employee -> System.out.println(employee));

        //map
        //collect
       List<Employee> increasedSal = employeeList.stream()
                .map(employee -> new Employee(employee.getFirstName(),
                        employee.getLastName(), employee.getSalary() *1.10,employee.getProjects()))
                .collect(Collectors.toList());

        System.out.println("Increased Sal "+ increasedSal);

        //filter

        List<Employee> salIncreasedCondtion = employeeList.stream()
                .filter(employee -> employee.getSalary() > 5000)
                .map(employee -> new Employee(employee.getFirstName(),
                        employee.getLastName(), employee.getSalary() + 1000.0, employee.getProjects()))
                .collect(Collectors.toList());

        System.out.println("Increased Sal "+ salIncreasedCondtion);

        //findfirst

        Employee employee1 = employeeList.stream()
                .filter(employee -> employee.getSalary() > 5000)
                .map(employee -> new Employee(employee.getFirstName(), employee.getLastName(), employee.getSalary() * 2.10, employee.getProjects()))
                .findFirst()
                .orElse(null);

        System.out.println("Lokesh "+employee1);
    }

    public List<Employee> getEmployee() {
        List<Employee> employees = new ArrayList<>();
        employees.add
                (new Employee("Lokesh", "Dhanasekar", 5000.0,
                        List.of("Project1", "Project2")));

        employees.add(new Employee("Priyanka", "Radhakrishnan", 6000.0,
                List.of("Project2", "Project3")));

        employees.add(new Employee("Pranav", "Lokesh", 10000.0,
                List.of("Project1", "Project3")));

        return employees;
    }
}
