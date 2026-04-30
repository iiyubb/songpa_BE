package com.ohgiraffers.homework;

public class Practice4 {
    public static void main(String[] args) {
        double score = 89.6;
        String grade = "";

        if ((int)score >= 90) {
            grade = "A";
        } else if ((int)score >= 80) {
            grade = "B";
        } else if ((int)score >= 70) {
            grade = "C";
        }  else if ((int)score >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println("홍길동의 이번 점수등급은 " + grade + "입니다.");
    }
}
