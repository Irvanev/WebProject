package com.example.webwork.services;


import com.example.webwork.dtos.UsersDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsersService {
    UsersDto register(UsersDto users);

    List<UsersDto> getAll();

    Optional<UsersDto> get(String id);

    void delete(String id);

    UsersDto update(UsersDto users);
    List<UsersDto> findUserByFirstName(String firstName);
    List<UsersDto> findUserByLastName(String lastName);
    List<UsersDto> findUsersByRole(int role);
}
