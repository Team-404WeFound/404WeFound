package com.WeFound.WeFound.dto;

import com.WeFound.WeFound.entity.Question;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AllCommentResponse {
    private Long questionId;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private List<CommentResponse> comments;
    private Long userId;








    public AllCommentResponse(Question question, List<CommentResponse> comments){
        this.questionId = question.getQuestionId();
        this.title = question.getTitle();
        this.content = question.getContent();
        this.createdAt = question.getCreatedAt();
        this.comments = comments;
        this.userId = getUserId();
    }
}
