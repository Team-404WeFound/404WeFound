package com.WeFound.WeFound.dto;

import com.WeFound.WeFound.entity.Question;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionResponse {
    private int question_id;
    private int user_id;
    private String title;
    private String content;

    public QuestionResponse(Question question){
        question_id = question.getQuestion_id();
        user_id = question.getUser_id();
        title = question.getTitle();
        content = question.getContent();
    }
}
