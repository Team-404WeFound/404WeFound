package com.WeFound.WeFound.controller;

import com.WeFound.WeFound.service.MainService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application.properties")
class MainControllerTest {

    @InjectMocks
    MainController mainController;

    @Mock
    MainService mainService;

    @Mock
    Model model;

    // 각 테스트 전에 실행되는 메서드
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    @DisplayName("mainPage 메서드 테스트")
    void mainPage() {
        String view = mainController.mainPage(model);

        verify(mainService, times(1)).populateModelWithUserDetails(model);
        assertEquals("main", view);
    }



}
