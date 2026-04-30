package com.ohgiraffers.homework;

public class Practice5 {
    public static void main(String[] args) {
        int month = 5;
        int day = 6;
        String gift = "";

        if ((month > 0 && month < 7) && (day > 1 && day < 16)) {
            gift = "배민 쿠폰";
        } else if ((month > 6 && month < 13) && (day > 15 && day < 32)) {
            gift = "스타벅스 커피";
        } else {
            gift = "사탕";
        }

        System.out.println("이유빈의 선물은 " + gift + "입니다.");
    }
}
