package com.WeFound.WeFound.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AnswerCommentResponse {
    private Long answerCommentId;
    private String content;
    private LocalDateTime createdAt;
    private Long userId;

public AnswerCommentResponse toResponse(AnswerCommentResponse answerCommentResponse, Long answerCommentId, String content, LocalDateTime createdAt, Long userId){
        return new AnswerCommentResponse(
                answerCommentResponse.getAnswerCommentId(),
                answerCommentResponse.getContent(),
                answerCommentResponse.getCreatedAt(),
                answerCommentResponse.getUserId()
        );
    }
}