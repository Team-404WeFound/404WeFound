package com.WeFound.WeFound.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application.properties")

@DisplayName("로그인 컨트롤러 테스트")
class LoginControllerTest {

    @Autowired
    private LoginController loginController;

    @Test
    @DisplayName("/login 경로에 대한 페이지 반환 테스트")
    void loginP() {
        // when
        String viewName = loginController.loginP();

        // then
        assertEquals("login", viewName);
        // 반환된 뷰 이름이 "login"인지 확인
    }
}
