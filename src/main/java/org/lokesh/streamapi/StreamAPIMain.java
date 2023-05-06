package org.lokesh.streamapi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        System.out.println("collect "+ increasedSal);

        //filter

        List<Employee> salIncreasedCondtion = employeeList.stream()
                .filter(employee -> employee.getSalary() > 5000)
                .map(employee -> new Employee(employee.getFirstName(),
                        employee.getLastName(), employee.getSalary() + 1000.0, employee.getProjects()))
                .collect(Collectors.toList());

        System.out.println("filter "+ salIncreasedCondtion);

        //findfirst

        Employee firstEmployee = employeeList.stream()
                .filter(employee -> employee.getSalary() > 5000)
                .map(employee -> new Employee(employee.getFirstName(), employee.getLastName(), employee.getSalary() * 2.10, employee.getProjects()))
                .findFirst()
                .orElse(null);

        System.out.println("findfirst "+firstEmployee);

        //flatMap

        String flatString = employeeList.stream()
                .map(employee -> employee.getProjects())
                .flatMap(strings -> strings.stream())
                .collect(Collectors.joining(","));

        System.out.println("flatmap " + flatString);

        //Short Circuit Operations

        List<Employee> shortCicuit = employeeList.stream()
                .skip(1)
                .limit(1)
                .collect(Collectors.toList());

        System.out.printf("shortCicuit " + shortCicuit);

        //finit data
        Stream.generate(Math::random)
                .limit(5)
                .forEach(value -> System.out.println(value));

        //sort
        List<Employee> sortedEmployees = employeeList.stream()
                .sorted((o1, o2) -> o1.getFirstName().compareToIgnoreCase(o2.getFirstName()))
                .collect(Collectors.toList());

        System.out.println("sortedEmployees " + sortedEmployees);

        //max operator

        Employee maxSalary = employeeList.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(NoSuchElementException::new);

        System.out.println("maxSalary "+maxSalary);

        //reduce

        Double totalSal = employeeList.stream()
                .map(employee -> employee.getSalary())
                .reduce(0.0,Double::sum);

        System.out.println("Total Salary "+totalSal);
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
