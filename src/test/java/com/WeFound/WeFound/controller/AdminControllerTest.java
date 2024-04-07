package com.WeFound.WeFound.controller;

import com.WeFound.WeFound.entity.User;
import com.WeFound.WeFound.service.AdminService;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
@Transactional
class AdminControllerTest {

    @InjectMocks
    AdminController adminController;

    @Mock
    AdminService adminService;

    @Mock
    Model model;

    @DisplayName("각 테스트 전에 실행되는 메서드")
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    // adminPage 메서드에 대한 테스트
    @Test
    @DisplayName("adminPage 메서드 테스트")
    void adminPage() {
        List<User> userList = new ArrayList<>();
        when(adminService.getAllUsers()).thenReturn(userList);

        String view = adminController.adminPage(model);

        //verify(adminService, times(1)).getAllUsers();
        verify(model, times(1)).addAttribute("userList", userList);
        assertEquals("admin", view);
    }



    @Test
    @DisplayName("accessDenied 메서드에 대한 테스트")
    void accessDenied() {
        String view = adminController.accessDenied();
        // view 이름이 "access-denied"인지 확인
        assertEquals("access-denied", view);
    }


    @Test
    @DisplayName("updateUserGrade 메서드에 대한 테스트")
    void updateUserGrade() {
        Long userId = 1L;
        String grade = "A";

        String view = adminController.updateUserGrade(userId, grade);

        // updateUserGrade 메서드가 한 번 호출되었는지 확인
        verify(adminService, times(1)).updateUserGrade(userId, grade);
        // view 이름이 "redirect:/admin"인지 확인
        assertEquals("redirect:/admin", view);
    }


    @Test
    @DisplayName("updateUserPoint 메서드에 대한 테스트")
    void updateUserPoint() {
        Long userId = 1L;
        Long point = 100L;
        String reason = "Good performance";

        String view = adminController.updateUserPoint(userId, point, reason);

        // updateUserPoint 메서드가 한 번 호출되었는지 확인
        verify(adminService, times(1)).updateUserPoint(userId, point, reason);
        // view 이름이 "redirect:/admin"인지 확인
        assertEquals("redirect:/admin", view);
    }



}
