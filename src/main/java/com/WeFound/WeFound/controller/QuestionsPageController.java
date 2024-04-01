package com.WeFound.WeFound.controller;

import com.WeFound.WeFound.dto.QuestionViewResponse;
import com.WeFound.WeFound.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class QuestionsPageController {
    private QuestionService questionService;

    public QuestionsPageController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/api/questions")
    public String getArticles(Model model) {
        List<QuestionViewResponse> questions = questionService.findAll().stream()
                .map(QuestionViewResponse::new)
                .toList();
        model.addAttribute("questions", questions);   // model에 블로그 글 리스트 저장

        return "main";   // articleList.html라는 뷰 조회
    }
}
