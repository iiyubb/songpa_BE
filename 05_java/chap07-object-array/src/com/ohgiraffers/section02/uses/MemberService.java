package com.ohgiraffers.section02.uses;

import java.util.Scanner;

public class MemberService {

    // 회원 5명 일괄 등록
    public void signUpMembers() {
        Member[] members = {
                new Member(1, "user01", "pass01", 28, '남'),
                new Member(2, "user02", "pass02", 45, '여'),
                new Member(3, "user03", "pass03", 67, '여'),
                new Member(4, "user04", "pass04", 54, '여'),
                new Member(5, "user05", "pass05", 17, '남')
        };

        if (MemberRepository.store(members)) {
            System.out.println("총 " + members.length + "명 등록 성공!");
        } else {
            System.out.println("정원 초과로 저장 실패");
        }
    }

    // 전체 회원 조회
    public void showAllMembers() {
        Member[] allMembers = MemberRepository.findAllMembers();
        for (Member member : allMembers) {
            if (member != null) {
                System.out.println(member.getInformation());
            }
        }
    }

    // 아이디로 회원 검색
    public void searchMemberById(Scanner sc) {
        System.out.print("검색할 아이디를 입력하세요: ");
        String searchId = sc.nextLine();

        Member[] foundMember = MemberRepository.findAllMembers();

        boolean isFound = false; // 플래그 변수 설정
        for (Member member : foundMember) {
            if (member != null) {
                if (searchId.equals(member.getId())) {
                    System.out.println("------ 검색 결과 ------");
                    System.out.println(member.getInformation());
                    isFound = true;
                    break;
                }
            }
        }
        if (!isFound) {
            System.out.println("아이디 [" + searchId + "] 회원을 찾을 수 없습니다.");
        }

    }
}
