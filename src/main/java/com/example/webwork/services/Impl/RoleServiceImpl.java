package com.example.webwork.services.Impl;

import com.example.webwork.exceptions.RoleConflictException;
import com.example.webwork.exceptions.RoleNotFoundException;
import com.example.webwork.dtos.RoleDto;
import com.example.webwork.models.Role;
import com.example.webwork.repositories.RoleRepository;
import com.example.webwork.services.RoleService;
import com.example.webwork.util.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final ModelMapper modelMapper;
    private final RoleRepository roleRepository;
    private final ValidationUtil validationUtil;

    public RoleServiceImpl(RoleRepository roleRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public RoleDto registerRole(RoleDto role) {

        if(!this.validationUtil.isValid(role)) {
            this.validationUtil
                    .violations(role)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            throw new IllegalArgumentException("Illegal arguments in Role!");
        }

        Role r = modelMapper.map(role, Role.class);
        String roleId = r.getId();
        if (roleId == null || roleRepository.findById(roleId).isEmpty()) {
            return modelMapper.map(roleRepository.save(r), RoleDto.class);
        } else {
            throw new RoleConflictException("A role with this id already exists");
        }
    }

    @Override
    public List<RoleDto> getAllRoles() {
        return roleRepository.findAll().stream().map((s) -> modelMapper.map(s, RoleDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<RoleDto> getRole(String id) {
        return Optional.ofNullable(modelMapper.map(roleRepository.findById(id), RoleDto.class));
    }

    @Override
    public void deleteRole(String id) {
        if (roleRepository.findById(id).isPresent()) {
            roleRepository.deleteById(id);
        } else {
            throw new RoleNotFoundException(id);
        }
    }

    @Override
    public RoleDto updateRole(RoleDto role) {

        if(!this.validationUtil.isValid(role)) {
            this.validationUtil
                    .violations(role)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            throw new IllegalArgumentException("Illegal arguments in Role for update!");
        }

        if (roleRepository.findById(role.getId()).isPresent()) {
            return modelMapper.map(roleRepository.save(modelMapper.map(role, Role.class)), RoleDto.class);
        } else {
            throw new RoleNotFoundException(role.getId());
        }
    }
}
