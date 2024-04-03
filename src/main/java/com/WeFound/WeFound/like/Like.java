


package com.WeFound.WeFound.like;


import com.WeFound.WeFound.entity.Question;
import com.WeFound.WeFound.entity.User;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import static jakarta.persistence.FetchType.LAZY;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "like")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_Id")
    private Long id;



    @ManyToOne(fetch = LAZY)
//다대일 @ManyToOne 관계로 매핑
// 패치 타입 LAZY 설정
    @JoinColumn(name = "user_id")
//Entity의 연관관계에서 외래 키를 매핑
    private User user;



    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "question_id")
    private Question question;



    @Builder
//생성자나 정적 팩터리가 처리해야 할 매개변수가 많다면

    public Like(User user, Question question) {
        this.user = user;
        this.question = question;
    }
}
