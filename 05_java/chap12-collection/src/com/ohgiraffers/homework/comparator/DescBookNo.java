package com.ohgiraffers.homework.comparator;

import com.ohgiraffers.homework.model.dto.BookDto;

import java.util.Comparator;

public class DescBookNo implements Comparator<BookDto> {

    @Override
    public int compare(BookDto o1, BookDto o2) {
        return o2.getbNo() - o1.getbNo();
    }
}
