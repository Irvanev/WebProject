package com.example.webwork.controllers;

import com.example.webwork.dtos.UsersDto;
import com.example.webwork.exceptions.UsersNotFoundException;
import com.example.webwork.services.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
//@RequestMapping("/users")
public class UserController {
    private final UsersService userService;
    public UserController(UsersService userService) {
        this.userService = userService;
    }

    @GetMapping("users")
    Iterable<UsersDto> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("user/{id}")
    UsersDto get(@PathVariable String id) {
        return userService.getUser(id).orElseThrow(() -> new UsersNotFoundException(id));
    }
    @GetMapping("users/byFirstName")
    public ResponseEntity<List<UsersDto>> getUsersByFirstName(@RequestParam String firstName) {
        List<UsersDto> users = userService.findUsersByFirstName(firstName);
        return ResponseEntity.ok(users);
    }
    @GetMapping("users/byLastName")
    public ResponseEntity<List<UsersDto>> getUsersByLastName(@RequestParam String lastName) {
        List<UsersDto> users = userService.findUsersByLastName(lastName);
        return ResponseEntity.ok(users);
    }
    @GetMapping("users/byBrandName")
    public ResponseEntity<List<UsersDto>> getUsersByBrandName(@RequestParam String brandName) {
        List<UsersDto> users = userService.findUsersByBrandName(brandName);
        return ResponseEntity.ok(users);
    }

    @GetMapping("users/byRole")
    public ResponseEntity<List<UsersDto>> getUsersByRole(@RequestParam int role) {
        List<UsersDto> users = userService.findUsersByRole(role);
        return ResponseEntity.ok(users);
    }
    @PostMapping("user")
    UsersDto createUser(@RequestBody UsersDto users) {
        return userService.registerUser(users);
    }
    @DeleteMapping("user/{id}")
    void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }
    @PutMapping("user")
    UsersDto updateUser(@RequestBody UsersDto users) {
        return userService.updateUser(users);
    }
}
