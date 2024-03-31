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

/*
--> 좋아요

1. 사용자가 게시글 상세 페이지에서 좋아요 버튼을 클릭한다. -> bt 클릭시 좋아요+1
2. 시스템은 해당 게시글의 좋아요 수를 증가시킨다.
3. 시스템은 사용자의 좋아요 목록에 해당 게시글을 추가한다.
4. 시스템은 변경된 좋아요 수를 게시글 상세 페이지에 반영한다.
5. 좋아요를 받을 시 점수를 받음 -> 댓글에 좋아요가 붙은 수만큼 점수를 얻는다.

 */
