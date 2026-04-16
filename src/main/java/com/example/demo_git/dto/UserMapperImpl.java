package com.example.demo_git.dto;

import com.example.demo_git.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper{
    @Override
    public User toUser(UserCreateDTO userCreateDTO) {
        return new User (userCreateDTO.getName(),
        userCreateDTO.getFullName());
    }
}
