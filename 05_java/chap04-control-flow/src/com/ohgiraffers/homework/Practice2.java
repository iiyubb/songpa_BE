package com.ohgiraffers.homework;

import java.util.Scanner;

public class Practice2 {
    public static void main(String[] args) {
//        double month, sales;
        int month, sales, bonus;

        Scanner sc = new Scanner(System.in);
        System.out.print("월 급여 입력: ");
        month = sc.nextInt();

        System.out.print("매출액 입력: ");
        sales = sc.nextInt();

        if (sales >= 50_000_000) {
            bonus = 5;
        } else if (sales >= 30_000_000) {
            bonus = 3;
        } else if (sales >= 10_000_000) {
            bonus = 1;
        } else {
            bonus = 0;
        }

        System.out.println("======================");
        System.out.println("매출액: " + sales);
        System.out.println("보너스율: " + bonus + "%");
        System.out.println("월 급여: " + month);
        System.out.println("보너스 금액: " + (int)(sales * bonus * 0.01));
        System.out.println("======================");
        System.out.println("총 급여: " + (int)(month + sales * bonus * 0.01));
    }
}
