package com.WeFound.WeFound.entity;

import com.WeFound.WeFound.dto.AddUserdto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
public class User {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private int id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;
/*
    @Column(name = "nickname",nullable = false)
    private String nickname;

    @Column(name = "role",nullable = false)
    private String role;

    @Column(name = "create_at",nullable = false)
    private Long create_at;

    @Column(name = "update_at",nullable = false)
    private Long update_at;


    /*@Column(name = "rank", nullable = false)
    private int rank;

    @Column(name = "닉네임", nullable = false)
    private String name;

    @Column(name = "집주소", nullable = false)
    private String Field;

    @Column(name = "디스코드채널아이디", nullable = false)
    private String Field2;*/


    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public static User toUser(AddUserdto addUserdto){
        User toUser = new User();
        toUser.setId(addUserdto.getId());
        toUser.setEmail(addUserdto.getEmail());
        toUser.setPassword(addUserdto.getPassword());
        return toUser;
    }
}