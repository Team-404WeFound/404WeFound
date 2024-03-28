package com.WeFound.WeFound.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Table(name = "like")
@NoArgsConstructor
@Getter
@Entity
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id",updatable = false)
    private Long user_id;

    @Column(name = "question_id")
    private Long question_id;

    @Column(name = "answer_id")
    private Long answer_id;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime created_at;

    public Like(Long user_id,Long question_id,Long answer_id,LocalDateTime created_at){
        this.user_id = user_id;
        this.question_id = question_id;
        this.answer_id = answer_id;
        this.created_at = created_at;
    }
}
