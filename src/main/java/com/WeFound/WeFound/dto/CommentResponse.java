package com.WeFound.WeFound.dto;

import com.WeFound.WeFound.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Builder
public class CommentResponse {
    private Long commentId;
    private String content;
    private LocalDateTime createdAt;
    private Long userId;

    public CommentResponse toResponse(Comment comment){
        return new CommentResponse(
                comment.getCommentId(),
                comment.getContent(),
                comment.getCreatedAt(),
                comment.getUserId()
                );

    }
}
