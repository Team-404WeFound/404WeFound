package com.WeFound.WeFound.entity;

import com.WeFound.WeFound.entity.Question;
import com.WeFound.WeFound.entity.User;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import static jakarta.persistence.FetchType.LAZY;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "likes")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    @Column(nullable = false)
    private boolean status; // true = 좋아요, false = 좋아요 취소

    public Like(User user, Question question) {
        this.user = user;
        this.question = question;
        this.status = true;
    }

    public void toggleLike() {
        this.status = !this.status;
    }
}
