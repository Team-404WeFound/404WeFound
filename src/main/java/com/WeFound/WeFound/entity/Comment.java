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

    @ManyToOne
    @JoinColumn(name = "question_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Question question;


    @CreatedDate
    @Column(name = "create_at")
    private LocalDateTime createdAt;

    @Builder
    public Comment(Question question, String content, Long userId){
        this.question=question;
        this.content=content;
        this.userId=userId;
    }

    public CommentResponse toResponse(){
        return CommentResponse.builder()
                .commentId(commentId)
                .content(content)
                .createdAt(createdAt)
                .userId(userId)
                .build();
    }

}
