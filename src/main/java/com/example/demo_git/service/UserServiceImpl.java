package com.example.demo_git.service;

import com.example.demo_git.dto.UserCreateDTO;
import com.example.demo_git.dto.UserMapper;
import com.example.demo_git.dto.UserResponseDTO;
import com.example.demo_git.repository.UserRepository;
import com.example.demo_git.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class UserServiceImpl implements UserService {


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

    @Override
    public UserResponseDTO findById(Long id) {
        Optional<User> saved = userRepository.findById(id);
        if (saved.isEmpty()) {
            throw new RuntimeException();
        }
        User user = saved.get();
        return userMapper.toDTO(user);
    }

    @Override
    public List<UserResponseDTO> findAll() {
        List<User> saved = userRepository.findAll();
        List<UserResponseDTO> userResponseDTOS = new ArrayList<>();
        for (User user1 : saved) {
            UserResponseDTO userResponseDTO = userMapper.toDTO(user1);
            userResponseDTOS.add(userResponseDTO);
        }
        return userResponseDTOS;
    }

    @Override
    public void  deleteByID(Long id) {
        userRepository.deleteById(id);

    }


}
