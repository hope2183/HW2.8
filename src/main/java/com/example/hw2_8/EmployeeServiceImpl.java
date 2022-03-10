package com.example.hw2_8;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.capitalize;
import static org.apache.commons.lang3.StringUtils.isAlpha;

@Service

public class EmployeeServiceImpl implements EmployeeService {
    private Map<String, Employee> employeeBook = new HashMap<>();


    public Employee addToEmployeeBook(String firstName, String lastName, int department, int salary) {
        validateNames(firstName, lastName);
        String correctFirstName = capitalize(firstName.toLowerCase());
        String correctLastName = capitalize(lastName.toLowerCase());
        Employee newEmployee = new Employee(correctFirstName, correctLastName, department, salary);
        String key = correctFirstName + correctLastName;
        if (employeeBook.containsKey(key)) {
            throw new EmployeeAlreadyExistsException("Employee already exists!");
        }
        employeeBook.put(key, newEmployee);
        return newEmployee;
    }

    private void validateNames(String... names) {
        Arrays.stream(names).forEach(name -> {
            if (!isAlpha(name)) {
                throw new InvalidNameException("Invalid name!");
            }
        });
    }


    @Override
    public Employee removeFromEmployeeBook(String firstName, String lastName) {
        validateNames(firstName, lastName);
        String correctFirstName = capitalize(firstName.toLowerCase());
        String correctLastName = capitalize(lastName.toLowerCase());
        String key = correctFirstName + correctLastName;
        if (!employeeBook.containsKey(key)) {
            throw new EmployeeDoesNotExistException("Employee does not exist!");
        }
        return employeeBook.remove(key);
    }

    @Override
    public Employee findInEmployeeBook(String firstName, String lastName) {
        validateNames(firstName, lastName);
        String correctFirstName = capitalize(firstName.toLowerCase());
        String correctLastName = capitalize(lastName.toLowerCase());
        String key = correctFirstName + correctLastName;
        if (!employeeBook.containsKey(key)) {
            throw new EmployeeDoesNotExistException("Employee does not exist!");
        }
        return employeeBook.get(key);
    }

    @Override
    public Collection<Employee> getEmployeeBook() {
//        if (employeeBook.isEmpty()) {
//            throw new EmployeeBookIsEmptyException("EMPLOYEE BOOK IS EMPTY!");
//        }
        return Collections.unmodifiableCollection(employeeBook.values());
    }


    public Employee addToEmployeeBook(String firstName, String lastName) {
        validateNames(firstName, lastName);
        String correctFirstName = capitalize(firstName.toLowerCase());
        String correctLastName = capitalize(lastName.toLowerCase());
        Employee newEmployee = new Employee(correctFirstName, correctLastName);
        String key = correctFirstName + correctLastName;
        if (employeeBook.containsKey(key)) {
            throw new EmployeeAlreadyExistsException("Employee already exists!");
        }
        employeeBook.put(key, newEmployee);
        return newEmployee;
    }
}
