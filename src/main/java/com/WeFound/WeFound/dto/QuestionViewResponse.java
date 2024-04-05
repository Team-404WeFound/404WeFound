package com.WeFound.WeFound.dto;

import com.WeFound.WeFound.entity.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class QuestionViewResponse {
    private Long questionId;
    private String title;
    private String content;
    private LocalDateTime creatAt;
    private Long userId;

    public QuestionViewResponse(Question question){
        this.questionId = question.getQuestionId();
        this.title = question.getTitle();
        this.content = question.getContent();
        this.creatAt = question.getCreatedAt();
        this.userId = question.getUserId();
    }
}
