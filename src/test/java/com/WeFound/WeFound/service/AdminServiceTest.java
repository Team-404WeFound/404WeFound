package com.WeFound.WeFound.service;

import com.WeFound.WeFound.entity.Point;
import com.WeFound.WeFound.entity.User;
import com.WeFound.WeFound.repository.PointRepository;
import com.WeFound.WeFound.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application.properties")
class AdminServiceTest {

    @InjectMocks
    AdminService adminService;

    @Mock
    UserRepository userRepository;

    @Mock
    PointRepository pointRepository;

    // 각 테스트 전에 실행되는 메서드
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // getAllUsers 메서드에 대한 테스트
    @Test
    @DisplayName("getAllUsers 메서드 테스트")
    void getAllUsers() {
        List<User> userList = new ArrayList<>();
        when(userRepository.findAll()).thenReturn(userList);

        List<User> result = adminService.getAllUsers();

        verify(userRepository, times(1)).findAll();
        assertEquals(userList, result);
    }

    // updateUserGrade 메서드에 대한 테스트
    @Test
    @DisplayName("updateUserGrade 메서드 테스트")
    void updateUserGrade() {
        Long userId = 1L;
        String grade = "A";
        User user = new User();
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        adminService.updateUserGrade(userId, grade);

        verify(userRepository, times(1)).findById(userId);
        verify(userRepository, times(1)).save(user);
        assertEquals(grade, user.getGrade());
    }

    // updateUserPoint 메서드에 대한 테스트
    @Test
    @DisplayName("updateUserPoint 메서드 테스트")
    void updateUserPoint() {
        Long userId = 1L;
        Long point = 100L;
        String reason = "Test";
        User user = new User();
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        adminService.updateUserPoint(userId, point, reason);

        verify(userRepository, times(1)).findById(userId);
        verify(pointRepository, times(1)).save(any(Point.class));
        verify(userRepository, times(1)).save(user);
    }
}
