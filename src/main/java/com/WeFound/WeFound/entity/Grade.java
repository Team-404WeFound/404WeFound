package com.WeFound.WeFound.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Table(name = "grade")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_id",nullable = false)
    private Long grade_id;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "grade_name")
    private String grade_name;

    @Column(name = "min_point")
    private int min_point;

    @Column(name = "max_point")
    private int max_point;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime created_at;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updated_at;

    public Grade(Long grade_id,Long user_id,String grade_name,int min_point,int max_point,LocalDateTime created_at,LocalDateTime updated_at){
        this.grade_id = grade_id;
        this.user_id = user_id;
        this.grade_name = grade_name;
        this.min_point = min_point;
        this.max_point = max_point;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
