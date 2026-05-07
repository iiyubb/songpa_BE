package com.ohgiraffers.homework.view;

import com.ohgiraffers.homework.controller.LibraryManager;
import com.ohgiraffers.homework.model.dto.Book;
import com.ohgiraffers.homework.model.dto.Member;

import java.util.Scanner;

public class LibraryMenu {

    private LibraryManager lm = new LibraryManager();
    Scanner sc = new Scanner(System.in);

    public void mainMenu() {
        System.out.print("이름: ");
        String name = sc.nextLine();

        System.out.print("나이: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("성별 (M/F): ");
        char gender = sc.nextLine().charAt(0);

        Member member = new Member(name, age, gender);
        // LibraryManager의 insertMember() 메소드에 전달
        lm.insertMember(member);

        while (true) {
            System.out.println("==== 메뉴 ===="); // 무한 반복 실행
            System.out.println("1. 마이페이지");  // LibraryManager의 myInfo() 호출하여 출력
            System.out.println("2. 도서 전체 조회");  // LibraryMenu의 selectAll() 호출
            System.out.println("3. 도서 검색");  // LibraryMenu의 searchBook() 호출
            System.out.println("4. 도서 대여하기");  // LibraryMenu의 rentBook() 호출
            System.out.println("0. 프로그램 종료하기");

            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println(lm.myInfo());
                    break;
                case 2:
                    selectAll();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    rentBook();
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    return;
                default:
                    System.out.println("입력이 잘못되었습니다.");
            }
        }
    }

    public void selectAll() {
        Book[] books = lm.selectAll();
        for (int i = 0; i < books.length; i++) {
            System.out.println(i + "번도서 => " + books[i].toString());
        }
    }

    public void searchBook() {
        System.out.print("검색할 제목 키워드: ");
        String keyword = sc.nextLine();
        Book[] books = lm.searchBook(keyword);

        if (books.length == 0) {
            System.out.println("검색 결과가 없습니다.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public void rentBook() {
        selectAll();
        System.out.print("대여할 도서 번호 선택: ");
        int index = sc.nextInt();
        sc.nextLine();
        if (index < 0 || index >= 5) {
            System.out.println("잘못된 도서 번호입니다.");
            return;
        }
        int result = lm.rentBook(index);

        if (result == 0) {
            System.out.println("성공적으로 대여되었습니다.");
        } else if (result == 1) {
            System.out.println("나이 제한으로 대여 불가능입니다.");
        } else if (result == 2) {
            System.out.println("성공적으로 대여되었습니다. 요리학원 쿠폰이 발급되었습니다. 마이페이지를 통해 확인하세요.");
        }
    }

}
