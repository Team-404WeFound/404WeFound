package com.WeFound.WeFound.entity;

import com.WeFound.WeFound.dto.CommentResponse;
import com.WeFound.WeFound.dto.QuestionResponse;
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
    @Column(name = "commentId", updatable = false)
    private Long commentId;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "userId")
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "questionId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Question question;

    @Column(name = "answerId")
    private Long answerId;

    @CreatedDate
    @Column(name = "createAt")
    private LocalDateTime createAt;

    public Comment(String content,Long userId,Question question,Long answerId,LocalDateTime createAt){
        this.content = content;
        this.userId = userId;
        this.question = question;
        this.answerId = answerId;
        this.createAt = createAt;
    }

    @Builder
    public Comment(Question question, String content){
        this.question=question;
        this.content=content;
    }

    public CommentResponse toResponse(){
        return CommentResponse.builder()
                .commentId(commentId)
                .content(content)
                .createdAt(createAt)
                .build();
    }
}
