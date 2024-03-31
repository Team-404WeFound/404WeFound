package com.WeFound.WeFound.service;

import com.WeFound.WeFound.dto.AnswerRequestDTO;
import com.WeFound.WeFound.dto.AnswerResponseDTO;

import java.util.List;



public interface AnswerService {
    Long writeAnswer(AnswerRequestDTO answerRequestDTO, Long question_id, String email);

    List<AnswerResponseDTO> answerList(Long id);

    void updateAnswer(AnswerRequestDTO answerRequestDTO,Long answer_id);

    void deleteAnswer(Long answer_id);

}
