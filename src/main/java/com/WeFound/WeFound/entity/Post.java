package com.WeFound.WeFound.entity;

import com.WeFound.WeFound.dto.PostResponse;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
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

    @Builder
    public Post(String title, String content){
        this.title = title;
        this.content = content;
    }

    public PostResponse toResponse(){
        return PostResponse.builder()
                .title(title)
                .content(content)
                .build();
    }
}
