package com.WeFound.WeFound.controller;

import com.WeFound.WeFound.entity.Point;
import com.WeFound.WeFound.service.MypageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MypageController {

    private final MypageService mypageService;

    @GetMapping("/mypage")
    public String myPage(Model model) {
        mypageService.populateModelWithUserDetails(model);

        String grade = (String) model.getAttribute("grade");
        model.addAttribute("grade", grade);

        Long currentPoint = (Long) model.getAttribute("currentPoint");
        model.addAttribute("currentPoint", currentPoint);

        List<Point> pointHistory = mypageService.getPointHistoryForCurrentUser();
        model.addAttribute("pointHistory", pointHistory);

        return "mypage";
    }
}