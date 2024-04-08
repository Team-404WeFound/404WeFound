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
    private Long gradeId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "grade_name")
    private String gradeName;

    @Column(name = "min_point")
    private int minPoint;

    @Column(name = "max_point")
    private int maxPoint;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Grade(Long gradeId,Long userId,String gradeName,int minPoint,int maxPoint,LocalDateTime createdAt,LocalDateTime updatedAt){
        this.gradeId = gradeId;
        this.userId = userId;
        this.gradeName = gradeName;
        this.minPoint = minPoint;
        this.maxPoint = maxPoint;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
