package com.WeFound.WeFound.service;

import com.WeFound.WeFound.entity.Question;
import com.WeFound.WeFound.entity.User;
import com.WeFound.WeFound.repository.LikeRepoitory;
import com.WeFound.WeFound.repository.QuestionRepository;
import com.WeFound.WeFound.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeService {
    private final LikeRepoitory likeRepoitory;
    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;



}
