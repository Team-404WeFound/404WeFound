package com.WeFound.WeFound.controller;

import com.WeFound.WeFound.dto.CustomUserDetails;
import com.WeFound.WeFound.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    public String createAnswer(
            @PathVariable Long questionId,
            @RequestParam String content,
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {
        answerService.createAnswer(questionId, content, userDetails.getUserId());
        return "redirect:/api/questions/" + questionId;
    }

    @GetMapping("/api/questions/{questionId}/answers/new")
    public String showAnswerForm(@PathVariable Long questionId, Model model) {
        model.addAttribute("questionId", questionId);
        return "answerForm";
    }

    @PostMapping("/api/answers/{answerId}/like")
    public String likeAnswer(
            @PathVariable Long answerId,
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {
        answerService.likeAnswer(answerId, userDetails.getUserId());
        return "redirect:/api/questions/" + answerService.getAnswerById(answerId).getQuestion().getQuestionId();
    }
}