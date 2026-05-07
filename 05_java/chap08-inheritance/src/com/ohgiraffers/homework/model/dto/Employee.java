package com.ohgiraffers.homework.model.dto;

public class Employee extends Person {

    private int salary;
    private String dept;

    public Employee() {
        super();
    }

    public Employee(String name, int age, double height, double weight, int salary, String dept) {
        super(age, height, weight);
        super.name = name;
        this.salary = salary;
        this.dept = dept;
    }

    public String information() {
        return "Name: " + getName() + ", Age: " + getAge() + ", Salary: " + this.salary + ", Department: " + this.dept;
    }
}
