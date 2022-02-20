package com.example.hw2_8;

import java.util.List;

public interface EmployeeService {

    Employee addToEmployeeBook(int departmentId, Integer id, String firstName, String lastName, int salary);

    Employee removeFromEmployeeBook(Integer id);

    Employee findInEmployeeBook(Integer id);

    List<Employee> getEmployeeBook();

}
