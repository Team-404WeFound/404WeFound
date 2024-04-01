package com.WeFound.WeFound.service;

import com.WeFound.WeFound.dto.AddCommentRequest;
import com.WeFound.WeFound.dto.AllCommentResponse;
import com.WeFound.WeFound.dto.CommentResponse;
import com.WeFound.WeFound.entity.Comment;
import com.WeFound.WeFound.entity.Question;
import com.WeFound.WeFound.repository.CommentRepository;
import com.WeFound.WeFound.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final QuestionRepository questionRepository;

    public CommentService(CommentRepository commentRepository, QuestionRepository questionRepository) {
        this.commentRepository = commentRepository;
        this.questionRepository = questionRepository;
    }

    public Comment save(Long question_id, AddCommentRequest request){
        Question question = questionRepository.findById(question_id).orElseThrow(IllegalArgumentException::new);
        Comment comment = request.toEntity(question);
        return commentRepository.save(comment);
    }

    public Comment findComment(Long questionId, Long commentId){
        return commentRepository.findByCommentId(questionId,commentId).orElseThrow(IllegalArgumentException::new);
    }

    public AllCommentResponse findAllComments(Long questionId) {
        List<Comment> comments = commentRepository.findByQuestionId(questionId)
                .orElseThrow(IllegalArgumentException::new);

        List<CommentResponse> commentList = new ArrayList<>();

        for (Comment comment : comments){
            commentList.add(comment.toResponse());
        }
        return  new AllCommentResponse(comments.get(0).getQuestion(), commentList);
    }
}
