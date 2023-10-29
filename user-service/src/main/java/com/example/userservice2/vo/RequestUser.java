package com.example.userservice2.vo;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
public class RequestUser {
    @NotNull(message = "Email should not be null")
    @Size(min=2, message = "email should not be less than 2 characters")
    @Email
    private String email;
    @NotNull(message = "Name should not be null")
    @Size(min=2, message = "name should not be less than 2 characters")
    private String name;
    @NotNull(message = "Password should not be null")
    @Size(min=8, message = "Password should be equal or grater then 8 characters")
    private String pwd;
}
