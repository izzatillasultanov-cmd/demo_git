package com.example.demo_git.dto;

import com.example.demo_git.user.User;

public interface UserMapper {
    User toUser(UserCreateDTO userCreateDTO);

    UserResponseDTO toDTO(User user);
}
