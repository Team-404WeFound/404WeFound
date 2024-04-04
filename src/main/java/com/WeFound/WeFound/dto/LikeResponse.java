package com.WeFound.WeFound.dto;



import com.WeFound.WeFound.entity.Like;

import lombok.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class LikeResponse {
    private  Long userId;
    private Long questionId;


    public LikeResponse(Like like) {
        this.userId= like.getUserId().getUserId();
        this.questionId = like.getQuestionId();

    }
}

