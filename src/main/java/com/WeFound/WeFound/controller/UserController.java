package com.WeFound.WeFound.controller;


import com.WeFound.WeFound.dto.AddUserdto;
import com.WeFound.WeFound.repository.UserRepository;
import com.WeFound.WeFound.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@Controller
//둘의 차이가 존제한다.


public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    /*  @GetMapping("/users")
      public String signup(AddUserdto request){
          userService.save(request);
          return "redirect:/login";
      }*/
//신규 작성
    @GetMapping("/api/users")
    public String findAll(Model model) {
        List<AddUserdto> memberDTOList = userService.findAll();
        model.addAttribute("memberList", memberDTOList);
        return "list";
    }

    @GetMapping("api/users/{id}")
    public String findById(@PathVariable Long id, Model model) {
        AddUserdto memberDTO = userService.findById(id);
        model.addAttribute("member", memberDTO);
        return "detail"; //디테일이란 값이 클라이언트로 이동함 @RestController로 인해(특강 참고)

    }
}
