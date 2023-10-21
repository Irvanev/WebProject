package com.example.webwork.controllers;

import com.example.webwork.dtos.RoleDto;
import com.example.webwork.exceptions.RoleNotFoundException;
import com.example.webwork.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @GetMapping()
    Iterable<RoleDto> all() {
        return roleService.getAll();
    }
    @GetMapping("/{id}")
    RoleDto get(@PathVariable UUID id) {
        return roleService.get(id).orElseThrow(() -> new RoleNotFoundException(id));
    }
    @DeleteMapping("/{id}")
    void deleteRole(@PathVariable UUID id) {
        roleService.delete(id);
    }
    @PutMapping()
    RoleDto update(@RequestBody RoleDto role) {
        return roleService.update(role);
    }
}
