package com.WeFound.WeFound.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "comment")
@NoArgsConstructor
@Getter
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "댓글식별자",updatable = false)
    private Long comment_id;

    @Column(name = "댓글내용",updatable = false)
    private String content;
    @Column(name = "작성자 식별자",updatable = false)
    private Long user_id;
    @Column(name = "게시글 식별자",updatable = false)
    private Long question_id;
    @Column(name = "답변 식별자",updatable = false)
    private Long answer_id;
    @Column(name = "생성 일시",updatable = false)
    private Long create_at;
    @Column(name = "수정 일시",updatable = false)
    private Long update_at;

    public Comment(String content,Long user_id,Long question_id,Long answer_id){
        this.content = content;
        this.user_id = user_id;
        this.question_id = question_id;
        this.answer_id = answer_id;
    }
}
