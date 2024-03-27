package com.WeFound.WeFound.dto;

import com.WeFound.WeFound.entity.Question;

public class AddQuestionRequest {
    private String title;
    private String content;
    private Long user_id;
    private Long question_id;

    public Question toEntity(){
        return Question.builder()
                .title(title)
                .content(content)
                .question_id(question_id)
                .user_id(user_id)
                .build();
    }
}
