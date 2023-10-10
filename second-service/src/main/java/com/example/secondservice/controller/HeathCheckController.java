package com.example.secondservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/second-service")
public class HeathCheckController {

    @GetMapping("/welcome")
    public String heathCheck(){
        return "Welcome to second server";
    }
}
