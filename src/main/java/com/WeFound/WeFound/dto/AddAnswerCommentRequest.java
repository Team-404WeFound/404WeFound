package com.WeFound.WeFound.dto;

import com.WeFound.WeFound.entity.Answer;
import com.WeFound.WeFound.entity.AnswerComment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddAnswerCommentRequest {
    private String content;

    public AnswerComment toEntity(Answer answer) {
        return AnswerComment.builder()
                .answer(answer)
                .content(content)
                .build();
    }
}