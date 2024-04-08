package com.WeFound.WeFound.repository;

import com.WeFound.WeFound.entity.Answer;
import com.WeFound.WeFound.entity.AnswerComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerCommentRepository extends JpaRepository<AnswerComment, Long> {
    List<AnswerComment> findByAnswer(Answer answer);
}