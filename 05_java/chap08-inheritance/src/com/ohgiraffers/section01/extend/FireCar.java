package com.ohgiraffers.section01.extend;

public class FireCar extends Car {

    public FireCar() {
        super(); // 부모(Car)의 기본 생성자 호출. 컴파일러가 자동 추가
        System.out.println("FireCar의 기본 생성자 호출");
    }

    @Override
    public void soundHorn() {
        if (isRunning()) {
            System.out.println("빠아아아아앙!!@!@!@!!");
        } else {
            System.out.println("소방차가 앞으로 갈 수 없습니다. 비키세요~~");
        }
    }

    // 부모에게 없는 고유한 기능 추가 (확장)
    public void sprayWater() {
        System.out.println("불난 곳을 발견했습니다. 물을 뿌립니다 ===========>>>>>>>>>");
    }
}
