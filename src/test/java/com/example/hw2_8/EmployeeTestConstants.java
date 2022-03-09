package com.example.hw2_8;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class EmployeeTestConstants {
    public static final String FIRST_NAME = "Ivan";
    public static final String FIRST_NAME2 = "Ivashka";
    public static final String FIRST_NAME3 = "Ivashechka";
    public static final String WRONG_FIRST_NAME = "Ivanych";
    public static final String LAST_NAME = "Ivanov";
    public static final String LAST_NAME2 = "Ivanovyh";
    public static final String LAST_NAME3 = "Ivanovushka";
    public static final String WRONG_LAST_NAME = "Ivanova";

    public static final int MAX_SALARY = 77777;
    public static final int MIN_SALARY = 11111;
    public static final int DEPARTMENT_ID = 5;
    public static final int DEPARTMENT_ID2 = 2;

    public static final Employee MAX_SALARY_EMPLOYEE = new Employee(FIRST_NAME,LAST_NAME,MAX_SALARY,DEPARTMENT_ID);
    public static final Employee MIN_SALARY_EMPLOYEE = new Employee(FIRST_NAME2,LAST_NAME2,MIN_SALARY,DEPARTMENT_ID);
    public static final Employee OTHER_DEPARTMENT_EMPLOYEE = new Employee(FIRST_NAME3,LAST_NAME3,MIN_SALARY,DEPARTMENT_ID2);
    public static final Set<Employee> EMPLOYEES = Set.of(MAX_SALARY_EMPLOYEE,MIN_SALARY_EMPLOYEE);
    public static final Set<Employee> DIFFERENT_DEPARTMENTS_EMPLOYEES = Set.of(MAX_SALARY_EMPLOYEE,OTHER_DEPARTMENT_EMPLOYEE);
    public static final Map<Integer, List<Employee>> DEPARTMENT_MAP =DIFFERENT_DEPARTMENTS_EMPLOYEES.stream().

                                                                        collect(groupingBy(Employee::getDepartment));
}

