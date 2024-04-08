package com.WeFound.WeFound.controller;

import com.WeFound.WeFound.dto.AddAnswerCommentRequest;
import com.WeFound.WeFound.dto.AnswerCommentResponse;
import com.WeFound.WeFound.dto.CustomUserDetails;
import com.WeFound.WeFound.entity.AnswerComment;
import com.WeFound.WeFound.service.AnswerCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AnswerCommentController {
    private final AnswerCommentService answerCommentService;

    @PostMapping("/answers/{answerId}/answerComments")
    public ResponseEntity<AnswerCommentResponse> createAnswerComment(@PathVariable Long answerId, @RequestBody AddAnswerCommentRequest request, @AuthenticationPrincipal CustomUserDetails userDetails) {
        AnswerComment answerComment = answerCommentService.createAnswerComment(answerId, request.getContent(), userDetails.getUserId());
        return ResponseEntity.ok(answerComment.toResponse());
    }

    @GetMapping("/answers/{answerId}/answerComments")
    public ResponseEntity<List<AnswerCommentResponse>> getAnswerCommentsByAnswer(@PathVariable Long answerId) {
        List<AnswerComment> answerComments = answerCommentService.getAnswerCommentsByAnswer(answerId);
        List<AnswerCommentResponse> response = answerComments.stream()
                .map(AnswerComment::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }
}