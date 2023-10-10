package com.example.firstservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first-service")
@Slf4j
public class HealthCheckController {

    @GetMapping("/welcome")
    public String heathCheck(){
        return "Welcome to first server";
    }

    @GetMapping("/message")
    public String message(@RequestHeader("first-request") String header){
        log.info("header={}", header);
        return "First service message";
    }
}
