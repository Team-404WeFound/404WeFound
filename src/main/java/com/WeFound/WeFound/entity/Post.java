package com.WeFound.WeFound.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
public class Post {
    @Id
    @Column(name = "post_id", updatable = false)
    private int post_id;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;


    @Column(name = "like_count")
    private int like_count;

    @CreatedDate
    @Column(name = "wtime")
    private LocalDateTime create_time;
}
