package com.WeFound.WeFound.controller;

import com.WeFound.WeFound.dto.AddQuestionRequest;
import com.WeFound.WeFound.dto.QuestionResponse;
import com.WeFound.WeFound.entity.Question;
import com.WeFound.WeFound.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    //todo 게시판 생성
    @PostMapping("/api/questions")
    public ResponseEntity<QuestionResponse> addQuestion(@RequestBody AddQuestionRequest request){
        Question question = questionService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(question.toResponse());
    }
    //todo 게시판 조회
    //todo 게시판 수정
    //todo 게시판 삭제

}
