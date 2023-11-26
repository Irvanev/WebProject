package com.example.webwork.controllers;

import com.example.webwork.dtos.UsersDto;
import com.example.webwork.exceptions.UsersNotFoundException;
import com.example.webwork.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private  UsersService userService;
    @Autowired
    public void setUserService(UsersService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    Iterable<UsersDto> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    UsersDto get(@PathVariable String id) {
        return userService.getUser(id).orElseThrow(() -> new UsersNotFoundException(id));
    }
    @GetMapping("/byFirstName")
    public ResponseEntity<List<UsersDto>> getUsersByFirstName(@RequestParam String firstName) {
        List<UsersDto> users = userService.findUsersByFirstName(firstName);
        return ResponseEntity.ok(users);
    }
    @GetMapping("/byLastName")
    public ResponseEntity<List<UsersDto>> getUsersByLastName(@RequestParam String lastName) {
        List<UsersDto> users = userService.findUsersByLastName(lastName);
        return ResponseEntity.ok(users);
    }
    @GetMapping("/byBrandName")
    public ResponseEntity<List<UsersDto>> getUsersByBrandName(@RequestParam String brandName) {
        List<UsersDto> users = userService.findUsersByBrandName(brandName);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/byRole")
    public ResponseEntity<List<UsersDto>> getUsersByRole(@RequestParam int role) {
        List<UsersDto> users = userService.findUsersByRole(role);
        return ResponseEntity.ok(users);
    }
    @PostMapping("/add")
    UsersDto createUser(@RequestBody UsersDto users) {
        return userService.registerUser(users);
    }
    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }
    @PutMapping("/update")
    UsersDto updateUser(@RequestBody UsersDto users) {
        return userService.updateUser(users);
    }
}