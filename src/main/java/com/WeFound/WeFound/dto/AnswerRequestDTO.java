package com.WeFound.WeFound.dto;

import com.WeFound.WeFound.entity.Answer;
import com.WeFound.WeFound.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnswerRequestDTO {

    private String content;


}
