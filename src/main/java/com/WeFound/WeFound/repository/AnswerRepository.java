package com.WeFound.WeFound.repository;

import com.WeFound.WeFound.entity.Answer;
import com.WeFound.WeFound.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer,Long> {
    List<Answer> findByQuestion(Question question);

}
