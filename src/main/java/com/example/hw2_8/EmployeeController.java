package com.example.hw2_8;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

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
    public String addToEmployeeBook(@RequestParam("firstName") String firstName,
                                    @RequestParam("lastName") String lastName,
                                    @RequestParam("department") int department,
                                    @RequestParam("salary") int salary) {
        return employeeService.addToEmployeeBook(firstName, lastName, department, salary) + " successfully added.";
    }

    @GetMapping("/remove")
    public String removeFromEmployeeList(@RequestParam("firstName") String firstName,
                                         @RequestParam("lastName") String lastName) {
        return employeeService.removeFromEmployeeBook(firstName, lastName) + " removed.";
    }


    @GetMapping("/find")
    public String findInEmployeeList(@RequestParam("firstName") String firstName,
                                     @RequestParam("lastName") String lastName) {
        return employeeService.findInEmployeeBook(firstName, lastName) + " found.";
    }

    @GetMapping("/printList")
    public Collection<Employee> getEmployeeBook() {
        return employeeService.getEmployeeBook();

    }

}
