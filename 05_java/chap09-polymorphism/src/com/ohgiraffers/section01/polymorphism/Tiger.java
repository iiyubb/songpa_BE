package com.ohgiraffers.section01.polymorphism;

public class Tiger extends Animal{

    @Override
    public void cry() {
        System.out.println("호랑이가 울부짖는다. 어흥!!!!!");
    }

    public void bite() {
        System.out.println("호랑이가 물어뜯는다. 왁!!!");
    }
}
