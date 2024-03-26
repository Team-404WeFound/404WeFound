package com.WeFound.WeFound.dto;

import com.WeFound.WeFound.entity.Post;

public class AddPostRequest {
    private String title;
    private String content;

    public Post toEntity(){
        return Post.builder()
                .title(title)
                .content(content)
                .build();
    }
}
