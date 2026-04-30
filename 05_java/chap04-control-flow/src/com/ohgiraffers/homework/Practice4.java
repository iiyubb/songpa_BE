package com.ohgiraffers.homework;

import java.util.Scanner;

public class Practice4 {
    public static void main(String[] args) {
        int r = (int) (Math.random() * 100) + 1;
        int count = 0;
        int num = 0;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("정수를 입력하세요: ");
            num = sc.nextInt();
            count++;

            if (r < num) {
                System.out.println("입력하신 정수보다 작습니다.");
            } else if (r > num) {
                System.out.println("입력하신 정수보다 큽니다.");
            }
        } while (num != r);

        System.out.println("정답입니다. " + count + "회만에 정답을 맞히셨습니다.");
    }
}
