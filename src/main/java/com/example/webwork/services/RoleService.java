package com.example.webwork.services;

import com.example.webwork.dtos.RoleDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RoleService {
    RoleDto register(RoleDto role);

    List<RoleDto> getAll();

    Optional<RoleDto> get(UUID id);

    void delete(UUID id);

    RoleDto update(RoleDto role);
}
