package com.ohgiraffers.section04.constructor;

public class Application {
    public static void main(String[] args) {
        User user = new User(); // 기본 생성자 함수를 호출하는 구문
        System.out.println(user.getInformation());

        user.setId("user01");

        // 매개변수가 있는 생성자 호출
        User user1 = new User("user02", "pass02", "유관순");
        System.out.println(user.getInformation());
    }
}
