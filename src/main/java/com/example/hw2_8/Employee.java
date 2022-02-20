package com.example.hw2_8;

public class Employee {
    private static int counter = 1;
    private int id;

    private final String firstName;
    //private final String fatherName;
    private final String lastName;
    private int department;
    private int salaryMonth;


    public Employee(int department, int id, String firstName, String lastName, int salaryMonth) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salaryMonth = salaryMonth;
        this.id = counter++;
    }

    public int getSalaryMonth() {
        return salaryMonth;
    }

    public void setSalaryMonth(int salaryMonth) {
        this.salaryMonth = salaryMonth;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getFullName() {

        return this.lastName +" "+ firstName;
    }

    public String getLastName() {

        return this.lastName;
    }

    public int getDepartment() {

        return this.department;
    }

    public void setDepartment(int department) {

        this.department = department;
    }

    public int getId() {

        return this.id;
    }




    @Override
    public String toString() {
        return "ID: "+id+" СОТРУДНИК: " + lastName + " " + firstName + " "+
                " ОТДЕЛ: " + department + " ЗАРАБОТНАЯ ПЛАТА, руб.: " + salaryMonth;
    }

}