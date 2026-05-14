package com.ohgiraffers.homework.view;

import com.ohgiraffers.homework.controller.BookManager;
import com.ohgiraffers.homework.model.dto.BookDto;

import java.util.List;
import java.util.Scanner;

public class BookMenu {

    private Scanner sc;
    private BookManager bm;

    public BookMenu() {
        sc = new Scanner(System.in);
        bm = new BookManager();
    }

    /* 메인 메뉴 출력 및 메뉴 번호에 따른 BookManager 메소드 실행 (반복) */
    public void mainMenu() {

        while (true) {
            System.out.println("\n*** 도서 관리 프로그램 ***");
            System.out.println("1. 새 도서 추가");
            System.out.println("2. 도서정보 정렬 후 출력");
            System.out.println("3. 도서 삭제");
            System.out.println("4. 도서 검색출력");
            System.out.println("5. 전체 출력");
            System.out.println("6. 끝내기");
            System.out.print("메뉴 번호 선택 : >> ");

            int menu = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기

            switch (menu) {
                case 1:
                    bm.addBook(inputBook());
                    break;
                case 2:
                    /* selectSortedBook()이 리턴한 정렬된 리스트를 printBookList()로 출력 */
                    bm.printBookList(selectSortedBook());
                    break;
                case 3:
                    bm.deleteBook(inputBookNo());
                    break;
                case 4:
                    bm.searchBook(inputBookTitle());
                    break;
                case 5:
                    bm.displayAll();
                    break;
                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    return; // main()으로 리턴
                default:
                    System.out.println("잘못된 메뉴 번호입니다. 다시 입력해주세요.");
            }
        }
    }

    /* BookDTO 객체의 필드 값을 키보드로 입력받아 초기화하고 객체 리턴 */
    public BookDto inputBook() {
        System.out.print("도서 제목 : ");
        String title = sc.nextLine();

        System.out.print("도서 장르 (1:인문 / 2:자연과학 / 3:의료 / 4:기타) : ");
        int category = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기

        System.out.print("도서 저자 : ");
        String author = sc.nextLine();

        /* 매개변수 생성자를 이용하여 BookDTO 객체 리턴 */
        return new BookDto(category, title, author);
    }

    /* 삭제할 도서 번호를 키보드로 입력받아 리턴 */
    public int inputBookNo() {
        System.out.print("도서 번호 : ");
        int bNo = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기
        return bNo;
    }

    /* 검색할 도서 제목을 키보드로 입력받아 리턴 */
    public String inputBookTitle() {
        System.out.print("도서 제목 : ");
        return sc.nextLine();
    }

    /* 도서 정렬 방식을 정수로 입력받아 BookManager의 sortedBookList()를 호출하고
     * 정렬된 리스트를 리턴 */
    public List<BookDto> selectSortedBook() {
        System.out.println("=== 도서 정렬 방식 선택 ===");
        System.out.println("1. 도서번호(ISBN) 오름차순 정렬");
        System.out.println("2. 도서번호(ISBN) 내림차순 정렬");
        System.out.println("3. 책 제목 오름차순 정렬");
        System.out.println("4. 책 제목 내림차순 정렬");
        System.out.print("정렬 방식 선택 : >> ");

        int type = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기

        return bm.sortedBookList(type);
    }
}