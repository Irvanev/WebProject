package com.example.webwork.services.Impl;

import com.example.webwork.exceptions.UsersConflictException;
import com.example.webwork.exceptions.UsersNotFoundException;
import com.example.webwork.dtos.UsersDto;
import com.example.webwork.models.Users;
import com.example.webwork.repositories.UsersRepository;
import com.example.webwork.services.UsersService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService {

    private final ModelMapper modelMapper;
    private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository, ModelMapper modelMapper) {
        this.usersRepository = usersRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UsersDto register(UsersDto users) {
        Users u = modelMapper.map(users, Users.class);
        String userId = u.getId();
        if (u.getId() == null || usersRepository.findById(userId).isEmpty()) {
            return modelMapper.map(usersRepository.save(u), UsersDto.class);
        } else {
            throw new UsersConflictException("A user with this id already exists");
        }
    }

    @Override
    public List<UsersDto> getAll() {
        return usersRepository.findAll().stream().map((s) -> modelMapper.map(s, UsersDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<UsersDto> get(String id) {
        return Optional.ofNullable(modelMapper.map(usersRepository.findById(id), UsersDto.class));
    }

    @Override
    public void delete(String id) {
        if (usersRepository.findById(id).isPresent()) {
            usersRepository.deleteById(id);
        } else {
            throw new UsersNotFoundException(id);
        }
    }

    @Override
    public UsersDto update(UsersDto users) {
        if (usersRepository.findById(users.getId()).isPresent()) {
            return modelMapper.map(usersRepository.save(modelMapper.map(users, Users.class)), UsersDto.class);
        } else {
            throw new UsersNotFoundException(users.getId());
        }
    }
    @Override
    public List<UsersDto> findUserByFirstName(String firstName) {
        return usersRepository.findAllByFirstName(firstName).stream().map((s) -> modelMapper.map(s, UsersDto.class)).collect(Collectors.toList());
    }
    @Override
    public List<UsersDto> findUserByLastName(String lastName) {
        return usersRepository.findAllByLastName(lastName).stream().map((s) -> modelMapper.map(s, UsersDto.class)).collect(Collectors.toList());
    }
    @Override
    public List<UsersDto> findUsersByRole(int role) {
        return usersRepository.findUsersByRole(role).stream().map((s) -> modelMapper.map(s, UsersDto.class)).collect(Collectors.toList());
    }
}
