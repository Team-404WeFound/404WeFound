
package com.WeFound.WeFound.controller;



import com.WeFound.WeFound.dto
import com.WeFound.WeFound.entity
import com.WeFound.WeFound.service

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/null")

public class GoController {
    private final GOService helloService;




    @GetMapping("/member/save 생성 필요")
    public String saveForm() {
        return "save";
    }

    @PostMapping("/member/save")
    public String save(@ModelAttribute MemberDTO memberDTO) {
        System.out.println("MemberController.save");
        System.out.println("memberDTO = " + memberDTO);
        memberService.save(memberDTO);
        return "login";
    }

    @GetMapping("/member/login 생성 필요")
    public String loginForm() {
        return "login";
    }




    //실패
    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
