package com.WeFound.WeFound.dto;


import com.WeFound.WeFound.entity.Answer;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class AnswerResponseDto {
    private Long answer_id;
    private String content;
    private Long user_id;
    private Long question_id;
    private LocalDateTime create_at;
    private LocalDateTime update_at;

    public AnswerResponseDto(Answer answer){
        answer_id = answer.getAnswer_id();
        content = answer.getContent();
        user_id = answer.getUser().getUserId();
        question_id = answer.getQuestion().getQuestionId();
        create_at = answer.getCreate_at();
        update_at = answer.getUpdate_at();
    }

    public void setAnswerId(Long answer_id) {
        this.answer_id = answer_id;
    }
}
