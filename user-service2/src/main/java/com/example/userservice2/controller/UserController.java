package com.example.userservice2.controller;

import com.example.userservice2.dto.UserDto;
import com.example.userservice2.service.UserService;
import com.example.userservice2.vo.Greeting;
import com.example.userservice2.vo.RequestUser;
import com.example.userservice2.vo.ResponseUser;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-service")
public class UserController {

    private final Greeting greeting;
    private final UserService userService;

    @Autowired
    public UserController(Greeting greeting, UserService userService) {
        this.greeting = greeting;
        this.userService = userService;
    }

    @GetMapping("/health-check")
    public String status(){
        return "The user service is activated successfully.";
    }

    @GetMapping("/welcome")
    public String welcome(){
        return greeting.getMessage();
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseUser createUser(@RequestBody RequestUser user){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto userDto = mapper.map(user, UserDto.class);
        userService.createUser(userDto);
        return mapper.map(userDto, ResponseUser.class);
    }

}
