package com.WeFound.WeFound.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Table(name = "favorite")
@NoArgsConstructor
@Getter
@Entity
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id",updatable = false)
    private Long userId;
    @Column(name = "question_id")
    private Long questionId;
    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Favorite(Long userId,Long questionId,LocalDateTime createdAt){
        this.userId = userId;
        this.questionId = questionId;
        this.createdAt = createdAt;
    }
}
