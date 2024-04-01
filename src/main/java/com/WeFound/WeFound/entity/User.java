package com.WeFound.WeFound.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import com.WeFound.WeFound.dto.AddUserdto;
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
    private int id;

    @Column(name = "email", nullable = false, unique = true) // 로그인, 중복 불가
    private String email;

    @Column(name = "password", nullable = false, unique = true) // 로그인
    private String password;

    @Column(name = "nickname",nullable = false, unique = true)
    private String nickname;

    @Column(name = "role",nullable = false)
    private String role;

    @CreatedDate
    @Column(name = "create_at")
    private LocalDateTime create_at;

    @LastModifiedDate
    @Column(name = "update_at")
    private LocalDateTime update_at;

    public User() {

    }

    public static User toUser(AddUserdto addUserdto){
        User toUser = new User();
        toUser.setId(addUserdto.getId());
        toUser.setEmail(addUserdto.getEmail());
        toUser.setPassword(addUserdto.getPassword());
        return toUser;
    }
}