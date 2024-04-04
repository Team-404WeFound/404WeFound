package com.WeFound.WeFound.dto;

import com.WeFound.WeFound.entity.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
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
