package com.ohgiraffers.homework.model.dto;

public class Student extends Person {

    private int grade;
    private String major;

    public Student() {
        super();
    }

    public Student(String name, int age, double height, double weight, int grade, String major) {
        super(age, height, weight);
        super.name = name;
        this.grade = grade;
        this.major = major;
    }

    public String information() {
        return "Name: " + getName() + ", Age: " + getAge() + ", Grade: " + this.grade + ", Major: " + this.major;
    }
}
