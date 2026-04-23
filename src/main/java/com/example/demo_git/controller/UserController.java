package com.example.demo_git.controller;

import com.example.demo_git.dto.UserCreateDTO;
import com.example.demo_git.dto.UserResponseDTO;
import com.example.demo_git.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public UserResponseDTO save(@RequestBody UserCreateDTO userCreateDTO) {
        return userService.save(userCreateDTO);
    }

    @GetMapping("/findByID")
    public UserResponseDTO findById(@RequestParam("id") Long id) {
        return userService.findById(id);
    }

    @GetMapping("/findAll")
    public List<UserResponseDTO> findAll() {
        return userService.findAll();
    }
}
