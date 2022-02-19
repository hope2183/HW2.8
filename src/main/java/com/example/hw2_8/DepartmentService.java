package com.example.hw2_8;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee findEmployeeWithMaxSalaryByDepartmentId (int departmentId);
    Employee findEmployeeWithMinSalaryByDepartmentId (int departmentId);
    Collection<Employee> findAllEmployeesInDepartment (int departmentId);
    Map<Integer, List<Employee>> findAllEmployeesByDepartments();

}
