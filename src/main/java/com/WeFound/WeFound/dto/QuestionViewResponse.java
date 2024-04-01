package com.WeFound.WeFound.dto;

import com.WeFound.WeFound.entity.Question;
import lombok.Getter;

@Getter
public class QuestionViewResponse {
    private Long questionId;
    private String title;
    private String content;

    public QuestionViewResponse(Question question){
        this.questionId = question.getQuestionId();
        this.title = question.getTitle();
        this.content = question.getContent();
    }
}
