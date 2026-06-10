package com.ohgiraffers.mapping.section01.entity;

import com.ohgiraffers.mapping.secion01.entity.MemberRegistDto;
import com.ohgiraffers.mapping.secion01.entity.MemberRole;
import com.ohgiraffers.mapping.secion01.entity.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.stream.Stream;

@SpringBootTest
public class MemberServiceTests {
    @Autowired
    private MemberService memberService;

    private static Stream<Arguments> getMember() {
        return Stream.of(
                Arguments.of(
                        "user01",
                        "pass01",
                        "홍길동",
                        "010-1234-5678",
                        "서울시 종로구",
                        LocalDateTime.now(),
                        MemberRole.ROLE_MEMBER,
                        "Y"
                ),
                Arguments.of(
                        "user02",
                        "pass02",
                        "유관순",
                        "010-8765-4321",
                        "서울시 서초구",
                        LocalDateTime.now(),
                        MemberRole.ROLE_ADMIN,
                        "Y"
                )
        );
    }

    @DisplayName("테이블 생성 테스트")
    @ParameterizedTest
    @MethodSource("getMember")
    void testCreateTable(
            String memberId, String memberPwd,
            String memberName, String phone, String address,
            LocalDateTime enrollDate, MemberRole memberRole, String status
    ) {
        //given
        MemberRegistDto newMember = new MemberRegistDto(
                memberId,
                memberPwd,
                memberName,
                phone,
                address,
                enrollDate,
                memberRole,
                status
        );

        //when
        //then
        Assertions.assertDoesNotThrow(
                () -> memberService.registMember(newMember)
        );
    }
}
