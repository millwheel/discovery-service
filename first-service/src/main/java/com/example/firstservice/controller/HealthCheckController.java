package com.example.firstservice.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first-service")
@Slf4j
public class HealthCheckController {
    Environment env;

    @Autowired
    public HealthCheckController(Environment env) {
        this.env = env;
    }

    @GetMapping("/welcome")
    public String heathCheck(){
        return "Welcome to first server";
    }

    @GetMapping("/message")
    public String message(@RequestHeader("first-request") String header){
        log.info("header={}", header);
        return "First service message";
    }

    @GetMapping("check")
    public String check(HttpServletRequest request){
        log.info("server port={}", request.getServerPort());
        return String.format("This is a message from first service on PORT %s", env.getProperty("local.server.port"));
    }
}
