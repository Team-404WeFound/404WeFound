package com.WeFound.WeFound.controller;

import com.WeFound.WeFound.dto.QuestionViewResponse;
import com.WeFound.WeFound.entity.Question;
import com.WeFound.WeFound.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class QuestionsPageController {
    private QuestionService questionService;

    public QuestionsPageController(QuestionService questionService) {
        this.questionService = questionService;
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
    public String getQuestion(@PathVariable Long questionId, Model model) {
        Question question = questionService.findById(questionId);
        model.addAttribute("question", new QuestionViewResponse(question));

        return "questionDetail";
    }

    @GetMapping("/inputQuestion")
    public String newQuestion(@RequestParam(required = false) Long questionId, Model model){
        if (questionId == null){
            model.addAttribute("question", new QuestionViewResponse());
        }
        else{
            Question question = questionService.findById(questionId);
            model.addAttribute("question", new QuestionViewResponse(question));
        }
        return "inputQuestion";
    }
}
