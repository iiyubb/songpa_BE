package com.ohgiraffers.section02.superkeyword;

import java.util.Date;

public class Application {
    public static void main(String[] args) {

        Product product = new Product();
        System.out.println(product.getInformation());

        Computer computer = new Computer("S-0123", "삼성", "갤럭시", 2000000, new Date(), "512", 12);
        System.out.println(computer.getInformation());

        SmartPhone phone = new SmartPhone("S-0124", "Apple", "iPhone", 1400000, new Date(),  "KT");
        System.out.println(phone.getInformation());
    }
}
