package com.WeFound.WeFound.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "comment")
@NoArgsConstructor
@Getter
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id",updatable = false)
    private Long comment_id;
    @Column(name = "content",updatable = false)
    private String content;
    @Column(name = "user_id",updatable = false)
    private Long user_id;
    @Column(name = "question_id",updatable = false)
    private Long question_id;
    @Column(name = "answer_id",updatable = false)
    private Long answer_id;
    @Column(name = "create_at",updatable = false)
    private LocalDateTime create_at;
    @Column(name = "update_at",updatable = false)
    private LocalDateTime update_at;

    public Comment(String content,Long user_id,Long question_id,Long answer_id){
        this.content = content;
        this.user_id = user_id;
        this.question_id = question_id;
        this.answer_id = answer_id;
    }
}
