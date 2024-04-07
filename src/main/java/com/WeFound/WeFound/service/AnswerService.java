package com.WeFound.WeFound.service;

import com.WeFound.WeFound.entity.Answer;
import com.WeFound.WeFound.entity.Question;
import com.WeFound.WeFound.repository.AnswerRepository;
import com.WeFound.WeFound.repository.QuestionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    @Transactional
    public Answer createAnswer(Long questionId, String content) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid question Id:" + questionId));

        Answer answer = new Answer();
        answer.setQuestion(question);
        answer.setContent(content);
        return answerRepository.save(answer);
    }

    @Transactional
    public List<Answer> getAnswersByQuestion(Long questionId) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid question Id:" + questionId));
        return answerRepository.findByQuestionOrderByCreatedAtAsc(question);
    }

    @Transactional
    public Answer getAnswerById(Long answerId) {
        return answerRepository.findById(answerId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid answer Id:" + answerId));
    }


}