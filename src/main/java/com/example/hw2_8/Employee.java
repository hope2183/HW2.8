package com.example.hw2_8;

public class Employee {
    private static int counter = 1;
    private int id;

    private final String firstName;
    //private final String fatherName;
    private final String lastName;
    private int department;
    private float salaryMonth;


    public Employee(int id, String firstName, String lastName) {

        this.firstName = firstName;
        //this.fatherName = fatherName;
        this.lastName = lastName;
        this.department = department;
        this.salaryMonth = salaryMonth;
        this.id = counter++;
    }

    public float getSalaryMonth() {
        return salaryMonth;
    }

    public void setSalaryMonth(float salaryMonth) {
        this.salaryMonth = salaryMonth;
    }

    public String getFirstName() {
        return this.firstName;
    }

  //  public String getFatherName() {
//        return this.fatherName;
//    }

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