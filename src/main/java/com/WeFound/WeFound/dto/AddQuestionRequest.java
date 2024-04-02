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
    private Long user_id;
    private Long question_id;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public Question toEntity(){
        return Question.builder()
                .title(title)
                .content(content)
                .question_id(question_id)
                .user_id(user_id)
                .build();
    }
}
