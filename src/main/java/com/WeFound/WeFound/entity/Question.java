package com.WeFound.WeFound.entity;

import com.WeFound.WeFound.dto.QuestionResponse;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id", updatable = false)
    private Long question_id;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime created_at;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updated_at;

    @Builder
    public Question(String title, String content, Long question_id, Long user_id, LocalDateTime created_at, LocalDateTime updated_at){
        this.title = title;
        this.content = content;
        this.question_id = question_id;
        this.user_id = user_id;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public QuestionResponse toResponse(){
        return QuestionResponse.builder()
                .title(title)
                .content(content)
                .created_at(created_at)
                .updated_at(updated_at)
                .build();
    }

    public Question update(String title, String content) {
        this.title = title;
        this.content = content;
        return this;
    }
}
