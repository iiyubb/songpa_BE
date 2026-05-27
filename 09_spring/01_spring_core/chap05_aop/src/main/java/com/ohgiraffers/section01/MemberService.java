package com.ohgiraffers.section01;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service // DAO를 호출해서 사용할 서비스 로직을 작성한 클래스
public class MemberService {

    private final MemberDao memberDao;

    // 생성자 하나일 때는 @Autowired 생략 가능
    public MemberService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public Map<Long, MemberDto> selectMembers() {
        System.out.println("selectMembers 메소드 실행");
        return memberDao.selectMembers();
    }

    public MemberDto selectMember(Long id) {
        System.out.println("selectMember 메소드 실행");
        return memberDao.selectMember(id);
    }

}
