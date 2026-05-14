package com.ohgiraffers.homework.comparator;

import com.ohgiraffers.homework.model.dto.BookDto;

import java.util.Comparator;

public class AscBookNo implements Comparator<BookDto> {

    @Override
    public int compare(BookDto o1, BookDto o2) {
        return o1.getbNo() - o2.getbNo();
    }
}
