package com.WeFound.WeFound.dto;

import com.WeFound.WeFound.entity.Question;
import lombok.Getter;

@Getter
public class QuestionViewResponse {
    private Long question_id;
    private String title;
    private String content;

    public QuestionViewResponse(Question question){
        this.question_id = question.getQuestion_id();
        this.title = question.getTitle();
        this.content = question.getContent();
    }
}
