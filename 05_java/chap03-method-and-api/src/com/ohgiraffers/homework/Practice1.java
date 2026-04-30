package com.ohgiraffers.homework;

public class Practice1 {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        cal.checkMethod();

        int sum = cal.sum1to10();
        System.out.println("1부터 10까지의 합: " + sum);

        cal.checkMaxNumber(10, 20);

        int result = cal.sumTwoNumber(10, 20);
        System.out.println("10과 20의 합은: " + result);

        int result2 = cal.minusTwoNumber(10, 5);
        System.out.println("10과 5의 차는 " + result2);
    }
}
