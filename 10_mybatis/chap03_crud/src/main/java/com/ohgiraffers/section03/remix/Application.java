package com.ohgiraffers.section03.remix;

public class Application {
    public static void main(String[] args) {
        MenuService menuService = new MenuService();
        menuService.selectAllMenu().forEach(System.out::println);
    }
}
