package com.WeFound.WeFound.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "유저아이디", updatable = false)
    private int id;

    @Column(name = "이메일", nullable = false, unique = true)
    private String email;

    @Column(name = "비밀번호", nullable = false)
    private String password;

    @Column(name = "등급", nullable = false)
    private int rank;

    @Column(name = "닉네임", nullable = false)
    private String name;

    @Column(name = "집주소", nullable = false)
    private String Field;

    @Column(name = "디스코드채널아이디", nullable = false)
    private String Field2;

}