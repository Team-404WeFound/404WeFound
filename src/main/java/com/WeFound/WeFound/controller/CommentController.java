package com.WeFound.WeFound.controller;

import com.WeFound.WeFound.dto.AddCommentRequest;
import com.WeFound.WeFound.dto.AllCommentResponse;
import com.WeFound.WeFound.dto.CommentResponse;
import com.WeFound.WeFound.dto.CustomUserDetails;
import com.WeFound.WeFound.entity.Comment;
import com.WeFound.WeFound.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/questions/{questionId}")
    public ResponseEntity<CommentResponse> addComment(
            @PathVariable Long questionId,
            @RequestBody AddCommentRequest request,
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {
        Comment comment = commentService.save(questionId, request, userDetails.getUserId());
        return ResponseEntity.ok(comment.toResponse());
    }

    @GetMapping("/questions/{question_id}/comment")
    public ResponseEntity<AllCommentResponse> getAllComments(@PathVariable Long question_id) {
        AllCommentResponse allComments = commentService.findAllComments(question_id);
        return ResponseEntity.ok(allComments);
    }

    @GetMapping("/questions/{question_id}/{comment_id}")
    public ResponseEntity<CommentResponse> getComment(
            @PathVariable Long question_id,
            @PathVariable Long comment_id
    ) {
        Comment comment = commentService.findComment(question_id, comment_id);
        return ResponseEntity.ok(comment.toResponse());
    }

    @DeleteMapping("/questions/{question_id}/{comment_id}")
    public ResponseEntity<Void> deleteComment(
            @PathVariable Long question_id,
            @PathVariable Long comment_id
    ) {
        commentService.deleteComment(question_id, comment_id);
        return ResponseEntity.ok().build();
    }
}