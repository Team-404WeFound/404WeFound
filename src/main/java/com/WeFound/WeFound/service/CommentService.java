package com.WeFound.WeFound.service;

import com.WeFound.WeFound.dto.AddCommentRequest;
import com.WeFound.WeFound.dto.AllCommentResponse;
import com.WeFound.WeFound.dto.CommentResponse;
import com.WeFound.WeFound.entity.Comment;
import com.WeFound.WeFound.entity.Question;
import com.WeFound.WeFound.repository.CommentRepository;
import com.WeFound.WeFound.repository.QuestionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final QuestionRepository questionRepository;

    public Comment save(Long questionId, AddCommentRequest request, Long userId) {
        Question question = questionRepository.findById(questionId).orElseThrow(IllegalArgumentException::new);
        Comment comment = request.toEntity(question, request.getContent(), userId);
        return commentRepository.save(comment);
    }

    public Comment findComment(Long questionId, Long commentId) {
        return commentRepository.findByQuestion_QuestionIdAndCommentId(questionId, commentId).orElseThrow(IllegalArgumentException::new);
    }

    public AllCommentResponse findAllComments(Long questionId) {
        List<Comment> comments = commentRepository.findByQuestion_QuestionId(questionId)
                .orElseThrow(IllegalArgumentException::new);

        List<CommentResponse> commentList = new ArrayList<>();
        for (Comment comment : comments) {
            commentList.add(comment.toResponse());
        }
        return new AllCommentResponse(comments.get(0).getQuestion(), commentList);
    }

    public List<Comment> findAllComment(Long questionId) {
        List<Comment> comments = commentRepository.findByQuestion_QuestionId(questionId)
                .orElseThrow(IllegalArgumentException::new);
        return comments;
    }

    @Transactional
    public void deleteComment(Long questionId, Long commentId) {
        commentRepository.deleteByQuestion_QuestionIdAndCommentId(questionId, commentId).orElseThrow(IllegalArgumentException::new);
    }
}