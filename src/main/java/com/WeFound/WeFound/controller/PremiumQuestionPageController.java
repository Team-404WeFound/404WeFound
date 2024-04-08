package com.WeFound.WeFound.controller;

import com.WeFound.WeFound.dto.AddQuestionRequest;
import com.WeFound.WeFound.dto.CustomUserDetails;
import com.WeFound.WeFound.dto.QuestionResponse;
import com.WeFound.WeFound.service.PremiumQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/premium-questions")
public class PremiumQuestionPageController {
    private final PremiumQuestionService premiumQuestionService;

    @GetMapping
    public String premiumQuestions(Model model) {
        model.addAttribute("questions", premiumQuestionService.findAll());
        return "premium-questions";
    }

    @GetMapping("/{questionId}")
    public String premiumQuestionDetail(@PathVariable Long questionId, Model model, @AuthenticationPrincipal CustomUserDetails details) {
        model.addAttribute("question", premiumQuestionService.findById(questionId));
        Long userId = premiumQuestionService.findUserIdByQuestionId(questionId);
        model.addAttribute("user", userId);
        // 댓글, 답변 등의 추가 정보를 모델에 담아서 전달
        return "premium-question-detail";
    }

    @PostMapping
    public ResponseEntity<QuestionResponse> addQuestion(@RequestBody AddQuestionRequest request, @AuthenticationPrincipal CustomUserDetails userDetails) {
        Long userId = userDetails.getUserId();
        request.setUserId(userId);
        QuestionResponse questionResponse = premiumQuestionService.save(request).toResponse();
        return ResponseEntity.status(HttpStatus.CREATED).body(questionResponse);
    }

    @PutMapping("/{questionId}")
    public ResponseEntity<Void> updateQuestion(@PathVariable Long questionId, @RequestBody AddQuestionRequest request) {
        premiumQuestionService.update(questionId, request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{questionId}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long questionId) {
        premiumQuestionService.delete(questionId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // 프리미엄 질문 작성 페이지로 이동
    @GetMapping("/new")
    public String newPremiumQuestion() {
        return "premium-question-form";
    }
}