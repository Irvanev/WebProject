package com.example.webwork.services.Impl;

import com.example.webwork.exceptions.RoleConflictException;
import com.example.webwork.exceptions.RoleNotFoundException;
import com.example.webwork.dtos.RoleDto;
import com.example.webwork.models.Role;
import com.example.webwork.repositories.RoleRepository;
import com.example.webwork.services.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleDto register(RoleDto role) {
        Role b = modelMapper.map(role, Role.class);
        if (b.getId() == null || b.getId() == 0 || get(b.getId()).isEmpty()) {
            return modelMapper.map(roleRepository.save(b), RoleDto.class);
        } else {
            throw new RoleConflictException("A role with this id already exists");
        }
    }

    @Override
    public List<RoleDto> getAll() {
        return roleRepository.findAll().stream().map((s) -> modelMapper.map(s, RoleDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<RoleDto> get(Long id) {
        return Optional.ofNullable(modelMapper.map(roleRepository.findById(id), RoleDto.class));
    }

    @Override
    public void delete(Long id) {
        if (roleRepository.findById(id).isPresent()) {
            roleRepository.deleteById(id);
        } else {
            throw new RoleNotFoundException(id);
        }
    }

    @Override
    public RoleDto update(RoleDto role) {
        if (roleRepository.findById(role.getId()).isPresent()) {
            return modelMapper.map(roleRepository.save(modelMapper.map(role, Role.class)), RoleDto.class);
        } else {
            throw new RoleNotFoundException(role.getId());
        }
    }
}
