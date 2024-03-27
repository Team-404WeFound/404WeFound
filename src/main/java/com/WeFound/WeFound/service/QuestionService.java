package com.WeFound.WeFound.service;

import com.WeFound.WeFound.dto.AddQuestionRequest;
import com.WeFound.WeFound.entity.Question;
import com.WeFound.WeFound.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question save(AddQuestionRequest request){
        return questionRepository.save(request.toEntity());
    }

    public List<Question> findAll(){
        return questionRepository.findAll();
    }
}
