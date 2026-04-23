package com.example.demo_git.service;

import com.example.demo_git.dto.UserCreateDTO;
import com.example.demo_git.dto.UserResponseDTO;

import java.util.List;

public interface UserService {
    UserResponseDTO save(UserCreateDTO userCreateDTO);

    UserResponseDTO findById(Long id);

    List<UserResponseDTO> findAll();

    public void deleteByID(Long id);

}
