package com.WeFound.WeFound.controller;

import com.WeFound.WeFound.dto.CustomUserDetails;
import com.WeFound.WeFound.dto.QuestionViewResponse;
import com.WeFound.WeFound.entity.*;
import com.WeFound.WeFound.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class QuestionsPageController {
    private final QuestionService questionService;
    private final CommentService commentService;
    private final AnswerService answerService;
    private final AnswerCommentService answerCommentService;
    private final UserService userService;

    @GetMapping("/api/questions")
    public String getQuestions(Model model) {
        List<QuestionViewResponse> questions = questionService.findAll().stream()
                .map(QuestionViewResponse::new)
                .toList();
        model.addAttribute("questions", questions);
        return "main";
    }

    @GetMapping("/api/questions/{questionId}")
    public String getQuestion(
            @PathVariable Long questionId,
            Model model,
            @AuthenticationPrincipal CustomUserDetails details
    ) {
        Question question = questionService.findById(questionId);
        Long userId = questionService.findUserIdByQuestionId(questionId);
        User user = userService.findNickNameByUserId(userId);
        List<Comment> comments = commentService.findAllComment(questionId);
        model.addAttribute("question", new QuestionViewResponse(question));
        model.addAttribute("user", user);
        model.addAttribute("comments", comments);

        List<Answer> answers = answerService.getAnswersByQuestion(questionId);
        model.addAttribute("answers", answers);
        for (Answer answer : answers) {
            List<AnswerComment> answerComments = answerCommentService.getAnswerCommentsByAnswer(answer.getAnswerId());
            answer.setComments(answerComments);
        }

        return "questionDetail";
    }

    @GetMapping("/inputQuestion")
    public String newQuestion(
            @RequestParam(required = false) Long questionId,
            Model model,
            @AuthenticationPrincipal CustomUserDetails details
    ) {
        if (questionId == null) {
            model.addAttribute("question", new QuestionViewResponse());
        } else {
            Question question = questionService.findById(questionId);
            if (details.getUserId().equals(question.getUserId())) {
                model.addAttribute("question", new QuestionViewResponse(question));
            } else {
                return "main";
            }
        }
        return "inputQuestion";
    }
}