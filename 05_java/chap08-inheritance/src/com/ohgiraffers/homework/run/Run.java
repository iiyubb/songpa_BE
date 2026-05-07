package com.ohgiraffers.homework.run;

import com.ohgiraffers.homework.model.dto.Employee;
import com.ohgiraffers.homework.model.dto.Student;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {

        Student[] students = new Student[3];
        students[0] = new Student("홍길동", 20, 178.2, 70.0, 1, "정보시스템공학과");
        students[1] = new Student("김말똥", 21, 187.3, 80.0, 2, "경영학과");
        students[2] = new Student("강개순", 23, 167.0, 45.0, 4, "정보통신공학과");

        for (Student student : students) {
            System.out.println(student.information());
        }

        Scanner sc = new Scanner(System.in);
        Employee[] employees = new Employee[10];
        int count = 0;

        while (true) {

            if (count >= employees.length) {
                System.out.println("사원 정보가 가득 찼습니다. (최대 " + employees.length + "명)");
                break;
            }

            System.out.println("\n===== 사원 정보 입력 (" + (count + 1) + "번째) =====");

            System.out.print("이름: ");
            String name = sc.nextLine();

            System.out.print("나이: ");
            int age = Integer.parseInt(sc.nextLine());

            System.out.print("신장: ");
            double height = Double.parseDouble(sc.nextLine());

            System.out.print("몸무게: ");
            double weight = Double.parseDouble(sc.nextLine());

            System.out.print("급여: ");
            int salary = Integer.parseInt(sc.nextLine());

            System.out.print("부서: ");
            String dept = sc.nextLine();

            employees[count] = new Employee(name, age, height, weight, salary, dept);
            count++;

            System.out.print("계속 추가하시겠습니까? (y/n): ");
            String answer = sc.nextLine();

            if (!answer.equalsIgnoreCase("y")) {
                break;
            }
        }

        /* 현재 기록된 사원들의 정보 모두 출력 */
        System.out.println("\n===== 현재 기록된 사원 정보 (총 " + count + "명) =====");
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i].information());
        }

        sc.close();
    }
}
