package com.example.hw2_8;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {

    Employee addToEmployeeBook(String firstName, String lastName, int department, int salary);

    Employee removeFromEmployeeBook(String firstName, String lastName);

    Employee findInEmployeeBook(String firstName, String lastName);

    Collection<Employee> getEmployeeBook();

    }
