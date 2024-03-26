package com.WeFound.WeFound.controller;

import com.WeFound.WeFound.dto.HelloDto;
import com.WeFound.WeFound.service.HelloService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hellos")
public class HelloController {
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }


    @GetMapping("/{id}")
    public HelloDto getHello(@PathVariable Long id) {
        return helloService.getHello(id);
    }


}