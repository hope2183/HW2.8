package com.example.hw2_8;

import java.util.Map;

public interface EmployeeService {

    Employee addToEmployeeBook(Integer id, String firstName, String lastName);

    Employee removeFromEmployeeBook(Integer id);

    Employee findInEmployeeBook(Integer id);

    Map<Integer,Employee> getEmployeeBook();

}
