package com.WeFound.WeFound.controller;

import com.WeFound.WeFound.service.MainService;
import com.WeFound.WeFound.service.MypageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MypageController {

    private final MypageService mypageService;

    @Autowired
    public MypageController(MypageService mypageService) {
        this.mypageService = mypageService;
    }

    @GetMapping("/mypage")
    public String mainPage(Model model) {
        mypageService.populateModelWithUserDetails(model);
        return "mypage";
    }
}
