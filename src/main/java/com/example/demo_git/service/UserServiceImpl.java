package com.example.demo_git.service;

import com.example.demo_git.dto.UserCreateDTO;
import com.example.demo_git.dto.UserMapper;
import com.example.demo_git.dto.UserResponseDTO;
import com.example.demo_git.repository.UserRepository;
import com.example.demo_git.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service

public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final UserMapper userMapper;

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
        return userRepository.findAllByDeletedFalse().stream()
                .map(e -> userMapper.toDTO(e))
                .toList();
    }

    @Override
   public UserResponseDTO deleteByID(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new RuntimeException();
        }
        User user = optionalUser.get();

        userRepository.deleteById(id);
        return userMapper.toDTO(user);
    }

    @Override
    public int getAllAge() {
        List<User> userList = userRepository.findAll();
        return userList.stream()
                .mapToInt(e -> e.getAge())
                .sum();
    }

    @Override
    public UserResponseDTO getMaxAge() {
        List<User> userList = userRepository.findAll();
        return userList.stream()
                .max(Comparator.comparing(User::getAge))
                .map(e -> userMapper.toDTO(e))
                .orElseThrow();
    }

    @Override
    public List<UserResponseDTO> findIdRange(long id1, long id2) {
        List<User> userlist = userRepository.findAll();
        return userlist.stream()
                .filter(e -> e.getId() >= id1)
                .filter(e -> e.getId() <= id2)
                .map(e -> userMapper.toDTO(e))
                .toList();
    }

    @Override
    public int getAgeByRange(long min, long max) {
        List<User> userList = userRepository.findAll();
        List<User> save = userList.stream()
                .filter(e -> e.getId() >= min)
                .filter(e -> e.getId() <= max)
                .toList();
        return save.stream()
                .mapToInt(e -> e.getAge())
                .sum();
    }

    @Override
    public UserResponseDTO softDelete(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            throw new RuntimeException("NOt user");
        }
        User user = userOptional.get();
        user.setDeleted(true);
        userRepository.save(user);
        return userMapper.toDTO(user);
    }


}
