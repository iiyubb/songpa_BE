package com.ohgiraffers.homework;

import java.util.Scanner;

public class Practice3 {
    public static void main(String[] args) {
        int num;
        String result = "";

        System.out.print("정수를 입력하세요: ");
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();

        for (int i = 1; i <= num; i++) {
            if (i % 2 == 1) {
                result += "수";
            } else if (i % 2 == 0) {
                result += "박";
            }
        }
        System.out.println(result);
    }
}
