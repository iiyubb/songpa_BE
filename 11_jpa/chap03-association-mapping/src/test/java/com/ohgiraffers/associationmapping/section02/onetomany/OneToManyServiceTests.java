package com.ohgiraffers.associationmapping.section02.onetomany;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class OneToManyServiceTests {

    @Autowired
    private OneToManyService oneToManyService;

    @Test
    @DisplayName("1:N 연간관계 조회 테스트")
    void oneToManyFindTest() {

        // given
        int categoryCode = 4;

        // when
        Category category = oneToManyService.findCategory(categoryCode);

        // then
        assertNotNull(category);
    }
}
