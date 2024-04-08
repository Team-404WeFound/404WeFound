package com.WeFound.WeFound.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AllAnswerCommentResponse {
    private List<AnswerCommentResponse> answerComments;

    public AllAnswerCommentResponse(List<AnswerCommentResponse> answerComments){
        this.answerComments = answerComments;
    }
}