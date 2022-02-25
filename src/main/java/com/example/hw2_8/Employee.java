package com.example.hw2_8;

public class Employee {

    private final String firstName;
    private final String lastName;
    private int department;
    private int salary;
    public Employee(String firstName, String lastName, int department, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
    }


    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getFullName() {

        return this.lastName +" "+ firstName;
    }

    public int getDepartment() {

        return this.department;
    }

    public void setDepartment(int department) {

        this.department = department;
    }


    @Override
    public String toString() {
        return " СОТРУДНИК: " + firstName + " " + lastName + " "+
                " ОТДЕЛ: " + department + " ЗАРАБОТНАЯ ПЛАТА, руб.: " + salary;
    }

}