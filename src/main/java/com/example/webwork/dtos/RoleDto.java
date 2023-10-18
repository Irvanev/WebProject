package com.example.webwork.dtos;

import com.example.webwork.models.enums.RoleEnum;

import java.util.UUID;

public class RoleDto {
    private UUID id;
    private RoleEnum roleEnum;

    protected RoleDto() {};

    public RoleDto(UUID id, RoleEnum roleEnum) {
        this.id = id;
        this.roleEnum = roleEnum;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public RoleEnum getRoleEnum() {
        return roleEnum;
    }

    public void setRoleEnum(RoleEnum roleEnum) {
        this.roleEnum = roleEnum;
    }

    @Override
    public String toString() {
        return "RoleDto{" +
                "id=" + id +
                ", roleEnum=" + roleEnum +
                '}';
    }
}
