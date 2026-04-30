package com.ohgiraffers.section01.array;

import java.util.Scanner;

public class Application3 {
    public static void main(String[] args) {

        // 5명의 자바 점수를 정수로 입력받아 합계와 평균을 실수로 구하는 프로그램 만들기
        // 1. 5명의 자바 점수를 저장할 배열 만들기
        int num = 5;
        int[] arr = new int[num];

        // 2. 점수를 입력받아 배열에 할당하는 for문 작성(Scanner 사용)
        System.out.println("5명의 점수를 입력해주세요.");
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }

        // 3. 합계와 평균 계산
        int sum = 0;
        for (int i = 0; i < num; i++) {
            sum += arr[i];
        }
        double avg = (double) sum / num;

        // 4. 합계 평균 출력
        System.out.println("합계: " + sum);
        System.out.println("평균: " + avg);
    }
}

