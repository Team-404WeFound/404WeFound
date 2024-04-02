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
    private Long comment_id;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "question_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Long question_id;

    @Column(name = "answer_id")
    private Long answer_id;

    @CreatedDate
    @Column(name = "create_at")
    private LocalDateTime create_at;

    @LastModifiedDate
    @Column(name = "update_at")
    private LocalDateTime update_at;

    public Comment(String content,Long user_id,Long question_id,Long answer_id,LocalDateTime create_at,LocalDateTime update_at){
        this.content = content;
        this.user_id = user_id;
        this.question_id = question_id;
        this.answer_id = answer_id;
        this.create_at = create_at;
        this.update_at = update_at;
    }

    @Builder
    public Comment(Long question_id, String content){
        this.question_id=question_id;
        this.content=content;
    }

    public CommentResponse toResponse(){
        return CommentResponse.builder()
                .comment_id(comment_id)
                .content(content)
                .created_at(create_at)
                .updated_at(update_at)
                .build();
    }
}
