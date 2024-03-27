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
    private Long question_id;
    private Long user_id;
    private String title;
    private String content;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public QuestionResponse(Question question){
        question_id = question.getQuestion_id();
        user_id = question.getUser_id();
        title = question.getTitle();
        content = question.getContent();
        created_at = question.getCreated_at();
        updated_at = question.getUpdated_at();
    }
}
