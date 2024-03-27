package com.WeFound.WeFound.service;

import com.WeFound.WeFound.dto.AddQuestionRequest;
import com.WeFound.WeFound.entity.Question;
import com.WeFound.WeFound.repository.QuestionRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

//    public List<Question> findAll(){
//        return questionRepository.findAll();
//    }

    public Question findById(Long questionId) {
        return questionRepository.findById(questionId).orElse(new Question());
    }


    public Page<Question> getPageableQuestions(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }

    @Transactional
    public void update(Long questionId, AddQuestionRequest request) {
        Question question = findById(questionId);
        question.update(request.getTitle(), request.getContent());
    }
}
