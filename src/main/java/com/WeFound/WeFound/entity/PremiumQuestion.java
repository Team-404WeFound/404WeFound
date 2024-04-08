package com.WeFound.WeFound.entity;

import com.WeFound.WeFound.dto.QuestionResponse;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class PremiumQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "premium_question_id", updatable = false)
    private Long premiumQuestionId;

    @Setter
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Builder
    public PremiumQuestion(String title, String content, Long premiumQuestionId, Long userId, LocalDateTime createdAt, LocalDateTime updatedAt){
        this.title = title;
        this.content = content;
        this.premiumQuestionId = premiumQuestionId;
        this.userId = userId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public QuestionResponse toResponse(){
        return QuestionResponse.builder()
                .title(title)
                .content(content)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }

    public PremiumQuestion update(String title, String content) {
        this.title = title;
        this.content = content;
        return this;
    }
}