package com.WeFound.WeFound.controller;

import com.WeFound.WeFound.dto.JoinDto;
import com.WeFound.WeFound.service.JoinService;
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
import static org.mockito.Mockito.*;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application.properties")
class JoinControllerTest {

    @InjectMocks
    JoinController joinController;

    @Mock
    JoinService joinService;

    // 각 테스트 전에 실행되는 메서드
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    @DisplayName("joinP 메서드 테스트")
    void joinP() {
        String view = joinController.joinP();
        assertEquals("join", view);
    }


    @Test
    @DisplayName("joinProcess 메서드 테스트")
    void joinProcess() {
        JoinDto joinDto = new JoinDto();
        joinDto.setEmail("test@test.com");
        joinDto.setPassword("password");
        joinDto.setNickName("nickname");

        doNothing().when(joinService).joinProcess(joinDto);

        String view = joinController.joinProcess(joinDto);

        verify(joinService, times(1)).joinProcess(joinDto);
        assertEquals("redirect:/login", view);
    }
}
