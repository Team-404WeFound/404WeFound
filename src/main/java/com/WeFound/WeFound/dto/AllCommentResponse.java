package com.WeFound.WeFound.dto;

import com.WeFound.WeFound.entity.Question;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class AllCommentResponse {
    private Long question_id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private List<CommentResponse> comments;

    public AllCommentResponse(Question question, List<CommentResponse> comments){
        this.question_id = question.getQuestion_id();
        this.title = question.getTitle();
        this.content = question.getContent();
        this.createdAt = question.getCreated_at();
        this.comments = comments;
    }
}
