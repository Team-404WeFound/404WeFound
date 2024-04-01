package com.WeFound.WeFound.controller;

import com.WeFound.WeFound.dto.JoinDto;
import com.WeFound.WeFound.service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JoinController {

    private final JoinService joinService;

    @Autowired
    public JoinController(JoinService joinService) {
        this.joinService = joinService;
    }

    @GetMapping("/join")
    public String joinP() {

        return "join";
    }


    @PostMapping("/joinProc")
    public String joinProcess(JoinDto joinDto) {

        System.out.println(joinDto.getEmail());

        joinService.joinProcess(joinDto);


        return "redirect:/login";
    }
}