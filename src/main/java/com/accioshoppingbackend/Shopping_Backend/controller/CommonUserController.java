package com.accioshoppingbackend.Shopping_Backend.controller;

import com.accioshoppingbackend.Shopping_Backend.exception.WrongCredentialsException;
import com.accioshoppingbackend.Shopping_Backend.model.ApplicationUser;
import com.accioshoppingbackend.Shopping_Backend.service.CommonUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class CommonUserController {

    @Autowired
    CommonUserService commonUserService;

    @PostMapping("/register")
    public String registerUser(@RequestBody ApplicationUser user){
        commonUserService.createUser(user);
        return "User created successfully";
    }

    @GetMapping("/api/user/authenticate")
    public String authenticateUser(@RequestHeader String Authorization){
        String [] details = Authorization.split(":");
        String email = details[0];
        String password  = details[1];
        try{
            commonUserService.authenticateUser(email, password);
            return "User login successfully";
        }
        catch (WrongCredentialsException wrongCredentialsException){
            return wrongCredentialsException.getMessage();
        }
    }

}
