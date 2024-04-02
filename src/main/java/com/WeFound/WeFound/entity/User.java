package com.WeFound.WeFound.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;

@Table(name = "users")
@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", updatable = false)
    private Long userId;

    @Column(name = "email", nullable = false, unique = true) // 로그인, 중복 불가
    private String email;

    @Column(name = "password", nullable = false, unique = true) // 로그인
    private String password;

    @Column(name = "nickname",nullable = false, unique = true)
    private String nickName;

    @Column(name = "role",nullable = false)  // 역할 (관리자 or 일반 사용자)
    private String role;

    @Column(name = "grade")
    private String grade;

    @Column(name = "point")
    private Long point;

    @CreatedDate
    @Column(name = "create_at")
    private LocalDateTime createAt;

    @LastModifiedDate
    @Column(name = "update_at")
    private LocalDateTime updateAt;

    public User() {

    }

}