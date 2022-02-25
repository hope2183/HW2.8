package com.example.hw2_8;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")

public class EmployeeDepartmentController {

    private final DepartmentService departmentService;

    public EmployeeDepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping("/max-salary")
    public Employee findEmployeeWithMaxSalaryByDepartmentId(@RequestParam int departmentId){
        return departmentService.findEmployeeWithMaxSalaryByDepartmentId(departmentId);
    }
    @GetMapping("/min-salary")
    public Employee findEmployeeWithMinSalaryByDepartmentId(@RequestParam int departmentId){
        return departmentService.findEmployeeWithMinSalaryByDepartmentId(departmentId);
    }
    @GetMapping(value = "/all", params = {"department"})
    public Collection<Employee> findAllEmployeesInDepartment(@RequestParam int department){
        return departmentService.findAllEmployeesInDepartment(department);
    }
    @GetMapping("/all")
    public Map<Integer, List<Employee>> findAllEmployeesByDepartments(){
        return departmentService.findAllEmployeesByDepartments();
    }
}
