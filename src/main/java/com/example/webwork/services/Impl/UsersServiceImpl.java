package com.example.webwork.services.Impl;

import com.example.webwork.exceptions.UsersConflictException;
import com.example.webwork.exceptions.UsersNotFoundException;
import com.example.webwork.dtos.UsersDto;
import com.example.webwork.models.Users;
import com.example.webwork.repositories.UsersRepository;
import com.example.webwork.services.UsersService;
import com.example.webwork.util.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService {

    private final ModelMapper modelMapper;
    private final UsersRepository usersRepository;
    private final ValidationUtil validationUtil;

    public UsersServiceImpl(UsersRepository usersRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.usersRepository = usersRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public UsersDto registerUser(UsersDto users) {

        if(!this.validationUtil.isValid(users)) {
            this.validationUtil
                    .violations(users)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            throw new IllegalArgumentException("Illegal arguments in Users!");
        }

        Users u = modelMapper.map(users, Users.class);
        String userId = u.getId();
        if (u.getId() == null || usersRepository.findById(userId).isEmpty()) {
            return modelMapper.map(usersRepository.save(u), UsersDto.class);
        } else {
            throw new UsersConflictException("A user with this id already exists");
        }
    }

    @Override
    public List<UsersDto> getAllUsers() {
        return usersRepository.findAll().stream().map((s) -> modelMapper.map(s, UsersDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<UsersDto> getUser(String id) {
        return Optional.ofNullable(modelMapper.map(usersRepository.findById(id), UsersDto.class));
    }

    @Override
    public void deleteUser(String id) {
        if (usersRepository.findById(id).isPresent()) {
            usersRepository.deleteById(id);
        } else {
            throw new UsersNotFoundException(id);
        }
    }

    @Override
    public UsersDto updateUser(UsersDto users) {

        if(!this.validationUtil.isValid(users)) {
            this.validationUtil
                    .violations(users)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            throw new IllegalArgumentException("Illegal arguments in Users for update!");
        }

        if (usersRepository.findById(users.getId()).isPresent()) {
            return modelMapper.map(usersRepository.save(modelMapper.map(users, Users.class)), UsersDto.class);
        } else {
            throw new UsersNotFoundException(users.getId());
        }
    }
    @Override
    public List<UsersDto> findUsersByFirstName(String firstName) {
        return usersRepository.findAllByFirstName(firstName).stream().map((s) -> modelMapper.map(s, UsersDto.class)).collect(Collectors.toList());
    }
    @Override
    public List<UsersDto> findUsersByLastName(String lastName) {
        return usersRepository.findAllByLastName(lastName).stream().map((s) -> modelMapper.map(s, UsersDto.class)).collect(Collectors.toList());
    }
    @Override
    public List<UsersDto> findUsersByRole(int role) {
        return usersRepository.findUsersByRole(role).stream().map((s) -> modelMapper.map(s, UsersDto.class)).collect(Collectors.toList());
    }
}
