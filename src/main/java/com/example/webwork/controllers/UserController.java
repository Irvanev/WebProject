package com.example.webwork.controllers;

import com.example.webwork.dtos.UsersDto;
import com.example.webwork.exceptions.UsersNotFoundException;
import com.example.webwork.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UsersService userService;

    @GetMapping()
    Iterable<UsersDto> all() {
        return userService.getAll();
    }
    @GetMapping("/{id}")
    UsersDto get(@PathVariable UUID id) {
        return userService.get(id).orElseThrow(() -> new UsersNotFoundException(id));
    }
    @DeleteMapping("/{id}")
    void deleteUsers(@PathVariable UUID id) {
        userService.delete(id);
    }
    @PutMapping()
    UsersDto update(@RequestBody UsersDto users) {
        return userService.update(users);
    }
}
