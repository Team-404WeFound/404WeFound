package com.WeFound.WeFound.controller;

import com.WeFound.WeFound.dto.AddQuestionRequest;
import com.WeFound.WeFound.dto.QuestionResponse;
import com.WeFound.WeFound.entity.Question;
import com.WeFound.WeFound.service.QuestionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    //todo 게시판 생성
    @PostMapping("/questions")
    public ResponseEntity<QuestionResponse> addQuestion(@RequestBody AddQuestionRequest request){
        Question question = questionService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(question.toResponse());
    }
    //todo 게시판 조회
    //일반 버전
//    @GetMapping("/questions")
//    public ResponseEntity<List<QuestionResponse>> showQuestion(){
//        List<Question> questionList = questionService.findAll();
//        List<QuestionResponse> questionResponseList = questionList
//                .stream()
//                .map(QuestionResponse::new)
//                .toList();
//
//        return ResponseEntity.ok(questionResponseList);
//    }

    //paging 사용 버전
    @GetMapping("/questions")
    public ResponseEntity<Page<QuestionResponse>> getQuestions(Pageable pageable){
        Page<Question> questionPage = questionService.getPageableQuestions(pageable);
        Page<QuestionResponse> questionResponsePage = questionPage.map(QuestionResponse::new);
        return ResponseEntity.ok(questionResponsePage);
    }

    //todo 게시판 단권 조회
    @GetMapping("/questions/{question_id}")
    public ResponseEntity<QuestionResponse> showOneQuestion(@PathVariable Long question_id){
        Question question = questionService.findById(question_id);
        return ResponseEntity.ok(question.toResponse());
    }

    //todo 게시판 수정
    @PutMapping("/questions/{question_id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable Long question_id,
                                                   @RequestBody AddQuestionRequest request){
        questionService.update(question_id,request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    //todo 게시판 삭제

}
