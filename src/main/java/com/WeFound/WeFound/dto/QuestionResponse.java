package com.WeFound.WeFound.dto;

import com.WeFound.WeFound.entity.Question;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionResponse {
    private int post_id;
    private int user_id;
    private String title;
    private String content;
    private int like_count;

    public QuestionResponse(Question question){
        post_id = question.getPost_id();
        user_id = question.getUser_id();
        title = question.getTitle();
        content = question.getContent();
        like_count = question.getLike_count();
    }
}
