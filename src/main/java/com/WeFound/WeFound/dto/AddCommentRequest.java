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
    public Comment toEntity(Question question) {
        return Comment.builder()
                .question_id(question.getQuestion_id())
                .content(content)
                .build();
    }
}
