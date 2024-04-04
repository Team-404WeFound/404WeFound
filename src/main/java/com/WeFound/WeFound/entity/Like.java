


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


@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
/*@IdClass(LikeId.class)*/
@Table(name = "likes")
public class Like  {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userId;

    @Id
    @Column(name = "question_id")
    private Long questionId;




    }

