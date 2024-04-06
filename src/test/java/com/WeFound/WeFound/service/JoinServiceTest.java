package com.WeFound.WeFound.service;

import com.WeFound.WeFound.dto.JoinDto;
import com.WeFound.WeFound.entity.User;
import com.WeFound.WeFound.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application.properties")
@DisplayName("JoinService 테스트")
class JoinServiceTest {

    @Autowired
    private JoinService joinService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @BeforeEach
    void setUp() {
        // Clear user repository before each test
        userRepository.deleteAll();
    }

    @Test
    @DisplayName("회원 가입 프로세스 - 존재하지 않는 이메일로 가입하는 경우")
    void joinProcessWithNonExistingEmail() {
        // Given
        JoinDto joinDto = new JoinDto("test@example.com", "testNick", "testPassword");

        // When
        joinService.joinProcess(joinDto);

        // Then
        User savedUser = userRepository.findByEmail("test@example.com").orElseThrow(EntityNotFoundException::new);
        assertNotNull(savedUser);
        assertEquals("test@example.com", savedUser.getEmail());
       // assertEquals("testNick", savedUser.getNickName());
      //  assertTrue(bCryptPasswordEncoder.matches("testPassword", savedUser.getPassword()));
        assertEquals("ROLE_USER", savedUser.getRole());
    }

    @Test
    @DisplayName("회원 가입 프로세스 - 이미 존재하는 이메일로 가입하는 경우")
    void joinProcessWithExistingEmail() {
        // Given
        JoinDto joinDto = new JoinDto("existing@example.com", "existingNick", "existingPassword");

        // When
        joinService.joinProcess(joinDto);

        // Then
        assertDoesNotThrow(() -> joinService.joinProcess(joinDto)); // Second attempt should not throw any exception
        User savedUser = userRepository.findByEmail("existing@example.com").orElseThrow(EntityNotFoundException::new);
        assertNotNull(savedUser);
        assertEquals("existing@example.com", savedUser.getEmail());
      //  assertEquals("existingNick", savedUser.getNickName());
      //  assertTrue(bCryptPasswordEncoder.matches("existingPassword", savedUser.getPassword()));
        assertEquals("ROLE_USER", savedUser.getRole());
    }
}
