package com.docker.example.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("helloworld")
public class HelloWorldController {

    @GetMapping("message")
    public String getMessage() {
        System.out.println("====== HelloWorldController::getMessage ======");
        return "HelloWorld!";
    }
}
