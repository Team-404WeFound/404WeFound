package com.WeFound.WeFound.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(name = "create_at",updatable = false)
    private LocalDateTime create_at;
    @Column(name = "update_at",updatable = false)
    private LocalDateTime update_at;

}
