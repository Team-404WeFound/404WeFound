package com.WeFound.WeFound.controller;

import com.WeFound.WeFound.service.PostService;
import org.springframework.stereotype.Controller;

@Controller
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    //todo 게시판 생성
    //todo 게시판 조회
    //todo 게시판 수정
    //todo 게시판 삭제

}
