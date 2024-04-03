package com.WeFound.WeFound.dto;

import com.WeFound.WeFound.entity.Answer;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class AnswerResponseDTO {
    private Long answer_id;
    private String content;
    private Long user_id;
    private Long question_id;
    private LocalDateTime create_at;
    private LocalDateTime update_at;

    public AnswerResponseDTO(Answer answer){
        answer_id = answer.getAnswer_id();
        content = answer.getContent();
        user_id = answer.getUser().getUser_id();
        question_id = answer.getQuestion().getQuestion_id();
        create_at = answer.getCreate_at();
        update_at = answer.getUpdate_at();
    }

    public void setAnswerId(Long answer_id) {
        this.answer_id = answer_id;
    }
}
