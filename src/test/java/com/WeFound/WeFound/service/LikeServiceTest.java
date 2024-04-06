package com.WeFound.WeFound.service;

import com.WeFound.WeFound.entity.Like;
import com.WeFound.WeFound.entity.Question;
import com.WeFound.WeFound.entity.User;
import com.WeFound.WeFound.repository.LikeRepository;
import com.WeFound.WeFound.repository.QuestionRepository;
import com.WeFound.WeFound.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application.properties")
@DisplayName("LikeService 테스트")
class LikeServiceTest {

    @Autowired
    private LikeService likeService;

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @BeforeEach
    void setUp() {
        likeRepository.deleteAll();
    }

    @Test
    @DisplayName("좋아요 추가 테스트")
    void addLike() {
        // Given
        User user = new User();
        user.setUserId(1L);
        user.setEmail("test@example.com");
        user.setPassword("password");
        user.setNickName("TestUser");
        user.setRole("ROLE_USER");
        user.setCreateAt(LocalDateTime.now());
        userRepository.save(user);

        Question question = Question.builder()
                .title("Test Question")
                .content("This is a test question.")
                .userId(user.getUserId())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        questionRepository.save(question);

        Like like = new Like(user, question);

        // When
        likeService.addLike(like);

        // Then
        assertNotNull(likeRepository.findById(like.getId()).orElse(null));
    }

    @Test
    @DisplayName("좋아요 삭제 테스트")
    void deleteLike() {
        addLike();
        // Given
        User user = new User();
        user.setUserId(1L);
        user.setEmail("test@example.com");
        user.setPassword("password");
        user.setNickName("TestUser");
        user.setRole("ROLE_USER");
        user.setCreateAt(LocalDateTime.now());
        userRepository.save(user);

        Question question = Question.builder()
                .title("Test Question")
                .content("This is a test question.")
                .userId(user.getUserId())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        questionRepository.save(question);

        Like like = new Like(user, question);
        likeRepository.save(like);

        // When
        likeService.deleteLike(user.getUserId(), question);

        // Then
      //  assertFalse(likeRepository.findById(like.getId()).isPresent());
    }
}
