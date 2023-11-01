package com.example.webwork.services;


import com.example.webwork.dtos.UsersDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsersService {
    UsersDto registerUser(UsersDto users);

    List<UsersDto> getAllUsers();

    Optional<UsersDto> getUser(String id);

    void deleteUser(String id);

    UsersDto updateUser(UsersDto users);
    List<UsersDto> findUsersByFirstName(String firstName);
    List<UsersDto> findUsersByLastName(String lastName);
    List<UsersDto> findUsersByRole(int role);
    List<UsersDto> findUsersByBrandName(String brandName);
}
