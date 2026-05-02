package com.example.demo_git.service;

import com.example.demo_git.dto.UserCreateDTO;
import com.example.demo_git.dto.UserResponseDTO;

import java.util.List;

public interface UserService {
    UserResponseDTO save(UserCreateDTO userCreateDTO);

    UserResponseDTO findById(Long id);

    List<UserResponseDTO> findAll();

    UserResponseDTO deleteByID(Long id);

    int getAllAge();

    UserResponseDTO getMaxAge();

    List<UserResponseDTO> findIdRange(long id1,long id2);

    int getAgeByRange(long min, long max);

    UserResponseDTO softDelete(Long id);


}
