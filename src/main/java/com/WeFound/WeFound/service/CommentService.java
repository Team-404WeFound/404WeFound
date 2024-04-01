package com.WeFound.WeFound.service;

import com.WeFound.WeFound.dto.AddCommentRequest;
import com.WeFound.WeFound.dto.CommentResponse;
import com.WeFound.WeFound.entity.Comment;
import com.WeFound.WeFound.entity.Question;
import com.WeFound.WeFound.repository.CommentRepository;
import com.WeFound.WeFound.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.sqm.internal.QuerySqmImpl;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final QuestionRepository questionRepository;

    public CommentService(CommentRepository commentRepository, QuestionRepository questionRepository) {
        this.commentRepository = commentRepository;
        this.questionRepository = questionRepository;
    }

    public Comment save(Long questionId, AddCommentRequest request){
        Question question = questionRepository.findById(questionId).orElseThrow(IllegalArgumentException::new);
        Comment comment = request.toEntity(question);
        return commentRepository.save(comment);
    }
}
