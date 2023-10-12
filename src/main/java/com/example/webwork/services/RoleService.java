package com.example.webwork.services;

import com.example.webwork.dtos.RoleDto;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    RoleDto register(RoleDto role);

    List<RoleDto> getAll();

    Optional<RoleDto> get(Long id);

    void delete(Long id);

    RoleDto update(RoleDto role);
}
