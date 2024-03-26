package com.WeFound.WeFound.dto;

import com.WeFound.WeFound.entity.Post;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostResponse {
    private int post_id;
    private int user_id;
    private String title;
    private String content;
    private int like_count;

    public PostResponse(Post post){
        post_id = post.getPost_id();
        user_id = post.getUser_id();
        title = post.getTitle();
        content = post.getContent();
        like_count = post.getLike_count();
    }
}
