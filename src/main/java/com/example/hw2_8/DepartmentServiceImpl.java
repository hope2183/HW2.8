package com.example.hw2_8;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findEmployeeWithMaxSalaryByDepartmentId(int departmentId) {
        return employeeService.getEmployeeBook().stream().filter(e -> e.getDepartment() == departmentId)
                .max(comparingInt(e -> e.getSalary()))
                .orElseThrow(() -> new EmployeeDoesNotExistException("Employee not found!"));
    }

    @Override
    public Employee findEmployeeWithMinSalaryByDepartmentId(int departmentId) {
        return employeeService.getEmployeeBook().stream().filter(e -> e.getDepartment() == departmentId)
                .min(comparingInt(e -> e.getSalary()))
                .orElseThrow(() -> new EmployeeDoesNotExistException("Employee not found!"));
    }

    @Override
    public Collection<Employee> findAllEmployeesInDepartment(int departmentId) {
        return employeeService.getEmployeeBook().stream().filter(e -> e.getDepartment() == departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> findAllEmployeesByDepartments() {
        return employeeService.getEmployeeBook().stream().
                collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
