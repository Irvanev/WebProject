package com.example.webwork.services;

import com.example.webwork.dtos.RoleDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RoleService {
    RoleDto register(RoleDto role); // просто имя void register(String name)

    List<RoleDto> getAll();

    Optional<RoleDto> get(String id);

    void delete(String id);

    RoleDto update(RoleDto role);
}

