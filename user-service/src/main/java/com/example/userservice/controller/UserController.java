package com.example.userservice.controller;

import com.example.userservice.vo.Greeting;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class UserController {

    private final Greeting greeting;

    @GetMapping("health-check")
    public String status(){
        return "The user service is activated successfully.";
    }

    @GetMapping("/welcome")
    public String welcome(){
        return greeting.getMessage();
    }

}
