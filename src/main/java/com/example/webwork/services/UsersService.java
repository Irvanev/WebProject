package com.example.webwork.services;


import com.example.webwork.dtos.UsersDto;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    UsersDto register(UsersDto users);

    List<UsersDto> getAll();

    Optional<UsersDto> get(Long id);

    void delete(Long id);

    UsersDto update(UsersDto users);
}
