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

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PremiumQuestionController {
    private final PremiumQuestionService premiumQuestionService;


    @PostMapping("/premium-questions")
    public ResponseEntity<QuestionResponse> addQuestion(
            @RequestBody AddQuestionRequest request,
            @AuthenticationPrincipal CustomUserDetails userDetails) {
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


}