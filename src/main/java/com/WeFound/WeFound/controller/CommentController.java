package com.WeFound.WeFound.controller;

import com.WeFound.WeFound.dto.AddCommentRequest;
import com.WeFound.WeFound.dto.CommentResponse;
import com.WeFound.WeFound.entity.Comment;
import com.WeFound.WeFound.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    //todo 댓글 생성
    @PostMapping("/{question_id}")
    public ResponseEntity<CommentResponse> addComment(@PathVariable Long question_id,
                                                      @RequestBody AddCommentRequest request){
        Comment comment = commentService.save(question_id, request);
        return ResponseEntity.ok(comment.toResponse());
    }

    //todo 댓글 조회
    //todo 댓글 수정
    //todo 댓글 삭제
}
