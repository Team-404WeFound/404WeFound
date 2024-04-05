package com.WeFound.WeFound.service;

import com.WeFound.WeFound.dto.AnswerRequestDto;
import com.WeFound.WeFound.dto.AnswerResponseDto;
import com.WeFound.WeFound.entity.Answer;
import com.WeFound.WeFound.entity.Question;
import com.WeFound.WeFound.entity.User;
import com.WeFound.WeFound.repository.AnswerRepository;
import com.WeFound.WeFound.repository.QuestionRepository;
import com.WeFound.WeFound.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class AnswerService {
    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public AnswerService(UserRepository userRepository, QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    @Transactional
    public Answer writeAnswer(AnswerRequestDto answerRequestDTO, Long question_id) {

        Question question = questionRepository.findById(question_id)
                .orElseThrow(() -> new IllegalArgumentException("게시물을 찾을 수 없습니다."));
        Answer res = Answer.builder()
                .content(answerRequestDTO.getContent())
                .question(question)
                .build();

        return answerRepository.save(res);

    }

    //    public List<AnswerResponseDTO> answerList(Long questionId) {
//        Question question = questionRepository.findById(questionId)
//                .orElseThrow(() -> new IllegalArgumentException("게시물을 찾을 수 없습니다."));
//        List<Answer> answers = answerRepository.findByQuestion(question);
//
//        return answers.stream()
//                .map(answer -> AnswerResponseDTO.builder().answer(answer).build())
//                .collect(Collectors.toList());
//    }
    public List<Answer> findAll(){
        return answerRepository.findAll();
    }
    public Answer findById(Long answer_id){return answerRepository.findById(answer_id).orElse(new Answer());}


    @Transactional
    public AnswerResponseDto updateAnswer(Long answer_id, AnswerRequestDto answerRequestDTO) {
        Answer answer = answerRepository.findById(answer_id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 댓글입니다."));
        answer.update(answerRequestDTO.getContent());
        // 수정된 답변을 조회하여 반환
        return new AnswerResponseDto(answer);
    }


    @Transactional
    public void deleteAnswer(Long answer_id) {
        answerRepository.deleteById(answer_id);
    }
}