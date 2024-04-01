package com.WeFound.WeFound.entity;

import com.WeFound.WeFound.dto.CommentResponse;
import com.WeFound.WeFound.service.QuestionService;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)

public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id", updatable = false)
    private Long commentId;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "question_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Long questionId;

    @Column(name = "answer_id")
    private Long answerId;

    @CreatedDate
    @Column(name = "create_at")
    private LocalDateTime createAt;

    @LastModifiedDate
    @Column(name = "update_at")
    private LocalDateTime updateAt;

    public Comment(String content,Long userId,Long questionId,Long answerId,LocalDateTime createAt,LocalDateTime updateAt){
        this.content = content;
        this.userId = userId;
        this.questionId = questionId;
        this.answerId = answerId;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    @Builder
    public Comment(Long questionId, String content){
        this.questionId=questionId;
        this.content=content;
    }

    public CommentResponse toResponse(){
        return CommentResponse.builder()
                .commentId(commentId)
                .content(content)
                .createdAt(createAt)
                .updatedAt(updateAt)
                .build();
    }
}
