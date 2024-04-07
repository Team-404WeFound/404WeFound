package com.WeFound.WeFound.controller;

import com.WeFound.WeFound.dto.CustomUserDetails;
import com.WeFound.WeFound.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application.properties")
class UserControllerTest {

    @InjectMocks
    UserController userController;

    @Mock
    UserService userService;

    @Mock
    CustomUserDetails userDetails;

    // 각 테스트 전에 실행되는 메서드
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // withdrawUser 메서드에 대한 테스트
    @Test
    @DisplayName("withdrawUser 메서드 테스트")
    void withdrawUser() {
        String email = "test@test.com";
        when(userDetails.getEmail()).thenReturn(email);

        String view = userController.withdrawUser(userDetails);

        verify(userService, times(1)).withdrawUser(email);
        assertEquals("redirect:/logout", view);
    }


}
