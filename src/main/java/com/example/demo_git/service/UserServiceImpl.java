package com.example.demo_git.service;

import com.example.demo_git.dto.UserCreateDTO;
import com.example.demo_git.dto.UserMapper;
import com.example.demo_git.dto.UserResponseDTO;
import com.example.demo_git.repository.UserRepository;
import com.example.demo_git.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserServiceImpl implements UserService{


    private UserRepository userRepository;
    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserResponseDTO save(UserCreateDTO userCreateDTO) {
        User user = userMapper.toUser(userCreateDTO);
        User user1 = userRepository.save(user);
        UserResponseDTO save = userMapper.toDTO(user1);
        return save;

    }
}
