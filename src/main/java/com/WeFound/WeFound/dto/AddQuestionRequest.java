package com.WeFound.WeFound.dto;

import com.WeFound.WeFound.entity.Question;

public class AddQuestionRequest {
    private String title;
    private String content;

    public Question toEntity(){
        return Question.builder()
                .title(title)
                .content(content)
                .build();
    }
}
