package com.example.hw2_8;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service

public class EmployeeServiceImpl implements EmployeeService {
    private Map<Integer, Employee> employeeBook;

    public EmployeeServiceImpl() {
        employeeBook = new HashMap<>();
    }

    public Employee addToEmployeeBook(int departmentId, Integer id, String firstName, String lastName, int salary) {
        Employee newEmployee = new Employee(departmentId,id,firstName, lastName,salary);
        if (employeeBook.containsKey(id)) {
            throw new EmployeeAlreadyExistsException("Employee with ID " + id + " already exists!");
        }
        employeeBook.put(id, newEmployee);
        return newEmployee;
    }


    @Override
    public Employee removeFromEmployeeBook(Integer id) {

        if (employeeBook.containsKey(id)) {
            Employee deletedEmployee = employeeBook.remove(id);
            return deletedEmployee;
        }
        throw new EmployeeDoesNotExistException("Employee does not exist!");
    }

    @Override
    public Employee findInEmployeeBook(Integer id) {
        if (employeeBook.containsKey(id)) {
            Employee foundEmployee = employeeBook.get(id);
            return foundEmployee;
        }
        throw new EmployeeDoesNotExistException("Employee with ID: " + id + " does not exist!");
    }

    @Override
    public List<Employee> getEmployeeBook() {
        if (employeeBook.isEmpty()) {
            throw new EmployeeBookIsEmptyException("EMPLOYEE BOOK IS EMPTY!");
        }
        return (List<Employee>) employeeBook;
    }

}
