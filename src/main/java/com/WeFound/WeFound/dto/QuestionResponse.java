package com.WeFound.WeFound.dto;

import com.WeFound.WeFound.entity.Question;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionResponse {
    private Long questionId;
    private Long userId;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public QuestionResponse(Question question){
        questionId = question.getQuestionId();
        userId = question.getUserId();
        title = question.getTitle();
        content = question.getContent();
        createdAt = question.getCreatedAt();
        updatedAt = question.getUpdatedAt();
    }
}
