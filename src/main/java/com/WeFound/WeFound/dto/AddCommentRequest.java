package com.WeFound.WeFound.dto;

import com.WeFound.WeFound.entity.Comment;
import com.WeFound.WeFound.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddCommentRequest {
    private String content;
    private Long userId;
    public Comment toEntity(Question question, String content, Long userId) {
        return Comment.builder()
                .question(question)
                .content(content)
                .userId(userId)
                .build();
    }
}
