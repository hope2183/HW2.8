package com.example.hw2_8;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee-list")

public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee-list/")
    public String welcome() {
        return "Welcome to employee world!";
    }

    @GetMapping("/add")
    public String addToEmployeeBook(@RequestParam("DepartmentId") int departmentId, @RequestParam("id") Integer id,
                                    @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
                                    @RequestParam("Salary") int salary) {
        return employeeService.addToEmployeeBook(departmentId, id,firstName,lastName, salary)+ " successfully added";

    }
    @GetMapping("/remove")
    public String removeFromEmployeeList(@RequestParam("id") Integer id) {
        return "EMPLOYEE: ID "+id+" "+employeeService.removeFromEmployeeBook(id)+" removed.";
    }


    @GetMapping("/find")
    public String findInEmployeeList(@RequestParam("id") Integer id) {
        return "EMPLOYEE: ID"+id+" "+employeeService.findInEmployeeBook(id);
    }

    @GetMapping("/printList")
    public List< Employee> getEmployeeBook() {
        return employeeService.getEmployeeBook();

    }

}
