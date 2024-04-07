package com.WeFound.WeFound.service;

import com.WeFound.WeFound.dto.AddCommentRequest;
import com.WeFound.WeFound.dto.AllCommentResponse;
import com.WeFound.WeFound.dto.CommentResponse;
import com.WeFound.WeFound.entity.Comment;
import com.WeFound.WeFound.entity.Question;
import com.WeFound.WeFound.repository.CommentRepository;
import com.WeFound.WeFound.repository.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application.properties")
@DisplayName("CommentService 테스트")
class CommentServiceTest {

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private QuestionRepository questionRepository;

    private Question testQuestion;
    private Comment testComment;



    @BeforeEach
    void setUp() {
        testQuestion = new Question(
                "Test Question Title", "Test Question Content",  1L,1L,
                LocalDateTime.now(), LocalDateTime.now());
        testComment = new Comment(testQuestion, "Test Comment Content");
    }

    @Test
    @DisplayName("댓글 저장 테스트")
    void saveComment() {
        // Given
        AddCommentRequest request = new AddCommentRequest("Test Comment Content");
        when(questionRepository.findById(testQuestion.getQuestionId())).thenReturn(Optional.of(testQuestion));
        when(commentRepository.save(any(Comment.class))).thenReturn(testComment);

        // When
        Comment savedComment = commentService.save(testQuestion.getQuestionId(), request);

        // Then
        assertNotNull(savedComment);
        assertEquals(testComment.getCommentId(), savedComment.getCommentId());
        assertEquals(testComment.getQuestion(), savedComment.getQuestion());
        assertEquals(testComment.getContent(), savedComment.getContent());
        //assertNotNull(savedComment.getCreatedAt());
    }

    @Test
    @DisplayName("댓글 저장 시, 해당하는 질문이 존재하지 않을 경우 IllegalArgumentException 발생")
    void saveCommentQuestionNotExist() {
        // Given
        AddCommentRequest request = new AddCommentRequest("Test Comment Content");
        when(questionRepository.findById(testQuestion.getQuestionId())).thenReturn(Optional.empty());

        // When / Then
        assertThrows(IllegalArgumentException.class, () -> commentService.save(testQuestion.getQuestionId(), request));
    }

    @Test
    @DisplayName("댓글 조회 테스트")
    void findComment() {
        // Given
        when(commentRepository.findByQuestion_QuestionIdAndCommentId(testQuestion.getQuestionId(), testComment.getCommentId()))
                .thenReturn(Optional.of(testComment));

        // When
        Comment foundComment = commentService.findComment(testQuestion.getQuestionId(), testComment.getCommentId());

        // Then
        assertNotNull(foundComment);
        assertEquals(testComment.getCommentId(), foundComment.getCommentId());
        assertEquals(testComment.getQuestion(), foundComment.getQuestion());
        assertEquals(testComment.getContent(), foundComment.getContent());
      //  assertNotNull(foundComment.getCreatedAt());
    }

    @Test
    @DisplayName("댓글 조회 시, 해당하는 댓글이 존재하지 않을 경우 IllegalArgumentException 발생")
    void findCommentNotExist() {
        // Given
        when(commentRepository.findByQuestion_QuestionIdAndCommentId(testQuestion.getQuestionId(), testComment.getCommentId()))
                .thenReturn(Optional.empty());

        // When / Then
        assertThrows(IllegalArgumentException.class, () -> commentService.findComment(testQuestion.getQuestionId(), testComment.getCommentId()));
    }

    @Test
    @DisplayName("질문에 속한 모든 댓글 조회 테스트")
    void findAllComments() {
        // Given
        List<Comment> commentList = new ArrayList<>();
        commentList.add(testComment);
        when(commentRepository.findByQuestion_QuestionId(testQuestion.getQuestionId())).thenReturn(Optional.of(commentList));

        // When
        AllCommentResponse allCommentResponse = commentService.findAllComments(testQuestion.getQuestionId());

        // Then
        assertNotNull(allCommentResponse);
       // assertEquals(testQuestion, allCommentResponse.getQuestion());
        assertFalse(allCommentResponse.getComments().isEmpty());
        assertEquals(1, allCommentResponse.getComments().size());
        CommentResponse commentResponse = allCommentResponse.getComments().get(0);
        assertEquals(testComment.getCommentId(), commentResponse.getCommentId());
        assertEquals(testComment.getContent(), commentResponse.getContent());
        assertNotNull(commentResponse.getCreatedAt());
    }

    @Test
    @DisplayName("질문에 속한 모든 댓글 조회 시, 해당하는 댓글이 존재하지 않을 경우 IllegalArgumentException 발생")
    void findAllCommentsNotExist() {
        // Given
        when(commentRepository.findByQuestion_QuestionId(testQuestion.getQuestionId())).thenReturn(Optional.empty());

        // When / Then
        assertThrows(IllegalArgumentException.class, () -> commentService.findAllComments(testQuestion.getQuestionId()));
    }

    @Test
    @DisplayName("댓글 삭제 테스트")
    void deleteComment() {
        // Given
//        when(commentRepository.deleteByQuestion_QuestionIdAndCommentId(testQuestion.getQuestionId(), testComment.getCommentId()))
//                .thenReturn((Optional<Void>) Optional.of(1L));

        // When / Then
        assertDoesNotThrow(() -> commentService.deleteComment(testQuestion.getQuestionId(), testComment.getCommentId()));
    }

    @Test
    @DisplayName("댓글 삭제 시, 해당하는 댓글이 존재하지 않을 경우 IllegalArgumentException 발생")
    void deleteCommentNotExist() {
        // Given
        when(commentRepository.deleteByQuestion_QuestionIdAndCommentId(testQuestion.getQuestionId(), testComment.getCommentId()))
                .thenReturn(Optional.empty());

        // When /

        assertThrows(IllegalArgumentException.class, () -> commentService.deleteComment(testQuestion.getQuestionId(), testComment.getCommentId()));
    }
}