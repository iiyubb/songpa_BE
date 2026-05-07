package com.ohgiraffers.section02.superkeyword;

import java.util.Date;

public class Product {

    private String code;
    private String brand;
    private String name;
    private int price;
    private Date manufactureingDate;

    public Product() {
        System.out.println("Product 기본 생성자 호출됨");
    }

    public Product(String code, String brand, String name, int price, Date manufactureingDate) {
        this.code = code;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.manufactureingDate = manufactureingDate;

        System.out.println("Product 매개변서 있는 생성자 호출됨");
    }

    public String getInformation() {
        return "Product [ code=" + code + ", brand=" + brand + ", name=" + name + ", price=" + price + ", 제조일자: " + manufactureingDate + "]";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getManufactureingDate() {
        return manufactureingDate;
    }

    public void setManufactureingDate(Date manufactureingDate) {
        this.manufactureingDate = manufactureingDate;
    }
}
