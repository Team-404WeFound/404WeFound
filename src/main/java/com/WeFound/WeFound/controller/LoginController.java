package com.WeFound.WeFound.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {


    //0407변경
/*    @GetMapping("/login")
    public String loginP() {



        return "login";

}*/

    @GetMapping("/login")
    public String loginP() {
        return "login";
    }

}