package com.WeFound.WeFound.controller;

import com.WeFound.WeFound.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private final MainService mainService;

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/")
    public String mainPage(Model model) {
        mainService.populateModelWithUserDetails(model);
        return "firstMain";
    }
}
