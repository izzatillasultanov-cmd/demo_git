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

    @DeleteMapping("/deleteById")
    public UserResponseDTO deleteByID(@RequestParam("id") Long id) {
        return userService.deleteByID(id);
    }

    @GetMapping("/getAllAge")
    public int getAllAge() {
        return userService.getAllAge();
    }

    @GetMapping("/getMaxAge")
    public UserResponseDTO getMaxAge() {
        return userService.getMaxAge();
    }

    @GetMapping("/getByIdRange")
    public List<UserResponseDTO> getBYIdRange(@RequestParam("min") Long min, @RequestParam("max") Long max) {
        return userService.findIdRange(min, max);

    }

    @GetMapping("/getAgeByIdRange")
    public int getAgeById(@RequestParam("min") Long min, @RequestParam("max") Long max) {
        return userService.getAgeByRange(min, max);
    }

    @DeleteMapping("/softDelete")
    public UserResponseDTO softDelete(@RequestParam("id") Long id) {
        return userService.softDelete(id);
    }

    @GetMapping("/getAgeTotalDeleted")
    public int getAgeTotalDeleted() {
        return userService.getTotalAgeDeleted();
    }

}
