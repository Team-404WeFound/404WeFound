package com.WeFound.WeFound.entity;

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
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", updatable = false)
    private Long user_id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "nickname",nullable = false)
    private String nickname;

    @Column(name = "role",nullable = false)
    private String role;

    @CreatedDate
    @Column(name = "create_at")
    private LocalDateTime create_at;

    @LastModifiedDate
    @Column(name = "update_at")
    private LocalDateTime update_at;


    /*@Column(name = "rank", nullable = false)
    private int rank;

    @Column(name = "닉네임", nullable = false)
    private String name;

    @Column(name = "집주소", nullable = false)
    private String Field;

    @Column(name = "디스코드채널아이디", nullable = false)
    private String Field2;*/



    public User() {

    }

    public static User toUser(AddUserdto addUserdto){
        User toUser = new User();
        toUser.setUser_id(addUserdto.getUser_id());
        toUser.setEmail(addUserdto.getEmail());
        toUser.setPassword(addUserdto.getPassword());
        return toUser;
    }
}