


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
    private  Long user;
    private Long questionId;


    public LikeResponse(Like like) {
        this.user = like.getUser().getUserId();
        this.questionId = like.getQuestionId();

    }
}

