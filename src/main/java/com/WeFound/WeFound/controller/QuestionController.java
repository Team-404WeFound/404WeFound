package com.WeFound.WeFound.controller;

import com.WeFound.WeFound.dto.AddQuestionRequest;
import com.WeFound.WeFound.dto.QuestionResponse;
import com.WeFound.WeFound.entity.Question;
import com.WeFound.WeFound.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    //todo 게시판 생성
    @PostMapping("/api/posts")
    public ResponseEntity<QuestionResponse> addQuestion(@RequestBody AddQuestionRequest request){
        Question question = questionService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(question.toResponse());
    }

    //todo 게시판 조회
    @GetMapping("/api/questions")
    public ResponseEntity<List<QuestionResponse>> showQuestion(){
        List<Question> questionList = questionService.findAll();
        List<QuestionResponse> questionResponseList = questionList
                .stream()
                .map(QuestionResponse::new)
                .toList();

        return ResponseEntity.ok(questionResponseList);
    }

    //todo 게시판 단권 조회
    @GetMapping("/api/questions/{question_id}")
    public ResponseEntity<QuestionResponse> showOneQuestion(@PathVariable Long question_id){
        Question question = questionService.findById(question_id);
        return ResponseEntity.ok(question.toResponse());
    }

    //todo 게시판 수정
    //todo 게시판 삭제

}
