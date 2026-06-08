package com.ohgiraffers.springmybatis.menu.model.dto;

public class CategoryDto {

    private int code;
    private String name;
    private int refCategoryCode;

    public CategoryDto() {
    }

    public CategoryDto(int code, String name, int refCategoryCode) {
        this.code = code;
        this.name = name;
        this.refCategoryCode = refCategoryCode;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRefCategoryCode() {
        return refCategoryCode;
    }

    public void setRefCategoryCode(int refCategoryCode) {
        this.refCategoryCode = refCategoryCode;
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", refCategoryCode=" + refCategoryCode +
                '}';
    }
}

