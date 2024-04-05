


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

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @Column(name = "question_id")
    private Long questionId;

    @Column(nullable = false)
    private boolean status; // true = 좋아요, false = 좋아요 취소

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate createDate; // 날짜


    public Like(User user, Long questionId) {

        this.user = user;
        this.questionId = questionId;

        this.status = true;
    }
}
   /* public void unLikeBoard( User user , Long questionId ) {
        this.status = false;
        questionId.setLiked(questionId.getLiked() - 1);
    }
*/






