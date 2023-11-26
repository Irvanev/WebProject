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
    private RoleService roleService;
    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
    @GetMapping("/all")
    Iterable<RoleDto> getAllRoles() {
        return roleService.getAllRoles();
    }
    @GetMapping("/{id}")
    RoleDto get(@PathVariable String id) {
        return roleService.getRole(id).orElseThrow(() -> new RoleNotFoundException(id));
    }
    @PostMapping("/add")
    RoleDto createRole(@RequestBody RoleDto role) {
        return roleService.registerRole(role);
    }
    @DeleteMapping("/{id}")
    void deleteRole(@PathVariable String id) {
        roleService.deleteRole(id);
    }
    @PutMapping("/update")
    RoleDto updateRole(@RequestBody RoleDto role) {
        return roleService.updateRole(role);
    }
}
