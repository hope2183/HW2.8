package com.example.hw2_8;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparingInt;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findEmployeeWithMaxSalaryByDepartmentId(int departmentId) {
        return employeeService.getEmployeeBook().stream().filter(e->e.getDepartment==departmentId)
                .max.comparingInt(e->e.getSalaryMonth).orElseThrow(EmployeeDoesNotExistException);
    }

    @Override
    public Employee findEmployeeWithMinSalaryByDepartmentId(int departmentId) {
        return null;
    }

    @Override
    public Collection<Employee> findAllEmployeesInDepartment(int departmentId) {
        return null;
    }

    @Override
    public Map<Integer, List<Employee>> findAllEmployeesByDepartments() {
        return null;
    }
}
