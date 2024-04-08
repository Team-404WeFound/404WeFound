package com.WeFound.WeFound.repository;

import com.WeFound.WeFound.entity.Answer;
import com.WeFound.WeFound.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findByQuestionOrderByCreatedAtAsc(Question question);
}