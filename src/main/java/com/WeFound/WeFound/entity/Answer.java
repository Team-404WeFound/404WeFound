package com.WeFound.WeFound.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Table(name = "answer")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id",updatable = false)
    private Long answer_id;

    @Column(name = "content",updatable = false)
    private String content;

    @Column(name = "user_id",updatable = false)
    private Long user_id;

    @Column(name = "question_id",updatable = false)
    private Long question_id;

    @CreatedDate
    @Column(name = "create_at",updatable = false)
    private LocalDateTime create_at;

    @LastModifiedDate
    @Column(name = "update_at",updatable = false)
    private LocalDateTime update_at;

    public Answer(Long answer_id,String content,Long user_id,Long question_id,LocalDateTime create_at,LocalDateTime update_at){
        this.answer_id = answer_id;
        this.content = content;
        this.user_id = user_id;
        this.question_id = question_id;
        this.create_at = create_at;
        this.update_at = update_at;
    }

}
