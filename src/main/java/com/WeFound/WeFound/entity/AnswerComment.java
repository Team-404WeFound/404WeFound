package com.WeFound.WeFound.entity;

import com.WeFound.WeFound.dto.AnswerCommentResponse;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class AnswerComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerCommentId;

    @ManyToOne
    @JoinColumn(name = "answer_id")
    private Answer answer;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(name = "user_id")
    private Long userId;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    // 생성자, 필요한 필드 추가
    @Builder
    public AnswerComment(Answer answer, String content, Long userId){
        this.answer=answer;
        this.content=content;
        this.userId=userId;
    }
    public AnswerCommentResponse toResponse(){
        return AnswerCommentResponse.builder()
                .answerCommentId(answerCommentId)
                .content(content)
                .createdAt(createdAt)
                .userId(userId)
                .build();
    }
}