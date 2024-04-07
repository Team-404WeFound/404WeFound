package com.WeFound.WeFound.repository;

import com.WeFound.WeFound.entity.Comment;
import com.WeFound.WeFound.entity.Question;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest // 스프링 부트 애플리케이션 컨텍스트를 로드하여 테스트를 수행하기 위해
@Transactional // 각 테스트 메소드가 트랜잭션을 사용하도록 지정하여 테스트 후 롤백하도록 함
@TestPropertySource(locations = "classpath:application.properties") // 테스트에 사용할 프로퍼티 소스를 지정

@DisplayName("댓글 레포지토리 테스트") // 테스트 클래스의 이름을 한글로 표시
class CommentRepositoryTest {

    @Autowired
    private CommentRepository commentRepository;

    @Test
    @DisplayName("주어진 질문 ID와 댓글 ID로 댓글을 찾는지 테스트")
    void findByQuestion_QuestionIdAndCommentId() {
        // given
        Long questionId = 1L;
        Long commentId = 1L;

        // when
        Optional<Comment> foundComment = commentRepository.findByQuestion_QuestionIdAndCommentId(questionId, commentId);

        // then
        assertTrue(foundComment.isPresent());
        // 여기에 추가 테스트 조건 추가 가능
    }

    @Test
    @DisplayName("주어진 질문 ID로 해당 질문에 속한 댓글 목록을 찾는지 테스트")
    void findByQuestion_QuestionId() {
        // given
        Long questionId = 1L;

        // when
        Optional<List<Comment>> foundComments = commentRepository.findByQuestion_QuestionId(questionId);

        // then
        assertTrue(foundComments.isPresent());
        // 여기에 추가 테스트 조건 추가 가능
    }

    @Test
    @DisplayName("주어진 질문 ID와 댓글 ID로 댓글을 삭제하는지 테스트")
    void deleteByQuestion_QuestionIdAndCommentId() {
        // given
        Long questionId = 1L;
        Long commentId = 1L;

        // when
        Optional<Void> deletionResult = commentRepository.deleteByQuestion_QuestionIdAndCommentId(questionId, commentId);

        // then
        assertTrue(deletionResult.isPresent());
        // 여기에 추가 테스트 조건 추가 가능
    }
}
