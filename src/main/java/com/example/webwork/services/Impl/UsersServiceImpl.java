package com.example.webwork.services.Impl;

import com.example.webwork.exceptions.UsersConflictException;
import com.example.webwork.exceptions.UsersNotFoundException;
import com.example.webwork.dtos.UsersDto;
import com.example.webwork.models.Users;
import com.example.webwork.repositories.UsersRepository;
import com.example.webwork.services.UsersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UsersDto register(UsersDto users) {
        Users u = modelMapper.map(users, Users.class);
        UUID userId = u.getId();
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
    public Optional<UsersDto> get(UUID id) {
        return Optional.ofNullable(modelMapper.map(usersRepository.findById(id), UsersDto.class));
    }

    @Override
    public void delete(UUID id) {
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
}
