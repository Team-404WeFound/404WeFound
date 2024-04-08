package com.WeFound.WeFound.service;

import com.WeFound.WeFound.entity.Answer;
import com.WeFound.WeFound.entity.AnswerComment;
import com.WeFound.WeFound.repository.AnswerCommentRepository;
import com.WeFound.WeFound.repository.AnswerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerCommentService {
    private final AnswerCommentRepository answerCommentRepository;
    private final AnswerRepository answerRepository;
    private final AnswerService answerService;

    @Transactional
    public AnswerComment createAnswerComment(Long answerId, String content, Long userId) {
        Answer answer = answerRepository.findById(answerId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid answer Id:" + answerId));

        //refactor: dto 분리하기
        AnswerComment answerComment = new AnswerComment();
        answerComment.setAnswer(answer);
        answerComment.setContent(content);
        answerComment.setUserId(userId);
        answerCommentRepository.save(answerComment);
        return answerComment;
    }

    @Transactional
    public List<AnswerComment> getAnswerCommentsByAnswer(Long answerId) {
        Answer answer = answerService.getAnswerById(answerId);
        return answerCommentRepository.findByAnswer(answer);
    }




}