package com.WeFound.WeFound.service;

import com.WeFound.WeFound.dto.AddPostRequest;
import com.WeFound.WeFound.entity.Post;
import com.WeFound.WeFound.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post save(AddPostRequest request){
        return postRepository.save(request.toEntity());
    }
}
