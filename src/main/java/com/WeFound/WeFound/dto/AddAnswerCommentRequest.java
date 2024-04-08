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
    private Long userId;

    public AnswerComment toEntity(Answer answer, String content, Long userId) {
        return AnswerComment.builder()
                .answer(answer)
                .content(content)
                .userId(userId)
                .build();
    }
}