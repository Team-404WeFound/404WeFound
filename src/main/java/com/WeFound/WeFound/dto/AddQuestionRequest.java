package com.WeFound.WeFound.dto;

import com.WeFound.WeFound.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddQuestionRequest {
    private String title;
    private String content;
    private Long userId;
    private Long questionId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Question toEntity(){
        return Question.builder()
                .title(title)
                .content(content)
                .questionId(questionId)
                .userId(userId)
                .build();
    }
}
