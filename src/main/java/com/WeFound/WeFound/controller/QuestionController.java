package com.WeFound.WeFound.controller;

import com.WeFound.WeFound.dto.AddQuestionRequest;
import com.WeFound.WeFound.dto.CustomUserDetails;
import com.WeFound.WeFound.dto.QuestionResponse;
import com.WeFound.WeFound.entity.Question;
import com.WeFound.WeFound.entity.User;
import com.WeFound.WeFound.service.AdminService;
import com.WeFound.WeFound.service.QuestionService;
import com.WeFound.WeFound.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class QuestionController {
    private final QuestionService questionService;
    private final UserService userService;
    private final AdminService adminService;

    public QuestionController(QuestionService questionService, UserService userService,AdminService adminService) {
        this.questionService = questionService;
        this.userService = userService;
        this.adminService = adminService;
    }

    //todo 게시판 생성
    //userid 있는 버전
    @PostMapping("/questions")
    public ResponseEntity<QuestionResponse> addQuestion(@RequestBody AddQuestionRequest request, @AuthenticationPrincipal CustomUserDetails userDetails){

        Long userId = userDetails.getUserId();
        request.setUserId(userId);
        Question question = questionService.save(request);

        // AddQuestionRequest가 실행되었을 때 reason 값을 "QuestionController"로 전달합니다.
        adminService.updateUserPoint(userId, 10L, "QuestionController");
        return ResponseEntity.status(HttpStatus.CREATED).body(question.toResponse());
    }

    //////////userid 없는 버전///////////////////////
//    @PostMapping("/questions")
//    public ResponseEntity<QuestionResponse> addQuestion(@RequestBody AddQuestionRequest request){
//        Question question = questionService.save(request);
//        return ResponseEntity.status(HttpStatus.CREATED).body(question.toResponse());
//    }

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
//    @GetMapping("/questions")
//    public ResponseEntity<Page<QuestionResponse>> getQuestions(Pageable pageable){
//        Page<Question> questionPage = questionService.getPageableQuestions(pageable);
//        Page<QuestionResponse> questionResponsePage = questionPage.map(QuestionResponse::new);
//        return ResponseEntity.ok(questionResponsePage);
//    }

    //todo 게시판 단권 조회
//    @GetMapping("/questions/{questionId}")
//    public ResponseEntity<QuestionResponse> showOneQuestion(@PathVariable Long questionId){
//        Question question = questionService.findById(questionId);
//        return ResponseEntity.ok(question.toResponse());
//    }

    //todo 게시판 수정
    @PutMapping("/questions/{questionId}")
    public ResponseEntity<Question> updateQuestion(@PathVariable Long questionId,
                                                   @RequestBody AddQuestionRequest request){
        questionService.update(questionId,request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    //todo 게시판 삭제
    @DeleteMapping("/questions/{questionId}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long questionId){
        questionService.delete(questionId);
        return ResponseEntity.ok().build();
    }

}
