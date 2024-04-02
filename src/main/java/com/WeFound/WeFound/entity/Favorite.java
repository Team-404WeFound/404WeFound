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
    private Long user_id;
    @Column(name = "question_id")
    private Long question_id;
    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime created_at;

    public Favorite(Long user_id,Long question_id,LocalDateTime created_at){
        this.user_id = user_id;
        this.question_id = question_id;
        this.created_at = created_at;
    }
}
