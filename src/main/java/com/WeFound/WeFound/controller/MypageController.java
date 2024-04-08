package com.WeFound.WeFound.controller;

import com.WeFound.WeFound.entity.Point;
import com.WeFound.WeFound.service.MainService;
import com.WeFound.WeFound.service.MypageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class MypageController {

    private final MypageService mypageService;

    @Autowired
    public MypageController(MypageService mypageService) {
        this.mypageService = mypageService;
    }

    @GetMapping("/mypage")
    public String myPage(Model model) {
        mypageService.populateModelWithUserDetails(model);
        // 등급
        String grade = (String) model.getAttribute("grade");
        model.addAttribute("grade", grade);
        // 포인트 내역
        List<Point> pointHistory = mypageService.getPointHistoryForCurrentUser();
        model.addAttribute("pointHistory", pointHistory);
        return "mypage";
    }
}