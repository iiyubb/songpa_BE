package com.ohgiraffers.homework.model.dto;

public class CookBook extends Book {

    private boolean coupon;

    public CookBook() {super();}

    public CookBook(String title, String author, String publisher, boolean coupon) {
        super(title, author, publisher);
        this.coupon = coupon;
    }

    @Override
    public String toString() {
        return "Title: " + getTitle() + ", Author: " + getAuthor() + ", Publisher: " + getPublisher() + ", Coupon: " + coupon;
    }

    public boolean isCoupon() {
        return coupon;
    }

    public void setCoupon(boolean coupon) {
        this.coupon = coupon;
    }
}
