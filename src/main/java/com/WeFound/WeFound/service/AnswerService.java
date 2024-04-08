package com.WeFound.WeFound.service;

import com.WeFound.WeFound.entity.Answer;
import com.WeFound.WeFound.entity.Question;
import com.WeFound.WeFound.entity.User;
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
    private final UserService userService;

    @Transactional
    public Answer createAnswer(Long questionId, String content, Long userId) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid question Id:" + questionId));

        //refactor: dto 분리하기
        Answer answer = new Answer();
        answer.setQuestion(question);
        answer.setContent(content);
        answer.setUserId(userId);
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


    @Transactional
    public void likeAnswer(Long answerId, Long userId) {
        Answer answer = answerRepository.findById(answerId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid answer Id:" + answerId));

        if (!answer.getLikedUsers().contains(userId)) {
            answer.getLikedUsers().add(userId);
            answerRepository.save(answer);

            User user = userService.findUserById(answer.getUserId());
            user.setPoint(user.getPoint() + 5);
            userService.saveUser(user);
        }
    }
}