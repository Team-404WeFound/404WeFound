package com.WeFound.WeFound.service;

import com.WeFound.WeFound.dto.AnswerRequestDTO;
import com.WeFound.WeFound.dto.AnswerResponseDTO;
import com.WeFound.WeFound.entity.Answer;
import com.WeFound.WeFound.entity.Question;
import com.WeFound.WeFound.entity.User;
import com.WeFound.WeFound.repository.AnswerRepository;
import com.WeFound.WeFound.repository.QuestionRepository;
import com.WeFound.WeFound.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnswerServiceimpl implements AnswerService{

    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    @Override
    public Long writeAnswer(AnswerRequestDTO answerRequestDTO, Long question_id, String email){
        User user = userRepository.findByEmail(email).orElseThrow(() ->new UsernameNotFoundException("이메일이 존재하지 않습니다."));
        Question question = questionRepository.findById(question_id).orElseThrow(() -> new IllegalArgumentException("게시물을 찾을 수 없습니다."));
        Answer res = Answer.builder()
                .content(answerRequestDTO.getContent())
                        .question(question).user(user).build();

        answerRepository.save(res);
        return res.getAnswer_id();
    }
    @Override
    public List<AnswerResponseDTO> answerList(Long id){
        Question question = questionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("게시물을 찾을 수 없습니다."));
        List<Answer> answers = answerRepository.findByQuestion(question);

        return answers.stream()
                .map(answer -> AnswerResponseDTO.builder()
                        .answer(answer).build())
                .collect(Collectors.toList());
    }
    @Override
    public void updateAnswer(AnswerRequestDTO answerRequestDTO,Long answer_id){
        Answer answer = answerRepository.findById(answer_id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 댓글입니다."));
        answer.update(answerRequestDTO.getContent());
        answerRepository.save(answer);
    }

    @Override
    public void deleteAnswer(Long answer_id){
        answerRepository.deleteById(answer_id);
    }
}
