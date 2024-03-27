package com.WeFound.WeFound.controller;


import com.WeFound.WeFound.dto.AddUserdto;
import com.WeFound.WeFound.repository.UserRepository;
import com.WeFound.WeFound.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String signup(AddUserdto request){
        userService.save(request);
        return "redirect:/login";
    }
}
