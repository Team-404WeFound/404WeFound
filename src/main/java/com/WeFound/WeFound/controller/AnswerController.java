package com.WeFound.WeFound.controller;

import com.WeFound.WeFound.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class AnswerController {
    private final AnswerService answerService;

    @PostMapping("/api/questions/{questionId}/answers")
    public String createAnswer(@PathVariable Long questionId, @RequestParam String content) {
        answerService.createAnswer(questionId, content);
        return "redirect:/api/questions/" + questionId;
    }

    @GetMapping("/api/questions/{questionId}/answers/new")
    public String showAnswerForm(@PathVariable Long questionId, Model model) {
        model.addAttribute("questionId", questionId);
        return "answerForm";
    }

}