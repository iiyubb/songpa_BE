package com.ohgiraffers.section01;

import org.springframework.stereotype.Repository;

import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.Map;

@Repository // DB 커넥션을 가지는 쪽에 많이 작성
public class MemberDao {

    private final Map<Long, MemberDto> memberMap;

    public MemberDao() {
        memberMap = new HashMap<>();
        memberMap.put(1L, new MemberDto(1L, "유관순"));
        memberMap.put(2L, new MemberDto(2L, "홍길동"));
    }

    public Map<Long, MemberDto> selectMembers() {
        return memberMap;
    }

    public MemberDto selectMember(Long id) {
        MemberDto returnMember = memberMap.get(id);

        if (returnMember == null) {
            throw new RuntimeException("해당하는 ID의 회원이 없습니다.");
        }
        return returnMember;
    }
}
