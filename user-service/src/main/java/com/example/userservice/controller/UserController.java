package com.example.userservice.controller;

import com.example.userservice.dto.UserDto;
import com.example.userservice.service.UserService;
import com.example.userservice.vo.Greeting;
import com.example.userservice.vo.RequestUser;
import com.example.userservice.vo.ResponseUser;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
        UserDto createdUserDto = userService.createUser(userDto);
        return mapper.map(createdUserDto, ResponseUser.class);
    }

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<ResponseUser> getUsers(){
        Iterable<UserDto> users = userService.getUserByAll();
        List<ResponseUser> responseUsers = new ArrayList<>();
        users.forEach(userDto -> {
            responseUsers.add(new ModelMapper().map(userDto, ResponseUser.class));
        });
        return responseUsers;
    }

    @GetMapping("/users/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseUser getUser(@PathVariable String userId){
        UserDto userByUserId = userService.getUserByUserId(userId);
        return new ModelMapper().map(userByUserId, ResponseUser.class);
    }

}
