package com.WeFound.WeFound.repository;

import com.WeFound.WeFound.entity.Comment;
import com.WeFound.WeFound.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<Comment> findByQuestion_QuestionIdAndCommentId(Long questionId, Long commentId);
    Optional<List<Comment>> findByQuestion_QuestionId(Long questionId);
    Optional<Void> deleteByQuestion_QuestionIdAndCommentId(Long questionId, Long commentId);
}
