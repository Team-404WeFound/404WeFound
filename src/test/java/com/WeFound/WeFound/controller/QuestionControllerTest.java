package com.WeFound.WeFound.controller;

import com.WeFound.WeFound.dto.AddQuestionRequest;
import com.WeFound.WeFound.dto.QuestionResponse;
import com.WeFound.WeFound.entity.Question;
import com.WeFound.WeFound.service.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application.properties")
class QuestionControllerTest {

    @InjectMocks
    QuestionController questionController;

    @Mock
    QuestionService questionService;

    // 각 테스트 전에 실행되는 메서드
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

/*    // addQuestion 메서드에 대한 테스트
    @Test
    @DisplayName("addQuestion 메서드 테스트")
    void addQuestion() {
        AddQuestionRequest request = new AddQuestionRequest();
        Question question = new Question();

        when(questionService.save(request)).thenReturn(question);

//문제부분
        ResponseEntity<QuestionResponse> response = questionController.addQuestion(request);

        verify(questionService, times(1)).save(request);
        assertEquals(question.toResponse(), response.getBody());
    }*/

    // showOneQuestion 메서드에 대한 테스트
    @Test
    @DisplayName("showOneQuestion 메서드 테스트")
    void showOneQuestion() {
        Long questionId = 1L;
        Question question = new Question();

        when(questionService.findById(questionId)).thenReturn(question);

        ResponseEntity<QuestionResponse> response = questionController.showOneQuestion(questionId);

        verify(questionService, times(1)).findById(questionId);
        assertEquals(question.toResponse(), response.getBody());
    }

    // updateQuestion 메서드에 대한 테스트
    @Test
    @DisplayName("updateQuestion 메서드 테스트")
    void updateQuestion() {
        Long questionId = 1L;
        AddQuestionRequest request = new AddQuestionRequest();

        ResponseEntity<Question> response = questionController.updateQuestion(questionId, request);

        verify(questionService, times(1)).update(questionId, request);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    // deleteQuestion 메서드에 대한 테스트
    @Test
    @DisplayName("deleteQuestion 메서드 테스트")
    void deleteQuestion() {
        Long questionId = 1L;

        ResponseEntity<Void> response = questionController.deleteQuestion(questionId);

        verify(questionService, times(1)).delete(questionId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
