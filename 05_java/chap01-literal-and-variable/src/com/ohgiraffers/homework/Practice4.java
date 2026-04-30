package com.ohgiraffers.homework;

public class Practice4 {
    public static void main(String[] args) {
        double korean = 80.5;
        double math = 50.6;
        double english = 70.8;

        double sum = korean + math + english;
        double mean = (korean + math + english) / 3;

        System.out.println("총점: " + (int)sum);
        System.out.println("평균: " + (int)mean);
    }
}
