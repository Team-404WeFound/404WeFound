package com.WeFound.WeFound.dto;
import com.WeFound.WeFound.entity.Answer;
import com.WeFound.WeFound.entity.Question;
import com.WeFound.WeFound.entity.User;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class AnswerRequestDto {
    private Long answer_id;
    private String content;
    private Long user_id;
    private Long question_id;
    private LocalDateTime create_at;
    private LocalDateTime update_at;

}
