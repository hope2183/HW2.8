package com.example.hw2_8;

import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class EmployeeServiceImpl implements EmployeeService {
    private Map<String, Employee> employeeBook = new HashMap<>();


    public Employee addToEmployeeBook(String firstName, String lastName, int department, int salary) {
        Employee newEmployee = new Employee(firstName, lastName, department, salary);
        String key = firstName + lastName;
        if (employeeBook.containsKey(key)) {
            throw new EmployeeAlreadyExistsException("Employee already exists!");
        }
        employeeBook.put(key, newEmployee);
        return newEmployee;
    }


    @Override
    public Employee removeFromEmployeeBook(String firstName, String lastName) {
        String key = firstName + lastName;
        if (!employeeBook.containsKey(key)) {
            throw new EmployeeDoesNotExistException("Employee does not exist!");
        }
        return employeeBook.remove(key);
    }

    @Override
    public Employee findInEmployeeBook(String firstName, String lastName) {
        String key = firstName + lastName;
        if (!employeeBook.containsKey(key)) {
            throw new EmployeeDoesNotExistException("Employee does not exist!");
        }
        return employeeBook.get(key);
    }

    @Override
    public Collection<Employee> getEmployeeBook() {
        if (employeeBook.isEmpty()) {
            throw new EmployeeBookIsEmptyException("EMPLOYEE BOOK IS EMPTY!");
        }
        return Collections.unmodifiableCollection(employeeBook.values());
    }

}
