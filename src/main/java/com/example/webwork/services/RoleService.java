package com.example.webwork.services;

import com.example.webwork.dtos.RoleDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RoleService {
    RoleDto registerRole(RoleDto role); // просто имя void register(String name)

    List<RoleDto> getAllRoles();

    Optional<RoleDto> getRole(String id);

    void deleteRole(String id);

    RoleDto updateRole(RoleDto role);
}

