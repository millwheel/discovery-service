package com.example.firstservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first-service")
public class HealthCheckController {

    @GetMapping("/welcome")
    public String heathCheck(){
        return "Welcome to first server";
    }
}
