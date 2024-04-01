package com.WeFound.WeFound.dto;

import com.WeFound.WeFound.entity.Answer;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Getter
@NoArgsConstructor

public class AnswerResponseDTO {
    private Long answer_id;
    private String content;
    private Long user_id;
    private Long question_id;
    private LocalDateTime create_at;
    private LocalDateTime update_at;
    @Builder
    public AnswerResponseDTO(Answer answer){
        this.answer_id = answer_id;
        this.content = content;
        this.user_id = user_id;
        this.question_id = question_id;
        this.create_at = create_at;
        this.update_at = update_at;
    }

    public void setAnswerId(Long answer_id) {
        this.answer_id = answer_id;
    }
}
