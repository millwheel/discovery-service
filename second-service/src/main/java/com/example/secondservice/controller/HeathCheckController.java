package com.example.secondservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/second-service")
@Slf4j
public class HeathCheckController {

    @GetMapping("/welcome")
    public String heathCheck(){
        return "Welcome to second server";
    }

    @GetMapping("/message")
    public String message(@RequestHeader("second-request") String header){
        log.info("header={}", header);
        return "Second service message";
    }

    @GetMapping("check")
    public String check(){
        return "This is a message from second service";
    }
}
