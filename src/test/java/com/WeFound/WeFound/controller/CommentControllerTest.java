package com.WeFound.WeFound.controller;

import com.WeFound.WeFound.dto.AddCommentRequest;
import com.WeFound.WeFound.dto.AllCommentResponse;
import com.WeFound.WeFound.dto.CommentResponse;
import com.WeFound.WeFound.entity.Comment;
import com.WeFound.WeFound.service.CommentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
@Transactional
class CommentControllerTest {

    @InjectMocks
    CommentController commentController;

    @Mock
    CommentService commentService;


    @BeforeEach
    @DisplayName("각 테스트 전에 실행되는 메서드")
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    @DisplayName("addComment 메서드에 대한 테스트")
    void addComment() {
        Long questionId = 1L;
        AddCommentRequest request = new AddCommentRequest();
        Comment comment = new Comment();

        when(commentService.save(questionId, request)).thenReturn(comment);
        ResponseEntity<CommentResponse> response = commentController.addComment(questionId, request);

        verify(commentService, times(1)).save(questionId, request);
        assertEquals(comment.toResponse(), response.getBody());
    }


    @Test
    @DisplayName("getAllComments 메서드에 대한 테스트")
    void getAllComments() {
        Long questionId = 1L;
        AllCommentResponse allComments = new AllCommentResponse();

        when(commentService.findAllComments(questionId)).thenReturn(allComments);

        ResponseEntity<AllCommentResponse> response = commentController.getAllComments(questionId);

        verify(commentService, times(1)).findAllComments(questionId);
        assertEquals(allComments, response.getBody());
    }



    @Test
    @DisplayName("getComment 메서드에 대한 테스트")
    void getComment() {
        Long questionId = 1L;
        Long commentId = 1L;
        Comment comment = new Comment();

        when(commentService.findComment(questionId, commentId)).thenReturn(comment);

        ResponseEntity<CommentResponse> response = commentController.getComment(questionId, commentId);

        verify(commentService, times(1)).findComment(questionId, commentId);
        assertEquals(comment.toResponse(), response.getBody());
    }



    @Test
    @DisplayName("deleteComment 메서드에 대한 테스트")
    void deleteComment() {
        Long questionId = 1L;
        Long commentId = 1L;

        ResponseEntity<Void> response = commentController.deleteComment(questionId, commentId);

        verify(commentService, times(1)).deleteComment(questionId, commentId);
        assertEquals(ResponseEntity.ok().build(), response);
    }


}
