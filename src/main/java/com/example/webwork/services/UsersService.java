package com.example.webwork.services;


import com.example.webwork.dtos.UsersDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsersService {
    UsersDto register(UsersDto users);

    List<UsersDto> getAll();

    Optional<UsersDto> get(UUID id);

    void delete(UUID id);

    UsersDto update(UsersDto users);
}
