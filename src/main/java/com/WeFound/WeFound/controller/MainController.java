package com.WeFound.WeFound.controller;

import com.WeFound.WeFound.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;

    @GetMapping("/")
    public String mainPage(Model model) {
        mainService.populateModelWithUserDetails(model);
        return "firstMain";
    }
}