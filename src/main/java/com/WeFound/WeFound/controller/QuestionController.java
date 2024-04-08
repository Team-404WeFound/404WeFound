package com.WeFound.WeFound.controller;

import com.WeFound.WeFound.dto.AddQuestionRequest;
import com.WeFound.WeFound.dto.CustomUserDetails;
import com.WeFound.WeFound.dto.QuestionResponse;
import com.WeFound.WeFound.entity.Question;
import com.WeFound.WeFound.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class QuestionController {
    private final QuestionService questionService;

    @PostMapping("/questions")
    public ResponseEntity<QuestionResponse> addQuestion(
            @RequestBody AddQuestionRequest request,
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {
        Long userId = userDetails.getUserId();
        request.setUserId(userId);
        Question question = questionService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(question.toResponse());
    }

    @PutMapping("/questions/{questionId}")
    public ResponseEntity<Question> updateQuestion(
            @PathVariable Long questionId,
            @RequestBody AddQuestionRequest request
    ) {
        questionService.update(questionId, request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/questions/{questionId}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long questionId) {
        questionService.delete(questionId);
        return ResponseEntity.ok().build();
    }
}