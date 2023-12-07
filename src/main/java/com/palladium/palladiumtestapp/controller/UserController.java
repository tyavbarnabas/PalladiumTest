package com.palladium.palladiumtestapp.controller;


import com.palladium.palladiumtestapp.dto.UserRequest;
import com.palladium.palladiumtestapp.dto.UserResponse;
import com.palladium.palladiumtestapp.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("api/v1/palladium")
public class UserController {

    private final UserService userService;


    @PostMapping("/create-user")
    public UserResponse createUser(@RequestBody UserRequest request){
        log.info("entering the create user controller...");
        return  userService.createUser(request);
    }

    @GetMapping("/get_all_users")
    public UserResponse getAllUser(){
        log.info("entering the create user controller...");
        return  userService.getAllUser();
    }
}
