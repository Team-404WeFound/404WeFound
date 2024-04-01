package com.WeFound.WeFound.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Builder
public class CommentResponse {
    private Long comment_id;
    private String content;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
