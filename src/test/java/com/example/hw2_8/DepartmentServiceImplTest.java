package com.example.hw2_8;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import static com.example.hw2_8.EmployeeTestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class DepartmentServiceImplTest {
    @Mock
    private EmployeeService employeeService;
    @InjectMocks
    private DepartmentServiceImpl out;

    @Test
    public void findEmployeeWithMaxSalaryInDepartment(){
    when(employeeService.getEmployeeBook()).thenReturn(EMPLOYEES);
    assertEquals(MAX_SALARY_EMPLOYEE, out.findEmployeeWithMaxSalaryByDepartmentId(DEPARTMENT_ID));
}
    @Test
    public void shouldThrowEmployeeDoesNotExistsExceptionWhenDepartmentIsEmptyForMaxSalary() {
        when(employeeService.getEmployeeBook()).thenReturn(new ArrayList<>());
        assertThrows(EmployeeDoesNotExistException.class, () -> out.findEmployeeWithMaxSalaryByDepartmentId(DEPARTMENT_ID));
    }
    @Test
    public void findEmployeeWithMinSalaryInDepartment(){
        when(employeeService.getEmployeeBook()).thenReturn(EMPLOYEES);
        assertEquals(MIN_SALARY_EMPLOYEE, out.findEmployeeWithMinSalaryByDepartmentId(DEPARTMENT_ID));
    }
    @Test
    public void shouldThrowEmployeeDoesNotExistsExceptionWhenNoMinSalary() {
        when(employeeService.getEmployeeBook()).thenReturn(new ArrayList<>());
        assertThrows(EmployeeDoesNotExistException.class, () -> out.findEmployeeWithMinSalaryByDepartmentId(DEPARTMENT_ID));
    }
    @Test
    public void shouldReturnEmptyMapWhenNoEmployees(){
        when(employeeService.getEmployeeBook()).thenReturn(new ArrayList<>());
        assertEquals(new HashMap<>(), out.findAllEmployeesByDepartments());
    }
    @Test
    public void shouldReturnAllEmployeesByDepartmentIfExists(){
        when(employeeService.getEmployeeBook()).thenReturn(DIFFERENT_DEPARTMENTS_EMPLOYEES);
        assertEquals(DEPARTMENT_MAP, out.findAllEmployeesByDepartments());
    }
    @Test
    public void shouldReturnEmptyCollectionWhenNoEmployeesInDepartment(){
        when(employeeService.getEmployeeBook()).thenReturn(EMPLOYEES);
        assertEquals(new ArrayList<>(), out.findAllEmployeesInDepartment(DEPARTMENT_ID2));
    }
    @Test
    public void shouldReturnEmployeesByDepartmentWhenExists(){
        when(employeeService.getEmployeeBook()).thenReturn(DIFFERENT_DEPARTMENTS_EMPLOYEES);
        assertEquals(List.of(MAX_SALARY_EMPLOYEE), out.findAllEmployeesInDepartment(DEPARTMENT_ID));
        assertEquals(List.of(OTHER_DEPARTMENT_EMPLOYEE), out.findAllEmployeesInDepartment(DEPARTMENT_ID2)) ;
    }
}
