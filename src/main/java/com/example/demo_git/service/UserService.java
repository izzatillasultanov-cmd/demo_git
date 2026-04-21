package com.example.demo_git.service;

import com.example.demo_git.dto.UserCreateDTO;
import com.example.demo_git.dto.UserResponseDTO;

public interface UserService {
    UserResponseDTO save(UserCreateDTO userCreateDTO);
}
