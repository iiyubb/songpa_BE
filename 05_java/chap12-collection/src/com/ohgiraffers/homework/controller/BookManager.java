package com.ohgiraffers.homework.controller;

import com.ohgiraffers.homework.comparator.AscBookNo;
import com.ohgiraffers.homework.comparator.AscBookTitle;
import com.ohgiraffers.homework.comparator.DescBookNo;
import com.ohgiraffers.homework.comparator.DescBookTitle;
import com.ohgiraffers.homework.model.dto.BookDto;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private ArrayList<BookDto> booklist;

    /* 도서 번호 자동 부여를 위한 시퀀스 값 */
    private int sequence;

    public BookManager() {
        booklist = new ArrayList<>();
        sequence = 0;
    }

    /* 전달받은 도서 정보를 리스트에 담는다.
     * 이때 도서 번호(bNo)를 자동으로 부여한다. */
    public void addBook(BookDto book) {
        book.setbNo(++sequence);
        booklist.add(book);
        System.out.println(book.getTitle() + " 도서가 추가되었습니다. (도서번호: " + book.getbNo() + ")");
    }

    /* 전달받은 도서 번호와 일치하는 도서를 제거한다.
     * 인덱스가 아닌 도서 번호(bNo) 기준으로 탐색하여 제거한다. */
    public void deleteBook(int bNo) {
        boolean isDeleted = false;

        for (int i = 0; i < booklist.size(); i++) {
            if (booklist.get(i).getbNo() == bNo) {
                BookDto removed = booklist.remove(i);
                System.out.println(removed.getTitle() + " 도서가 삭제되었습니다.");
                isDeleted = true;
                break;
            }
        }

        if (!isDeleted) {
            System.out.println("해당 도서 번호의 도서가 목록에 없습니다.");
        }
    }

    public void searchBook(String title) {
        for (BookDto book : booklist) {
            if (book.getTitle().equals(title)) {
                System.out.println(book.toString());
            } else {
                System.out.println("조회된 도서가 목록에 없습니다.");
            }
        }
    }

    public void displayAll() {
        if (booklist.isEmpty()) {
            System.out.println("조회 결과가 없습니다.");
        } else {
            for (BookDto book : booklist) {
                System.out.println(book.toString());
            }
        }
    }

    /* 사용자가 선택한 정렬 방식(type)에 따라 정렬된 리스트를 반환한다.
     * 1. 도서번호 오름차순
     * 2. 도서번호 내림차순
     * 3. 도서제목 오름차순
     * 4. 도서제목 내림차순 */
    public List<BookDto> sortedBookList(int type) {

        /* 원본 리스트를 보존하기 위해 복사본을 만들어 정렬한다. */
        List<BookDto> sortedList = new ArrayList<>(booklist);

        switch (type) {
            case 1:
                sortedList.sort(new AscBookNo());
                break;
            case 2:
                sortedList.sort(new DescBookNo());
                break;
            case 3:
                sortedList.sort(new AscBookTitle());
                break;
            case 4:
                sortedList.sort(new DescBookTitle());
                break;
            default:
                System.out.println("잘못된 정렬 방식입니다. 원본 순서로 반환합니다.");
        }

        return sortedList;
    }

    /* 전달받은 리스트 객체의 도서를 출력한다. */
    public void printBookList(List<BookDto> printList) {
        if (printList == null || printList.isEmpty()) {
            System.out.println("출력결과가 없습니다.");
            return;
        }

        for (BookDto book : printList) {
            System.out.println(book);
        }
    }
}
