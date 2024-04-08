package com.WeFound.WeFound.service;

import com.WeFound.WeFound.dto.AddQuestionRequest;
import com.WeFound.WeFound.entity.PremiumQuestion;
import com.WeFound.WeFound.repository.PremiumQuestionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PremiumQuestionService {
    private final PremiumQuestionRepository premiumQuestionRepository;

    public PremiumQuestion save(AddQuestionRequest request) {
        return premiumQuestionRepository.save(PremiumQuestion.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build());
    }

    public List<PremiumQuestion> findAll() {
        return premiumQuestionRepository.findAll();
    }

    public PremiumQuestion findById(Long questionId) {
        return premiumQuestionRepository.findById(questionId).orElse(new PremiumQuestion());
    }

    @Transactional
    public void update(Long questionId, AddQuestionRequest request) {
        PremiumQuestion question = findById(questionId);
        question.update(request.getTitle(), request.getContent());
    }

    public void delete(Long questionId) {
        premiumQuestionRepository.deleteById(questionId);
    }

    public Long findUserIdByQuestionId(Long questionId) {
        return premiumQuestionRepository.findById(questionId).orElseThrow().getUserId();
    }
}