package com.WeFound.WeFound.controller;

import com.WeFound.WeFound.dto.AddPostRequest;
import com.WeFound.WeFound.dto.PostResponse;
import com.WeFound.WeFound.entity.Post;
import com.WeFound.WeFound.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    //todo 게시판 생성
    @PostMapping("/posts")
    public ResponseEntity<PostResponse> addPost(@RequestParam AddPostRequest request){
        Post post = postService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(post.toResponse());
    }
    //todo 게시판 조회
    //todo 게시판 수정
    //todo 게시판 삭제

}
