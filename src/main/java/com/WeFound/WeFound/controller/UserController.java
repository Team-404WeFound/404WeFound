package com.WeFound.WeFound.controller;

import com.WeFound.WeFound.dto.CustomUserDetails;
import com.WeFound.WeFound.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/withdraw")
    public String withdrawUser(@AuthenticationPrincipal CustomUserDetails userDetails) {
        userService.withdrawUser(userDetails.getEmail());
        return "redirect:/logout";
    }
}
