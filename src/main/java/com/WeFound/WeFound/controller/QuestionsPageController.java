package com.WeFound.WeFound.controller;

import com.WeFound.WeFound.dto.CustomUserDetails;
import com.WeFound.WeFound.dto.QuestionViewResponse;
import com.WeFound.WeFound.entity.Comment;
import com.WeFound.WeFound.entity.Question;
import com.WeFound.WeFound.service.CommentService;
import com.WeFound.WeFound.service.QuestionService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class QuestionsPageController {
    private QuestionService questionService;
    private CommentService commentService;

    public QuestionsPageController(QuestionService questionService, CommentService commentService) {
        this.questionService = questionService;
        this.commentService = commentService;
    }

    @GetMapping("/api/questions")
    public String getQuestions(Model model) {
        List<QuestionViewResponse> questions = questionService.findAll().stream()
                .map(QuestionViewResponse::new)
                .toList();
        model.addAttribute("questions", questions);   // model에 블로그 글 리스트 저장

        return "main";   // main.html라는 뷰 조회
    }

    @GetMapping("/api/questions/{questionId}")   //상세 html 뷰로 전환을 위한 Get
    public String getQuestion(@PathVariable Long questionId,Model model, @AuthenticationPrincipal CustomUserDetails details) {
        Question question = questionService.findById(questionId);
        model.addAttribute("question", new QuestionViewResponse(question));

        List<Comment> comments = commentService.findAllComment(questionId);
        if (!comments.isEmpty()){
            model.addAttribute("comments", comments);
        }
        else{
            return "questionDetailNoComment";
        }
        return "questionDetail";
    }

    @GetMapping("/inputQuestion")
    public String newQuestion(@RequestParam(required = false) Long questionId, Model model, @AuthenticationPrincipal CustomUserDetails details){
        if (questionId == null){
            model.addAttribute("question", new QuestionViewResponse());
        }
        else{
            Question question = questionService.findById(questionId);
            if (details.getUserId().equals(question.getUserId())){
            model.addAttribute("question", new QuestionViewResponse(question));
            }
            else{
                return "main";
            }
        }
        return "inputQuestion";
    }
}
