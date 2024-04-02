package com.WeFound.WeFound.controller;

import com.WeFound.WeFound.dto.AddCommentRequest;
import com.WeFound.WeFound.dto.AllCommentResponse;
import com.WeFound.WeFound.dto.CommentResponse;
import com.WeFound.WeFound.entity.Comment;
import com.WeFound.WeFound.service.CommentService;
import com.WeFound.WeFound.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;
    public CommentController(CommentService commentService, QuestionService questionService) {
        this.commentService = commentService;
    }

    // 질문 id 에 댓글 추가
    @PostMapping("/{questionId}")
    public ResponseEntity<CommentResponse> addComment(@PathVariable Long questionId,
                                                      @RequestBody AddCommentRequest request){
        Comment comment = commentService.save(questionId, request);
        return ResponseEntity.ok(comment.toResponse());
    }

    // 질문 id 에 해당하는 댓글 모두 조회
    @GetMapping("/{question_id}")
    public ResponseEntity<AllCommentResponse> getAllComments(@PathVariable Long question_id){
        AllCommentResponse allComments = commentService.findAllComments(question_id);
        return ResponseEntity.ok(allComments);
    }

    // 질문 id에 해당하고 선택된 comment id의 댓글 단권 조회
    @GetMapping("/{question_id}/{comment_id}")
    public ResponseEntity<CommentResponse> getComment(@PathVariable Long question_id,
                                                      @PathVariable Long comment_id){
        Comment comment = commentService.findComment(question_id, comment_id);
        return ResponseEntity.ok(comment.toResponse());
    }

    //todo 댓글 삭제

}
