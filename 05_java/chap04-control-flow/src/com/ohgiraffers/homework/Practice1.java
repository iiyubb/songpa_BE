package com.ohgiraffers.homework;

import java.util.Scanner;

public class Practice1 {
    public static void main(String[] args) {
        int korean;
        int english;
        int math;

        Scanner sc = new Scanner(System.in);
        System.out.print("국어 점수를 입력하세요: ");
        korean = sc.nextInt();

        System.out.print("영어 점수를 입력하세요: ");
        english = sc.nextInt();

        System.out.print("수학 점수를 입력하세요: ");
        math = sc.nextInt();

        int mean = (korean + english + math) / 3;
        if (mean >= 60 && korean >= 40 && english >= 40 && math >= 40) {
            System.out.println("합격입니다!");
        } if (mean < 60) {
            System.out.println("평균 점수 미달로 불합격입니다.");
        } if (korean < 40) {
            System.out.println("국어 점수 미달로 불합격입니다.");
        } if (english < 40) {
            System.out.println("영어 점수 미달로 불합격입니다.");
        } if (math < 40) {
            System.out.println("수학 점수 미달로 불합격입니다.");
        }
    }
}
