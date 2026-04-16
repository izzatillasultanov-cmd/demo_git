package com.example.demo_git.controller;

import com.example.demo_git.dto.UserCreateDTO;
import com.example.demo_git.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public void save(@RequestBody UserCreateDTO userCreateDTO) {
        userService.save(userCreateDTO);

    }
}
